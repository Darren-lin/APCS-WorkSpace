import java.util.ArrayList;


/**
 * This class makes and index Entry based on the word they are currently
 * scanning
 *
 * @author Darren Lin
 * @version Nov 4, 2019
 * @author Period: 4
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: none
 */
public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numsList;


    //
    /**
     * Constructs an IndexEntry for a given word (converted to upper case); sets
     * numsList to an empty ArrayList.
     * 
     * @param word
     *            is the word they are testing
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    /**
     * Returns the word of this IndexEntry object.
     * 
     * @return word which is the current word
     */
    public String getWord()
    {
        return word; // Fix this!!
    }


    /**
     * If num is not already in the list, adds num at the end of this
     * IndexEntry's list of numbers.
     * 
     * @param num
     *            is the num that we are testing
     */
    public void add( int num )
    {
        if ( !numsList.contains( num ) )
        {
            numsList.add( num );
        }
    }


    /**
     * this method adds to the new string
     * 
     * @return newString which is the newstring
     */
    public String toString()
    {
        String result = "";
        String newString = "";
        for ( int x = 0; x < numsList.size(); x++ )
        {
            if ( numsList.size() - 1 != x )
            {
                newString = newString + Integer.toString( numsList.get( x ) )
                    + ", ";
            }
            else
            {
                newString = newString + Integer.toString( numsList.get( x ) );
            }
        }
        result = word + " " + newString;
        return result; // TODO Fix this!!
    }
}
