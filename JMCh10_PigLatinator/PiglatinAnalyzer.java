import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * This class converts normal english to piglatin Its purpose is to translate a
 * phrase entered in by the user to piglatin
 * 
 * @author Darren Lin
 * @version 10/8/19
 * 
 * @author Period - 4
 * @author Assignment - PiglatinAnalyzer
 * 
 * @author Sources - none
 */
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to its piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        while ( phraseToTranslate.length() > 0 )
        {
            if ( !Character.isLetter( phraseToTranslate.charAt( 0 ) ) )
            {
                translation += phraseToTranslate.charAt( 0 );
                phraseToTranslate = phraseToTranslate.substring( 1 );
            }
            else
            {
                int index = 1;
                translation += wordToPigLatin(
                    locateWord( 0, phraseToTranslate ) );
                while ( Character
                    .isLetter( phraseToTranslate.charAt( index ) ) )
                {
                    index++;
                    if ( index == phraseToTranslate.length() )
                    {
                        break;
                    }
                }
                phraseToTranslate = phraseToTranslate.substring( index );
            }
        }
        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        int indexOfVowel = locateVowel( englishWord );
        if ( indexOfVowel == 0 )
        {
            pigLatinWord = englishWord + "yay";
        }
        else if ( indexOfVowel == -1 )
        {
            pigLatinWord = englishWord + "ay";
        }
        else
        {
            String endPos = englishWord.substring( indexOfVowel );
            String begPos = englishWord.substring( 0, indexOfVowel );
            char cap;
            if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
            {
                begPos = Character.toLowerCase( begPos.charAt( 0 ) )
                    + begPos.substring( 1, begPos.length() );
                cap = Character.toUpperCase( endPos.charAt( 0 ) );
                pigLatinWord += cap + endPos.substring( 1, endPos.length() )
                    + begPos + "ay";
            }
            else
            {
                pigLatinWord = endPos + begPos + "ay";
            }
        }
        return pigLatinWord;
    }


    private int locateVowel( String word )
    {
        for ( int i = 0; i < word.length(); i++ )
        {
            if ( "AEIOUaeiou".indexOf( word.charAt( i ) ) != -1 )
            {
                return i;
            }
        }

        return -1;
    }


    private String locateWord( int pos, String s )
    {
        int endpos = pos;
        String result = "";
        if ( s.length() == 0 )
        {
            return result;
        }
        while ( Character.isLetter( s.charAt( endpos ) ) )
        {
            endpos++;
            if ( endpos == s.length() )
            {
                break;
            }
        }
        result = s.substring( pos, endpos );
        return result;
    }
}
