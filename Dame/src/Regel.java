
public class Regel extends Welt{

	private static final long serialVersionUID = 1L;

	public static void klicklinks(int x, int y) {
		int xFeld = (int) x/Feld.getweiteW();
		int yFeld = (int) y/Feld.gethoeheW();
		System.out.println(yFeld+","+xFeld);
		System.out.println(x+","+y);
		if(feld[xFeld][yFeld].getWeissSpieler()==true) {
			System.out.println("weiﬂer stein");
		}else if(feld[xFeld][yFeld].getSchwarzSpieler()==true) {
			System.out.println("schwarzer stein");
		}
	}

}
