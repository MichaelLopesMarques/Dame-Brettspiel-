package Dame;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Start extends JFrame implements MouseListener, ActionListener{
    

	private static final long serialVersionUID = 1L;
	
	private JButton play, tut, end;	//Initalisierung der JButton & JFrames
	
	
    public Start() {
    	super();								//pack();
    	this.setTitle("Dame");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(400,400);
    	
        
    	menubuttons();
        
     	this.setLocationRelativeTo(null);		//setzt das Fenster in die mitte
     	this.setLayout(null);					
     	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    }
    
	public void paint(Graphics g){
		//super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Start.png"),0,23,400,400,this);	//Grafik wird ins Fenster eingefügt
		play.repaint();
		tut.repaint();
		end.repaint();
	}
	
    public void menubuttons(){
    	Font font = new Font("Tw Cen MT Condensed Extra Bold",0,24);
    	
        play = new JButton("Start");	//Name des neuen Buttons + Beschreibung 
        play.setBounds(120,130,160,40);		//Position + Größe des Buttons 
        play.setFont(font);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.WHITE);
        play.setFocusPainted(false);
        this.add(play);						//Button wird hinzugefügt

        tut = new JButton("Tutorial");
        tut.setBounds(120,200,160,40);
        tut.setFont(font);
        tut.setBackground(Color.BLACK);
        tut.setForeground(Color.WHITE);
        tut.setFocusPainted(false);
        this.add(tut);
        
        end = new JButton("Beenden");
        end.setBounds(120,270,160,40);
        end.setFont(font);
        end.setBackground(Color.BLACK);
        end.setForeground(Color.WHITE);
        end.setFocusPainted(false);
        	this.add(end); 
        

        play.addActionListener(this);				//Buttons wird der Actionlistner hinzugefügt
        tut.addActionListener(this);
        end.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(play)) {				//wenn man den Button drückt
			setVisible(false);
			new Welt();				//Objekt Welt wird erzeugt

		}
		if(source.equals(tut)) {
			new Gewonnen();
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