import java.util.Scanner;
import java.io.*;


/**
 * A class for calculating Statistics on a set of numbers.
 *
 * @author Darren Lin
 * @version 10/30/19
 * @author Period: 4
 * 
 * @author Assignment: Lab Activity 16.1 - Statistics
 * 
 * @author Sources: none
 */
public class Statistics
{
    private final static int MAX_VALUE = 100;

    private int[] statsData = new int[1000];

    private int howMany;


    /**
     * Constructs this object with an array of integers for use with statistical
     * calculation
     * 
     * @param fileName
     *            name of file containing numbers for statistical evaluation
     */
    public Statistics( String fileName )
    {
        howMany = 0;
        loadFile( fileName );
    }


    /**
     * Loads text file into array data. Values are stored from positions
     * 0..howMany-1. Returns the number of data values as howMany
     * 
     * @param fileName
     *            file or string containing numbers to read
     */
    public void loadFile( String fileName )
    {
        int index = 0;
        Scanner inFile;

        try
        {
            if ( new File( fileName ).isFile() )
            {
                inFile = new Scanner( new File( fileName ) );
            }
            else
            {
                inFile = new Scanner( fileName );
            }

            while ( inFile.hasNext() )
            {
                statsData[index] = inFile.nextInt();
                index++;
            }
        }
        catch ( IOException i )
        {
            System.out.println( "Error: " + i.getMessage() );
        }
        howMany = index;
    }


    /**
     * Returns average of values in vector data.
     * 
     * @return average of this objects data collection
     */
    public double average()
    {
        long sum = 0;
        for ( int x = 0; x < howMany; x++ )
        {
            sum += statsData[x];
        }
        return (double) sum / howMany; // TODO Fix this
    }


    /**
     * Finds standard deviation of values in vector data.
     * 
     * @return the standard deviation of the vector data
     */
    public double stdDev()
    {
        double sum = 0;
        double dev;
        double avg = average();
        for ( int x = 0; x < howMany; x++ )
        {
            sum += ( ( statsData[x] - avg ) * ( statsData[x] - avg ) );
        }
        dev = Math.sqrt(( sum / ( howMany - 1 ) ));
        return dev;
    }


    /**
     * finds the largest integer in the array scores. This array is sized from
     * 0..MAX_VALUE, with each element storing the quantity of each number from
     * 0..MAX_VALUE.
     * 
     * @param scores
     *            integer array sized at MAX_VALUE+1 with each element storing
     *            the quantity of each number from 0..MAX_VALUE
     */
    public int findLargest( int[] scores )
    {
        int highestScore = 0;
        for ( int x = 0; x < scores.length; x++ )
        {
            if ( scores[x] - highestScore > 0 )
            {
                highestScore = scores[x];
            }
        }
        return highestScore; // TODO Fix this
    }


    /**
     * The array data is analyzed and transferred into a smaller array smallList
     * (0..MAX_VALUE). For each occurrence of n in the array data, smallList[n]
     * is incremented +1. findLargest is then called to find the largest
     * quantity in the array smallList. The mode(s) is/are returned in an array.
     * 
     * @return array of mode(s)
     */
    public int[] findMode()
    {
        int[] smallList = new int[MAX_VALUE + 1];
        int count = 0, count2 = 0;
        for ( int x = 0; x < howMany; x++ )
        {
            smallList[statsData[x]] += 1;
        }
        int largVal = findLargest( smallList );
        for ( int x = 0; x < smallList.length; x++ )
        {
            if ( smallList[x] == largVal )
            {
                count += 1;
                int modeArray[] = new int[count];

            }
        }
        int modeArray[] = new int[count];
        for ( int x = 0; x < smallList.length; x++ )
        {
            if ( smallList[x] == largVal )
            {
                modeArray[count2] = x;
                count2 += 1;
            }
        }
        return modeArray; // TODO Fix this
    }

    /**
     * Runs the tests
     * @param args tests if it prints out the correct outputs
     */
    public static void main( String[] args )
    {
        Statistics fileStats = new Statistics( "numbers.txt" );

        System.out.printf( "The average = %6.2f", fileStats.average() );
        System.out.println();
        System.out.printf( "Standard deviation = %6.2f", fileStats.stdDev() );
        System.out.println();

        int[] mode = fileStats.findMode();
        System.out.print( "The mode is(are) --> " );
        for ( int m : mode )
        {
            System.out.print( m + "  " );
        }
    }
}