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
	
	private JButton single, multi, tut, end;	//Initalisierung der JButton & JFrames
	private JFrame frame;
	//Welt welt = new Welt();
	
    public Spielbrett() {
    	super();
    	//pack();
    	this.setTitle("Dame");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1200,900);
        
        single = new JButton("Singleplayer");	//Name des neuen Buttons + Beschreibung 
        single.setBounds(520,100,240,50);		//Position + Gr��e des Buttons 
        this.add(single);						//Button wird hinzugef�gt
        
        multi = new JButton("Multiplayer");
        multi.setBounds(520,200,240,50);
        this.add(multi);

        tut = new JButton("Tutorial");
        tut.setBounds(520,300,240,50);
        this.add(tut);
        
        end = new JButton("Beenden");
        end.setBounds(520,400,240,50);
        this.add(end);
        
        menu();									//Methode Menu wird aufgerufen
        
        single.addActionListener(this);			//Buttons wird der Actionlistner hinzugef�gt
        multi.addActionListener(this);
        tut.addActionListener(this);
        end.addActionListener(this);
        
        
    	this.setResizable(false);				//�nderung der Gr��e des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    }
    
    public void menu() {
    	JMenuBar bar = new JMenuBar();			//Men�bar wird erzeugt
    	JMenu menu = new JMenu("Datei");		//Menuspalte wird erzeugt und Datei genannt
    	
    	bar.add(menu);							//Men�spalten werden der Men�zeile hinzugef�gt
    	this.add(bar);							//???
    	setJMenuBar(bar);						//Men� wird gesetzt
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(single)) {			//wenn man den Button dr�ckt
			Welt welt = new Welt();			//Objekt Welt wird erzeugt
		}
		if(source.equals(multi)) {
			Welt welt = new Welt();
		}
		if(source.equals(tut)) {
			Tutorial tutorial = new Tutorial();
		}
		if(source.equals(end)) {
			System.exit(0);					//Programm wird beendet
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