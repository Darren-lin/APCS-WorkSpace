
// Implements the list of messages for teletext

import java.awt.Graphics;


/**
 * This class adds and removes the headlines scrolling in the display.
 *
 * @author Darren Lin
 * @version Jan 9, 2020
 * @author Period: 4
 * @author Assignment: JMCh20_7Teletext
 *
 * @author Sources: none
 */
public class TeletextList
{
    private ListNode2<String> heading;
    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        heading = new ListNode2<String>( "Today's headlines:", null, null );
        heading.setPrevious( new ListNode2<String>( "", null, heading ) );
        heading.setNext( new ListNode2<String>( "", heading, null ) );
        ListNode2<String> temp = heading.getNext();

        for ( String str : headlines )
        {
            temp.setNext( new ListNode2<String>( str, temp, null ) );
            temp = temp.getNext();
        }

        temp.setNext( heading.getPrevious() );
        heading.getPrevious().setPrevious( temp );

        topNode = heading;
    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        heading.getNext()
            .setNext( new ListNode2( msg,
                heading.getNext(),
                heading.getNext().getNext() ) );
        heading.getNext()
            .getNext()
            .getNext()
            .setPrevious( heading.getNext().getNext() );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        if ( !topNode.getNext().equals( heading )
            || !topNode.getNext().getValue().equals( "" ) )
        {
            topNode.setNext( topNode.getNext().getNext() );
            topNode.getNext().getNext().setPrevious( topNode );
        }
    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }


    /**
     * Adds a new node with msg to the headlines list before a given node.
     * @param node the node to add before
     * @param msg the msg to add
     * @return newNode a referenece to the added node.
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getPrevious().setNext( newNode );
        node.setPrevious( newNode );
        return newNode;
    }


    /**
     * Adds a new node with msg to the headlines list after a given node.
     * @param node the node to add after
     * @param msg the msg to add
     * @return newNode a reference to the added node.
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>( msg,
            node,
            node.getNext() );
        node.getNext().setPrevious( newNode );
        node.setNext( newNode );
        return newNode;
    }


    /**
     * Removes a given node from the list.
     * @param node the node to remove
     */
    private void remove( ListNode2<String> node )
    {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }


    /**
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * @param g the graphic
     * @param x the x value
     * @param y the y value
     * @param lineHeight the lines height
     * @param nLines the number of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node
            .getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}