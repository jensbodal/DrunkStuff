package drunkstuff;

import javax.swing.JApplet;


/**
 *
 * @author jensb
 */
public class DrunkStuff_Main extends JApplet {

    /**
     * @param args the command line arguments
     */
    public DrunkStuff_Main() {
        /*
         * Person(
         *  Gender, Weight, Age, Drinks, Hours
         * );
         */
        Person person = new Person("Male", 202, 27, 8, 4);
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = 
                new Calculator_Controller(view, person);
        this.add(view);

    }

}
