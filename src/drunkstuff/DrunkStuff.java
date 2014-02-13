package drunkstuff;

/**
 *
 * @author jensb
 */
public class DrunkStuff 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /*
         * Person(
         *  Gender, Weight, Age, Drinks, Hours
         * );
         */
        Person person = new Person("male", 210, 27, 3, 0);
        System.out.println(person.getBAC());
        System.out.println(person.AmIDrunk());
    }

}
