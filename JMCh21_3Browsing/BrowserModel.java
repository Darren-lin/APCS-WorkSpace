// import java.util.List;
import java.util.Stack;


/**
 * Browses through lines of text and it will sort through and find the text that
 * matches what is clicked on.
 *
 * @author Darren Lin
 * @version Jan 17, 2020
 * @author Period: 4
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: none
 */
public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;

    private Stack<Integer> forwardStk;

    private int topLine;


    /**
     * constructor for the browser
     * @param view2 the browser view
     */
    public BrowserModel( BrowserView view2 )
    {
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        view = view2;
        view.update( 0 );
    }


    /**
     * returns back to the home page or 0
     */
    public void home()
    {
        Integer num = new Integer( topLine );
        backStk.push( num );

        topLine = 0;
        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * goes back
     */
    public void back()
    {
        if ( !backStk.isEmpty() )
        {
            forwardStk.push( topLine );
            topLine = backStk.pop();
            view.update( topLine );
        }
    }


    /**
     * goes forward
     */
    public void forward()
    {
        if ( !forwardStk.isEmpty() )
        {
            backStk.push( topLine );
            topLine = forwardStk.pop();
            view.update( topLine );
        }
    }


    /**
     * follows the link that is clicked 
     * @param n the line clicked
     */
    public void followLink( int n )
    {
        Integer num = new Integer( topLine );
        backStk.push( num );

        topLine = n;
        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * checks if it has a back page
     * @return true or false if it has a back page
     */
    public boolean hasBack()
    {
        return !backStk.empty();
    }


    /**
     * checks if it has a front page
     * @return true or false if it has a front page
     */
    public boolean hasForward()
    {
        return !forwardStk.empty();
    }


    // The following are for test purposes only
    /**
     * returns back stack
     * @return backStk
     */
    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * returns front stack
     * @return frontStk
     */
    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * returns the line that is at the top
     * @return topLine
     */
    public int getTopLine()
    {
        return topLine;
    }
}
