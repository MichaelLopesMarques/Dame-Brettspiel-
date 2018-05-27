
public class Welt {
	
	private static int laengeF=8;
	private static int breiteF=8;
	private int gerade=0;
	
	private Feld[][] feld;

	public Welt() {
		int z=0;
    
		feld = new Feld[8][8];
		for (int x=0;x<8;x++) {
			for (int y=0;y<8;y++) {
				gerade=x+y;
				if (gerade%2==0) {
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
