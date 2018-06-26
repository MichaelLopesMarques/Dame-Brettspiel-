import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Highscore extends JFrame {
		
	private JLabel platz = new JLabel();
	private JLabel score = new JLabel();
	private JLabel name = new JLabel();
	private JTextField textfeld = new JTextField();
	public static JButton save = new JButton();

		public Highscore(){
		this.setTitle("Highscore");									//Einstellungen für das Fenster
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(580,500);
    	this.setVisible(true);	
    	this.setLayout(null);
    	this.setLocationRelativeTo(null);
    	
    	platz.setBounds(80, 24, 52, 29);
        platz.setText("Platz");
        platz.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz);
        
        name.setBounds(220, 24, 65, 29);
        name.setText("Name");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name);
        
        score.setBounds(400, 24, 64, 29);
        score.setText("Score");
        score.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score);
        
        textfeld.setBounds(200, 384, 113, 24);
        textfeld.setText("Name");
        this.add(textfeld);
        
        save.setBounds(200, 416, 113, 41);
        save.setText("Speichern");
        this.add(save);
        
		}
}