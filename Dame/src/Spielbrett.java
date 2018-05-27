import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class Spielbrett extends JFrame {
    
    public Spielbrett() {
    	super();
    	//pack();
    	JFrame frame = new JFrame ("Dame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setVisible(true);
        
        Welt welt = new Welt();
    }
}