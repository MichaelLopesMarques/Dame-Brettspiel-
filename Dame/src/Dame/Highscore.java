package Dame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Highscore extends JFrame{
	
	private JLabel platz = new JLabel();
	private JLabel score = new JLabel();
	private JLabel name = new JLabel();
	private JLabel farbe = new JLabel();
	
	private JLabel platz1 = new JLabel();
	private JLabel platz2 = new JLabel();
	private JLabel platz3 = new JLabel();
	
	private static JLabel name1 = new JLabel();
	private static JLabel name2 = new JLabel();
	private static JLabel name3 = new JLabel();
	
	private static JLabel score1 = new JLabel();
	private static JLabel score2 = new JLabel();
	private static JLabel score3 = new JLabel();
	
	private static JLabel farbe1 = new JLabel();
	private static JLabel farbe2 = new JLabel();
	private static JLabel farbe3 = new JLabel();

	public static String farbeneu;
	public static String nameneu;
	
	public static ArrayList<Integer> sortier = new ArrayList<Integer>();
	
	public Highscore()  { 								
		
				
		this.setTitle("Highscore");									//Einstellungen für das Fenster
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(580,500);
    	this.setVisible(true);	
    	this.setLayout(null);
    	this.setLocationRelativeTo(null);
    	
    	platz.setBounds(20, 24, 52, 29);
        platz.setText("Platz");
        platz.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz);
        
        name.setBounds(180, 24, 100, 29);
        name.setText("Name");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name);
        
        score.setBounds(400, 24, 64, 29);
        score.setText("Zeit");
        score.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score);
        
        farbe.setBounds(480, 24, 64, 29);
        farbe.setText("Farbe");
        farbe.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe);
        
        ///////////////////////////////////////////////////////////////////////////////////////        
        
        platz1.setBounds(20, 24, 52, 100);
        platz1.setText("1");
        platz1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz1);
        
        name1.setBounds(180, 24, 100, 100);
        name1.setText("Michael");
        name1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name1);
        
        score1.setBounds(400, 24, 64, 100);
        score1.setText("70");
        score1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score1);
        
        farbe1.setBounds(480, 24, 64, 100);
        farbe1.setText("Weiss");
        farbe1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe1);
        
        ///////////////////////////////////////////////////////////////////////////////////////        
        
        platz2.setBounds(20, 24, 52, 200);
        platz2.setText("2");
        platz2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz2);
        
        name2.setBounds(180, 24, 100, 200);
        name2.setText("Mamba-Player");
        name2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name2);
        
        score2.setBounds(400, 24, 64, 200);
        score2.setText("80");
        score2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score2);
        
        farbe2.setBounds(480, 24, 64, 200);
        farbe2.setText("Schwarz");
        farbe2.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe2);
        
        ///////////////////////////////////////////////////////////////////////////////////////
        
        platz3.setBounds(20, 24, 52, 300);
        platz3.setText("3");
        platz3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz3);
        
        name3.setBounds(180, 24, 100, 300);
        name3.setText("Damepro");
        name3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name3);
        
        score3.setBounds(400, 24, 64, 300);
        score3.setText("86");
        score3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score3);
        
        farbe3.setBounds(480, 24, 64, 300);
        farbe3.setText("Schwarz");
        farbe3.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe3);

        
		}
		
	public static void ArrayListEinfuegen() {
		sortier.add(Integer.parseInt(score1.getText()));
		sortier.add(Integer.parseInt(score2.getText()));
		sortier.add(Integer.parseInt(score3.getText()));
		
		String[] a = {score1.getText(),name1.getText(),farbe1.getText()};
		String[] b = {score2.getText(),name2.getText(),farbe2.getText()};
		String[] c = {score3.getText(),name3.getText(),farbe3.getText()};
		String[] d = {String.valueOf(Welt.zeit),Gewonnen.textfeld.getText(),Gewonnen.farbewin};
		
		System.out.println(sortier);
		
		sortieren(sortier, 0, sortier.size() - 1);

		System.out.println(sortier);
		score1.setText(String.valueOf(sortier.get(0)));
		score2.setText(String.valueOf(sortier.get(1)));
		score3.setText(String.valueOf(sortier.get(2)));
		
		if(sortier.get(0)==Integer.parseInt(a[0])) {			//achtung unfall ;D
			score1.setText(String.valueOf(sortier.get(0)));
			name1.setText(a[1]);
			farbe1.setText(a[2]);
		}else if(sortier.get(0)==Integer.parseInt(b[0])) {
			score1.setText(String.valueOf(sortier.get(0)));
			name1.setText(b[1]);
			farbe1.setText(b[2]);
		}else if(sortier.get(0)==Integer.parseInt(c[0])) {
			score1.setText(String.valueOf(sortier.get(0)));
			name1.setText(c[1]);
			farbe1.setText(c[2]);
		}else if(sortier.get(0)==Integer.parseInt(d[0])) {
			score1.setText(String.valueOf(sortier.get(0)));
			name1.setText(d[1]);
			farbe1.setText(d[2]);
		}
		
		if(sortier.get(1)==Integer.parseInt(a[0])) {
			score2.setText(String.valueOf(sortier.get(1)));
			name2.setText(a[1]);
			farbe2.setText(a[2]);
		}else if(sortier.get(1)==Integer.parseInt(b[0])) {
			score2.setText(String.valueOf(sortier.get(1)));
			name2.setText(b[1]);
			farbe2.setText(b[2]);
		}else if(sortier.get(1)==Integer.parseInt(c[0])) {
			score2.setText(String.valueOf(sortier.get(1)));
			name2.setText(c[1]);
			farbe2.setText(c[2]);
		}else if(sortier.get(1)==Integer.parseInt(d[0])) {
			score2.setText(String.valueOf(sortier.get(1)));
			name2.setText(d[1]);
			farbe2.setText(d[2]);
		}
		
		if(sortier.get(2)==Integer.parseInt(a[0])) {
			score3.setText(String.valueOf(sortier.get(2)));
			name3.setText(a[1]);
			farbe3.setText(a[2]);
		}else if(sortier.get(2)==Integer.parseInt(b[0])) {
			score3.setText(String.valueOf(sortier.get(2)));
			name3.setText(b[1]);
			farbe3.setText(b[2]);
		}else if(sortier.get(2)==Integer.parseInt(c[0])) {
			score3.setText(String.valueOf(sortier.get(2)));
			name3.setText(c[1]);
			farbe3.setText(c[2]);
		}else if(sortier.get(2)==Integer.parseInt(d[0])) {
			score3.setText(String.valueOf(sortier.get(2)));
			name3.setText(d[1]);
			farbe3.setText(d[2]);
		}
	}
	
	
	public static void sortieren(List<Integer> liste, int start, int ende) {
		if (start < ende) {
			int pivot = start;
		    int links = start + 1;
		    int rechts = ende;
		    int pivotValue = liste.get(pivot);
		    while (links <= rechts) {
		    	while (links <= ende && pivotValue >= liste.get(links)) {
		    		links++;
		    	}
		    	while (rechts > start && pivotValue < liste.get(rechts)) {
		    		rechts--;
		    	}
		    	if (links < rechts) {
		    		Collections.swap(liste, links, rechts);
		    	}
		    }
		    Collections.swap(liste, pivot, links - 1);
		    sortieren(liste, start, rechts - 1); 
		    sortieren(liste, rechts + 1, ende);   
		}
	}
}



    
	





