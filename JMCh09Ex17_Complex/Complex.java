

/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Darren Lin
 * @version 10/3/19
 * @author Period: 4
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: none
 */
public class Complex
{
    private double a;

    private double b;


    /**
     * @param a a variable
     */
    public Complex( double a )
    {
        this( a, 0.0 );
    }


    /**
     * @param a - real
     * @param b - imaginary
     */
    public Complex( double a, double b )
    {
        this.a = a;
        this.b = b;
    }


    /**
     * gives the user the abs value of a * a + b * b
     * @return the sqrt of a * a + b * b
     */
    public double abs()
    {
        return Math.sqrt( a * a + b * b );
    }


    /**
     * adds a to other.a and b to other.b
     * @param other is the other complex number
     * @return a new complex number
     */
    public Complex add( Complex other )
    {
        double newValueOfA = a + other.a;
        double newValueOfB = b + other.b;
        return new Complex( newValueOfA, newValueOfB );
    }


    /**
     * adds the double d to the complex number
     * @param d is value to add to complex number
     * @return a new complex number
     */
    public Complex add(double d)
    {
        return new Complex( a + d, b);
    }


    /**
     * multiplies a complex number (a,b) by another (other.a,other.b)
     * @param other is the other complex number
     * @return a new complex number
     */
    public Complex multiply( Complex other )
    {
        return new Complex( a * other.a - b * other.b,
            a * other.b + b * other.a );
    }


    /**
     * allows doubles to go through multiply method
     * @param d is the value to multiply by
     * @return a new complex number
     */
    public Complex multiply( double d )
    {
        return new Complex( a * d, b * d );
    }


    /**
     * toString method
     * @return the string in the form of a + bi
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
