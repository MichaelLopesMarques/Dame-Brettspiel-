package Dame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Highscore extends JFrame implements ActionListener{
	
	private JLabel[] platz = new JLabel[4];
	private static JLabel[] score = new JLabel[4];
	private static JLabel[] name = new JLabel[4];
	private static JLabel[] farbe = new JLabel[4];
	
	private static JButton nochmal = new JButton();
	private static JButton beenden = new JButton();

	public static String farbeneu;
	public static String nameneu;
	
	public static ArrayList<Integer> sortier = new ArrayList<Integer>();
	
	public Highscore()  { 								
		
				
		this.setTitle("Highscore");									//Einstellungen für das Fenster
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.setSize(580,400);
    	this.setVisible(true);	
    	this.setLayout(null);
    	this.setLocationRelativeTo(null);
    	
    	platz[0]=new JLabel();
    	platz[0].setBounds(20, 24, 52, 29);
    	platz[0].setText("Platz");
    	platz[0].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz[0]);
        
        name[0]=new JLabel();
        name[0].setBounds(180, 24, 100, 29);
        name[0].setText("Name");
        name[0].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name[0]);
        
        score[0]=new JLabel();
        score[0].setBounds(400, 24, 64, 29);
        score[0].setText("Zeit");
        score[0].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score[0]);
        
        farbe[0]=new JLabel();
        farbe[0].setBounds(480, 24, 64, 29);
        farbe[0].setText("Farbe");
        farbe[0].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe[0]);
        
        ///////////////////////////////////////////////////////////////////////////////////////        
        
        platz[1]=new JLabel();
        platz[1].setBounds(20, 24, 52, 100);
        platz[1].setText("1");
        platz[1].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz[1]);
        
        name[1]=new JLabel();
        name[1].setBounds(180, 24, 100, 100);
        name[1].setText("Michael");
        name[1].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name[1]);
        
        score[1]=new JLabel();
        score[1].setBounds(400, 24, 64, 100);
        score[1].setText("70");
        score[1].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score[1]);
        
        farbe[1]=new JLabel();
        farbe[1].setBounds(480, 24, 64, 100);
        farbe[1].setText("Weiss");
        farbe[1].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe[1]);
        
        ///////////////////////////////////////////////////////////////////////////////////////        
        
        platz[2]=new JLabel();
        platz[2].setBounds(20, 24, 52, 200);
        platz[2].setText("2");
        platz[2].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz[2]);
        
        name[2]=new JLabel();
        name[2].setBounds(180, 24, 100, 200);
        name[2].setText("Mamba-Player");
        name[2].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name[2]);
        
        score[2]=new JLabel();
        score[2].setBounds(400, 24, 64, 200);
        score[2].setText("80");
        score[2].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score[2]);
        
        farbe[2]=new JLabel();
        farbe[2].setBounds(480, 24, 64, 200);
        farbe[2].setText("Schwarz");
        farbe[2].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe[2]);
        
        ///////////////////////////////////////////////////////////////////////////////////////
        
        platz[3]=new JLabel();
        platz[3].setBounds(20, 24, 52, 300);
        platz[3].setText("3");
        platz[3].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(platz[3]);
        
        name[3]=new JLabel();
        name[3].setBounds(180, 24, 100, 300);
        name[3].setText("Damepro");
        name[3].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(name[3]);
        
        score[3]=new JLabel();
        score[3].setBounds(400, 24, 64, 300);
        score[3].setText("86");
        score[3].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(score[3]);
        
        farbe[3]=new JLabel();
        farbe[3].setBounds(480, 24, 64, 300);
        farbe[3].setText("Schwarz");
        farbe[3].setHorizontalAlignment(SwingConstants.CENTER);
        this.add(farbe[3]);

        ///////////////////////////////////////////////////////////////////////////////////////
        
        nochmal.setBounds(100, 250, 100, 40);
        nochmal.setText("Nochmal");
        nochmal.addActionListener(this);
        this.add(nochmal);
        
        beenden.setBounds(380, 250, 100, 40);
        beenden.setText("Beenden");
        beenden.addActionListener(this);
        this.add(beenden);
		}
		
	public static void ArrayListEinfuegen() {
		sortier.add(Integer.parseInt(score[1].getText()));
		sortier.add(Integer.parseInt(score[2].getText()));
		sortier.add(Integer.parseInt(score[3].getText()));
		
		String[] a = {score[1].getText(),name[1].getText(),farbe[1].getText()};
		String[] b = {score[2].getText(),name[2].getText(),farbe[2].getText()};
		String[] c = {score[3].getText(),name[3].getText(),farbe[3].getText()};
		String[] d = {String.valueOf(Welt.zeit),Gewonnen.textfeld.getText(),Gewonnen.farbewin};
		
		System.out.println(sortier);
		
		sortieren(sortier, 0, sortier.size() - 1);

		System.out.println(sortier);
		
		for (int i=0;i<(sortier.size()-1);i++) {
			if(sortier.get(i)==Integer.parseInt(a[0])) {			//achtung unfall ;D
				score[i+1].setText(String.valueOf(sortier.get(i)));
				name[i+1].setText(a[1]);
				farbe[i+1].setText(a[2]);
			}else if(sortier.get(i)==Integer.parseInt(b[0])) {
				score[i+1].setText(String.valueOf(sortier.get(i)));
				name[i+1].setText(b[1]);
				farbe[i+1].setText(b[2]);
			}else if(sortier.get(i)==Integer.parseInt(c[0])) {
				score[i+1].setText(String.valueOf(sortier.get(i)));
				name[i+1].setText(c[1]);
				farbe[i+1].setText(c[2]);
			}else if(sortier.get(i)==Integer.parseInt(d[0])) {
				score[i+1].setText(String.valueOf(sortier.get(i)));
				name[i+1].setText(d[1]);
				farbe[i+1].setText(d[2]);
			}
		}
		
		sortier.remove(3);
		sortier.remove(2);
		sortier.remove(1);
		sortier.remove(0);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source.equals(nochmal)) {
			Welt.Reset();
			dispose();
		}
		
		if(source.equals(beenden)) {
			dispose();
		}
	}
}



    
	





