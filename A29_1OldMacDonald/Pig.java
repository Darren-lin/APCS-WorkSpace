/**
 * Makes a Pig with parameters type and sound Makes a pig and returns the sound
 * and type of animal
 *
 * @author Darren Lin
 * @version Oct 29, 2019
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: none
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * @param type
     *            Pig is type pig
     * @param sound
     *            is the sound of the pig
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * getSound method returns the sound of the animal
     * 
     * @return mySound is the sound
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * getType returns the type of animal
     * 
     * @return myType is the type of animal
     */
    public String getType()
    {
        return myType;
    }

}
