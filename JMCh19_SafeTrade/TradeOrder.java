import java.lang.reflect.*;


/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 *
 * @author darren lin
 * @version Apr 14, 2020
 * @author Period: 4
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: none
 */
public class TradeOrder
{
    private Trader trader;

    private String symbol;

    private boolean buyOrder;

    private boolean marketOrder;

    private int numShares;

    private double price;


    /**
     * Constructs a new TradeOrder for a given trader, stock symbol, a number of
     * shares, and other parameters.
     * 
     * @param trader
     *            a trader who placed this order.
     * @param symbol
     *            the symbol of the comapny
     * @param buyOrder
     *            if true this is a buy order; otherwise this is a sell order.
     * @param marketOrder
     *            if true this is a market order; otherwise this is a limit
     *            order.
     * @param numShares
     *            the number of shares that are being traded
     * @param price
     *            the price per share
     */
    public TradeOrder(
        Trader trader,
        java.lang.String symbol,
        boolean buyOrder,
        boolean marketOrder,
        int numShares,
        double price )
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }


    /**
     * returns the trader
     * 
     * @return trader the trader
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * returns the symbol
     * 
     * @return symbol the symbol of the company
     */
    public String getSymbol()
    {
        return symbol;
    }


    /**
     * returns false or true if it is a buy Order
     * 
     * @return true if it is a buyOrder
     */
    public boolean isBuy()
    {
        return buyOrder;
    }


    /**
     * returns false or true if it is a sell Order
     * 
     * @return true if it is a sellOrder
     */
    public boolean isSell()
    {
        return !buyOrder;

    }


    /**
     * returns true or false depending on whether it is at market
     * 
     * @return true or false if it is at market
     */
    public boolean isMarket()
    {
        return marketOrder;
    }


    /**
     * returns true or false depending on whether it is at limit
     * 
     * @return true or false if it is at limit
     */
    public boolean isLimit()
    {
        return !marketOrder;
    }


    /**
     * returns the number of shares
     * 
     * @return numShares
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * returns the price per share
     * 
     * @return price the price per share
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * returns the number of shares left after subtracting
     * 
     * @param shares
     *            the shares to subtract from numShares
     */
    public void subtractShares( int shares )
    {
        if ( shares > numShares )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            numShares -= shares;
        }
    }


    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
