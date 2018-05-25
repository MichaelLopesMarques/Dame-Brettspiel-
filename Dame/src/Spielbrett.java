import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class Spielbrett extends JFrame {
	
    
    public static void main(String[] args) {
    	
        Spielbrett frame = new Spielbrett("Dame");
        frame.setTitle("Dame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setVisible(true);
    }
    public Spielbrett(String title) {
    	super(title);
    }
}