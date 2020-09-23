/**
 * This class is a named cow which has all the properties of cow but has a
 * differnt name This class is run by OldMacDonald and it prints out the name of
 * the cow and the sound it makes
 *
 * @author Darren Lin
 * @version Oct 29, 2019
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: none
 */
class NamedCow extends Cow
{
    private String nameOfCow;


    /**
     * @param name
     *            is the name of the named cow
     * @param sound
     *            of the cow
     * @param type
     *            is cow
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        nameOfCow = name;
    }


    /**
     * @param type
     *            is the same type from the cow class
     * @param sound
     *            is the sound of the cow
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * gets the name of the cow
     * 
     * @return nameOfCow which is the name of the cow
     */
    public String getName()
    {
        return nameOfCow;
    }
}
