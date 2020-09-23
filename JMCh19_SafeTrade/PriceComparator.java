/**
 *   A price comparator for trade orders.
 *
 *  @author  darren lin
 *  @version Apr 14, 2020
 *  @author  Period: 4
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: none
 */
public class PriceComparator implements java.util.Comparator<TradeOrder>
{
    private boolean ascending;


    /**
     * Constructs a price comparator that compares two orders in ascending
     * order. Sets the private boolean ascending flag to true.
     */
    public PriceComparator()
    {
        ascending = true;
    }


    /**
     * Constructs a price comparator that compares two orders in ascending or
     * descending order. The order of comparison depends on the value of a given
     * parameter. Sets the private boolean ascending flag to asc
     * 
     * @param asc
     *            if true, make an ascending comparator; otherwise make a
     *            descending comparator.
     */
    public PriceComparator( boolean asc )
    {
        ascending = asc;
    }


    /**
     * Compares two trade orders.
     * 
     * @param order1
     *            the first order
     * @param order2
     *            the second order
     * @return 0 if it is market&market, 1 if it is limit&market, and -1 if it
     *         is market&limit
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        else if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;
        }
        else if ( order1.isLimit() && order2.isMarket() )
        {
            return 1;
        }
        else
        {
            double diff1 = ( order1.getPrice() - order2.getPrice() ) * 100;
            double diff2 = ( order2.getPrice() - order1.getPrice() ) * 100;
            if (ascending)
            {
                // if ( ascending == true )
                // {
                return (int)diff1;
                // }
            }
            else
            {
                return (int)diff2;
            }
        }
    }
}
