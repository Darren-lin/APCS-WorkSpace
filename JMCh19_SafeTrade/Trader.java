import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock trader.
 *
 * @author darren lin
 * @version Apr 14, 2020
 * @author Period: 4
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: none
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName;

    private String password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    /**
     * Constructs a new trader, affiliated with a given brockerage, with a given
     * screen name and password.
     * 
     * @param brokerage
     *            the brokerage for this trader
     * @param name
     *            user name
     * @param pswd
     *            password
     */
    public Trader(
        Brokerage brokerage,
        java.lang.String name,
        java.lang.String pswd )
    {
        this.brokerage = brokerage;
        screenName = name;
        password = pswd;
        mailbox = new LinkedList<String>();
    }


    /**
     * Returns the name for this trader.
     * 
     * @return screenName the screen name for this trader.
     */
    public String getName()
    {
        return screenName;
    }


    /**
     * Returns the password for this trader.
     * 
     * @return password the password for the trader
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * Compares this trader to another by comparing their screen names case
     * blind.
     * 
     * @param other
     *            the other trader
     * @return true or false depending on the screenNames
     */
    public int compareTo( Trader other )
    {
        return this.screenName.compareToIgnoreCase( other.getName() );
    }


    /**
     * Compares this trader to another by comparing their screen names ignoring
     * case
     * 
     * @param other
     *            the other trader
     * @return true or false depending on the screenNames
     */
    public boolean equals( Object other )
    {
        return screenName.equalsIgnoreCase( ( (Trader)other ).getName() );
    }


    /**
     * Creates a new TraderWindow for this trader and saves a reference to it in
     * myWindow. Removes and displays all the messages, if any, from this
     * trader's mailbox by calling myWindow.showMessage(msg) for each message
     */
    public void openWindow()
    {
        myWindow = new TraderWindow( this );
        while ( !mailbox.isEmpty() )
        {
            myWindow.showMessage( mailbox.remove() );
        }
    }


    /**
     * Returns true if this trader has any messages in its mailbox.
     * 
     * @return true if there are messages
     */
    public boolean hasMessages()
    {
        return !mailbox.isEmpty();
    }


    /**
     * Adds msg to this trader's mailbox and displays all messages. If this
     * trader is logged in (myWindow is not null) removes and shows all the
     * messages in the mailbox by calling myWindow.showMessage(msg) for each msg
     * in the mailbox.
     * 
     * @param msg
     *            the msg being recieved
     */
    public void receiveMessage( String msg )
    {
        mailbox.add( msg );
        if ( myWindow != null )
        {
            while ( !mailbox.isEmpty() )
            {
                myWindow.showMessage( mailbox.remove() );
            }
        }
    }


    /**
     * Requests a quote for a given stock symbol from the brokerage by calling
     * brokerage's getQuote.
     * 
     * @param symbol
     *            the symbol of the stock
     */
    public void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * Places a given order with the brokerage by calling brokerage's
     * placeOrder.
     * 
     * @param order
     *            an order to be placed
     */
    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    /**
     * Logs out this trader. Calls brokerage's logout for this trader. Sets
     * myWindow to null (this method is called from a TraderWindow's window
     * listener when the "close window" button is clicked)
     */
    public void quit()
    {
        brokerage.logout( this );
        myWindow = null;
    }


    //
    // The following are for test purposes only
    //
    /**
     * returns the mailbox
     * 
     * @return mailbox the traders mailbox
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
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
                if ( field.getType().getName().equals( "Brokerage" ) )
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                }
                else
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
                }
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
