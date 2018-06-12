
public class Regel extends Welt{

	private static final long serialVersionUID = 1L;

	private static int wertWeiss;
	private static int wertSchwarz;
	private static int merkxwert;
	private static int merkywert;
	
	public static void klicklinks(int x, int y) {
		int xFeld = (int) x/Feld.getweiteW();
		int yFeld = (int) y/Feld.gethoeheW();
		System.out.println(yFeld+","+xFeld);
		System.out.println(x+","+y);
		if(feld[xFeld][yFeld].getWeissSpieler()==true && wertWeiss==0 && wertSchwarz==0) {
			System.out.println("weiﬂer stein nehmen");
			feld[xFeld][yFeld].setWeissSpieler(false);
			feld[xFeld][yFeld].setLeerFeld(true);
			wertWeiss++;
			merkxwert=xFeld;
			merkywert=yFeld;
			return;
		}
		
		if(feld[xFeld][yFeld].getLeerFeld()==true && wertWeiss==1 && !((xFeld+yFeld)%2==0)&&
				(feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1])) {
			System.out.println("weiﬂer stein setzen");
			feld[xFeld][yFeld].setLeerFeld(false);
			feld[xFeld][yFeld].setWeissSpieler(true);
			wertWeiss=0;
			return;
		}else if(wertWeiss==1 && (!feld[xFeld][yFeld].getLeerFeld()==true || (xFeld+yFeld)%2==0 ||
				!(feld[xFeld][yFeld]==feld[merkxwert-1][merkywert-1]||feld[xFeld][yFeld]==feld[merkxwert+1][merkywert-1]))){
			feld[merkxwert][merkywert].setLeerFeld(false);
			feld[merkxwert][merkywert].setWeissSpieler(true);
			wertWeiss=0;
		}
		
		if(feld[xFeld][yFeld].getSchwarzSpieler()==true && wertWeiss==0 && wertSchwarz==0) {
			System.out.println("schwarzer stein nehmen");
			feld[xFeld][yFeld].setSchwarzSpieler(false);
			feld[xFeld][yFeld].setLeerFeld(true);
			wertSchwarz++;
			merkxwert=xFeld;
			merkywert=yFeld;
			return;
		}
		
		if(feld[xFeld][yFeld].getLeerFeld()==true && wertSchwarz==1 && !((xFeld+yFeld)%2==0)&&
				feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]) {
			System.out.println("schwarzer stein setzen");
			feld[xFeld][yFeld].setLeerFeld(false);
			feld[xFeld][yFeld].setSchwarzSpieler(true);
			wertSchwarz=0;
			return;
		}else if(wertSchwarz==1 && (!feld[xFeld][yFeld].getLeerFeld()==true || (xFeld+yFeld)%2==0 ||
				!(feld[xFeld][yFeld]==feld[merkxwert+1][merkywert+1]||feld[xFeld][yFeld]==feld[merkxwert-1][merkywert+1]))){
			feld[merkxwert][merkywert].setLeerFeld(false);
			feld[merkxwert][merkywert].setSchwarzSpieler(true);
			wertSchwarz=0;
		}
	}

}
