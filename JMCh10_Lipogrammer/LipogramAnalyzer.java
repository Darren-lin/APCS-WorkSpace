/**
 * converts the letter e in the sentence or phrase to #. The user inputs a
 * sentence and the code will replace the letter e with a #. It will also keep a
 * record on what words had an e.
 * 
 * @author Darren Lin
 * @version 10/7/19
 * 
 * @author Period - 4
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - none
 */
public class LipogramAnalyzer
{
    private String text;
    private String noSymbolText;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
        noSymbolText = text;
        noSymbolText = noSymbolText.replace( ',', ' ' );
        noSymbolText = noSymbolText.replace( ';', ' ' );
        noSymbolText = noSymbolText.replace( '.', ' ' );
        noSymbolText = noSymbolText.replace( '?', ' ' );
        noSymbolText = noSymbolText.replace( '!', ' ' );
        noSymbolText = noSymbolText.replace( ':', ' ' );
        noSymbolText = noSymbolText.replace( '&', ' ' );
        noSymbolText = noSymbolText.replace( '(', ' ' );
        noSymbolText = noSymbolText.replace( ')', ' ' );
        noSymbolText = noSymbolText.replace( '"', ' ' );
        noSymbolText = noSymbolText.replace( '@', ' ' );
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String s2 = text.replace( letter, '#' );
        return s2;
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        int i;
        int k;
        String result = "";
        String foundLetter = "*";

        for ( i = 0; i < text.length(); i++ )
        {
            k = text.indexOf( letter, i );
            if ( k < 0 )
            {
                break;
            }
            String word = this.extractWord( k );
            int sidx = foundLetter.indexOf( "*" + word + "*" );

            if ( sidx < 0 )
            {
                foundLetter = foundLetter.concat( "*" + word + "*" );
                result += word + "\n";
            }

            i = k;
        }
        return result;
    }


    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        int i;
        int beg;
        int end;
        for ( i = pos; i >= 0; i-- )
        {
            char ch = noSymbolText.charAt( i );
            if ( ch == ' ' )
            {
                break;
            }
        }

        beg = i + 1;
        for ( i = pos; i < noSymbolText.length(); i++ )
        {
            char ch = noSymbolText.charAt( i );
            if ( ch == ' ' )
            {
                break;
            }

        }
        
        end = i - 1;
        String s2 = text.substring( beg, end + 1 );
        return s2;
    }
}