import java.util.*;


/**
 * Responsible for queuing and dispatching messages
 * 
 * @author Darren Lin
 * @version 1/22/20
 * 
 * @author Period - 4
 * @author Assignment - JMCh21_6ActorsWorld
 * 
 * @author Sources - none
 */

public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;


    /**
     * signs up the actor
     * @param actor the actor signed up
     */
    public void signUp( Actor actor )
    {
        actors.add( actor );
    }


    /**
     * creates the server
     */
    public MailServer()
    {
        actors = new TreeSet<Actor>();
    }


    /**
     * dispatches the message
     * @param msg that is dispatched
     */
    public void dispatch( Message msg )
    {
        if ( msg.getRecipient() != null )
        {
            msg.getRecipient().receive( msg );
        }
        else
        {
            for ( Actor actor : actors )
            {
                if ( actor.getName() != msg.getSender().getName() )
                {
                    actor.receive( msg );
                }
            }
        }
    }


    // for testing purposes only
    /**
     * protected getActors
     * @return actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
