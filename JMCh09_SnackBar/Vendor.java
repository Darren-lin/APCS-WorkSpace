import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author Darren Lin
 * @version 10/1/19
 * 
 * @author Period - 4
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - none
 */
public class Vendor
{
    // Fields:
    private static double totalSales = 0;

    private int price = 0;

    private int change = 0;

    private int amountInStock;

    private int deposit = 0;


    /**
     * returns number of sales
     * 
     * @return sale amount
     */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp;
    }


    // Constructor
    // Parameters:
    // int price of a single item in cents
    // int number of items to place in stock
    /**
     * @param cost
     *            cost of item
     * @param stock
     *            amount of stock
     */
    public Vendor( int cost, int stock )
    {
        price = cost;
        amountInStock = stock;
    }


    // Sets the quantity of items in stock.
    // Parameters:
    // int number of items to place in stock
    // Return:
    // None
    /**
     * sets amountInStock to newStock
     * 
     * @param newStock
     *            is added to amountInStock
     */
    public void setStock( int newStock )
    {
        amountInStock = newStock;
    }


    // Returns the number of items currently in stock.
    // Parameters:
    // None
    // Return:
    // int number of items currently in stock
    /**
     * returns amountInStock
     * 
     * @return amountInStock
     */
    public int getStock()
    {
        return amountInStock;
    }


    // Adds a specified amount (in cents) to the deposited amount.
    // Parameters:
    // int number of cents to add to the deposit
    // Return:
    // None
    /**
     * adds money to the deposit
     * 
     * @param cent
     *            is the amount of cents
     */
    public void addMoney( int cent )
    {
        if ( amountInStock > 0 )
        {
            deposit += cent;
        }
    }


    // Returns the currently deposited amount (in cents).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current deposit
    /**
     * returns the deposit value
     * 
     * @return deposit
     */
    public int getDeposit()
    {
        return deposit;
    }


    // Implements a sale. If there are items in stock and
    // the deposited amount is greater than or equal to
    // the single item price, then adjusts the stock
    // and calculates and sets change and returns true;
    // otherwise refunds the whole deposit (moves it into change)
    // and returns false.
    // Parameters:
    // None
    // Return:
    // boolean successful sale (true) or failure (false)
    /**
     * returns true if a sale is made and false if a sale is not made or the
     * amount of money given is less than the price
     * 
     * @return true or false
     */
    public boolean makeSale()
    {
        if ( amountInStock > 0 && deposit >= price )
        {
            amountInStock -= 1;
            if ( deposit > price )
            {
                change = deposit - price;
            }
            totalSales += .01 * price;
            deposit = 0;
            return true;
        }
        else
        {
            change = deposit;
            deposit = 0;
            return false;
        }
    }


    // Returns and zeroes out the amount of change (from the last
    // sale or refund).
    // Parameters:
    // None
    // Return:
    // int number of cents in the current change
    /**
     * returns change
     * 
     * @return change
     */
    public int getChange()
    {
        return change;
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
