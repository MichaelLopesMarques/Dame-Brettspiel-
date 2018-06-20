
public class Regel extends Welt{

	private static final long serialVersionUID = 1L;

	private static int wertWeiss;
	private static int wertSchwarz;
	
	private static int merkxwert;
	private static int merkywert;
	private static int xFeld;
	private static int yFeld;
	
	public static void klicklinks(int x, int y) {
		xFeld = (int) x/Feld.getweiteW();
		yFeld = (int) y/Feld.gethoeheW();
		System.out.println(yFeld+","+xFeld);
		System.out.println(x+","+y);
		
		if(feld[xFeld][yFeld].getWeissSpieler()==true && wertWeiss==0 && wertSchwarz==0) {		//Bedingung um weissen Stein zu nehmen
			weissNehmen();
			return;
		}
		
		if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertWeiss==1 && (merkxwert-2)>=0 && (merkywert-2)>=0 &&
				feld[merkxwert-1][merkywert-1].getSchwarzSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert-2][merkywert-2]) {				//Bedingung für Springen nach links bei weiss
			weissSpringen();
			feld[merkxwert-1][merkywert-1].setSchwarzSpieler(false);
			feld[merkxwert-1][merkywert-1].setLeerFeld(true);
			weissDamePruefen();
			return;
		}else if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertWeiss==1 && (merkxwert+2)<=7 && (merkywert-2)>=0 &&		//Bedingung für Springen nach rechts bei weiss
				feld[merkxwert+1][merkywert-1].getSchwarzSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert-2]) {
			weissSpringen();
			feld[merkxwert+1][merkywert-1].setSchwarzSpieler(false);
			feld[merkxwert+1][merkywert-1].setLeerFeld(true);
			weissDamePruefen();
			return;
		}
		
		if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)) {	//Bedingung um weissen Stein zu setzen
			weissSetzen();
			weissDamePruefen();
			return;
		}else if(wertWeiss==1 && (!feld[xFeld][yFeld].getFeldhinbewegen()==true || (xFeld+yFeld)%2==0 || (merkxwert-1)<0 || (merkxwert+1)>7 ||
			!(feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1]))){
			feld[merkxwert][merkywert].setWeissWahl(false);
			feld[merkxwert][merkywert].setWeissSpieler(true);
			wertWeiss=0;
			vordefiniertEntfernen();
			return;
		}
		
		
		
		if(feld[xFeld][yFeld].getSchwarzSpieler()==true && wertWeiss==0 && wertSchwarz==0) {		//Bedingung um schwarzen Stein zu nehmen
			schwarzNehmen();
			return;
		}
		
		if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertSchwarz==1 && (merkxwert+2)<=7 && (merkywert+2)<=7 &&			//Bedingung für Springen nach rechts bei schwarz
				feld[merkxwert+1][merkywert+1].getWeissSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert+2]) {
			schwarzSpringen();
			feld[merkxwert+1][merkywert+1].setWeissSpieler(false);
			feld[merkxwert+1][merkywert+1].setLeerFeld(true);
			schwarzDamePruefen();
			return;
		}else if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertSchwarz==1 && (merkxwert-2)>=0 && (merkywert+2)<=7 &&		//Bedingung für Springen nach links bei schwarz
				feld[merkxwert-1][merkywert+1].getWeissSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert-2][merkywert+2]) {
			schwarzSpringen();
			feld[merkxwert-1][merkywert+1].setWeissSpieler(false);
			feld[merkxwert-1][merkywert+1].setLeerFeld(true);
			schwarzDamePruefen();
			return;
		}
		
		if(feld[xFeld][yFeld].getFeldhinbewegen()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)) {		//Bedingung um schwarzen Stein zu setzen
			schwarzSetzen();
			schwarzDamePruefen();
			return;
		}else if(wertSchwarz==1 && (!feld[xFeld][yFeld].getFeldhinbewegen()==true || (xFeld+yFeld)%2==0 || (merkxwert-1)<0 || (merkxwert+1)>7 ||
				!(feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]))){
			feld[merkxwert][merkywert].setSchwarzWahl(false);
			feld[merkxwert][merkywert].setSchwarzSpieler(true);
			wertSchwarz=0;
			vordefiniertEntfernen();
			return;
		}
	}

	public static void weissNehmen() {
			System.out.println("weißer stein nehmen");
			feld[xFeld][yFeld].setWeissSpieler(false);	
			feld[xFeld][yFeld].setWeissWahl(true);
			if((xFeld-2)>=0 &&(yFeld-2)>=0 && feld[xFeld-1][yFeld-1].getSchwarzSpieler()==true && feld[xFeld-2][yFeld-2].getLeerFeld()==true) {
				feld[xFeld-2][yFeld-2].setLeerFeld(false);
				feld[xFeld-2][yFeld-2].setFeldhinbewegen(true);
			}else if((xFeld-1)>=0 &&(yFeld-1)>=0 && feld[xFeld-1][yFeld-1].getLeerFeld()==true) {
				feld[xFeld-1][yFeld-1].setLeerFeld(false);
				feld[xFeld-1][yFeld-1].setFeldhinbewegen(true);
			}
			if((xFeld+2)<=7 && (yFeld-2)>=0 && feld[xFeld+1][yFeld-1].getSchwarzSpieler()==true && feld[xFeld+2][yFeld-2].getLeerFeld()==true) {
				feld[xFeld+2][yFeld-2].setLeerFeld(false);
				feld[xFeld+2][yFeld-2].setFeldhinbewegen(true);
			}else if((xFeld+1)<=7 && (yFeld-1)>=0 && feld[xFeld+1][yFeld-1].getLeerFeld()==true) {
				feld[xFeld+1][yFeld-1].setLeerFeld(false);
				feld[xFeld+1][yFeld-1].setFeldhinbewegen(true);
			}
			wertWeiss++;
			merkxwert=xFeld;
			merkywert=yFeld;
	}
	
	public static void weissSetzen() {
		if((merkxwert-1)>=0 && (merkxwert+1)<=7 && (feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||
				feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1])) {
			weissPlatzWechsel();
		}else if((merkxwert-1)<0 && feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1]) {
			weissPlatzWechsel();
		}else if((merkxwert+1)>7 &&	feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]) {
			weissPlatzWechsel();
		}
		vordefiniertEntfernen();
	}
	
	public static void weissPlatzWechsel() {
		System.out.println("weißer stein setzen");
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setWeissSpieler(true);
		feld[merkxwert][merkywert].setWeissWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertWeiss=0;
	}
	
	public static void weissSpringen() {
		System.out.println("weisser stein springt");
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setWeissSpieler(true);
		feld[merkxwert][merkywert].setWeissWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
		wertWeiss=0;
	}
	
	public static void weissDamePruefen() {
		if(feld[xFeld][0].getWeissSpieler()==true) {			//prüfe, ob weisse Spielfigur zur Dame wird
			feld[xFeld][0].setWeissSpieler(false);				//weisse Figur wird entfernt
			feld[xFeld][0].setWeissDame(true);					//weisse Dame wird platziert
		}
	}
	
	
	public static void schwarzNehmen() {
		System.out.println("schwarzer stein nehmen");
		feld[xFeld][yFeld].setSchwarzSpieler(false);
		feld[xFeld][yFeld].setSchwarzWahl(true);
		wertSchwarz++;
		if((xFeld+2)<=7 && (yFeld+2)<=7 && feld[xFeld+1][yFeld+1].getWeissSpieler()==true && feld[xFeld+2][yFeld+2].getLeerFeld()==true) {
			feld[xFeld+2][yFeld+2].setLeerFeld(false);
			feld[xFeld+2][yFeld+2].setFeldhinbewegen(true);
		}else if((xFeld+1)<=7 && (yFeld+1)<=7 && feld[xFeld+1][yFeld+1].getLeerFeld()==true) {
			feld[xFeld+1][yFeld+1].setLeerFeld(false);
			feld[xFeld+1][yFeld+1].setFeldhinbewegen(true);
		}
		if((xFeld-2)>=0 && (yFeld+2)<=7 && feld[xFeld-1][yFeld+1].getWeissSpieler()==true && feld[xFeld-2][yFeld+2].getLeerFeld()==true) {
			feld[xFeld-2][yFeld+2].setLeerFeld(false);
			feld[xFeld-2][yFeld+2].setFeldhinbewegen(true);
		}else if((xFeld-1)>=0 && (yFeld+1)<=7 && feld[xFeld-1][yFeld+1].getLeerFeld()==true) {
			feld[xFeld-1][yFeld+1].setLeerFeld(false);
			feld[xFeld-1][yFeld+1].setFeldhinbewegen(true);
		}
		merkxwert=xFeld;
		merkywert=yFeld;
	}
	
	public static void schwarzSetzen() {
		if((merkxwert-1)>=0 && (merkxwert+1)<=7 && (feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||
				feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1])) {
			schwarzPlatzWechsel();
		}else if((merkxwert-1)<0 && feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]) {
			schwarzPlatzWechsel();
		}else if((merkxwert+1)>7 && feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]) {
			schwarzPlatzWechsel();
		}
		vordefiniertEntfernen();
	}
	
	public static void schwarzPlatzWechsel() {
		System.out.println("schwarzer stein setzen");
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setSchwarzSpieler(true);
		feld[merkxwert][merkywert].setSchwarzWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertSchwarz=0;
		return;
	}
	
	public static void schwarzSpringen() {
		System.out.println("schwarzer stein springt");
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setSchwarzSpieler(true);
		feld[merkxwert][merkywert].setSchwarzWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
		wertSchwarz=0;
	}
	
	public static void vordefiniertEntfernen() {
		if((merkxwert-1)>=0 && (merkywert-1)>=0 && feld[merkxwert-1][merkywert-1].getFeldhinbewegen()==true) {
			feld[merkxwert-1][merkywert-1].setFeldhinbewegen(false);
			feld[merkxwert-1][merkywert-1].setLeerFeld(true);
		}
		if((merkxwert-2)>=0 && (merkywert-2)>=0 && feld[merkxwert-2][merkywert-2].getFeldhinbewegen()==true) {
			feld[merkxwert-2][merkywert-2].setFeldhinbewegen(false);
			feld[merkxwert-2][merkywert-2].setLeerFeld(true);	
		}
		if((merkxwert+1)<=7 && (merkywert-1)>=0 && feld[merkxwert+1][merkywert-1].getFeldhinbewegen()==true) {
			feld[merkxwert+1][merkywert-1].setFeldhinbewegen(false);
			feld[merkxwert+1][merkywert-1].setLeerFeld(true);
		}
		if((merkxwert+2)<=7 && (merkywert-2)>=0 && feld[merkxwert+2][merkywert-2].getFeldhinbewegen()==true) {
			feld[merkxwert+2][merkywert-2].setFeldhinbewegen(false);
			feld[merkxwert+2][merkywert-2].setLeerFeld(true);	
		}
		if((merkxwert+1)<=7 && (merkywert+1)<=7 && feld[merkxwert+1][merkywert+1].getFeldhinbewegen()==true) {
			feld[merkxwert+1][merkywert+1].setFeldhinbewegen(false);
			feld[merkxwert+1][merkywert+1].setLeerFeld(true);
		}
		if((merkxwert+2)<=7 && (merkywert+2)<=7 && feld[merkxwert+2][merkywert+2].getFeldhinbewegen()==true) {
			feld[merkxwert+2][merkywert+2].setFeldhinbewegen(false);
			feld[merkxwert+2][merkywert+2].setLeerFeld(true);	
		}
		if((merkxwert-1)>=0 && (merkywert+1)<=7 && feld[merkxwert-1][merkywert+1].getFeldhinbewegen()==true) {
			feld[merkxwert-1][merkywert+1].setFeldhinbewegen(false);
			feld[merkxwert-1][merkywert+1].setLeerFeld(true);
		}
		if((merkxwert-2)>=0 && (merkywert+2)<=7 && feld[merkxwert-2][merkywert+2].getFeldhinbewegen()==true) {
			feld[merkxwert-2][merkywert+2].setFeldhinbewegen(false);
			feld[merkxwert-2][merkywert+2].setLeerFeld(true);
		}
	}
	
	public static void schwarzDamePruefen() {
		if(feld[xFeld][7].getSchwarzSpieler()==true) {			//prüfe, ob schwarze Spielfigur zur Dame wird
			feld[xFeld][7].setSchwarzSpieler(false);			//schwarz Figur wird entfernt
			feld[xFeld][7].setSchwarzDame(true);				//schwarz Dame wird platziert
		}
	}
}
