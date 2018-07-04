package Dame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Tutorial extends JFrame implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton next, end;
	
	public static int z=1;
	
	public Tutorial(){
		this.setTitle("Dame Tutorial");								//Einstellungen für das Fenster
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(1200,923);
    	
    	Font font = new Font("Tw Cen MT Condensed Extra Bold",0,48);
    	
        next = new JButton("Nächste");	//Name des neuen Buttons + Beschreibung 
        next.setBounds(850,673,320,80);		//Position + Größe des Buttons 
        next.setFont(font);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false);
        this.add(next);		
        
        
        end = new JButton("Ende");	//Name des neuen Buttons + Beschreibung 
        end.setBounds(850,773,320,80);		//Position + Größe des Buttons 
        end.setFont(font);
        end.setBackground(Color.BLACK);
        end.setForeground(Color.WHITE);
        end.setFocusPainted(false);
        this.add(end);		


        end.addActionListener(this);
        next.addActionListener(this);
        
     	this.setLocationRelativeTo(null);		//setzt das Fenster in die mitte
     	this.setLayout(null);					
     	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    	
    	
	}
	public void paint(Graphics g){
		if(z == 1) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 1.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 2) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 2.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 3) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 3.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 4) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 4.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 5) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 5.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 6) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 6.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			
		}
		if(z == 7) {
			g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Tutorial 7.png"),0,23,this);	//Grafik wird ins Fenster eingefügt
			next.setEnabled(false);
			
			
		}
		next.repaint();
		end.repaint();
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source.equals(next)) {				//wenn man den Button drückt
			z++;
			repaint();
		}
		if(source.equals(end)) {				//wenn man den Button drückt
			dispose();
			z=1;
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
