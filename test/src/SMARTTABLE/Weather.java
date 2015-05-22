package SMARTTABLE;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BoxLayout;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Weather extends JPanel {
	//String abc;
	JLabel l0,l1,l2;
	JLabel summary;
	JLabel weather_icon;
	JLabel temperature;
	JLabel humidity;
	/**
	 * Create the panel.
	 */	
	public Weather(int a) {
		String[] temp=Weather_c.get_daily_info(a);

		System.out.println("2222222222222222222222222");
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		
		Color myColor = Color.decode("#BC1C48");
		setBackground(myColor);
		setLayout(null);
		
		JLabel l0 = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/logo_weather.png")).getImage()).getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH)));
		l0.setBounds(0, 0,70,70);
		add(l0); 

		System.out.println("I am "+a);
		l1 = new JLabel("WEATHER");
		l1.setBounds(70, 18, 297, 38);
		l1.setFont(new Font("-À±°íµñ340", Font.BOLD, 40));
		l1.setForeground(Color.white);
		add(l1);	
		

		 JLabel home = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//home.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
	      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));			       				
    home.setBounds(1470, 70,60,60);	
	   add(home); 
			   
		Calendar currentDate = Calendar.getInstance(); //Get the current date
		SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy"); //format it as per your requirement
		String dateNow = formatter.format(addDays(currentDate.getTime(),a));	
		String dayNow = new SimpleDateFormat("EE", Locale.ENGLISH).format(addDays(currentDate.getTime(),a));
		
		
		l2 = new JLabel(dayNow+dateNow);
		l2.setBounds(1100, 15, 500, 38);
		l2.setFont(new Font("-À±°íµñ340", Font.BOLD, 40));
		l2.setHorizontalAlignment(JLabel.RIGHT);
		l2.setForeground(Color.white);
		add(l2);	
		
		//DATE TAP
		JLabel date_tap = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/tap.png")).getImage()).getScaledInstance(450, 50, java.awt.Image.SCALE_SMOOTH)));
		date_tap.setBounds(1280,15,450,50);
		date_tap.setHorizontalAlignment(JLabel.LEFT);
		add(date_tap); 
	
		//icon
		String temp2=temp[0];
		temp2 = temp[0].replace("\"","");
		temp2 = temp2.replace("icon: ","");
		System.out.println("22"+temp2);
		JLabel lblNewLabel = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/"+temp2+".png")).getImage()).getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(630,160,400,400);
		add(lblNewLabel); 
				
	
		//max
		temp2 = temp[2].replace("temperatureMax: ","");
		JLabel lblNewLabel_3 = new JLabel(temp2);
		lblNewLabel_3.setFont(new Font("-À±°íµñ340", Font.PLAIN, 90));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(JLabel.LEFT);
		lblNewLabel_3.setBounds(820, 560,400, 150);
		add(lblNewLabel_3);
		
		//min
		temp2 = temp[3].replace("temperatureMin: ","");
		JLabel lblNewLabel_1 = new JLabel(temp2);
		lblNewLabel_1.setFont(new Font("-À±°íµñ340", Font.PLAIN, 90));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
		lblNewLabel_1.setBounds(400, 520,400, 150);
		add(lblNewLabel_1);		
		
		JLabel slash=new JLabel("/");
		slash.setFont(new Font("-À±°íµñ340", Font.PLAIN, 40));
		slash.setForeground(Color.white);
		slash.setHorizontalAlignment(JLabel.CENTER);
		slash.setBounds(610, 540,400, 150);
		add(slash);		
		
		JLabel tem=new JLabel("¡É");
		tem.setFont(new Font("-À±°íµñ340", Font.PLAIN, 40));
		tem.setForeground(Color.white);
		tem.setHorizontalAlignment(JLabel.LEFT);
		tem.setBounds(1010, 580,100, 150);
		add(tem);		
		
		//summary
		temp2 = temp[1].replace("\"","");
		temp2 = temp2.replace("summary: ","");
		temp2 = temp2.replace(".","");
		JLabel lblNewLabel_2 = new JLabel(temp2);
		lblNewLabel_2.setFont(new Font("-À±°íµñ340", Font.BOLD, 30));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_2.setBounds(50, 620,1600, 200);
		add(lblNewLabel_2); 
		
		
	}
	
	 public static Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return cal.getTime();
	    }
}
