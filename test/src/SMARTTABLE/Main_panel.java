package SMARTTABLE;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BoxLayout;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_panel extends JPanel {

	JLabel background=new JLabel("");
	/**
	 * Create the panel.
	 */
	public Main_panel() {
		setLayout(null);
		
		background.setIcon(new javax.swing.ImageIcon("whether_icon/main_1.jpg"));
		background.setBounds(0,0,1600,900);
		add(background);			

		
        JLabel back = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//back.jpg")).getImage()).getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH)));
		      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));

	      back.setBounds(10, 650, 70, 70);	
		      add(back);   
	}
	
	public void Change_bg(int a){
		int b=a;
		background.setIcon(new javax.swing.ImageIcon("whether_icon/main_"+b+".jpg"));
		background.setBounds(0,0,1600,900);
		add(background);	
		revalidate();
		repaint();	
	}

}
