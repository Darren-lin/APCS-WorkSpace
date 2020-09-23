/**
 * This class makes a new farm and the animal sounds This class prints out the
 * type of animal + goes + the sound the animal makes
 *
 * @author Darren Lin
 * @version Oct 29, 2019
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: none
 */
class OldMacDonald
{
    /**
     * Tests the code
     * 
     * @param args
     *            runs the farm
     */
    public static void main( String[] args )
    {
        Cow c = new Cow( "cow", "moo" );
        System.out.println( c.getType() + " goes " + c.getSound() );

        Farm newFarm = new Farm();
        newFarm.animalSounds();
    }
}
