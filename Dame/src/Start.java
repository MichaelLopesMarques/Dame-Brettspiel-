import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Start extends JFrame implements MouseListener, ActionListener{
    

	private static final long serialVersionUID = 1L;
	
	private JButton single, multi, tut, end;	//Initalisierung der JButton & JFrames

	
    public Start() {
    	super();								//pack();
    	this.setTitle("Dame");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(400,400);
        
        single = new JButton("Singleplayer");	//Name des neuen Buttons + Beschreibung 
        single.setBounds(120,40,160,40);		//Position + Größe des Buttons 
        this.add(single);						//Button wird hinzugefügt
        
        multi = new JButton("Multiplayer");
        multi.setBounds(120,110,160,40);
        this.add(multi);

        tut = new JButton("Tutorial");
        tut.setBounds(120,180,160,40);
        this.add(tut);
        
        end = new JButton("Beenden");
        end.setBounds(120,250,160,40);
        this.add(end); 
        

        single.addActionListener(this);			//Buttons wird der Actionlistner hinzugefügt
        multi.addActionListener(this);
        tut.addActionListener(this);
        end.addActionListener(this);
        
        
     	this.setLocationRelativeTo(null);		//setzt das Fenster in die mitte
     	this.setLayout(null);					
     	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    }
    

    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(single)) {				//wenn man den Button drückt
			setVisible(false);
			Welt welt = new Welt();				//Objekt Welt wird erzeugt
		}
		if(source.equals(multi)) {
			Welt welt = new Welt();
		}
		if(source.equals(tut)) {
			Tutorial tutorial = new Tutorial();
		}
		if(source.equals(end)) {
			System.exit(0);						//Programm wird beendet
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