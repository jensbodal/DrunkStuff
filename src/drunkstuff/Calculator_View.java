/*
 * Calculator_View.java
 */ 

package drunkstuff;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jens Bodal
 */
public class Calculator_View extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final int X = 10;
    private final int Y = 10;
    
    BorderLayout layout; // = new BorderLayout();
    JTextField age;
    JComboBox sex;
    JPanel panel;
    
    public Calculator_View(Person person) {
        init();
    }
    
    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new BorderLayout();
        this.setLayout(layout);
        this.setBounds(X, Y, WIDTH, HEIGHT);
        
        this.add(mainPanel());
        
    }
    
    private JPanel mainPanel() {
        panel = new JPanel();
        panel.add(sexChooser());
        return this.panel;
    }
    
    private JComboBox sexChooser() {
        String[] sexes = {"Male", "Female"};
        this.sex = new JComboBox(sexes);
        
        return this.sex;
    }
}
