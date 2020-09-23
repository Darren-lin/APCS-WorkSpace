import java.util.*;
import java.lang.reflect.*;
import java.text.DecimalFormat;


/**
 * Represents a stock in the SafeTrade project
 *
 * @author darren lin
 * @version Apr 14, 2020
 * @author Period: 4
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: none
 */
public class Stock
{
    private static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice;

    private double hiPrice;

    private double lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders;

    private PriorityQueue<TradeOrder> sellOrders;


    /**
     * the Stock constructor
     * 
     * @param symbol
     *            the symbol of the stock
     * @param name
     *            the name of the company
     * @param price
     *            the price per share
     */
    public Stock(
        java.lang.String symbol,
        java.lang.String name,
        double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;
        buyOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator( false ) );
        sellOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator( true ) );
    }


    /**
     * Returns a quote string for this stock. The quote includes: the company
     * name for this stock; the stock symbol; last sale price; the lowest and
     * highest day prices; the lowest price in a sell order (or "market") and
     * the number of shares in it (or "none" if there are no sell orders); the
     * highest price in a buy order (or "market") and the number of shares in it
     * (or "none" if there are no buy orders).
     * 
     * @return quote which is the quote for this stock.
     */
    public String getQuote()
    {
        String quote = companyName + " (" + stockSymbol + ") " + "\n"
            + "Price:" + lastPrice + " hi: " + hiPrice + " lo " + loPrice
            + " vol " + volume + "\n";
        if ( sellOrders.isEmpty() && buyOrders.isEmpty() )
        {
            quote += "Ask: none" + " Bid: none";
            return quote;
        }
        else if ( sellOrders.isEmpty() && !buyOrders.isEmpty() )
        {
            quote += "Ask: none" + " Bid: " + buyOrders.peek().getPrice()
                + " size: " + buyOrders.peek().getShares();
            return quote;
        }
        else
        {
            if ( buyOrders.isEmpty() )
            {
                quote += "Ask: " + sellOrders.peek().getPrice() + " size: "
                    + sellOrders.peek().getShares() + " Bid: none\n";
                return quote;
            }
            quote += "Ask: " + sellOrders.peek().getPrice() + " size: "
                + sellOrders.peek().getShares() + " Bid: "
                + buyOrders.peek().getPrice() + " size: "
                + buyOrders.peek().getShares();
            return quote;
        }
    }


    /**
     * Places a trading order for this stock. Adds the order to the appropriate
     * priority queue depending on whether this is a buy or sell order. Notifies
     * the trader who placed the order that the order has been placed, by
     * sending a message to that trader.
     * 
     * @param order
     *            a trading order to be placed
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order == null )
        {
            return;
        }
        String msg = "";
        if ( order.isBuy() )
        {
            buyOrders.add( order );

            msg = "New order: Buy " + order.getSymbol() + "(" + companyName
                + ")" + "\n" + order.getShares() + " shares at ";

            if ( order.isMarket() )
            {
                msg += "market";
            }
            else if ( order.isLimit() )
            {
                msg += money.format( order.getPrice() );
            }

        }
        else if ( order.isSell() )
        {
            sellOrders.add( order );

            msg = "New order: Sell " + order.getSymbol() + "(" + companyName
                + ")" + "\n" + order.getShares() + " shares at ";

            if ( order.isMarket() )
            {
                msg += "market";
            }
            else if ( order.isLimit() )
            {
                msg += money.format( order.getPrice() );
            }
        }
        // else if ( order.isSell() == false )
        // {
        // return;
        // }
        // else if ( order.isBuy() == false )
        // {
        // return;
        // }
        order.getTrader().receiveMessage( msg );
        executeOrders();
    }


    /**
     * Examines the top sell order and the top buy order in the respective
     * priority queues. If both are limit orders and the buy order price is
     * greater or equal to the sell order price, executes the order (or a part
     * of it) at the sell order price. If one order is limit and the other is
     * market, executes the order (or a part of it) at the limit order price If
     * both orders are market, executes the order (or a part of it) at the last
     * sale price. Figures out how many shares can be traded, which is the
     * smallest of the numbers of shares in the two orders. Subtracts the traded
     * number of shares from each order; Removes each of the orders with 0
     * remaining shares from the respective queue. Updates the day's low price,
     * high price, and volume. Sends a message to each of the two traders
     * involved in the transaction.
     */
    protected void executeOrders()
    {
        while ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            double price = 0;
            if ( buyOrders.peek().isLimit() && sellOrders.peek().isLimit()
                && buyOrders.peek().getPrice() >= sellOrders.peek()
                    .getPrice() )
            {
                price = sellOrders.peek().getPrice();
            }
            else if ( ( buyOrders.peek().isLimit()
                && sellOrders.peek().isMarket() ) )
            {
                price = buyOrders.peek().getPrice();
            }
            else if ( buyOrders.peek().isMarket()
                && sellOrders.peek().isLimit() )
            {
                price = sellOrders.peek().getPrice();
            }
            else if ( buyOrders.peek().isMarket()
                && sellOrders.peek().isMarket() )
            {
                price = lastPrice;
            }
            int shares = 0;
            if ( buyOrders.peek().getShares() > sellOrders.peek().getShares() )
            {
                shares = sellOrders.peek().getShares();
            }
            else if ( buyOrders.peek().getShares() < sellOrders.peek()
                .getShares() )
            {
                shares = buyOrders.peek().getShares();
            }
            else if ( buyOrders.peek().getShares() == sellOrders.peek()
                .getShares() )
            {
                shares = sellOrders.peek().getShares();
            }
            volume += shares;
            buyOrders.peek().subtractShares( shares );
            sellOrders.peek().subtractShares( shares );
            Trader buyer = buyOrders.peek().getTrader();
            Trader seller = sellOrders.peek().getTrader();
            if ( buyOrders.peek().getShares() == 0 )
            {
                buyOrders.remove( buyOrders.peek() );
            }
            if ( sellOrders.peek().getShares() == 0 )
            {
                sellOrders.remove( sellOrders.peek() );
            }
            if ( price < loPrice )
            {
                loPrice = price;
            }

            if ( price > hiPrice )
            {
                hiPrice = price;
            }
            lastPrice = price;
            buyer.receiveMessage( "You bought: " + shares + " " + stockSymbol
                + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
            seller.receiveMessage( "You sold: " + shares + " " + stockSymbol
                + " at " + money.format( price ) + " amt "
                + money.format( shares * price ) );
        }
    }

    //
    // The following are for test purposes only
    //


    /**
     * returns the stock symbol
     * 
     * @return stockSymbol the stocks symbol
     */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }


    /**
     * returns the company's name
     * 
     * @return comapnyName the companys name
     */
    protected String getCompanyName()
    {
        return companyName;
    }


    /**
     * returns the lowest price
     * 
     * @return loPrice the lowest price
     */
    protected double getLoPrice()
    {
        return loPrice;
    }


    /**
     * returns the highest price
     * 
     * @return hiPrice the highest price
     */
    protected double getHiPrice()
    {
        return hiPrice;
    }


    /**
     * returns the last price
     * 
     * @return lastPrice the last price
     */
    protected double getLastPrice()
    {
        return lastPrice;
    }


    /**
     * returns the volume
     * 
     * @return volume the volume of shares
     */
    protected int getVolume()
    {
        return volume;
    }


    /**
     * returns the buy orders
     * 
     * @return buyOrders the buy orders
     */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }


    /**
     * returns the sell orders
     * 
     * @return sellOrders the sell orders
     */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
