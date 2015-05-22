package SMARTTABLE;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;






import com.github.dvdme.ForecastIOLib.*;

public class main {

	public static JFrame frame;
	private Weather_c weather;
	public static Main_panel m_panel;
	private calendar_c calendar;
	private fridge_c fridge;
	private news_c news;
	public static int swipe_direction = -1;
	public static int where_panel = -1; 
	public static main window;
	static JButton j1;
	static JButton j2;
	static JButton j3;
	static JButton j4;
	static JButton j5;
	static JButton cancel;
	
	ButtonListener listener = new ButtonListener();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new main();
					newSample leapmotion = new newSample();
					Thread leap = new Thread (leapmotion);
					leap.start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
		//weather.getWeather();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();		
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton cancel = new JButton("");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(listener); 
		cancel.setBounds(1470, 70,60,60); 
	      cancel.setOpaque(false);
	      cancel.setContentAreaFilled(false);
	      cancel.setBorderPainted(false);  	
		frame.getContentPane().add(cancel);
		
		/*weather = new Weather_c();
		weather.setBounds(0, 0, 1600, 900);
		frame.getContentPane().add(weather);*/	
		
		/*daily_weather = new weather_daily_panel();
		daily_weather.setBackground(Color.gray);
		daily_weather.setBounds(0, 342, 923, 156);
		frame.getContentPane().add(daily_weather); */
		
		m_panel= new Main_panel();
		m_panel.setBounds(0, 0,1600,900);
		main.where_panel = 4;
		frame.getContentPane().add(m_panel);	
		
		add_button();
		
	}	
	
	void add_button(){		
		
		j1=new JButton("weather");
	      j1.setActionCommand("weather");
	      j1.addActionListener(listener); 
	      j1.setBounds(550, 230,250,250);
	      j1.setOpaque(false);
	      j1.setContentAreaFilled(false);
	      j1.setBorderPainted(false);
	       m_panel.add(j1);          

	      j2=new JButton("calendar");
	      j2.setActionCommand("calendar");
	      j2.addActionListener(listener); 
	      j2.setBounds(830, 230,250,250);   
	      j2.setOpaque(false);
	      j2.setContentAreaFilled(false);
	      j2.setBorderPainted(false);
	       m_panel.add(j2);          

	      j3=new JButton("news");
	      j3.setActionCommand("news");
	      j3.addActionListener(listener); 
	      j3.setBounds(550, 510,250,250);   
	      j3.setOpaque(false);
	      j3.setContentAreaFilled(false);
	      j3.setBorderPainted(false);
	       m_panel.add(j3);

	      j4=new JButton("fridge");
	      j4.setActionCommand("fridge");
	      j4.addActionListener(listener); 
	      j4.setBounds(830, 510,250,250);   
	      j4.setOpaque(false);
	      j4.setContentAreaFilled(false);
	      j4.setBorderPainted(false);
	       m_panel.add(j4);         
	       

	       cancel = new JButton("");
	      cancel.setActionCommand("cancel");
	      cancel.addActionListener(listener); 
	      cancel.setBounds(1500, 70,60,60);  
	      cancel.setOpaque(false);
	      cancel.setContentAreaFilled(false);
	      cancel.setBorderPainted(false);  
	      frame.add(cancel);

	     
	  
	}

	public static Component get_panel(){
		return m_panel;
	}

	public static Component get_home(){
		return cancel;
	}
	public static Component get_bt1(){
		return j1;
	}

	public static Component get_bt2(){
		return j2;
	}

	public static Component get_bt3(){
		return j3;
	}

	public static Component get_bt4(){
		return j4;
	}
	
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command=e.getActionCommand();
	
			if(command.equals("weather"))
			{
				weather=new Weather_c();
				weather.setBounds(0, 0,1600,900);
				frame.getContentPane().remove(m_panel);
				frame.getContentPane().add(weather);				
				frame.revalidate();
				frame.repaint();	
			}			
			else if(command.equals("calendar"))
			{								
				calendar=new calendar_c();
				calendar.setBounds(0, 0,1600,900);
				frame.getContentPane().remove(m_panel);
				frame.getContentPane().add(calendar);				
				frame.revalidate();
				frame.repaint();				
			}			
			else if(command.equals("news"))
			{								
				try {
					news=new news_c();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				news.setBounds(0, 0,1600,900);
				frame.getContentPane().remove(m_panel);
				frame.getContentPane().add(news);				
				frame.revalidate();
				frame.repaint();				
			}			
			else if(command.equals("fridge"))
			{								
				fridge=new fridge_c();
				fridge.setBounds(0, 0,1600,900);
				frame.getContentPane().remove(m_panel);
				frame.getContentPane().add(fridge);				
				frame.revalidate();
				frame.repaint();				
			}		
			else if(command.equals("cancel"))
			{	
				m_panel = new Main_panel();
				m_panel.setBounds(0, 0,1600,900);
				frame.getContentPane().removeAll();	
				frame.getContentPane().add(m_panel);
				add_button();
				frame.revalidate();
				frame.repaint();										
			}
		}
	}
}
