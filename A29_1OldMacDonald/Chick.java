/**
 * This class creats a chick and prints out a random sound This class prints out
 * a random sound and returns it to Farm which prints it out
 *
 * @author Darren Lin
 * @version Oct 29, 2019
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: none
 */
class Chick implements Animal
{
    private String myType;

    private String mySound;

    private String myOtherSound;


    /**
     * @param type
     *            is chick
     * @param sound
     *            the sound of the chick
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * @param type
     *            is chick
     * @param defSound
     *            makes sound 1
     * @param otherSound
     *            makes sound 2
     */
    public Chick( String type, String defSound, String otherSound )
    {
        myType = type;
        mySound = defSound;
        myOtherSound = otherSound;
    }


    /**
     * getSound gets the sound of the chick
     * 
     * @return mySound is sound 1
     */
    public String getSound()
    {
        if ( myOtherSound.equals( "" ) )
        {
            return mySound;
        }
        else
        {
            int num = (int)( ( Math.random() + .5 ) * 2 );
            if ( num == 1 )
            {
                return mySound;
            }
            else
            {
                return myOtherSound;
            }
        }
    }


    /**
     * gets the type of the animal
     * 
     * @return myType the type of animal
     */
    public String getType()
    {
        return myType;
    }

}