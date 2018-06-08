import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.image.BufferedImage;

public class Welt extends JFrame {
	
	private static int laengeFeld=8;
	private static int breiteFeld=8;
	
	private static int weiteFenster = 1000;
	private static int hoeheFenster = 1000;
	
	private int gerade=0;
	
	private Feld[][] feld;
	
	private Screen screen;
	
	private BufferedImage weiss = Bilder.Anpassung(Bilder.labeBild("bilder/weiss.png"), Feld.gethoeheW(),Feld.getweiteW());
	private BufferedImage schwarz = Bilder.Anpassung(Bilder.labeBild("bilder/schwarz.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private BufferedImage weissstein = Bilder.Anpassung(Bilder.labeBild("bilder/weissstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	private BufferedImage schwarzstein = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	public Welt() {
		super("Dame");
    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(weiteFenster,hoeheFenster);
    	menu();
    		
    	
    	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    	
    	screen=new Screen();																			//neues Objekt der Klasse Screen
		add(screen);
    	
    	brett();
    	
    	screen.repaint();
	}
	
    public void menu() {
    	JMenuBar bar = new JMenuBar();			//Menübar wird erzeugt
    	JMenu menu = new JMenu("Datei");		//Menuspalte wird erzeugt und Datei genannt
    	
    	bar.add(menu);							//Menüspalten werden der Menüzeile hinzugefügt
    	this.add(bar);							//???
    	setJMenuBar(bar);						//Menü wird gesetzt
    }
    
	public void brett() {
		int z=0;
    
		feld = new Feld[laengeFeld][breiteFeld];
		for (int x=0;x<laengeFeld;x++) {
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y]=new Feld(x,y,weiss,schwarz,weissstein,schwarzstein);
				gerade=x+y;
				if (gerade%2==0) {
					feld[x][y].setWeiss(weiss);
					System.out.print(1);
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}else {
					if(y<=2) {
						feld[x][y].setSchwarzstein(schwarzstein);
						System.out.print(2);
					}else if (y>=5) {
						System.out.print(3);
						feld[x][y].setWeissstein(weissstein);
					}else {
						feld[x][y].setSchwarz(schwarz);
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
	
	public class Screen extends JPanel{					//Unterklasse von JFrame (JPanel)
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {		//Überschreiben der Methode paintComponet in JPanel
			draw(g); 		//wird das Feld gezeichnet						//die welt wird gezeichnet
		}
	}
	
	public void draw(Graphics g) {			//hier wird fett gezeichnet
		for (int x=0;x<laengeFeld;x++) {		//Schleifen damit dann trotzdem eine NullPointException auftritt und es dann funkt
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y].draw(g); 		//wird das Feld gezeichnet
			}
		}
		
	}
}
