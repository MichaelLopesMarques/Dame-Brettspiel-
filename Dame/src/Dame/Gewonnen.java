package Dame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gewonnen extends JFrame implements ActionListener{
    
	private static JTextField textfeld = new JTextField();
	private static JButton speicher = new JButton();
	private JLabel zeit = new JLabel();
	private JLabel farbe = new JLabel();
	
	public Gewonnen() {
    	super();								//pack();
    	this.setTitle("Gewonnen");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(600,300);
   
    	menu();
        
     	this.setLocationRelativeTo(null);		//setzt das Fenster in die mitte
     	this.setLayout(null);					
     	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    }
    
    public void menu() {
        textfeld.setBounds(100, 200, 250, 40);
        textfeld.setText("Name");
        this.add(textfeld);
        
        speicher.setBounds(400, 200, 100, 40);
        speicher.setText("Speichern");
        speicher.addActionListener(this);
        speicher.setActionCommand("save");
        this.add(speicher);
        
        zeit.setBounds(50, 50, 100, 40);
        zeit.setText("Zeit in sec: "+Welt.zeit);
        zeit.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(zeit);
        
        if(Welt.weisssteinda==0) {
        	farbe.setBounds(350, 50, 200, 40);
        	farbe.setText("Gewonnen hat schwarz");
        	farbe.setHorizontalAlignment(SwingConstants.CENTER);
        	this.add(farbe);
        }else if(Welt.schwarzsteinda==0) {
        	farbe.setBounds(350, 50, 200, 40);
        	farbe.setText("Gewonnen hat weiss");
        	farbe.setHorizontalAlignment(SwingConstants.CENTER);
        	this.add(farbe);
        }
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
