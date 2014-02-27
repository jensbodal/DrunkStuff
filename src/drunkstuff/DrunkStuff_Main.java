package drunkstuff;

import javax.swing.JApplet;
import javax.swing.JFrame;


/**
 *
 * @author jensb
 */
public class DrunkStuff_Main extends JApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person = new Person();
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = 
                new Calculator_Controller(view, person);
        JFrame frame = new JFrame();
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(view.bounds());
        frame.setVisible(true);
    }
    
    public DrunkStuff_Main() {
        Person person = new Person("Male", 202, 27, 8, 4);
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = 
                new Calculator_Controller(view, person);
        this.add(view);
    }
        /*
         * Person(
         *  Gender, Weight, Age, Drinks, Hours
         * );
         */
        


    }

