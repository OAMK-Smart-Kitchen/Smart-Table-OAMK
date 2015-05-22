package SMARTTABLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import SMARTTABLE.main.ButtonListener;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class Weather_c extends JPanel {


	String[][] temp = new String[8][30];
	static String[][] main_temp = new String[8][4];
	Weather weather;
	
	JButton b0 = new JButton("0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	ButtonListener listener = new ButtonListener();
	/**
	 * Create the panel.
	 */
	public Weather_c() {
		
		main.where_panel = 1;
		
		get_daily_weather();
		setLayout(null);
		weather=new Weather(0);
		weather.setBounds(0, 0,1600,900);
		add(weather);	

		b0.setBounds(10, 0,100,15);		
		b1.setBounds(10, 10,100,15);
		b2.setBounds(10, 30,100,15);
		b3.setBounds(10, 50,100,15);
		b4.setBounds(10, 70,100,15);
		b5.setBounds(10, 90,100,15);
		b6.setBounds(10, 110,100,15);
		
		b0.setActionCommand("0");
		b0.addActionListener(listener); 
		b1.setActionCommand("1");
		b1.addActionListener(listener); 		
		b2.setActionCommand("2");
		b2.addActionListener(listener); 		
		b3.setActionCommand("3");
		b3.addActionListener(listener); 		
		b4.setActionCommand("4");
		b4.addActionListener(listener); 		
		b5.setActionCommand("5");
		b5.addActionListener(listener); 		
		b6.setActionCommand("6");
		b6.addActionListener(listener); 
		
		add(b0);
		add(b1);	
		add(b2);	
		add(b3);	
		add(b4);	
		add(b5);	
		add(b6);		
	}
	
	void get_daily_weather(){
		
		ForecastIO fio = new ForecastIO("02f04a04fe302036069fe6f79652df2a");
		fio.setUnits(ForecastIO.UNITS_SI);
		fio.setLang(ForecastIO.LANG_ENGLISH);
		fio.getForecast("65.0002126" , "25.5098393");
		
		FIODaily daily = new FIODaily(fio);
		
		if(daily.days()<0)
			System.out.println("No daily data.");
		else
			System.out.println("\nDaily:\n");
		
		int h_length =0;
		
		for(int i = 0; i<daily.days(); i++){
			String [] h = daily.getDay(i).getFieldsArray();
			System.out.println("Day #"+(i+1));
			
			for(int j=0; j<h.length; j++){
				//System.out.println(h[j]+": "+daily.getDay(i).getByKey(h[j]));
					temp [i][j]=h[j]+": "+daily.getDay(i).getByKey(h[j]);					
					if(temp[i][j].startsWith("icon")){	
						main_temp[i][0]=temp[i][j];
						System.out.println(main_temp[i][0]);	
					}
					else if(temp[i][j].startsWith("summary")){	
						main_temp[i][1]=temp[i][j];
						System.out.println(main_temp[i][1]);						
					}else if(temp[i][j].startsWith("temperatureMax")&&(!temp[i][j].startsWith("temperatureMaxTime"))){						
						main_temp[i][2]=temp[i][j];
						System.out.println(main_temp[i][2]);								
					}else if(temp[i][j].startsWith("temperatureMin")&&(!temp[i][j].startsWith("temperatureMinTime"))){
						main_temp[i][3]=temp[i][j];
						System.out.println(main_temp[i][3]);				
					}			
				}			
				
			}
			
				for(int k=0;k<8;k++){
					for(int j=0;j<4;j++){
						System.out.println("lll"+main_temp[k][j]);	
					}				
				}				
	}	
	
	static String[] get_daily_info(int a){
		return main_temp[a];		
	}
	

	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command=e.getActionCommand();
	
			
			if(command.equals("0"))
			{		
				remove(weather);							
				weather = new Weather(0);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}
			else if(command.equals("1"))
			{	
				remove(weather);
				weather = new Weather(1);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}			
			else if(command.equals("2"))
			{		
				remove(weather);
				weather = new Weather(2);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}			
			else if(command.equals("3"))
			{							
				remove(weather);				
				weather = new Weather(3);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}			
			else if(command.equals("4"))
			{						
				remove(weather);					
				weather = new Weather(4);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}			
			else if(command.equals("5"))
			{					
				remove(weather);						
				weather = new Weather(5);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}			
			else if(command.equals("6"))
			{					
				remove(weather);						
				weather = new Weather(6);
				weather.setBounds(0, 0,1600,900);
				add(weather);			
				revalidate();
				repaint();				
			}
		}
	}
	

}

