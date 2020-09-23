/**
 *  This is a class that tests the Book class.
 *
 *  @author  Darren Lin
 *  @version 8/27/19
 *  @author  Period: 4
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: none
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        /* TODO *** TO BE IMPLEMENTED *** */
        Book Book = new Book (3);
        System.out.println(Book.getNumPages());
        System.out.println(Book.getCurrentPage());
        Book.nextPage();
        System.out.println(Book.getCurrentPage());
        Book.nextPage();
        System.out.println(Book.getCurrentPage());
        Book.nextPage();
        System.out.println(Book.getCurrentPage());
    }
}
