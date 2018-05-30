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
        single.setBounds(520,100,240,50);
        this.add(single);
        
        multi = new JButton("Multiplayer");
        multi.setBounds(520,200,240,50);
        this.add(multi);

        tut = new JButton("Tutorial");
        tut.setBounds(520,300,240,50);
        this.add(tut);
        
        end = new JButton("Beenden");
        end.setBounds(520,400,240,50);
        this.add(end);
        
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