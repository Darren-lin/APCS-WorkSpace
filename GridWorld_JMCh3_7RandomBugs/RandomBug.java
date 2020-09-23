import info.gridworld.actor.Bug;
import java.awt.Color;


/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move
 * 
 * @author Darren Lin
 * @version 8/28/19
 *
 * @author Period - 4
 * @author Assignment - Random Bugs - UTurnBug
 *
 * @author Sources - none
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }


    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }


    public void turn( int angle )
    {
        setDirection(getDirection() + 180);
        angle = 45 * (int)( Math.random() * 8 );
    }


    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() )
            move();
        else
            turn();
    }
}
