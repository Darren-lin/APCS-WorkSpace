/**
 * Simulates a six-sided die.
 *
 * @author Darren Lin
 * @version 9/11/19
 * @author Period: 4
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: none
 */
public class Die
{
    private int numDots;


    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        numDots = (int)( 6 * Math.random() + 1 );
    }


    /**
     * Returns the value of the most recent roll.
     * 
     * @return numDots
     */
    public int getNumDots()
    {
        return numDots; // Fix this !!!
    }
}
