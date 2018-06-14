import java.awt.Graphics;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Tutorial extends JFrame {

	public Tutorial(){
		this.setTitle("Dame Tutorial");
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(1200,900);
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    	this.setLocationRelativeTo(null);
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("bilder/Download.png"),100,100,this);
		
		
	}
	

}
