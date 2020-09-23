import java.util.*;


/**
 * RPN Calculator
 *
 * @author Darren Lin
 * @version 1/17/20
 * @author Period: 4
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: none
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> stack;

    private Queue<String> queue;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        stack = new Stack<Integer>();
        queue = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * calculates the equations answer after the iput is given
     */
    public void calculate()
    {

        while ( scan.hasNext() )
        {
            String nextString = scan.next();
            int count = 0;
            while ( count < nextString.length() )
            {
                char nextChar = nextString.charAt( count );
                if ( !( nextChar == 'q' ) && !( nextChar == 'Q' ) )
                {
                    queue.add( nextChar + "" );
                }
                if ( nextChar == 'q' || nextChar == 'Q' )
                {
                    System.out
                        .println( returnEquation() + "= " + stack.pop() );
                }

                else if ( nextChar == '+' )
                {
                    stack.push( stack.pop() + stack.pop() );
                }
                else if ( nextChar == '-' )
                {
                    stack.push( -stack.pop() + stack.pop() );
                }
                else if ( nextChar == '*' )
                {
                    stack.push( stack.pop() * stack.pop() );

                }
                else if ( nextChar == '/' )
                {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push( num2 / num1 );
                }
                else
                {
                    stack.push( Character.getNumericValue( nextChar ) );
                }
                count++;
            }
        }
    }


    /**
     * returns the equation and answer after the input is given
     * 
     * @return the full equation and answer
     */
    public String returnEquation()
    {
        String print = "";
        while ( !queue.isEmpty() )
        {
            print += queue.remove() + " ";
        }
        return print;
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}