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
	
	private JButton single, multi, tut, end;	//Initalisierung der JButton & JFrames
	
	public static boolean bot;
	
	
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
		single.repaint();
		multi.repaint();
		tut.repaint();
		end.repaint();
	}
	
    public void menubuttons(){
    	Font font = new Font("Tw Cen MT Condensed Extra Bold",0,24);
    	
        single = new JButton("Single");	//Name des neuen Buttons + Beschreibung 
        single.setBounds(100,130,90,40);		//Position + Größe des Buttons 
        single.setFont(font);
        single.setBackground(Color.BLACK);
        single.setForeground(Color.WHITE);
        single.setFocusPainted(false);
        this.add(single);						//Button wird hinzugefügt
        
        multi = new JButton("Multi");	//Name des neuen Buttons + Beschreibung 
        multi.setBounds(210,130,90,40);		//Position + Größe des Buttons 
        multi.setFont(font);
        multi.setBackground(Color.BLACK);
        multi.setForeground(Color.WHITE);
        multi.setFocusPainted(false);
        this.add(multi);						//Button wird hinzugefügt


        tut = new JButton("Tutorial");
        tut.setBounds(100,200,200,40);
        tut.setFont(font);
        tut.setBackground(Color.BLACK);
        tut.setForeground(Color.WHITE);
        tut.setFocusPainted(false);
        this.add(tut);
        
        end = new JButton("Beenden");
        end.setBounds(100,270,200,40);
        end.setFont(font);
        end.setBackground(Color.BLACK);
        end.setForeground(Color.WHITE);
        end.setFocusPainted(false);
        	this.add(end); 
        

        single.addActionListener(this);				//Buttons wird der Actionlistner hinzugefügt
        tut.addActionListener(this);
        end.addActionListener(this);
        multi.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(single)) {				//wenn man den Button drückt
			//setVisible(false);
			bot=true;
			new Welt();				//Objekt Welt wird erzeugt
			

		}
		if(source.equals(multi)) {
			bot=false;
			new Welt();
			
		}
		if(source.equals(tut)) {
			new Tutorial();
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