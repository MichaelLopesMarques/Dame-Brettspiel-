import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Feld {
	
	private int x;
	private int y;
	
	private static int weiteW=100;
	private static int hoeheW=100;
	
	private BufferedImage weiss, schwarz, weissstein, schwarzstein;
	
	public Feld(int x, int y,BufferedImage weiss,BufferedImage schwarz,BufferedImage weissstein,BufferedImage schwarzstein) {
		this.x=x;
		this.y=y;
		this.weiss=weiss;
		this.schwarz=schwarz;
		this.weissstein=weissstein;
		this.schwarzstein=schwarzstein;
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
		int gerade=x+y;
		if (gerade%2==0) {
		g.drawImage(weiss, x*weiteW, y*hoeheW, null);
		}else {
			if (y<=2) {
				g.drawImage(schwarzstein, x*weiteW, y*hoeheW, null);
			}else if (y>=5) {
				g.drawImage(weissstein, x*weiteW, y*hoeheW, null);
			}else {
				g.drawImage(schwarz, x*weiteW, y*hoeheW, null);
			}
		}
	}

	public static int gethoeheW() {
		return hoeheW;
	}

	public static int getweiteW() {
		return weiteW;
	}
}
