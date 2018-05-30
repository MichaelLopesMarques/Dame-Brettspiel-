import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Spielbrett extends JFrame implements MouseListener, ActionListener{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton single, multi, tut, end;
	private JFrame frame;
	
    public Spielbrett() {
    	super();
    	//pack();
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1200,900);
    	
        
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
        
        single.addActionListener(this);
        multi.addActionListener(this);
        tut.addActionListener(this);
        end.addActionListener(this);
        
        
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
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(end)) {
			System.exit(0);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}