package drunkstuff;

import javax.swing.JFrame;

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
        Person person = new Person("Male", 155, 27, 8, 4);
        System.out.println(person.AmIDrunk());
        System.out.println(person.getBAC());
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = new Calculator_Controller(view, person);
        controller.updateUI();

    }

}
