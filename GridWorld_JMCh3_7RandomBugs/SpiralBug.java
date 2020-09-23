import info.gridworld.actor.Bug;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  Darren Lin
   @version 8/28/19

   @author  Period - 4
   @author  Assignment - GridWorld Part 2, Exercise 2 - SpiralBug

   @author  Sources - none
 */
public class SpiralBug extends Bug
{
    private int steps;
    private int sideLength;

    public SpiralBug( int n )
    {
        steps = 0;
        sideLength = n;
    }

    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}