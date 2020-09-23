import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import java.util.*;
import gpdraw.*;


/**
 * This Class calculates the area and perimeter of an irregular polygon
 *
 * @author Darren Lin
 * @version 11/3/19
 *
 * @author Period - 4
 * @author Assignment - A15_1IrregularPolygon
 * 
 * @author Sources - none
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool(new SketchPad(300, 300, 0));

    private ArrayList<Point2D.Double> myPolygon;


    /**
     * Creates a polygon called myPolygon
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    /**
     * adds a point to myPolygon
     * 
     * @param aPoint
     *            a point that is added
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * calculates the perimeter of the irregular polygon
     * 
     * @return perimeter which is the perimeter
     */
    public double perimeter()
    {
        double perimeter = 0;
        if ( myPolygon.size() > 3 )
        {
            for ( int x = 0; x < myPolygon.size() - 1; x++ )
            {
                Double value = myPolygon.get( x );
                Double value2 = myPolygon.get( x + 1 );
                perimeter += Math.sqrt( Math.pow( ( value2.x - value.x ), 2 )
                    + Math.pow( ( value2.y - value.y ), 2 ) );
            }
            Double value3 = myPolygon.get( myPolygon.size() - 1 );
            Double value4 = myPolygon.get( 0 );
            perimeter += Math.sqrt( Math.pow( ( value4.x - value3.x ), 2 )
                + Math.pow( ( value4.y - value3.y ), 2 ) );
        }
        else
        {
            return 0;
        }
        return perimeter;
    }


    /**
     * calculates the area of the irregular polygon
     * 
     * @return area which is the area of the irregular polygon
     */
    public double area()
    {
        int x = 0;
        double area = 0;
        if ( myPolygon.size() > 3 )
        {
            while ( x < myPolygon.size() )
            {
                double xValue = myPolygon.get( x ).getX();
                double yValue = myPolygon.get( x ).getY();
                area += xValue
                    * myPolygon.get( ( x + 1 ) % myPolygon.size() ).getY();
                area -= yValue
                    * myPolygon.get( ( x + 1 ) % myPolygon.size() ).getX();
                x += 1;
            }
        }
        return Math.abs( area ) / 2;
    }


    /**
     * draws the irregular polygon
     */
    public void draw()
    {

        if ( myPolygon.size() > 3 )
        {
            double xValatz = myPolygon.get( 0 ).getX();
            double yValatz = myPolygon.get( 0 ).getY();
            pen.up();
            pen.move( xValatz, yValatz );
            pen.down();
            for ( int x = 1; x < myPolygon.size(); x++ )
            {
                double xValue = myPolygon.get( x ).getX();
                double yValue = myPolygon.get( x ).getY();
                pen.move( xValue, yValue );
            }
            pen.move( xValatz, yValatz );
        }
    }
}
