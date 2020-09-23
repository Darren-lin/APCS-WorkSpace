/**
 * creates and places black rocks on the tiles.
 * 
 * @author Darren Lin
 * @version 1/25/20
 * 
 * @author Period - 4
 * @author Assignment - JM Ch22.6 - Hex
 * 
 * @author Sources - none
 */
public class HexBoard extends CharMatrix
{
    /**
     * @param rows super row
     * @param cols super col
     */
    public HexBoard( int rows, int cols )
    {
        super( rows, cols );
    }


    /**
     * determines if coordinate is black
     * @param r row 
     * @param c col
     * @return true or false
     */
    public boolean isBlack( int r, int c )
    {
        if ( charAt( r, c ) == 'b' )
        {
            if ( isInBounds( r, c ) == true )
            {
                return true;
            }
        }
        return false;
    }


    /**
     * determines if coordinate is white
     * @param r row 
     * @param c col
     * @return true or false
     */
    public boolean isWhite( int r, int c )
    {
        if ( charAt( r, c ) == 'w' )
        {
            if ( isInBounds( r, c ) == true )
            {
                return true;
            }
        }
        return false;

    }


    /**
     * determines if coordinate is gray
     * @param r row 
     * @param c col
     * @return true or false
     */
    public boolean isGray( int r, int c )
    {
        if ( charAt( r, c ) == 'x' )
        {
            if ( isInBounds( r, c ) == true )
            {
                return true;
            }

        }
        return false;
    }


    /**
     * sets the tile to black
     * @param r row
     * @param c col
     */
    public void setBlack( int r, int c )
    {
        setCharAt( r, c, 'b' );
    }

    /**
     * sets the tile to white
     * @param r row
     * @param c col
     */
    public void setWhite( int r, int c )
    {
        setCharAt( r, c, 'w' );
    }

    /**
     * sets the tile to gray
     * @param r row
     * @param c col
     */
    public void setGray( int r, int c )
    {
        setCharAt( r, c, 'x' );
    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        int numBlack = 0;
        int x = 0;
        while ( x < numRows() )
        {
            areaFill( x, 0 );
            x++;
        }
        for ( int i = 0; i < numRows(); i++ )
        {
            if ( isGray( i, numCols() - 1 ) )
            {
                numBlack++;
            }
        }
        for ( int i = 0; i < numRows(); i++ )
        {
            for ( int k = 0; k < numCols(); k++ )
            {
                if ( isGray( i, k ) )
                {
                    setBlack( i, k );
                }
            }
        }
        if ( numBlack > 0 )
        {
            return true;
        }
        return false;
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     */
    public void areaFill( int r, int c )
    {
        if ( isInBounds( r, c ) && isBlack( r, c ) )
        {
            setGray( r, c );
            areaFill( r - 1, c - 1 );
            areaFill( r - 1, c );
            areaFill( r, c - 1 );
            areaFill( r, c + 1 );
            areaFill( r + 1, c );
            areaFill( r + 1, c + 1 );
        }
    }


    /**
     * prints out 'B' 'W' or 'X'
     */
    public String toString()
    {
        String s = "";

        for ( int r = 0; r < numRows(); r++ )
        {
            for ( int c = 0; c < numCols(); c++ )
            {
                if ( isBlack( r, c ) )
                    s += 'B';
                else if ( isWhite( r, c ) )
                    s += 'W';
                else if ( isGray( r, c ) )
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }


    // ****************************************************************

    /**
     * checks if it is inbounds
     * @param row of coordinate
     * @param col of coordinate
     * @return true or false
     */
    private boolean isInBounds( int row, int col )
    {
        return row < numRows() && row >= 0 && col >= 0 && col < numCols();
    }
}
