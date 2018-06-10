
public class Regel {

	public static void klicklinks(int x, int y) {
		int xFeld = (int) x/Feld.getweiteW();
		int yFeld = (int) y/Feld.gethoeheW();
		System.out.println(xFeld+","+yFeld);
	}

}
