import javax.swing.JFrame;
import javax.swing.*;

public class Spielbrett extends JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JButton single;
	private JButton multi;
	private JButton tut;
	private JButton end;
	
    public Spielbrett() {
    	super();
    	//pack();
    	JFrame frame = new JFrame ("Dame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false);
        frame.setVisible(true);
        
        Welt welt = new Welt();
        
        
        single = new JButton("Singleplayer");
        single.setBounds(80,20,600,100);
        add(single);
        
    }
    public void menu() {
    	JMenuBar bar = new JMenuBar();
    	JMenu menu = new JMenu("Datei");
    	
    	bar.add(menu);
    	setJMenuBar(bar);
    }
}