import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class Bilder {
	public static BufferedImage labeBild(String path) {											//Bild laden	
		try {																				
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			return ImageIO.read(in);															//gibt Bild zurück
		} catch (IOException e) {
			e.printStackTrace();																//falls er kein Bild findet
		}
		return null;		
	}
	
	public static BufferedImage Anpassung(BufferedImage anpassung, int weite, int hoehe) {		//Anpassung der Skalierung des Bildes
		BufferedImage anpassen = new BufferedImage(weite, hoehe, anpassung.getType());			//Bild wir mit höhe und breite eingefügt
		Graphics g = anpassen.getGraphics();													//Bild eingefügt
		g.drawImage(anpassung,0,0,weite,hoehe,null);
		g.dispose();
		return anpassen;
	}
}
