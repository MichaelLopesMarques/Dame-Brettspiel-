import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.image.BufferedImage;

public class Welt extends JFrame {
	
	private static int laengeF=8;
	private static int breiteF=8;
	private int gerade=0;
	
	private Feld[][] feld;
	
	private BufferedImage weiss = Bilder.Anpassung(Bilder.labeBild("bilder\\Download.png"), 80, 80);
	
	public Welt() {
		super();
    	//pack();
    	this.setTitle("Dame");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1200,900);
    	menu();
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
    
	public void Brett(Graphics g) {
		int z=0;
    
		feld = new Feld[laengeF][breiteF];
		for (int x=0;x<laengeF;x++) {
			for (int y=0;y<breiteF;y++) {
				gerade=x+y;
				if (gerade%2==0) {
					feld[x][y]=new Feld();
					System.out.print(1);
					g.drawImage(weiss,80,80,this);
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}else {
					if(x<=2) {
						System.out.print(2);
					}else if (x>=5) {
						System.out.print(3);
					}else {
						System.out.print(0);
					}
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}
			}
		}
	}
}
