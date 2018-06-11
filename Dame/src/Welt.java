import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Point;

import java.awt.image.BufferedImage;

public class Welt extends JFrame implements MouseListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	protected static int laengeFeld=8;
	protected static int breiteFeld=8;
	
	private static int weiteFenster = 800;
	private static int hoeheFenster = 800;
	private int menuhoehe=23;
	
	protected static Feld[][] feld;
	
	private Screen screen;
	
	static JMenuItem dateiNew, dateiEnd;
	
	private BufferedImage weiss = Bilder.Anpassung(Bilder.labeBild("bilder/weiss.png"), Feld.gethoeheW(),Feld.getweiteW());
	private BufferedImage schwarz = Bilder.Anpassung(Bilder.labeBild("bilder/schwarz.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private BufferedImage weissstein = Bilder.Anpassung(Bilder.labeBild("bilder/weissstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	private BufferedImage schwarzstein = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	public Welt() {
		super("Dame");
    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(weiteFenster+getInsets().left,hoeheFenster+getInsets().top+menuhoehe);
    	setLocationRelativeTo(null);						//setzt das Fenster in die mitte
    	menu();
    		
    	this.setResizable(false);				//Änderung der Größe des Fensters wird deaktivert
    	this.setVisible(true);					//Fenster wird sichtbar gemacht
    	
    	screen=new Screen();					//neues Objekt der Klasse Screen
		add(screen);
    	
		this.addMouseListener(this);
		
    	brett();
	}
	
    public void menu() {
    	JMenuBar bar = new JMenuBar();			//Menübar wird erzeugt
    	
    	JMenu datei = new JMenu("Datei");		//Menuspalte wird erzeugt und Datei genannt
    	JMenu high = new JMenu("Highscore");	//Menuspalte wird erzeugt und Highscore genannt
    	JMenu opt = new JMenu("Optionen");		//Menuspalte wird erzeugt und Optionen genannt
    	JMenu help = new JMenu("Hilfe");			//Menuspalte wird erzeugt und Hilfe genannt
    	
    	dateiNew = new JMenuItem("Neues Spiel");	
    	dateiEnd = new JMenuItem("Beenden");
    
    	
    	datei.add(dateiNew);
    	datei.add(dateiEnd);
    	
    	dateiEnd.addActionListener(this);			//Menüpunkt wird der Actionlistner hinzugefügt   
    	dateiNew.addActionListener(this);
    	high.addActionListener(this);
    	opt.addActionListener(this);
    	help.addActionListener(this);
    	
    	bar.add(datei);							//Menüspalten werden der Menüzeile hinzugefügt
    	bar.add(high);								
    	bar.add(opt);
    	bar.add(help);
    	
    	setJMenuBar(bar);						//Menü wird gesetzt
    	

    }
    
	public void brett() {
		int z=0;
    
		feld = new Feld[laengeFeld][breiteFeld];
		for (int x=0;x<laengeFeld;x++) {
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y]=new Feld(x,y,weiss,schwarz,weissstein,schwarzstein);
				if ((x+y)%2==0) {
					feld[x][y].setLeerFeld(true);
					feld[x][y].setWeiss(weiss);
					System.out.print(0);
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}else {
					if(y<=2) {
						feld[x][y].setSchwarzSpieler(true);
						feld[x][y].setSchwarzstein(schwarzstein);
						System.out.print(1);
					}else if (y>=5) {
						feld[x][y].setWeissSpieler(true);
						feld[x][y].setWeissstein(weissstein);
						System.out.print(2);
					}else {
						feld[x][y].setLeerFeld(true);
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
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			Regel.klicklinks(e.getX()-getInsets().left, e.getY()-getInsets().top-menuhoehe);
			screen.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(dateiEnd)) {			
			System.exit(0);						//Programm wird beendet
		}
		if(source.equals(dateiNew)) {			
			brett();							//Das Spielbrett wird neu gezeichnet
			screen.repaint();
		}
	}

}
