/**
 * Implements a sorted list of words
 * 
 * @author Darren Lin
 * @version 11/22/19
 * 
 * @author Period - 4
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - none
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * creates a public sorted word list
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * @param capacity
     *            is the capacity
     */
    public SortedWordList( int capacity )
    {
        super( capacity );
    }


    /**
     * this tells us the index of the word
     * 
     * @param word
     *            is the word
     * @return mid
     */
    public int indexOf( String word )
    {
        int left;
        int right = size() - 1;
        for ( left = 0; left <= right; )
        {

            int mid = ( left + right ) / 2;
            if ( word.compareToIgnoreCase( get( mid ) ) > 0 )
            {
                left = mid + 1;
            }
            else if ( word.compareToIgnoreCase( get( mid ) ) < 0 )
            {
                right = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }


    /**
     * this returns true or false if we get an index from indexOf
     * 
     * @param word
     *            is the word
     * @return true or false
     */
    public boolean contains( String word )
    {
        return ( indexOf( word ) >= 0 );

    }


    /**
     * this method calls the super set method and sets the value of the word
     * 
     * @param i
     *            Index
     * @param word
     *            the word to set
     * @return the super.set method
     */
    public String set( int i, String word )
    {
        if ( ( i > 0 && word.compareToIgnoreCase( get( i - 1 ) ) <= 0 )
            || ( i < size() - 1
                && word.compareToIgnoreCase( get( i + 1 ) ) >= 0 ) )
        {
            throw new IllegalArgumentException( "word=" + word + " i=" + i );
        }
        return super.set( i, word );
    }


    /**
     * adds a word to the word list
     * 
     * @param i
     *            Index
     * @param word
     *            is the word to add
     */
    public void add( int i, String word )
    {
        if ( ( i > 0 && word.compareToIgnoreCase( get( i - 1 ) ) <= 0 )
            || ( i < size() - 1
                && word.compareToIgnoreCase( get( i ) ) >= 0 ) )
        {
            throw new IllegalArgumentException( "word=" + word + " i=" + i );
        }
        super.add( i, word );
    }


    /**
     * adds the word
     * 
     * @param word
     *            is the word to add
     * @return true or false
     */
    public boolean add( String word )
    {
        if ( contains( word ) )
        {
            return false;
        }
        int left;
        int right = size() - 1;
        for ( left = 0; left <= right; )
        {

            int mid = ( left + right ) / 2;
            if ( word.compareToIgnoreCase( get( mid ) ) > 0 )
            {
                left = mid + 1;
            }
            else if ( word.compareToIgnoreCase( get( mid ) ) < 0 )
            {
                right = mid - 1;
            }
        }
        super.add( right + 1, word );
        return true;
    }


    /**
     * merges 2 word lists
     * 
     * @param word
     *            the sorted word list to merge
     */
    public void merge( SortedWordList word )
    {
        for ( int x = 0; x < word.size(); x++ )
        {
            add( word.get( x ) );
        }
    }
}