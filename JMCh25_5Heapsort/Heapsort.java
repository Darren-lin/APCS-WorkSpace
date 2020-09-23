/**
 * a Heapsort class which uses heapsort to sort.
 * 
 * @author Darren Lin
 * @version 3/8/20
 * 
 * @author Period - 4
 * @author Assignment - JMCH25_5Heapsort
 * 
 * @author Sources - none
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    /**
     * sorts the array by calling reheapdown
     * 
     * @param a
     *            the array
     */
    public static void sort( double[] a )
    {
        int n = a.length;
        for ( int i = n / 2; i >= 1; i-- )
        {
            reheapDown( a, i, n );
        }
        while ( n > 1 )
        {
            double temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
            n--;
            reheapDown( a, 1, n );
        }
    }


    // Should be private - made public for testing
    /**
     * is called by sort to organize the array
     * 
     * @param a
     *            the array
     * @param i
     *            the initial
     * @param n
     *            the last
     */
    public static void reheapDown( double[] a, int i, int n )
    {
        if ( a.length <= 0 )
        {
            return;
        }
        while ( 2 * i <= n && 2 * i + 1 <= n + 1 )
        {
            if ( 2 * i + 1 <= n )
            {
                if ( a[2 * i - 1] > a[2 * i] )
                {
                    if ( a[2 * i - 1] > a[i - 1] )
                    {
                        double temp = a[i - 1];
                        a[i - 1] = a[2 * i - 1];
                        a[2 * i - 1] = temp;
                        i = 2 * i - 1;
                    }
                    else
                    {
                        return;
                    }
                }
                else
                {
                    if ( a[2 * i] > a[i - 1] )
                    {
                        double temp = a[i - 1];
                        a[i - 1] = a[2 * i];
                        a[2 * i] = temp;
                        i = 2 * i;
                    }
                    else
                    {
                        return;
                    }
                }
            }
            else
            {
                if ( a[2 * i - 1] > a[i - 1] )
                {
                    double temp = a[i - 1];
                    a[i - 1] = a[2 * i - 1];
                    a[2 * i - 1] = temp;
                    i = 2 * i - 1;
                }
                else
                {
                    return;
                }
            }
        }
    }
}
