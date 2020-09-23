
/**
 * This class tests the die
 *
 * 
 * @author Darren Lin
 * @version Sep 17, 2019
 * @author Period: 4
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: none
 */
public class DieTest
{
    public static void main( String[] args )
    {
        Die die = new Die();
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );

    }
}
