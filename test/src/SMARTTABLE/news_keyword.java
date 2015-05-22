package SMARTTABLE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class news_keyword extends JPanel {


   
   /**
    * Create the panel.
    */
	   public news_keyword() {
		      
		      setLayout(null);
		        JLabel background = new JLabel();
		      Color myColor = Color.decode("#FAC823");
		      setBackground(myColor);
		      background.setIcon(new javax.swing.ImageIcon("whether_icon/NEWS_KEYWORD.png"));
		      background.setBounds(410,0,1600,900);
		      add(background);   
		      
		      JLabel l1 = new JLabel("select the topic");
		      l1.setBounds(680, 120, 500, 38);
		      l1.setFont(new Font("-À±°íµñ340", Font.BOLD, 35));
		      l1.setForeground(Color.black);
		      add(l1);   
		      //JLabel l0 = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/logo_weather.png")).getImage()).getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH)));
		      
		         JLabel back = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//back.jpg")).getImage()).getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH)));
		      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));				   
		      add(back);   
		      back.setBounds(1400, 10, 200, 40);
		      

				JLabel l0 = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/news_icon.png")).getImage()).getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH)));
				l0.setBounds(0, 0,70,70);
				add(l0); 

				l1 = new JLabel("NEWS");
				l1.setBounds(70, 13, 297, 38);
				l1.setFont(new Font("-À±°íµñ340", Font.BOLD, 40));
				l1.setForeground(Color.white);
				add(l1);
				

				 JLabel home = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//home.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
			      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));			       				
		     home.setBounds(1470, 70,60,60);	
			   add(home); 
		   }
		   

  
   
   
}
