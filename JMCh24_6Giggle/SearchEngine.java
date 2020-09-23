import java.util.*;


/**
 * makes a search engine that searches for phrases
 * 
 * @author Darren Lin
 * @version 2/19/20
 * 
 * @author Period - 4
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - none
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    /**
     * creates the search engine url and hashmap
     * 
     * @param url
     *            the url
     */
    public SearchEngine( String url )
    {
        myIndex = new HashMap( 20000 );
        myURL = url;
    }


    /**
     * returns the url
     * 
     * @return myURL which is the url
     */
    public String getURL()
    {
        return myURL;
    }


    /**
     * adds a line to list
     * 
     * @param line
     *            adds line
     */
    public void add( String line )
    {
        Set<String> words = parseWords( line );
        for ( String word : words )
        {
            if ( myIndex.containsKey( word ) )
            {
                myIndex.get( word ).add( line );
            }
            else
            {
                List<String> list = new LinkedList<String>();
                list.add( line );
                myIndex.put( word, list );
            }
        }
    }


    /**
     * returns the place where the word is
     * 
     * @param word
     *            word to search for
     * @return placement of word
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * parses the list of lines
     * 
     * @param line
     *            to parse
     * @return list of words with no duplicates
     */
    private Set<String> parseWords( String line )
    {
        Set<String> newWords = new HashSet<String>();
        String[] temp = line.split( "\\W+" );
        int i = 0;
        while ( i < temp.length )
        {
            if ( temp[i].length() > 0 )
            {
                newWords.add( temp[i].toLowerCase() );
            }
            i++;
        }
        return newWords;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * returns index
     * @return index is returned
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
