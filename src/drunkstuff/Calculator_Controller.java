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
                this.view.sexChooser().addActionListener(L_sex);

        addActionListeners();
    }
    
    public void updateUI() {
        view.setVisible(true);
    }
    
    private void addActionListeners() {
        this.view.getSexChooser().addActionListener(L_sex);
        this.view.sexChooser().addActionListener(L_sex);
    }
    
    
    private ActionListener L_sex = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
                        System.out.println(e.getWhen());

        }
        
    };
    
}
