package Dame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Point;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Welt extends JFrame implements MouseListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	protected static int laengeFeld=8;
	protected static int breiteFeld=8;
	
	private static int weiteFenster = 1000;
	private static int hoeheFenster = 800;
	private int menuhoehe=23;
	
	protected static Feld[][] feld;
	
	private static Screen screen;
	
	private static Timer timer;
	private TimerTask timertask;
	public static int zeit=0;
	
	static JMenuItem dateiNew, dateiEnd, sonstigeshigh, sonstigeshelp;
	
	public JLabel amZug = new JLabel();
	public JLabel stoppuhr = new JLabel();
	public JLabel schlagzwang = new JLabel();
	
	public static int weisssteinda, schwarzsteinda;
	
	private static BufferedImage weiss = Bilder.Anpassung(Bilder.labeBild("bilder/weiss.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage schwarz = Bilder.Anpassung(Bilder.labeBild("bilder/schwarz.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private static BufferedImage weissstein = Bilder.Anpassung(Bilder.labeBild("bilder/weissstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage schwarzstein = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzstein.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private static BufferedImage schwarzgewaehlt = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzGewaehlt.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage weissgewaehlt = Bilder.Anpassung(Bilder.labeBild("bilder/weissGewaehlt.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private static BufferedImage schwarzdame = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzsteindame.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage weissdame = Bilder.Anpassung(Bilder.labeBild("bilder/weisssteindame.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private static BufferedImage schwarzdamegewaehlt = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzsteindameGewaehlt.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage weissdamegewaehlt = Bilder.Anpassung(Bilder.labeBild("bilder/weisssteindameGewaehlt.png"), Feld.gethoeheW(),Feld.getweiteW());
	
	private static BufferedImage feldgehen = Bilder.Anpassung(Bilder.labeBild("bilder/schwarzFeldGewaehlt.png"), Feld.gethoeheW(),Feld.getweiteW());
	private static BufferedImage dametitel = Bilder.Anpassung(Bilder.labeBild("bilder/DameTitel.png"), 200,100);
	
	public Welt() {
		super("Dame");
    	this.pack();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(weiteFenster+getInsets().left-2,hoeheFenster+getInsets().top+menuhoehe-2);
    	setLocationRelativeTo(null);				//setzt das Fenster in die mitte
    	menu();
    		
    	this.setResizable(false);					//�nderung der Gr��e des Fensters wird deaktivert
    	this.setVisible(true);						//Fenster wird sichtbar gemacht
    	
    	Font font = new Font("Tw Cen MT Condensed Extra Bold",0,24);
    	
    	stoppuhr.setFont(font);
    	stoppuhr.setBounds(800, 100, 200, 80);
    	this.add(stoppuhr);
    	amZug.setFont(font);
    	amZug.setBounds(800, 200, 200, 100);
    	amZug.setOpaque(true);
    	this.add(amZug);
    	schlagzwang.setFont(font);
    	schlagzwang.setBounds(800, 300, 200, 100);
    	this.add(schlagzwang);
    	
    	
    	screen=new Screen();						//neues Objekt der Klasse Screen
		add(screen);
    	
		this.addMouseListener(this);

    	brett();

	}
	
    public void menu() {
    	JMenuBar bar = new JMenuBar();				//Men�bar wird erzeugt
    	
    	JMenu datei = new JMenu("Datei");			//Menuspalte wird erzeugt 
    	JMenu sonstiges = new JMenu("Sonstiges");	
    	
    	
    	dateiNew = new JMenuItem("Neues Spiel");	//Men�punkte werden erzeugt	
    	dateiEnd = new JMenuItem("Beenden");
    	sonstigeshigh = new JMenuItem("Highscore");
    	sonstigeshelp = new JMenuItem("Hilfe");
    
    	
    	datei.add(dateiNew);						//Men�punkt wird der Men�spalte eingef�gt
    	datei.add(dateiEnd);
    	sonstiges.add(sonstigeshigh);
    	sonstiges.add(sonstigeshelp);
    	
    	dateiEnd.addActionListener(this);			//Men�punkt wird der Actionlistner hinzugef�gt   
    	dateiNew.addActionListener(this);
    	sonstigeshigh.addActionListener(this);
    	sonstiges.addActionListener(this);
    	sonstigeshelp.addActionListener(this);
    	
    	bar.add(datei);								//Men�spalten werden der Men�zeile hinzugef�gt								
    	bar.add(sonstiges);

    	
    	setJMenuBar(bar);							//Men� wird gesetzt
    	

    }

	public static void brett() {
		int z=0;
    
		feld = new Feld[laengeFeld][breiteFeld];
		for (int x=0;x<laengeFeld;x++) {
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y]=new Feld(x,y,weiss,schwarz,weissstein,schwarzstein,schwarzgewaehlt,weissgewaehlt, schwarzdame, weissdame, feldgehen, 
						schwarzdamegewaehlt,weissdamegewaehlt, dametitel);
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
		public void paintComponent(Graphics g) {		//�berschreiben der Methode paintComponet in JPanel
			draw(g); 		//wird das Feld gezeichnet						//die welt wird gezeichnet
			stoppuhr.repaint();
	    	if(Regel.getWertWeiss() > 0 && Regel.getWertSchwarz() == 0) {
	    		amZug.setBackground(Color.WHITE);
	    		amZug.setForeground(Color.BLACK);
	    		amZug.setText("<html><body>Weiss<br>am Zug</html>");
	    		amZug.repaint();
	    	}else if(Regel.getWertWeiss() == 0 && Regel.getWertSchwarz() > 0) {
	    		amZug.setBackground(Color.BLACK);
	    		amZug.setForeground(Color.WHITE);
	    		amZug.setText("<html><body>Schwarz<br>am Zug</html>");
	    		amZug.repaint();
	    	}
	    	if(Regel.kannspringen == true) {
	    		schlagzwang.setText("Schlagzwang!");
	    		schlagzwang.repaint();
	    	}else {
	    		schlagzwang.setText("Beliebiger Zug");
	    		schlagzwang.repaint();
	    	}
		}
	}
	
	public void draw(Graphics g) {				//hier wird fett gezeichnet
		for (int x=0;x<laengeFeld;x++) {		//Schleifen damit dann trotzdem eine NullPointException auftritt und es dann funkt
			for (int y=0;y<breiteFeld;y++) {
				feld[x][y].draw(g); 			//wird das Feld gezeichnet
			}
		}
		
	}
	
	public void timer() {
		timer=new Timer();									//neuer Timer wird erstellt
		timertask = new TimerTask() {						//neuer Timertask wird erstellt
			@Override
			public void run() {								//dadrin ist die Methode run
				zeit++;
				System.out.println(zeit);
		    	stoppuhr.setText("Zeit: " + zeit);
				//screen.repaint();
			}
			
		};	

	}
	
	private void hatWergewonnen() {		
		weisssteinda=0;
		schwarzsteinda=0;
		for (int x=0;x<laengeFeld;x++) {	
			for (int y=0;y<breiteFeld;y++) {
				if(feld[x][y].getWeissSpieler()==true||feld[x][y].getWeissDame()==true||feld[x][y].getWeissWahl()==true||feld[x][y].getWeissdameWahl()==true) {
					weisssteinda++;
				}else if(feld[x][y].getSchwarzSpieler()==true||feld[x][y].getSchwarzDame()==true||feld[x][y].getSchwarzWahl()==true||feld[x][y].getSchwarzdameWahl()==true) {
					schwarzsteinda++;
				}
			}
		}
		if(weisssteinda==0||schwarzsteinda==0) {
			new Gewonnen();
			System.out.println("Gewonnen");
			timer.cancel();
		}
	}
	
	public static void Reset() {
		Regel.wertWeiss=0;
		Regel.wertSchwarz=1;
		Regel.kannspringen=false;
		timer.cancel();
		zeit=0;
		brett();							//Das Spielbrett wird neu gezeichnet
		screen.repaint();
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
			if(Regel.wertSchwarz>0 && Start.bot==true) {
				Bot.Bot();
			}
			screen.repaint();
			if(zeit==0) {														//wenn die zeit auf 0 ist
				timer();														//dann wird die Methode Timer gesetzt
				timer.scheduleAtFixedRate(timertask, 0, 1000);					//timer soll jetzt im sekundentakt hochlaufen
			}
		}
		hatWergewonnen();
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
			Reset();
		}
		if(source.equals(sonstigeshelp)) {
			new Tutorial();
		}
		if(source.equals(sonstigeshigh)) {
				new Highscore();
	   }
	}
}
