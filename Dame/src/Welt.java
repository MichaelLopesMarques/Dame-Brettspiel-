import java.awt.Color;
public class Welt {
	
	private static int laengeF=8;
	private static int breiteF=8;
	private int gerade=0;
	
	private Feld[][] feld;

	public Welt() {
		int z=0;
    
		feld = new Feld[laengeF][breiteF];
		for (int x=0;x<laengeF;x++) {
			for (int y=0;y<breiteF;y++) {
				gerade=x+y;
				if (gerade%2==0) {
					feld[x][y]=new Feld();
					System.out.print(1);
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}else {
					System.out.print(0);
					z++;
					if (z>7) {
						System.out.println();
						z=0;
					}
				}
			}
		}
	}
}
