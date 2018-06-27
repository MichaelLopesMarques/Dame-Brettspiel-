
public class Regel extends Welt{

	private static final long serialVersionUID = 1L;

	private static int wertWeiss=1;				//0 = weisser spieler nicht dran   1 = weiss spieler dran    2 = weisser stein genommen
	private static int wertSchwarz=0;
	
	private static int merkxwert;				//x-Feld wird hier drin gespeichert
	private static int merkywert;				//y-Feld wird hier drin gespeichert
	
	private static int xFeld;					//sind die Felder im Array
	private static int yFeld;
	
	public static boolean kannspringen=false;
	
	public static void klicklinks(int x, int y) {
		if(x<800) {
			xFeld = (int) x/Feld.getweiteW();				//Position im Array wird berechnet
			yFeld = (int) y/Feld.gethoeheW();
			System.out.println(yFeld+","+xFeld);
			System.out.println(x+","+y);
		
			if(feld[xFeld][yFeld].getWeissSpieler()==true && wertWeiss==1 && wertSchwarz==0) {			//Bedingung um weissen Stein zu nehmen
				feld[xFeld][yFeld].setWeissSpieler(false);												//auf dem geklickten Feld wird die weisse Figur ausgetauscht
				feld[xFeld][yFeld].setWeissWahl(true);													//durch den gewählten weissen Stein
				felderVorgabeOben();
				weissNehmen();
				return;																					//damit die Bedingung nicht wieder rückgängig gemacht wird
			}else if(feld[xFeld][yFeld].getWeissDame()==true && wertWeiss==1 && wertSchwarz==0) {		//Bedingung um weisse Dame zu nehmen
				feld[xFeld][yFeld].setWeissDame(false);													//auf dem geklickten Feld wird die weisse Dame ausgetauscht
				feld[xFeld][yFeld].setWeissdameWahl(true);												//durch den gewählten weissen Dame
				felderVorgabeOben();
				felderVorgabeUnten();
				weissNehmen();
				return;
			}
			
			if(feld[xFeld][yFeld].getSchwarzSpieler()==true && wertWeiss==0 && wertSchwarz==1) {		//Bedingung um schwarzen Stein zu nehmen
				feld[xFeld][yFeld].setSchwarzSpieler(false);											//auf dem geklickten Feld wird die schwarze Figur ausgetauscht
				feld[xFeld][yFeld].setSchwarzWahl(true);												//durch den gewählten schwarzen Stein
				felderVorgabeUnten();
				schwarzNehmen();
				return;
			}else if(feld[xFeld][yFeld].getSchwarzDame()==true && wertWeiss==0 && wertSchwarz==1) {		//Bedingung um schwarzen Dame zu nehmen
				feld[xFeld][yFeld].setSchwarzDame(false);												//auf dem geklickten Feld wird die schwarze Dame ausgetauscht
				feld[xFeld][yFeld].setSchwarzdameWahl(true);											//durch den gewählten schwarzen Dame
				felderVorgabeUnten();
				felderVorgabeOben();
				schwarzNehmen();
				return;
			}
			
			
		
			if(feld[xFeld][yFeld].getFeldhinbewegen()==true && (merkxwert-2)>=0 && (merkywert-2)>=0 &&  feld[xFeld][yFeld]==feld[merkxwert-2][merkywert-2]) {																	//Bedingung für Springen nach links bei weiss
				if(feld[merkxwert][merkywert].getWeissWahl()==true && wertWeiss==2) {
					weissPlatzWechsel();
					weissSpringen();
					weissDamePruefen();
					feld[merkxwert-1][merkywert-1].setSchwarzSpieler(false);																	//der übersprungene Stein wird ausgetauscht
					feld[merkxwert-1][merkywert-1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getWeissdameWahl()==true && wertWeiss==2) {
					weissDamePlatzWechsel();
					weissSpringen();
					feld[merkxwert-1][merkywert-1].setSchwarzSpieler(false);																	//der übersprungene Stein wird ausgetauscht
					feld[merkxwert-1][merkywert-1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getSchwarzdameWahl()==true && wertSchwarz==2) {
					schwarzDamePlatzWechsel();
					schwarzSpringen();
					feld[merkxwert-1][merkywert-1].setWeissSpieler(false);
					feld[merkxwert-1][merkywert-1].setWeissDame(false);
				}
				feld[merkxwert-1][merkywert-1].setLeerFeld(true);																			//durch ein leeres Feld, da der Stein nicht mehr vorhanden ist
				return;
			}else if(feld[xFeld][yFeld].getFeldhinbewegen()==true && (merkxwert+2)<=7 && (merkywert-2)>=0 && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert-2]) {																	//Bedingung für Springen nach rechts bei weiss
				if(feld[merkxwert][merkywert].getWeissWahl()==true && wertWeiss==2) {
					weissPlatzWechsel();
					weissSpringen();
					weissDamePruefen();
					feld[merkxwert+1][merkywert-1].setSchwarzSpieler(false);
					feld[merkxwert+1][merkywert-1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getWeissdameWahl()==true && wertWeiss==2) {
					weissDamePlatzWechsel();
					weissSpringen();
					feld[merkxwert+1][merkywert-1].setSchwarzSpieler(false);
					feld[merkxwert+1][merkywert-1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getSchwarzdameWahl()==true && wertSchwarz==2) {
					schwarzDamePlatzWechsel();
					schwarzSpringen();
					feld[merkxwert+1][merkywert-1].setWeissSpieler(false);
					feld[merkxwert+1][merkywert-1].setWeissDame(false);
				}
				feld[merkxwert+1][merkywert-1].setLeerFeld(true);
				return;
			}
			
			if(feld[xFeld][yFeld].getFeldhinbewegen()==true && (merkxwert+2)<=7 && (merkywert+2)<=7 && feld[xFeld][yFeld]==feld[merkxwert+2][merkywert+2]) {																			//Bedingung für Springen nach rechts bei schwarz
				if(feld[merkxwert][merkywert].getSchwarzWahl()==true && wertSchwarz==2) {
					schwarzPlatzWechsel();
					schwarzSpringen();
					schwarzDamePruefen();
					feld[merkxwert+1][merkywert+1].setWeissSpieler(false);																			//überspringbarer Stein wird ausgetauscht
					feld[merkxwert+1][merkywert+1].setWeissDame(false);
				}else if(feld[merkxwert][merkywert].getWeissdameWahl()==true && wertWeiss==2) {
					weissDamePlatzWechsel();
					weissSpringen();
					feld[merkxwert+1][merkywert+1].setSchwarzSpieler(false);
					feld[merkxwert+1][merkywert+1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getSchwarzdameWahl()==true && wertSchwarz==2) {
					schwarzDamePlatzWechsel();
					schwarzSpringen();
					feld[merkxwert+1][merkywert+1].setWeissSpieler(false);																			//überspringbarer Stein wird ausgetauscht
					feld[merkxwert+1][merkywert+1].setWeissDame(false);
				}
				feld[merkxwert+1][merkywert+1].setLeerFeld(true);																				//durch ein leeres Feld
				return;
			}else if(feld[xFeld][yFeld].getFeldhinbewegen()==true && (merkxwert-2)>=0 && (merkywert+2)<=7 && feld[xFeld][yFeld]==feld[merkxwert-2][merkywert+2]) {																			//Bedingung für Springen nach links bei schwarz
				if(feld[merkxwert][merkywert].getSchwarzWahl()==true && wertSchwarz==2) {
					schwarzPlatzWechsel();
					schwarzSpringen();
					schwarzDamePruefen();
					feld[merkxwert-1][merkywert+1].setWeissSpieler(false);
					feld[merkxwert-1][merkywert+1].setWeissDame(false);
				}else if(feld[merkxwert][merkywert].getWeissdameWahl()==true && wertWeiss==2) {
					weissDamePlatzWechsel();
					weissSpringen();
					feld[merkxwert-1][merkywert+1].setSchwarzSpieler(false);
					feld[merkxwert-1][merkywert+1].setSchwarzDame(false);
				}else if(feld[merkxwert][merkywert].getSchwarzdameWahl()==true && wertSchwarz==2) {
					schwarzDamePlatzWechsel();
					schwarzSpringen();
					feld[merkxwert-1][merkywert+1].setWeissSpieler(false);
					feld[merkxwert-1][merkywert+1].setWeissDame(false);
				}
				feld[merkxwert-1][merkywert+1].setLeerFeld(true);
				return;
			}
			
			
		
			if(feld[merkxwert][merkywert].getWeissWahl()==true && feld[xFeld][yFeld].getFeldhinbewegen()==true && wertWeiss==2 && kannspringen==false) {			//Bedingung um weissen Stein zu setzen
				System.out.println("weißer stein setzen");
				weissPlatzWechsel();
				weissDamePruefen();
				wertWeiss=0;																												//wertWeiss wird auf 0 gesetzt, da der Zug zu ende ist
				wertSchwarz++;
				return;
			}else if(feld[merkxwert][merkywert].getWeissdameWahl()==true && feld[xFeld][yFeld].getFeldhinbewegen()==true && wertWeiss==2 && kannspringen==false) {	//Bedingung um weissen Dame zu setzen
				System.out.println("weisse dame setzen");
				feld[xFeld][yFeld].setWeissDame(true);																						//durch die Dame die sich nun auf diesem Platz befindet
				feld[xFeld][yFeld].setFeldhinbewegen(false);
				feld[merkxwert][merkywert].setWeissdameWahl(false);
				feld[merkxwert][merkywert].setLeerFeld(true);
				wertWeiss=0;																												//beim bewegen ist der Zug beendet
				wertSchwarz++;																												//schwarz kann als nächstes bewegt werden
				vordefiniertEntfernen();
				return;
			}else if(wertWeiss==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getWeissWahl()==true){		//Bedingung, falls man sich mit einer weissen Figur verklickt oder einen Stein nehmen möchte
				feld[merkxwert][merkywert].setWeissWahl(false);																				//Setzt die Spielfigur in die ursprungssituation
				feld[merkxwert][merkywert].setWeissSpieler(true);
				wertWeiss=1;
				vordefiniertEntfernen();
				return;
			}else if(wertWeiss==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getWeissdameWahl()==true){	//Bedingung, falls man sich mit der weissen Dame verklickt oder einen Stein nehmen möchte
				feld[merkxwert][merkywert].setWeissdameWahl(false);																			//Setzt die Spielfigur in die ursprungssituation
				feld[merkxwert][merkywert].setWeissDame(true);
				wertWeiss=1;
				vordefiniertEntfernen();
				return;
			}
		
			if(feld[merkxwert][merkywert].getSchwarzWahl()==true && feld[xFeld][yFeld].getFeldhinbewegen()==true && wertSchwarz==2 && kannspringen==false) {			//Bedingung um schwarzen Stein zu setzen
				System.out.println("schwarzer stein setzen");
				schwarzPlatzWechsel();
				schwarzDamePruefen();
				wertSchwarz=0;																													//schwarzer Zug wird beendet
				wertWeiss++;	
				return;
			}else if(feld[merkxwert][merkywert].getSchwarzdameWahl()==true && feld[xFeld][yFeld].getFeldhinbewegen()==true && wertSchwarz==2 && kannspringen==false) {	//Bedingung um weissen Stein zu setzen
				System.out.println("weisse dame setzen");
				feld[xFeld][yFeld].setFeldhinbewegen(false);
				feld[xFeld][yFeld].setSchwarzDame(true);
				feld[merkxwert][merkywert].setWeissdameWahl(false);
				feld[merkxwert][merkywert].setLeerFeld(true);
				wertSchwarz=0;
				wertWeiss++;
				vordefiniertEntfernen();
				return;
			}else if(wertSchwarz==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getSchwarzWahl()==true){		//falls man sich mit der schwarzen Figur verklickt oder eine andere Figur lieber spielen möchte
				feld[merkxwert][merkywert].setSchwarzWahl(false);
				feld[merkxwert][merkywert].setSchwarzSpieler(true);
				wertSchwarz=1;
				vordefiniertEntfernen();
				return;
			}else if(wertSchwarz==2 && feld[xFeld][yFeld].getFeldhinbewegen()==false && feld[merkxwert][merkywert].getSchwarzdameWahl()==true){	//falls man sich mit der schwarzen Dame verklickt oder eine andere Figur lieber spielen möchte
				feld[merkxwert][merkywert].setSchwarzdameWahl(false);
				feld[merkxwert][merkywert].setSchwarzDame(true);
				wertSchwarz=1;
				vordefiniertEntfernen();
				return;
			}
		}
	}

	public static void weissNehmen() {					//Methode für weissen Stein nehmen
		System.out.println("weißer stein nehmen");
		merkxwert=xFeld;								//der x-Wert wird gespeichert
		merkywert=yFeld;								//der y-Wert wird gespeicht
		wertWeiss++;									//wird auf 2 erhöht
	}
	
	public static void weissPlatzWechsel() {					//Methode, die den weissen Stein an die neue Position setzt und auf der alten Position den Stein entfernt
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setWeissSpieler(true);
		feld[merkxwert][merkywert].setWeissWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
	}
	
	public static void weissSpringen() {						//Methode für weiss Springen
		System.out.println("weisser stein springt");
		vordefiniertEntfernen();
		kannspringen=false;
		wertWeiss=1;											//wertWeiss wird auf 1 gesetzt, da man nach dem Springen noch einen Zug machen kann
	}
	
	
	
	public static void schwarzNehmen() {						//Methode, die den schwarzen Stein nimmt
		System.out.println("schwarzer stein nehmen");
		merkxwert=xFeld;
		merkywert=yFeld;
		wertSchwarz++;
	}
	
	public static void schwarzPlatzWechsel() {					//Methode, die den schwarzen Stein an die neue Pos platziert und den alten Stein durch ein leeres Feld austauscht
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setSchwarzSpieler(true);
		feld[merkxwert][merkywert].setSchwarzWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
	}
	
	public static void schwarzSpringen() {						//Methode für schwarz Springen
		System.out.println("schwarzer stein springt");
		vordefiniertEntfernen();
		kannspringen=false;
		wertSchwarz=1;
	}
	
	
	
	public static void weissDamePruefen() {
		if(feld[xFeld][0].getWeissSpieler()==true) {			//prüfe, ob weisse Spielfigur zur Dame wird
			feld[xFeld][0].setWeissSpieler(false);				//weisse Figur wird entfernt
			feld[xFeld][0].setWeissDame(true);					//weisse Dame wird platziert
		}
	}
	
	public static void schwarzDamePruefen() {
		if(feld[xFeld][7].getSchwarzSpieler()==true) {			//prüfe, ob schwarze Spielfigur zur Dame wird
			feld[xFeld][7].setSchwarzSpieler(false);			//schwarz Figur wird entfernt
			feld[xFeld][7].setSchwarzDame(true);				//schwarz Dame wird platziert
		}
	}
	
	public static void weissDamePlatzWechsel() {				//Methode, die den weissen Stein an die neue Position setzt und auf der alten Position den Stein entfernt
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setWeissDame(true);
		feld[merkxwert][merkywert].setWeissdameWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
	}
	
	public static void schwarzDamePlatzWechsel() {					//Methode, die den schwarzen Stein an die neue Pos platziert und den alten Stein durch ein leeres Feld austauscht
		feld[xFeld][yFeld].setFeldhinbewegen(false);
		feld[xFeld][yFeld].setSchwarzDame(true);
		feld[merkxwert][merkywert].setSchwarzdameWahl(false);
		feld[merkxwert][merkywert].setLeerFeld(true);
		vordefiniertEntfernen();
	}
	
	
	
	public static void felderVorgabeOben() {																									//Prüft, die Felder, wo man mach oben gehen kann	
		if(feld[xFeld][yFeld].getWeissWahl()==true||feld[xFeld][yFeld].getWeissdameWahl()==true) {
			if((xFeld-2)>=0 &&(yFeld-2)>=0 && (feld[xFeld-1][yFeld-1].getSchwarzSpieler()==true||feld[xFeld-1][yFeld-1].getSchwarzDame()==true) && feld[xFeld-2][yFeld-2].getLeerFeld()==true) {		//prüft, ob man über einen Stein nach links oben springen kann
				feld[xFeld-2][yFeld-2].setLeerFeld(false);																							//setzt das leere Feld auf
				feld[xFeld-2][yFeld-2].setFeldhinbewegen(true);																						//das vordefinierte Feld
				kannspringen=true;
			}
			if((xFeld+2)<=7 && (yFeld-2)>=0 && (feld[xFeld+1][yFeld-1].getSchwarzSpieler()==true||feld[xFeld+1][yFeld-1].getSchwarzDame()==true) && feld[xFeld+2][yFeld-2].getLeerFeld()==true) {	//prüft, ob man über einen Stein nach rechts oben springen kann
				feld[xFeld+2][yFeld-2].setLeerFeld(false);
				feld[xFeld+2][yFeld-2].setFeldhinbewegen(true);
				kannspringen=true;
			}
		}else if(feld[xFeld][yFeld].getSchwarzdameWahl()==true) {
			if((xFeld-2)>=0 &&(yFeld-2)>=0 && (feld[xFeld-1][yFeld-1].getWeissSpieler()==true||feld[xFeld-1][yFeld-1].getWeissDame()==true) && feld[xFeld-2][yFeld-2].getLeerFeld()==true) {		//prüft, ob man über einen Stein nach links oben springen kann
				feld[xFeld-2][yFeld-2].setLeerFeld(false);																							//setzt das leere Feld auf
				feld[xFeld-2][yFeld-2].setFeldhinbewegen(true);																						//das vordefinierte Feld
				kannspringen=true;
			}
			if((xFeld+2)<=7 && (yFeld-2)>=0 && (feld[xFeld+1][yFeld-1].getWeissSpieler()==true||feld[xFeld+1][yFeld-1].getWeissDame()==true) && feld[xFeld+2][yFeld-2].getLeerFeld()==true) {	//prüft, ob man über einen Stein nach rechts oben springen kann
				feld[xFeld+2][yFeld-2].setLeerFeld(false);
				feld[xFeld+2][yFeld-2].setFeldhinbewegen(true);
				kannspringen=true;
			}
		}
		if((xFeld-1)>=0 &&(yFeld-1)>=0 && feld[xFeld-1][yFeld-1].getLeerFeld()==true) {								//prüft, ob man nach links oben gehen kann
			feld[xFeld-1][yFeld-1].setLeerFeld(false);
			feld[xFeld-1][yFeld-1].setFeldhinbewegen(true);
		}
		if((xFeld+1)<=7 && (yFeld-1)>=0 && feld[xFeld+1][yFeld-1].getLeerFeld()==true) {								//prüft, on man nach rechts oben gehen kann
			feld[xFeld+1][yFeld-1].setLeerFeld(false);
			feld[xFeld+1][yFeld-1].setFeldhinbewegen(true);
		}
	}
	
	public static void felderVorgabeUnten() {																									//Prüft, die Felder, wo man mach unten gehen kann
		if(feld[xFeld][yFeld].getSchwarzWahl()==true||feld[xFeld][yFeld].getSchwarzdameWahl()==true) {
			if((xFeld+2)<=7 && (yFeld+2)<=7 && (feld[xFeld+1][yFeld+1].getWeissSpieler()==true||feld[xFeld+1][yFeld+1].getWeissDame()==true) && feld[xFeld+2][yFeld+2].getLeerFeld()==true) {
				feld[xFeld+2][yFeld+2].setLeerFeld(false);
				feld[xFeld+2][yFeld+2].setFeldhinbewegen(true);
				kannspringen=true;
			}
			if((xFeld-2)>=0 && (yFeld+2)<=7 && (feld[xFeld-1][yFeld+1].getWeissSpieler()==true||feld[xFeld-1][yFeld+1].getWeissDame()==true) && feld[xFeld-2][yFeld+2].getLeerFeld()==true) {
				feld[xFeld-2][yFeld+2].setLeerFeld(false);
				feld[xFeld-2][yFeld+2].setFeldhinbewegen(true);
				kannspringen=true;
			}
		}else if(feld[xFeld][yFeld].getWeissdameWahl()==true) {
			if((xFeld+2)<=7 && (yFeld+2)<=7 && (feld[xFeld+1][yFeld+1].getSchwarzSpieler()==true||feld[xFeld+1][yFeld+1].getSchwarzDame()==true) && feld[xFeld+2][yFeld+2].getLeerFeld()==true) {
				feld[xFeld+2][yFeld+2].setLeerFeld(false);
				feld[xFeld+2][yFeld+2].setFeldhinbewegen(true);
				kannspringen=true;
			}
			if((xFeld-2)>=0 && (yFeld+2)<=7 && (feld[xFeld-1][yFeld+1].getSchwarzSpieler()==true||feld[xFeld-1][yFeld+1].getSchwarzDame()==true) && feld[xFeld-2][yFeld+2].getLeerFeld()==true) {
				feld[xFeld-2][yFeld+2].setLeerFeld(false);
				feld[xFeld-2][yFeld+2].setFeldhinbewegen(true);
				kannspringen=true;
			}
		}
		if((xFeld+1)<=7 && (yFeld+1)<=7 && feld[xFeld+1][yFeld+1].getLeerFeld()==true) {
			feld[xFeld+1][yFeld+1].setLeerFeld(false);
			feld[xFeld+1][yFeld+1].setFeldhinbewegen(true);
		}
		if((xFeld-1)>=0 && (yFeld+1)<=7 && feld[xFeld-1][yFeld+1].getLeerFeld()==true) {
			feld[xFeld-1][yFeld+1].setLeerFeld(false);
			feld[xFeld-1][yFeld+1].setFeldhinbewegen(true);
		}
	}
	
	
	public static void vordefiniertEntfernen() {																	//setzt alle vordefinierten hingebaren Felder zurück
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
	
	public static int getWertWeiss() {
		return wertWeiss;
	}
	
	public static int getWertSchwarz() {
		return wertSchwarz;
	}

}
