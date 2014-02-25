/*
 * Calculator_Controller.java
 */ 

package drunkstuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_Controller {
    private Calculator_View view;
    private Person person;
    
    public Calculator_Controller(Calculator_View view, Person person) {
        this.person = person;
        this.view = view;
        this.addActionListeners();
    }
    
    public void updateUI() {
        view.setVisible(true);
    }
    
    private void addActionListeners() {
        view.getSexChooser().addActionListener(L_Sex());
        //this.view.getSexChooser().getSelectedItem();
        //this.view.sexChooser.addActionListener(L_Sex());
        
    }
    
    private ActionListener L_Sex() {
        
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String sex = view.getSelectedSex();
                person = new Person(sex, person.getWeight(), person.getAge(),
                        person.getNumberOfDrinks(), 
                        person.getHoursSinceFirstDrink());
                view.updatePerson(person);
            }
        };
    }

        
    
    
}
