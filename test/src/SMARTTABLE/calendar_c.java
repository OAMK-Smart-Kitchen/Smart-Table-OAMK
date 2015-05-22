package SMARTTABLE;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class calendar_c extends JPanel {

	/**
	 * Create the panel.
	 */
	public calendar_c() {
		setLayout(null);
		JLabel l1 = new JLabel("This is calendar page. Coming soon");
		add(l1); 
		l1.setBounds(400, 10,400,200);	
		 JLabel home = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//home.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
	      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));			       				
   home.setBounds(1470, 70,60,60);	
	   add(home); 
	}

}
