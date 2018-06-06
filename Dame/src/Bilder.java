import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class Bilder {
	public static BufferedImage labeBild(String path) {			//ohne diese Klasse kannst du die Bilder nicht reinladen!
		try {																				//was Hochriskantes passiert hier mal wieder (huhu riskant!)
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			return ImageIO.read(in);	//return die Bilder, die in der Klasse reingeladen werden und vorhanden sind?
		} catch (IOException e) {
			e.printStackTrace();				//falls er kein Bild findet
		}
		return null;		//brauch noch ein Return, weil es möglich sein kann, dass er kein Return beim try/catch zurückgibt
	}
	
	public static BufferedImage Anpassung(BufferedImage anpassung, int weite, int hoehe) {		//Anpassung der Skalierung des Bildes
		BufferedImage anpassen = new BufferedImage(weite, hoehe, anpassung.getType());			//Bild wir mit höhe und breite eingefügt
		Graphics g = anpassen.getGraphics();													//dam wird das bild irgendwie angepasst
		g.drawImage(anpassung,0,0,weite,hoehe,null);
		g.dispose();
		return anpassen;
	}
}
