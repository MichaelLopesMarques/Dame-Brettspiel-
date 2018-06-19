import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Feld {
	
	private int x;
	private int y;
	
	private static int weiteW=100;
	private static int hoeheW=100;
	
	private boolean schwarzSpieler;
	private boolean weissSpieler;
	
	private boolean schwarzWahl;
	private boolean weissWahl;
	
	private boolean leerFeld;
	private boolean feldhinbewegen;
	
	private boolean schwarzdameFigur;
	private boolean weissdameFigur;
	
	private boolean schwarzdameWahl;
	private boolean weissdameWahl;
	
	private BufferedImage weiss, schwarz, weissstein, schwarzstein, schwarzgewaehlt,weissgewaehlt,schwarzdame,weissdame, feldbewegen, schwarzdamegewaehlt, weissdamegewaehlt;
	
	public Feld(int x, int y,BufferedImage weiss,BufferedImage schwarz,BufferedImage weissstein,
			BufferedImage schwarzstein,BufferedImage schwarzgewaehlt,BufferedImage weissgewaehlt,BufferedImage schwarzdame, BufferedImage weissdame,
			BufferedImage feldbewegen, BufferedImage schwarzdamegewaehlt, BufferedImage weissdamegewaehlt) {
		this.x=x;
		this.y=y;
		this.weiss=weiss;
		this.schwarz=schwarz;
		this.weissstein=weissstein;
		this.schwarzstein=schwarzstein;
		this.schwarzgewaehlt=schwarzgewaehlt;
		this.weissgewaehlt=weissgewaehlt;
		this.schwarzdame=schwarzdame;
		this.weissdame=weissdame;
		this.feldbewegen=feldbewegen;
		this.schwarzdamegewaehlt=schwarzdamegewaehlt;
		this.weissdamegewaehlt=weissdamegewaehlt;
	}
	
	public void setWeiss(BufferedImage weiss) {
		this.weiss = weiss;
	}
	
	public void setSchwarz(BufferedImage schwarz) {
		this.schwarz=schwarz;
	}
	
	public void setWeissstein(BufferedImage weissstein) {
		this.weissstein=weissstein;
	}
	
	public void setSchwarzstein(BufferedImage schwarzstein) {
		this.schwarzstein=schwarzstein;
	}

	public void draw(Graphics g) {
		if(leerFeld==true) {											//wenn das Feld leer ist
			if ((x+y)%2==0) {
				g.drawImage(weiss, x*weiteW, y*hoeheW, null);
			}else {
				g.drawImage(schwarz, x*weiteW, y*hoeheW, null);
			}
		}else if(weissSpieler==true) {									//weißer stein drauf ist
			g.drawImage(weissstein, x*weiteW, y*hoeheW, null);
		}else if(schwarzSpieler==true) {								//schwarzer stein drauf ist
			g.drawImage(schwarzstein, x*weiteW, y*hoeheW, null);
		}else if(schwarzWahl==true) {									//wenn der stein gedrückt wird
			g.drawImage(schwarzgewaehlt, x*weiteW, y*hoeheW, null);
		}else if(weissWahl==true) {										//wenn der stein gedrückt wird
			g.drawImage(weissgewaehlt, x*weiteW, y*hoeheW, null);
		}else if(schwarzdameFigur==true) {										//wenn der stein gedrückt wird
			g.drawImage(schwarzdame, x*weiteW, y*hoeheW, null);
		}else if(weissdameFigur==true) {										//wenn der stein gedrückt wird
			g.drawImage(weissdame, x*weiteW, y*hoeheW, null);
		}else if(feldhinbewegen==true) {										//wenn der stein gedrückt wird
			g.drawImage(feldbewegen, x*weiteW, y*hoeheW, null);
		}else if(schwarzdameWahl==true) {										//wenn der stein gedrückt wird
			g.drawImage(schwarzdamegewaehlt, x*weiteW, y*hoeheW, null);
		}else if(weissdameWahl==true) {										//wenn der stein gedrückt wird
			g.drawImage(weissdamegewaehlt, x*weiteW, y*hoeheW, null);
		}
	}

	public static int gethoeheW() {
		return hoeheW;
	}

	public static int getweiteW() {
		return weiteW;
	}

	public boolean getSchwarzSpieler() {
		return schwarzSpieler;
	}

	public void setSchwarzSpieler(boolean schwarzSpieler) {
		this.schwarzSpieler = schwarzSpieler;
	}

	public boolean getWeissSpieler() {
		return weissSpieler;
	}

	public void setWeissSpieler(boolean weissSpieler) {
		this.weissSpieler = weissSpieler;
	}

	public boolean getLeerFeld() {
		return leerFeld;
	}

	public void setLeerFeld(boolean leerFeld) {
		this.leerFeld = leerFeld;
	}
	
	public boolean getWeissWahl() {
		return weissWahl;
	}

	public void setWeissWahl(boolean weissWahl) {
		this.weissWahl = weissWahl;
	}
	
	public boolean getSchwarzWahl() {
		return schwarzWahl;
	}

	public void setSchwarzWahl(boolean schwarzWahl) {
		this.schwarzWahl = schwarzWahl;
	}
	
	public boolean getSchwarzDame() {
		return schwarzWahl;
	}

	public void setSchwarzDame(boolean schwarzdameFigur) {
		this.schwarzdameFigur = schwarzdameFigur;
	}
	public boolean getWeissDame() {
		return schwarzWahl;
	}

	public void setWeissDame(boolean weissdameFigur) {
		this.weissdameFigur = weissdameFigur;
	}

	public boolean getFeldhinbewegen() {
		return feldhinbewegen;
	}

	public void setFeldhinbewegen(boolean feldhinbewegen) {
		this.feldhinbewegen = feldhinbewegen;
	}

	public boolean getSchwarzdameWahl() {
		return schwarzdameWahl;
	}

	public void setSchwarzdameWahl(boolean schwarzdameWahl) {
		this.schwarzdameWahl = schwarzdameWahl;
	}

	public boolean getWeissdameWahl() {
		return weissdameWahl;
	}

	public void setWeissdameWahl(boolean weissdameWahl) {
		this.weissdameWahl = weissdameWahl;
	}
}
