/**
 * PollTest tests the polls
 * 
 * @author Darren Lin
 * @version 9/6/19
 * @author Period: 4
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: none
 */
public class PollTest
{
    /**
     * tests the poll
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian",
            "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
