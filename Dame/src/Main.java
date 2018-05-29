import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static JButton single;
	private JButton multi;
	private JButton tut;
	private JButton end;
	
	public static void main(String[] args) {
	    	//super();
	    	//pack();
	    	JFrame frame = new JFrame ("Dame");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1280,720);
	        frame.setResizable(false);
	        frame.setVisible(true);
	        
	        Welt welt = new Welt();
	        
	        
	        single = new JButton("Singleplayer");
	        single.setBounds(100,100,100,100);
	        add(single);
	        
	}

	private static void add(JButton single2) {
		// TODO Auto-generated method stub
		
	}
}
