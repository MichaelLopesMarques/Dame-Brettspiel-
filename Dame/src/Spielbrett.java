import javax.swing.JFrame;
import javax.swing.*;

public class Spielbrett extends JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton single;
	private JButton multi;
	private JButton tut;
	private JButton end;
	private JFrame frame;
	
    public Spielbrett() {
    	super();
    	//pack();
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1280,720);
    	
        
        Welt welt = new Welt();
        
        
        single = new JButton("Singleplayer");
        single.setBounds(80,20,600,100);
        this.add(single);
        
        menu();
        
    	this.setResizable(false);
    	this.setVisible(true);
    }
    public void menu() {
    	JMenuBar bar = new JMenuBar();
    	JMenu menu = new JMenu("Datei");
    	
    	bar.add(menu);
    	this.add(bar);
    	setJMenuBar(bar);
    }
}