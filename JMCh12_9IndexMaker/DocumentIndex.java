import java.util.ArrayList;


/**
 * This class documents the index received and prints it
 *
 * @author Darren Lin
 * @version Nov 4, 2019
 * @author Period: 4
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: none
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{

    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Creates an empty DocumentIndex with a given initial capacity.
     * 
     * @param initialCapacity
     *            which is the initial capacity of the list
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    /**
     * If word is not yet in this DocumentIndex, creates a new IndexEntry for
     * word, and inserts it into this list in alphabetical order; adds num to
     * this word's IndexEntry by calling its add(num) method.
     * 
     * @param word
     *            the word we are testing
     * @param num
     *            the number we are adding on
     */
    public void addWord( String word, int num )
    {
        get( foundOrInserted( word ) ).add( num );
    }


    /**
     * For each word in str, calls addWord(word, num).
     * 
     * @param str
     *            is the string we are splitting
     * @param num
     *            is the index ad which we are adding
     */
    public void addAllWords( String str, int num )
    {
        String[] words = str.split( "\\W+" );
        for ( int x = 0; x < words.length; x++ )
        {
            if ( words[x].length() > 0 )
            {
                addWord( words[x], num );
            }
        }
    }


    /**
     * Tries to find an EndexEntry with a given word in this DocumentIndex. If
     * not found, inserts a new EndexEntry for word at the appropriate place (in
     * lexicographical order). Returns the index of the found or inserted
     * IndexEntry
     * 
     * @param word
     *            is the word we are currently on
     * @return x which is the index
     */
    private int foundOrInserted( String word )
    {
        if ( size() == 0 )
        {
            add( new IndexEntry( word ) );
            return 0;
        }
        int x = 0;
        while ( x < size() )
        {
            if ( get( x ).getWord().compareToIgnoreCase( word ) == 0 )
            {
                return x;
            }
            else if ( get( x ).getWord().compareToIgnoreCase( word ) > 0 )
            {
                break;
            }
            x += 1;
        }
        add( x, new IndexEntry( word ) );
        return x; // TODO Fix this!!
    }
}
