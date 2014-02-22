/*
 * Calculator_Controller.java
 */ 

package drunkstuff;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_Controller {
    Calculator_View view;
    Person person;
    
    public Calculator_Controller(Calculator_View view, Person person) {
        this.view = view;
        this.person = person;
    }
    
    public void updateUI() {
        view.setVisible(true);
    }
}
