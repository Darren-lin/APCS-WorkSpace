import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Darren Lin
 * @version 8/28/19
 * 
 * @author Period - 4
 * @author Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner
 * 
 * @author Sources - none
 */
public class SpiralBugRunner
{
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );
        SpiralBug alice = new SpiralBug( 6 );
        alice.setColor( Color.ORANGE );
        world.add( new Location( 7, 8 ), alice );
        world.show();

    }
}