/**
 * A class to solve various loop problems
 * 
 * @author Darren Lin
 * @version 9/18/19
 * 
 *          Period - 4 Assignment - A12.1 - FunLoops
 * 
 *          Sources - none
 */
public class FunLoops
{
    /**
     * finds n amount of magic squares
     * @param n number magic squares found
     */
    public void magicsquare( int n )
    {
        System.out.println( "Magic Squares" );

        long count = 0;
        long sum = 0;
        long square = 0;
        long num = 0;
        long squaredNum = 1;
        while ( count < n )
        {
            square = squaredNum * squaredNum;
            sum = square;
            for ( int i = 1; sum > 0; i++ )
            {
                sum -= i;
            }
            if ( sum == 0 )
            {
                num += 1;
                System.out.println( num + ": " + square );
                count++;
            }
            squaredNum++;
        }
    }


    /**
     *  finds the lcm
     * @param a a number
     * @param b b number
     * @return returns lcm
     */
    public int lcm( int a, int b )
    {
        int x = a;
        int y = b;
        int gcf = 1;
        while ( x != y )
        {
            if ( x < y )
            {
                y -= x;
            }
            else
            {
                x -= y;
            }
        }
        gcf = x;

        return a * b / gcf;
    }


    /**
     * runs the loops
     * @param args args
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );
        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
