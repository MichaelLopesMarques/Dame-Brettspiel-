
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
		
		if(feld[xFeld][yFeld].getWeissSpieler()==true && wertWeiss==0 && wertSchwarz==0) {
			System.out.println("wei�er stein nehmen");
			feld[xFeld][yFeld].setWeissSpieler(false);
			feld[xFeld][yFeld].setWeissWahl(true);
			wertWeiss++;
			merkxwert=xFeld;
			merkywert=yFeld;
			return;
		}
		
		if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&& (merkxwert-1)>=0 && (merkxwert+1)<=7 && 
				(feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1])) {
			weissSetzen();
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&& (merkxwert-1)<0 &&
				feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1]) {
			weissSetzen();
			return;
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&& (merkxwert+1)>7 &&
			feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]) {
			weissSetzen();
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&& (merkxwert-1)>=0 &&
				feld[merkxwert-1][merkywert-1].getSchwarzSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert-2][merkywert-2]) {
			weissSpringen();
			feld[merkxwert-1][merkywert-1].setSchwarzSpieler(false);
			feld[merkxwert-1][merkywert-1].setLeerFeld(true);
			return;
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&& (merkxwert+1)<=7 &&
				feld[merkxwert+1][merkywert-1].getSchwarzSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert-2]) {
			weissSpringen();
			feld[merkxwert+1][merkywert-1].setSchwarzSpieler(false);
			feld[merkxwert+1][merkywert-1].setLeerFeld(true);
			return;
		}else if(wertWeiss==1 && (!feld[xFeld][yFeld].getLeerFeld()==true || (xFeld+yFeld)%2==0 || (merkxwert-1)<0 || (merkxwert+1)>7 ||
			!(feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1]))){
			feld[merkxwert][merkywert].setLeerFeld(false);
			feld[merkxwert][merkywert].setWeissSpieler(true);
			wertWeiss=0;
			return;
		}
		
		if(feld[xFeld][yFeld].getSchwarzSpieler()==true && wertWeiss==0 && wertSchwarz==0) {
			System.out.println("schwarzer stein nehmen");
			feld[xFeld][yFeld].setSchwarzSpieler(false);
			feld[xFeld][yFeld].setSchwarzWahl(true);
			wertSchwarz++;
			merkxwert=xFeld;
			merkywert=yFeld;
			return;
		}
		
		if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&(merkxwert-1)>=0 && (merkxwert+1)<=7 &&
				(feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1])) {
			schwarzSetzen();
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&(merkxwert-1)<0 &&
				feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]) {
			schwarzSetzen();
			return;
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&(merkxwert+1)>7 &&
				feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]) {
			schwarzSetzen();
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&(merkxwert+1)<=7 &&
				feld[merkxwert+1][merkywert+1].getWeissSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert+2]) {
			schwarzSpringen();
			feld[merkxwert+1][merkywert+1].setWeissSpieler(false);
			feld[merkxwert+1][merkywert+1].setLeerFeld(true);
		}else if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&(merkxwert-1)>=0 &&
				feld[merkxwert-1][merkywert+1].getWeissSpieler()==true && feld[xFeld][yFeld]==feld[merkxwert-2][merkywert+2]) {
			schwarzSpringen();
			feld[merkxwert-1][merkywert+1].setWeissSpieler(false);
			feld[merkxwert-1][merkywert+1].setLeerFeld(true);
		}else if(wertSchwarz==1 && (!feld[xFeld][yFeld].getLeerFeld()==true || (xFeld+yFeld)%2==0 || (merkxwert-1)<0 || (merkxwert+1)>7 ||
				!(feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]))){
			feld[merkxwert][merkywert].setLeerFeld(false);
			feld[merkxwert][merkywert].setSchwarzSpieler(true);
			wertSchwarz=0;
			return;
		}
	}

	public static void weissSetzen() {
		System.out.println("wei�er stein setzen");
		feld[xFeld][yFeld].setLeerFeld(false);
		feld[xFeld][yFeld].setWeissSpieler(true);
		feld[merkxwert][merkywert].setWeissWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertWeiss=0;
		return;
	}
	
	public static void schwarzSetzen() {
		System.out.println("schwarzer stein setzen");
		feld[xFeld][yFeld].setLeerFeld(false);
		feld[xFeld][yFeld].setSchwarzSpieler(true);
		feld[merkxwert][merkywert].setSchwarzWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertSchwarz=0;
		return;
	}
	
	public static void weissSpringen() {
		System.out.println("weisser stein springt");
		feld[xFeld][yFeld].setLeerFeld(false);
		feld[xFeld][yFeld].setWeissSpieler(true);
		feld[merkxwert][merkywert].setWeissWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertWeiss=0;
	}
	
	public static void schwarzSpringen() {
		System.out.println("schwarzer stein springt");
		feld[xFeld][yFeld].setLeerFeld(false);
		feld[xFeld][yFeld].setSchwarzSpieler(true);
		feld[merkxwert][merkywert].setSchwarzWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		wertSchwarz=0;
	}
}
