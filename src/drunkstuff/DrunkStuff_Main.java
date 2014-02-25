package drunkstuff;

import javax.swing.JFrame;

/**
 *
 * @author jensb
 */
public class DrunkStuff_Main
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
        Person person = new Person("Male", 202, 27, 8, 4);
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = 
                new Calculator_Controller(view, person);
        controller.updateUI();

    }

}
