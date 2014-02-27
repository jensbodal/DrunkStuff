/*
 * Calculator_View.java
 */ 

package drunkstuff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_View extends JPanel {
    private final int v_WIDTH = 400;
    private final int v_HEIGHT = 100;
    private final int X = 10;
    private final int Y = 10;
    private final Dimension fieldDimensions = new Dimension(50, 20);
    //asdf
    public Rectangle bounds = new Rectangle(X, Y, v_WIDTH, v_HEIGHT);
    
    
    private JComboBox sexChooser;
    private JTextField BAC_Field;
    private JTextField age_Field;
    private JTextField weight_Field;
    private JTextField drinks_Field;
    private JTextField hours_Field;
    //
    private BorderLayout layout; // = new BorderLayout();
    private JPanel panel;
    private Person person;
    
    public Calculator_View(Person person) {
        this.person = person;
        startup();
    }
    
    public void updatePerson(Person person) {
        this.person = person;
        setBAC_Field(person.getBAC());
        setAge_Field(person.getAge());
        setWeight_Field(person.getWeight());
        setDrinks_Field(person.getNumberOfDrinks());
        setHours_Field(person.getHoursSinceFirstDrink());
    }
    
    private void startup() {
        layout = new BorderLayout();
        this.setLayout(layout);
        this.setBounds(X, Y, v_WIDTH, v_HEIGHT);
        
        // Initialize all fields
        initSexChooser();
        initBAC_Field();
        initAge_Field();
        initWeight_Field();
        initDrinks_Field();
        initHours_Field();
        this.add(mainPanel());
        // Add all panels
//        this.add(sexChooser);
//        this.add(BAC_Field);
//        this.add(age_Field);
//        this.add(weight_Field);
//        this.add(drinks_Field);
//        this.add(hours_Field);
    }
    
    private JPanel mainPanel() {
        panel = new JPanel();
        panel.add(sexChooser);
        panel.add(BAC_Field);
        panel.add(age_Field);
        panel.add(weight_Field);
        panel.add(drinks_Field);
        panel.add(hours_Field);
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
        BAC_Field.setPreferredSize(fieldDimensions);
        BAC_Field.setText(String.valueOf(this.person.getBAC()));
        BAC_Field.setEditable(false);
    }
    
    private void setBAC_Field(double BAC) {
        String stringBAC = String.valueOf(BAC);
        BAC_Field.setText(stringBAC);
    }
    
    private void initAge_Field() {
        age_Field = new JTextField();
        age_Field.setPreferredSize(fieldDimensions);
        age_Field.setText(String.valueOf(this.person.getAge()));
    }
    
    private void setAge_Field(int age) {
        age_Field.setText(String.valueOf(age));
    }
    
    public JTextField getAge_Field() {
        return age_Field;
    }
    
    private void initWeight_Field() {
        weight_Field = new JTextField();
        weight_Field.setPreferredSize(fieldDimensions);
        weight_Field.setText(String.valueOf(this.person.getWeight()));
    }
    
    private void setWeight_Field(double weight) {
        weight_Field.setText(String.valueOf(weight));
    }
    
    public JTextField getWeight_Field() {
        return weight_Field;
    }
    
    private void initDrinks_Field() {
        drinks_Field = new JTextField();
        drinks_Field.setPreferredSize(fieldDimensions);
        drinks_Field.setText(String.valueOf(this.person.getNumberOfDrinks()));
    }
    
    private void setDrinks_Field(double drinks) {
        drinks_Field.setText(String.valueOf(drinks));
    }
    
    public JTextField getDrinks_Field() {
        return drinks_Field;
    }
    
    private void initHours_Field() {
        hours_Field = new JTextField();
        hours_Field.setPreferredSize(fieldDimensions);
        hours_Field.setText(String.valueOf
                (this.person.getHoursSinceFirstDrink()));
    }
    
    private void setHours_Field(double hours) {
        hours_Field.setText(String.valueOf(hours));
    }
    
    public JTextField getHours_Field() {
        return hours_Field;
    }
}
