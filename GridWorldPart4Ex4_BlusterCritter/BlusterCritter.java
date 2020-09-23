import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;


/**
 * This class creates a Bluster Critter
 *
 * @author Darren Lin
 * @version 11/12/19
 * @author Period: 4
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 * @author Sources: none
 */
public class BlusterCritter extends Critter
{
    private int c;

    private int redValue;

    private int blueValue;

    private int greenValue;


    /**
     * this is the constructor for the critter
     * 
     * @param c
     *            intial val of c
     */
    public BlusterCritter( int c )
    {
        this.c = c;
    }


    /**
     * this method retrns all actors that are within 2 spaces away from bluster
     * critter Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        // Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location myLoc = this.getLocation();
        for ( int r = myLoc.getRow() - 2; r <= myLoc.getRow() + 2; r++ )
        {
            for ( int col = myLoc.getCol() - 2; col <= myLoc.getCol()
                + 2; col++ )
            {
                Location loc = new Location( r, col );
                if ( this.getGrid().isValid( loc ) )
                {
                    Actor actorAtLoc = this.getGrid().get( loc );
                    if ( actorAtLoc instanceof Critter )
                    {
                        actors.add( actorAtLoc );
                    }
                }
            }
        }
        actors.remove( this );
        return actors;
    }


    /**
     * This method processes all the actors and tells the bluster critter to
     * darken or lighten Postcondition: (1) The state of all actors in the grid
     * other than this critter and the elements of <code>actors</code> is
     * unchanged. (2) The location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        int size = actors.size();
        if ( size < c )
        {
            this.lighten();
        }
        else
        {
            this.darken();
        }
    }


    /**
     * this method darkens the critter
     */
    private void darken()
    {
        Color color = getColor();
        redValue = color.getRed();
        greenValue = color.getGreen();
        blueValue = color.getBlue();
        if ( redValue > 0 )
        {
            redValue -= 1;
        }
        if ( greenValue > 0 )
        {
            greenValue -= 1;
        }
        if ( blueValue > 0 )
        {
            blueValue -= 1;
        }
        setColor( new Color( redValue, greenValue, blueValue ) );
    }


    /**
     * this method lightens the critter
     */
    private void lighten()
    {
        Color color = getColor();
        redValue = color.getRed();
        greenValue = color.getGreen();
        blueValue = color.getBlue();
        if ( redValue < 255 )
        {
            redValue += 1;
        }
        if ( greenValue < 255 )
        {
            greenValue += 1;
        }
        if ( blueValue < 255 )
        {
            blueValue += 1;
        }
        setColor( new Color( redValue, greenValue, blueValue ) );
    }
}
