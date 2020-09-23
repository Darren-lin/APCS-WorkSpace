/**
 * This class holds the animals and its sounds This class will automatically
 * test the sounds of the animals
 * 
 * @author Darren Lin
 * @version 10/28/19 
 * Period - 4 
 * Assignment - A29.1 Old MacDonald
 * 
 * 
 * Sources - none
 */
public class Farm
{
    private Animal[] a = new Animal[3];


    /**
     * Farm holds the animals
     */
    public Farm()
    {
        a[0] = new Cow( "cow", "moo moo" );
        a[0] = new NamedCow( "cow", "Elsie", "moo" );
        a[1] = new Chick( "chick", "cluck cluck" );
        a[1] = new Chick( "chick", "cluckity cluck", "cheep" );
        a[2] = new Pig( "pig", "oink oink" );
    }


    /**
     * Animalsounds holds the sounds of the animals and prints out *animal* goes
     * *sound*
     */
    public void animalSounds()
    {
        for ( int i = 0; i < a.length; i++ )
        {
            System.out.println( a[i].getType() + " goes " + a[i].getSound() );
        }
        NamedCow named = (NamedCow)a[0];
        System.out.println( named.getType() + " is named " + named.getName() );
    }
}
