package Dame;

public class HighscoreEintrag implements Comparable {
		
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
