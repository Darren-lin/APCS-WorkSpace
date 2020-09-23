import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a brokerage.
 *
 * @author darren Lin
 * @version Apr 14, 2020
 * @author Period: 4
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: none
 */
public class Brokerage implements Login
{
    private Map<String, Trader> traders;

    private Set<Trader> loggedTraders;

    private StockExchange exchange;


    /**
     * Constructs new brokerage affiliated with a given stock exchange.
     * Initializes the map of traders to an empty map (a TreeMap), keyed by
     * trader's name; initializes the set of active (logged-in) traders to an
     * empty set (a TreeSet)
     * 
     * @param exchange
     *            a stock Exchange
     */
    public Brokerage( StockExchange exchange )
    {
        this.exchange = exchange;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }


    /**
     * Tries to register a new trader with a given screen name and password. If
     * successful, creates a Trader object for this trader and adds this trader
     * to the map of all traders (using the screen name as the key).
     * 
     * @param name
     *            name of user
     * @param password
     *            password of user
     * @return 0 if you can add the trader
     */
    public int addUser( String name, String password )
    {
        if ( name.length() < 4 || name.length() > 10 )
        {
            return -1;
        }
        else if ( password.length() < 2 || password.length() > 10 )
        {
            return -2;
        }
        else if ( traders.containsKey( name ) )
        {
            return -3;
        }
        Trader newTrader = new Trader( this, name, password );
        traders.put( name, newTrader );
        return 0;
    }


    /**
     * Tries to login a trader with a given screen name and password. If no
     * messages are waiting for the trader, sends a "Welcome to SafeTrade!"
     * message to the trader. Opens a dialog window for the trader by calling
     * trader's openWindow() method. Adds the trader to the set of all logged-in
     * traders
     * 
     * @param name
     *            name of trader
     * @param password
     *            password of trader
     * @return 0 if the trader can login
     */
    public int login( java.lang.String name, java.lang.String password )
    {
        Trader logTrader = traders.get( name );
        if ( !traders.containsKey( name ) )
        {
            return -1;
        }
        else if ( !traders.get( name ).getPassword().equals( password ) )
        {
            return -2;
        }
        else if ( loggedTraders.contains( logTrader ) )
        {
            return -3;
        }
        if ( logTrader.hasMessages() )
        {
            logTrader.openWindow();
        }
        else
        {
            logTrader.receiveMessage( "Welcome to SafeTrade!" );
            logTrader.openWindow();
            loggedTraders.add( logTrader );
        }
        return 0;
    }


    /**
     * Removes a specified trader from the set of logged-in traders. The trader
     * may be assumed to logged in already.
     * 
     * @param trader
     *            the trader logging out
     */
    public void logout( Trader trader )
    {
        if ( loggedTraders.contains( trader ) )
        {
            loggedTraders.remove( trader );
        }
        else
        {
            return;
        }

    }


    /**
     * Requests a quote for a given stock from the stock exachange and passes it
     * along to the trader by calling trader's receiveMessage method.
     * 
     * @param symbol
     *            the symbol of the stock
     * @param trader
     *            the trader getting the quote
     */
    public void getQuote( java.lang.String symbol, Trader trader )
    {
        trader.receiveMessage( exchange.getQuote( symbol ) );
    }


    /**
     * Places an order at the stock exchange.
     * 
     * @param order
     *            an order to be placed at the stock exchange.
     */
    public void placeOrder( TradeOrder order )
    {
        exchange.placeOrder( order );
    }


    //
    // The following are for test purposes only
    //
    /**
     * gets traders from the map
     * 
     * @return traders the traders in the map
     */
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    /**
     * returns the logged traders
     * 
     * @return loggedTraders the logged in traderes
     */
    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    /**
     * returns the exchange
     * 
     * @return exchange the stock exchange
     */
    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
