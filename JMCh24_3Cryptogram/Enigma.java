// import java.util.Arrays;

/**
 * This class encodes and decodes an encrypted file
 * 
 * @author Darren Lin
 * @version 2/12/20
 * 
 * @author Period - 4
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - none
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * This constructs the lookup table
     * 
     * @param numLetters
     *            num of letters to add
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * This method sets a substitution in the look up table
     * 
     * @param index
     *            for sub
     * @param ch
     *            to sub
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    /**
     * decodes the message
     * 
     * @param text
     *            to decode
     * @return the decoded message
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );
        int i = 0;
        int x;
        char character;
        while ( i < text.length() )
        {
            character = text.charAt( i );
            if ( !Character.isAlphabetic( character ) )
            {
                buffer.append( character );
            }
            else
            {

                if ( Character.isUpperCase( character ) )
                {
                    x = Character.getNumericValue( text.charAt( i ) )
                        - Character.getNumericValue( 'A' );
                    buffer.append( ( "" + lookupTable[x] ).toLowerCase() );
                }
                else if ( Character.isLowerCase( character ) )
                {
                    x = Character.getNumericValue( text.charAt( i ) )
                        - Character.getNumericValue( 'a' );
                    buffer.append( ( "" + lookupTable[x] ).toLowerCase() );
                }
                else
                {
                    buffer.append( character );
                }
            }
            i++;

        }
        return buffer.toString();
    }


    /**
     * gets hints from the user
     * 
     * @param text
     *            to hint
     * @param lettersByFrequency
     *            for hints
     * @return the hint
     */
    public String getHints( String text, String lettersByFrequency )
    {
        String hint = "";
        int[] num = countLetters( text );
        int counts;
        int j = 0;
        for ( int i = 0; i < num.length; i++ )
        {
            counts = 0;
            while ( j < num.length )
            {
                if ( num[j] < num[i] || ( num[j] == num[i] && j < i ) )
                {
                    counts++;
                }
                j++;
            }
            hint += lettersByFrequency.charAt( counts );
        }
        return hint;
    }


    /**
     * counts the letters
     * 
     * @param text
     *            the text to count
     * @return the numer of letters
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( int i = 0; i < text.length(); i++ )
        {
            Character character = text.charAt( i );
            if ( Character.isAlphabetic( character ) )
            {
                character = Character.toUpperCase( character );
                counts[Character.getNumericValue( character )
                    - Character.getNumericValue( 'A' )]++;
            }
        }
        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * returns the look up table
     * 
     * @return look up table
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * counts the letters
     * 
     * @param text
     *            the text to count
     * @return the number of letters
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}