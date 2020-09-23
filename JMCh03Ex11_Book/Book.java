/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what
 *       abstraction it represents, and how to use it.
 *
 *  @author  Darren Lin
 *  @version 8/27/19
 *  @author  Period: 4
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: none
 */
public class Book
{
    // TODO implement data fields
    private int numPages, currentPage;
    // TODO implement constructor
    public Book (int p)
    {
        currentPage = 1;
        numPages = p;
    }
    // TODO implement methods
    public int getNumPages()
    {
        return numPages;
    }
    
    public int getCurrentPage()
    {
        return currentPage;
    }
    
    public void nextPage()
    {
        if (currentPage < numPages)
        {
                currentPage++;
        }
    }
    
}
