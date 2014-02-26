/*
 * Calculator_View.java
 */ 

package drunkstuff;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_View extends JPanel {
    private final int v_WIDTH = 400;
    private final int v_HEIGHT = 400;
    private final int X = 10;
    private final int Y = 10;
    private JComboBox sexChooser;
    private JTextField BAC_Field;
    //
    private BorderLayout layout; // = new BorderLayout();
    private JTextField age;
    private JPanel panel;
    private Person person;
    
    public Calculator_View(Person person) {
        this.person = person;
        startup();
    }
    
    public void updatePerson(Person person) {
        this.person = person;
        setBAC_Field(person.getBAC());
    }
    
    private void startup() {
        layout = new BorderLayout();
        this.setLayout(layout);
        this.setBounds(X, Y, v_WIDTH, v_HEIGHT);
        
        // Initialize all fields
        initSexChooser();
        initBAC_Field();
        this.add(mainPanel());
        
    }
    
    private JPanel mainPanel() {
        panel = new JPanel();
        panel.add(sexChooser);
        panel.add(BAC_Field);
        return this.panel;
    }
    
    private void initSexChooser() {
        String[] sexes = {"Male", "Female"};
        sexChooser = new JComboBox(sexes);
        
    }
    
    public String getSelectedSex() {
        return sexChooser.getSelectedItem().toString();
    }
    
    public JComboBox getSexChooser() {
        return sexChooser;
    }
    
    private void initBAC_Field() {
        BAC_Field = new JTextField();
        BAC_Field.setText(String.valueOf(this.person.getBAC()));
        BAC_Field.setEditable(false);
    }
    
    private void setBAC_Field(double BAC) {
        String stringBAC = String.valueOf(BAC);
        BAC_Field.setText(stringBAC);
    }
}
