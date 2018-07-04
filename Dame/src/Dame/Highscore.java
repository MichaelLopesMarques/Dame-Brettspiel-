package Dame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Highscore {
	
	private class HighscoreEintrag implements Comparable {
		
		private String player;												//Speicherung Spielername
		private double punkte;												//Speicherung Punkte
	
	    public HighscoreEintrag (String player, double punkte) {		//Erzeugt einen Highscore eintrag
	    	this.player = player;												
	    	this.punkte = punkte;
    }	
		public int compareTo(Object o) {								//Vergleichsfunktion
			Highscore He = (Highscore) o;
        if (this.punkte > He.getPunkte()) {
            return 1;
        } else if (this.punkte < He.getPunkte()) {
            return -1;
        }
		return 0;
	}
	
	public String getPlayer() {										//Funktionen um die Werte auszulesen
        return player;
    }

    public double getPunkte() {
        return punkte;
    }

    public String toString() {
        return this.player + ":" + this.punkte;
    }
    
    
}

/*	private JLabel platz = new JLabel();
	private JLabel score = new JLabel();
	private JLabel name = new JLabel();
	private JLabel farbe = new JLabel();
	
	private JLabel platz1 = new JLabel();
	private JLabel platz2 = new JLabel();
	private JLabel platz3 = new JLabel();
	
	private JLabel name1 = new JLabel();
	private JLabel name2 = new JLabel();
	private JLabel name3 = new JLabel();
	
	private JLabel score1 = new JLabel();
	private JLabel score2 = new JLabel();
	private JLabel score3 = new JLabel();
	
	private JLabel farbe1 = new JLabel();
	private JLabel farbe2 = new JLabel();
	private JLabel farbe3 = new JLabel(); */
	
	


	public Highscore() throws IOException{ 			// was hoch riskantes passiert hier
			
		Highscore[] highs = new Highscore[3];
		
		File textdatei = new File("highscore.txt");
		
		if (textdatei.exists()) {
            try {
            	FileReader textr = new FileReader(textdatei);					
            	char[] c = new char[(int) textdatei.length()]; 					
            	textr.read(c); 																							
                String s = new String(c);
                String[] entrys = s.split("\n");						//Den String bei Zeilenumbruch teilen und die einzelnen


                for (int i = 0; i < entrys.length; i++) {
                    if (i < 3) {
                        String[] entry = entrys[i].split(":");
                       // highs[i] = new Highscore(entry[0], Double.parseDouble(entry[1]));
                    }
                }
                textr.close();
            } catch (FileNotFoundException e) { 
                e.printStackTrace(); 
            } catch (IOException e) { 
                e.printStackTrace();
            }
        } else {
          // highs[0] = new HighscoreEintrag("Michael", 100);
           //highs[1] = new HighscoreEintrag("Leon", 50);
           //highs[2] = new HighscoreEintrag("Henri", 80);
        }
		Arrays.sort(highs);
		
		for(int i = 0; i < highs.length; i++) {
			System.out.println(highs[i]);
		}
		try {
			FileWriter fw = new FileWriter(textdatei);
			for(int i = 0; i < highs.length; i++) {
				if(i < highs.length -1) {
					fw.write(highs[i].toString()+"\n");
				} else {
					fw.write(highs[i].toString());
				}
			}
		fw.close();
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace();
    }
}


public double getPunkte() {
	// TODO Auto-generated method stub
	return 0;
}	
}		
	/*	this.setTitle("Highscore");									//Einstellungen für das Fenster
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(580,500);
    	this.setVisible(true);	
    	this.setLayout(null);
    	this.setLocationRelativeTo(null);
    	
    	platz.setBounds(20, 24, 52, 29);
        platz.setText("Platz");
        platz.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz);
        
        name.setBounds(180, 24, 100, 29);
        name.setText("Name");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name);
        
        score.setBounds(400, 24, 64, 29);
        score.setText("Score");
        score.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score);
        
        farbe.setBounds(480, 24, 64, 29);
        farbe.setText("Farbe");
        farbe.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe);
        
        platz1.setBounds(20, 24, 52, 100);
        platz1.setText("1");
        platz1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz1);
        
        name1.setBounds(180, 24, 100, 100);
        name1.setText("Michael");
        name1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name1);
        
        score1.setBounds(400, 24, 64, 100);
        score1.setText("100");
        score1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score1);
        
        farbe1.setBounds(480, 24, 64, 100);
        farbe1.setText("Weiss");
        farbe1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe1);
        
        platz2.setBounds(20, 24, 52, 200);
        platz2.setText("2");
        platz2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz2);
        
        name2.setBounds(180, 24, 100, 200);
        name2.setText("KrasserBot");
        name2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name2);
        
        score2.setBounds(400, 24, 64, 200);
        score2.setText("80");
        score2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score2);
        
        farbe2.setBounds(480, 24, 64, 200);
        farbe2.setText("Schwarz");
        farbe2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe2);
        
        platz3.setBounds(20, 24, 52, 300);
        platz3.setText("3");
        platz3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz3);
        
        name3.setBounds(180, 24, 100, 300);
        name3.setText("Schachprofi");
        name3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name3);
        
        score3.setBounds(400, 24, 64, 300);
        score3.setText("10");
        score3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score3);
        
        farbe3.setBounds(480, 24, 64, 300);
        farbe3.setText("Schwarz");
        farbe3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe3);
        
        
        
        //BufferedReader in = new BufferedReader(new FileReader("highscore.txt"));		//Text Datei wird gelesen
        
        //BufferedWriter out = new BufferedWriter(new FileWriter("highscore.txt")); 		//Um in die Text Datei schreiben zu können 
        
		} */




    
	





