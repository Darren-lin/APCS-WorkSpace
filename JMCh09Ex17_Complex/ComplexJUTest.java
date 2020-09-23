import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author Darren Lin
 * @version 10/3/19
 * @author Period: 4
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: 4
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        Complex c = new Complex( 11 );
        assertEquals( "11.0 + 0.0i", c.toString() );
    }


    @Test
    public void testConstructor2Param()
    {
        Complex c1 = new Complex( 2, 3 );
        assertEquals( "2.0 + 3.0i", c1.toString() );

    }


    @Test
    public void testAddRealAndComplexNum()
    {
        Complex c2 = new Complex( 5, 3 );
        Complex c = c2.add( 1.5 );
        assertEquals( "6.5 + 3.0i", c.toString() );

    }


    @Test
    public void testAdd2ComplexNums()
    {
        Complex c2 = new Complex( 5, 2 );
        Complex c = c2.add( new Complex( 3, 7 ) );
        assertEquals( "8.0 + 9.0i", c.toString() );
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        Complex c1 = new Complex( 1, 2 );
        Complex c2 = new Complex( 3, 4 );
        Complex c3 = c2.multiply( c1 );
        assertEquals( "-5.0 + 10.0i", c3.toString() );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        Complex c = new Complex( 3, 6 );
        Complex ans = c.multiply( 4.0 );
        assertEquals( "12.0 + 24.0i", ans.toString() );
    }


    @Test
    public void testAbsoluteValue()
    {
        Complex c2 = new Complex( 3, 4 );
        assertEquals( 5.0, c2.abs(), 0.01 );
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
