import java.util.Scanner;
import java.io.*;


/**
 * This class creates a new .java file with the words that are less than or
 * equal to the max length and more than or equal to the min length.
 * 
 * @author Darren Lin
 * @version 11/20/19
 * 
 * @author Period - 4
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 * @author Sources - none
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out
                .println( "*** Can't create RamblecsDictionary.java ***" );
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     */
    public static void openInputFile( String fileName )
    {
        try
        {
            fileIn = new Scanner( new File( fileName ) );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "error" );
        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     */
    public static void createOutputFile( String fileName )
    {
        try
        {
            fileOut = new PrintWriter( fileName );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "error" );
        }
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        int count = 0;
        fileOut.println( "public class RamblecsDictionary" );
        fileOut.println( "{" );
        fileOut.println( "    public String words[] =" );
        fileOut.println( "    {" );
        while ( fileIn.hasNext() )
        {

            String nextWord = fileIn.next().toUpperCase();

            if ( nextWord.length() >= MINLENGTH
                && nextWord.length() <= MAXLENGTH )
            {
                fileOut.println( "        \"" + nextWord + "\"," );
                count += 1;
            }

        }
        fileOut.println( "    };" );
        fileOut.println( "}" );
        return count; // fix this!!!
    }
}
