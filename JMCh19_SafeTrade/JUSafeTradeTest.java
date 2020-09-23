import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author Darren Lin
 * @author none
 * @author none
 * @version 4/14/20
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: none
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
            to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertTrue(
            "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>",
            to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertFalse(
            "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder
                + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder
                + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertFalse(
            "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder
                + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.getShares() + " should be " + numShares
                + ">>",
            numShares == to.getShares()
                || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        to.subtractShares( numToSubtract );
        assertEquals(
            "<< TradeOrder: subtractShares(" + numToSubtract + ") should be "
                + ( numShares - numToSubtract ) + ">>",
            numShares - numToSubtract,
            to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }


    // --Test PriceComparator

    @Test
    public void priceComparatorConstructor()
    {
        PriceComparator priceComp = new PriceComparator();
        assertNotNull( priceComp );
    }


    @Test
    public void priceComparatorConstructorBoolean()
    {
        PriceComparator priceCompFalse = new PriceComparator( false );
        PriceComparator priceCompTrue = new PriceComparator( true );
        assertNotNull( priceCompFalse );
        assertNotNull( priceCompTrue );
    }


    @Test
    public void priceComparatorCompare()
    {

        PriceComparator priceComp = new PriceComparator();
        boolean limitOrder = false;
        TradeOrder order1 = new TradeOrder( null,
            symbol,
            buyOrder,
            limitOrder,
            numShares,
            123.45 );
        TradeOrder order2 = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            234.56 );
        TradeOrder order3 = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            123.45 );
        assertEquals(
            "<< PriceComparator: " + priceComp.compare( order1, order2 )
                + " should be 1 >>",
            priceComp.compare( order1, order2 ),
            1 );
        assertEquals(
            "<< PriceComparator: " + priceComp.compare( order2, order1 )
                + " should be -1 >>",
            priceComp.compare( order2, order1 ),
            -1 );
        assertEquals(
            "<<Pricecomparator: " + priceComp.compare( order2, order3 )
                + " should be 0 >>",
            priceComp.compare( order2, order3 ),
            0 );
    }


    @Test
    public void priceComparatorToString()
    {
        PriceComparator priceComp = new PriceComparator();
        assertNotNull( priceComp.toString() );
    }


    // --Test Trader

    @Test
    public void traderConstructor()
    {
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        assertNotNull( trader );
    }


    @Test
    public void traderGetName()
    {
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        assertEquals( "<< Trader: " + trader.getName()
            + " should be trader >>", trader.getName(), "trader" );
    }


    @Test
    public void traderGetPassword()
    {
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        assertEquals( "<< Trader: " + trader.getPassword()
            + " should be 1234 >>", trader.getPassword(), "1234" );
    }


    @Test
    public void traderCompareTo()
    {
        Trader trader1 = new Trader( new Brokerage( new StockExchange() ),
            "trader1",
            "1234" );
        Trader trader2 = new Trader( new Brokerage( new StockExchange() ),
            "trader2",
            "2345" );
        Trader trader3 = new Trader( new Brokerage( new StockExchange() ),
            "trader1",
            "3456" );
        assertNotNull( trader2 );
        assertEquals( "<< Trader: " + trader1.getName() + " compareTo ( "
            + trader2.getName() + " ) should be "
            + trader1.getName().compareToIgnoreCase( trader2.getName() )
            + " >>", trader1.compareTo( trader2 ), -1 );
        assertEquals( "<< Trader: " + trader1.getName() + " compareTo ( "
            + trader3.getName() + " ) should be "
            + trader1.getName().compareToIgnoreCase( trader3.getName() )
            + " >>", trader1.compareTo( trader3 ), 0 );
    }


    @Test
    public void traderEquals()
    {
        Trader trader1 = new Trader( new Brokerage( new StockExchange() ),
            "trader1",
            "1234" );
        Trader trader2 = new Trader( new Brokerage( new StockExchange() ),
            "trader2",
            "2345" );
        Trader trader3 = new Trader( new Brokerage( new StockExchange() ),
            "trader1",
            "3456" );
        assertFalse(
            "<< Trader: " + trader1.equals( trader2 ) + " should be " + false
                + " >>",
            trader1.equals( trader2 ) );
        assertTrue(
            "<< Trader: " + trader1.equals( trader3 ) + " should be " + true
                + " >>",
            trader1.equals( trader3 ) );
    }


    // --Test Brokerage

    @Test
    public void brokerageConstructor()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        String str = brokerage.toString();
        assertTrue( "<< Invalid Brokerage Constructor >>",
            str.contains( "Brokerage" ) );
    }


    @Test
    public void brokerageAddUser()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        brokerage.addUser( "brokerage", "1234" );
        assertTrue(
            "<< Brokerage: " + brokerage.addUser( "brokerage", "1234" )
                + " should be " + true + ">>",
            brokerage.getTraders().containsKey( "brokerage" ) );
        assertFalse(
            "<< Brokerage: " + brokerage.addUser( "brokerage", "1234" )
                + " should be " + false + ">>",
            brokerage.getTraders().containsKey( "broker" ) );
    }


    @Test
    public void brokerageLogin()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( brokerage, "trader", "1234" );
        brokerage.addUser( "trader1", "1234" );
        brokerage.login( "trader1", "1234" );
        assertFalse(
            "<< Brokerage:  should login a trader" + trader.getName()
                + " and their password " + trader.getPassword() + " should be "
                + true + ">>",
            brokerage.getLoggedTraders().contains( trader ) );

    }


    @Test
    public void brokerageLogOut()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        brokerage.addUser( "trader1", "1234" );
        brokerage.login( "trader1", "1234" );
        brokerage.logout( trader );
        assertFalse(
            "<< Brokerage: " + brokerage.getLoggedTraders().contains( trader )
                + " should be " + false + ">>",
            brokerage.getLoggedTraders().contains( trader ) );
    }


    @Test
    public void brokerageGetQuote()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( brokerage, "trader", "1234" );
        stockExchange.listStock( symbol, "GGL", price );
        brokerage.getQuote( symbol, trader );
        assertTrue( "<< Invalid Brokerage getQuote >>", trader.hasMessages() );
    }


    @Test
    public void brokeragePlaceOrder()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        TradeOrder tradeOrder = new TradeOrder( trader,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        brokerage.placeOrder( tradeOrder );
        assertTrue( "<< Invalid Brokerage getQuote >>", trader.hasMessages() );
        trader.openWindow();
        brokerage.placeOrder( tradeOrder );
        assertFalse( "<< Invalid Brokerage getQuote >>",
            trader.hasMessages() );

    }


    @Test
    public void brokerageToString()
    {
        StockExchange stockExchange = new StockExchange();
        Brokerage brokerage = new Brokerage( stockExchange );
        stockExchange.listStock( symbol, "GGL", price );
        assertNotNull( brokerage.toString() );
    }
    // --Test StockExchange


    @Test
    public void stockExchangeConstructor()
    {
        StockExchange stockExchange = new StockExchange();
        String toString = stockExchange.toString();
        assertTrue( "<< Invalid StockExchange Constructor >>",
            toString.contains( "StockExchange[" ) );
    }


    @Test
    public void stockExchangeListStock()
    {
        StockExchange stockExchange = new StockExchange();
        stockExchange.listStock( symbol, "GGL", price );
        assertTrue(
            "<< StockExchange: "
                + stockExchange.getListedStocks().containsKey( symbol )
                + " should be " + true,
            stockExchange.getListedStocks().containsKey( symbol ) );
    }


    @Test
    public void stockExchangeGetQuote()
    {
        StockExchange stockExchange = new StockExchange();
        stockExchange.listStock( symbol, "GGL", price );
        String quoteOfStock = stockExchange.getQuote( symbol );
        assertTrue( "<< Invalid StockExchange getQuote >>",
            quoteOfStock != null );
    }


    @Test
    public void StockExchangePlaceOrder()
    {
        StockExchange stockExchange = new StockExchange();
        stockExchange.listStock( symbol, "GGL", price );
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        TradeOrder tradeOrder = new TradeOrder( trader,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        brokerage.addUser( "trader", "1234" );
        stockExchange.placeOrder( tradeOrder );
        assertFalse(
            "<< StockExchange: " + stockExchange.getListedStocks()
                .get( tradeOrder.getSymbol() )
                .getBuyOrders()
                .isEmpty() + " should be" + false + " >>",
            stockExchange.getListedStocks()
                .get( tradeOrder.getSymbol() )
                .getBuyOrders()
                .isEmpty() );
        assertTrue( trader.hasMessages() );

    }


    @Test
    public void StockExchangeToString()
    {
        StockExchange stockExchange = new StockExchange();
        assertNotNull( stockExchange.toString() );
    }
    // --Test Stock


    @Test
    public void stockConstructor()
    {
        Stock stock = new Stock( symbol, "GGL", price );
        assertNotNull( stock );
    }


    @Test
    public void stockGetQuote()
    {
        Stock stock = new Stock( symbol, "GGL", price );
        String quoteForStock = stock.getQuote();
        assertEquals( quoteForStock,
            "GGL (" + symbol + ") " + "\nPrice:" + price + " hi: " + price
                + " lo " + price + " vol 0\nAsk: none Bid: none" );

    }


    @Test
    public void stockPlaceOrder()
    {
        StockExchange stockExchange = new StockExchange();
        Stock stock = new Stock( symbol, "GGL", price );
        stockExchange.listStock( symbol, "GGL", price );
        Brokerage brokerage = new Brokerage( stockExchange );
        Trader trader = new Trader( new Brokerage( new StockExchange() ),
            "trader",
            "1234" );
        TradeOrder tradeOrder = new TradeOrder( trader,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        stock.placeOrder( tradeOrder );
        assertEquals( stock.getBuyOrders().isEmpty(), false );
        assertTrue( trader.hasMessages() );

    }


    @Test
    public void stockToString()
    {
        Stock stock = new Stock( symbol, "GGL", price );
        assertNotNull( stock.toString() );
    }
    // Remove block comment below to run JUnit test in console


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUSafeTradeTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUSafeTradeTest" );
    }

}
