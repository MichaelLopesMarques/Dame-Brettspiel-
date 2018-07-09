package Dame;

public class Bot extends Regel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void Bot() {
		while(wertSchwarz>0) {
			xFeld = (int) (Math.random() * 7);
			yFeld = (int) (Math.random() * 7);
			//xFeld = 3;
			//yFeld = 2;
			System.out.println("Bot: " + yFeld+","+xFeld);
		
			if(feld[xFeld][yFeld].getSchwarzSpieler()==true && wertWeiss==0 && wertSchwarz==1) {		//Bedingung um schwarzen Stein zu nehmen
				feld[xFeld][yFeld].setSchwarzSpieler(false);											//auf dem geklickten Feld wird die schwarze Figur ausgetauscht
				feld[xFeld][yFeld].setSchwarzWahl(true);												//durch den gewählten schwarzen Stein
				felderVorgabeUnten();
				schwarzNehmen();

			}else if(feld[xFeld][yFeld].getSchwarzDame()==true && wertWeiss==0 && wertSchwarz==1) {		//Bedingung um schwarzen Dame zu nehmen
				feld[xFeld][yFeld].setSchwarzDame(false);												//auf dem geklickten Feld wird die schwarze Dame ausgetauscht
				feld[xFeld][yFeld].setSchwarzdameWahl(true);											//durch den gewählten schwarzen Dame
				felderVorgabeUnten();
				felderVorgabeOben();
				schwarzNehmen();

			}
			

			
			


		
			if(xFeld<7 && feld[merkxwert][merkywert].getSchwarzWahl()==true && feld[xFeld + 1][yFeld + 1].getFeldhinbewegen()==true && wertSchwarz==2 && kannspringen==false) {			//Bedingung um schwarzen Stein zu setzen
				System.out.println("schwarzer stein setzen");
				feld[xFeld + 1][yFeld + 1].setFeldhinbewegen(false);
				feld[xFeld + 1][yFeld + 1].setSchwarzSpieler(true);
				feld[merkxwert][merkywert].setSchwarzWahl(false);
				feld[merkxwert][merkywert].setLeerFeld(true);
				vordefiniertEntfernen();
				schwarzDamePruefen();
				wertSchwarz=0;																													//schwarzer Zug wird beendet
				wertWeiss++;
				return;

			}else if(xFeld>0 && feld[merkxwert][merkywert].getSchwarzWahl()==true && feld[xFeld - 1][yFeld + 1].getFeldhinbewegen()==true && wertSchwarz==2 && kannspringen==false) {			//Bedingung um schwarzen Stein zu setzen
				System.out.println("schwarzer stein setzen");
				feld[xFeld - 1][yFeld + 1].setFeldhinbewegen(false);
				feld[xFeld - 1][yFeld + 1].setSchwarzSpieler(true);
				feld[merkxwert][merkywert].setSchwarzWahl(false);
				feld[merkxwert][merkywert].setLeerFeld(true);
				vordefiniertEntfernen();
				schwarzDamePruefen();
				wertSchwarz=0;																													//schwarzer Zug wird beendet
				wertWeiss++;
				return;
			}else if(wertSchwarz==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getSchwarzWahl()==true){		//falls man sich mit der schwarzen Figur verklickt oder eine andere Figur lieber spielen möchte
				feld[merkxwert][merkywert].setSchwarzWahl(false);
				feld[merkxwert][merkywert].setSchwarzSpieler(true);
				wertSchwarz=1;
				vordefiniertEntfernen();

			}else if(wertSchwarz==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getSchwarzdameWahl()==true){	//falls man sich mit der schwarzen Dame verklickt oder eine andere Figur lieber spielen möchte
				feld[merkxwert][merkywert].setSchwarzdameWahl(false);
				feld[merkxwert][merkywert].setSchwarzDame(true);
				wertSchwarz=1;
				vordefiniertEntfernen();

			}
		}
		
	}

}
