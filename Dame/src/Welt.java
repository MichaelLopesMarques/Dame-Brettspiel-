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
	
	private static int weiteFenster = 800;
	private static int hoeheFenster = 800;
	
	private int gerade=0;
	
	private Feld[][] feld;
	
	private Screen screen;
	
	private BufferedImage weiss = Bilder.Anpassung(Bilder.labeBild("bilder/weiss.png"), Feld.gethoeheW(),Feld.getweiteW());
	private BufferedImage schwarz = Bilder.Anpassung(Bilder.labeBild("bilder/schwarz.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	public Welt() {
		super("Dame");
    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(weiteFenster,hoeheFenster);
    	menu();
    		
    	
    	this.setResizable(false);				//�nderung der Gr��e des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    	
    	screen=new Screen();																			//neues Objekt der Klasse Screen
		add(screen);
    	
    	brett();
    	
    	screen.repaint();
	}
	
    public void menu() {
    	JMenuBar bar = new JMenuBar();			//Men�bar wird erzeugt
    	JMenu menu = new JMenu("Datei");		//Menuspalte wird erzeugt und Datei genannt
    	
    	bar.add(menu);							//Men�spalten werden der Men�zeile hinzugef�gt
    	this.add(bar);							//???
    	setJMenuBar(bar);						//Men� wird gesetzt
    }
    
	public void brett() {
		int z=0;
    
		feld = new Feld[laengeFeld][breiteFeld];
		for (int x=0;x<laengeFeld;x++) {
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y]=new Feld(x,y,weiss,schwarz);
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
					if(x<=2) {
						feld[x][y].setSchwarz(schwarz);
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
	
	public class Screen extends JPanel{					//Unterklasse von JFrame (JPanel)
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {		//�berschreiben der Methode paintComponet in JPanel
			try {										//was Hochriskantes passiert hier mal wieder (huhu riskant!)
				draw(g); 		//wird das Feld gezeichnet						//die welt wird gezeichnet
			} catch (NullPointerException e) {			//f�ngt eine NullPointerException ab, weil die warum auch immer kommt
							
			}
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
