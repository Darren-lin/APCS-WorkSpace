import java.awt.*;
import javax.swing.*;


/**
 * This writes an optical illusion
 * 
 * @author Darren Lin
 * @version 9/18/19
 * 
 *          Period - 4 Assignment - A12.6 - ParallelLines
 * 
 *          Sources - none
 */
public class ParallelLines extends JPanel
{
    public final static int offset = 10;

    public final static int side_length = 40;

    public final static int x_start = 15;
    public final static int y_start = 40;


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * This method draws the illusion
     * 
     * @param g
     *            graphics object
     * @param width
     *            width of screen
     * @param height
     *            height of screen
     * @param size
     *            of screen
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        for ( int row = 0; row < 8; row++ )
        {

            int x = x_start;

            if ( row % 4 == 1 || row % 4 == 3 )
            {
                x = x_start + offset;
            }
            else if ( row % 4 == 2 )
            {
                x = x_start + 2 * offset;
            }
            else
            {
                x = x_start;
            }

            for ( int col = 0; col < 7; col++ )
            {
                g.fillRect( x + 2 * col * side_length,
                    y_start + ( row * side_length ),
                    side_length,
                    side_length );
            }

            g.drawLine( x_start,
                row * side_length + 80,
                width - 60,
                row * side_length + 80 );
        }
    }


    /**
     * draws parallel lines
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
