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
        Person person = new Person("male", 220, 27, 5, 1);
        System.out.printf("%.5s%n", person.getBAC());
        System.out.println(person.AmIDrunk());
    }

}
