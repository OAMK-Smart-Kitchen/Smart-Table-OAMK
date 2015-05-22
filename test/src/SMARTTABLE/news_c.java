package SMARTTABLE;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class news_c extends JPanel {

	news_keyword keyword;
	news_title title;
	private ArrayList<String> commands;
	public ArrayList<String> titles;
	public ArrayList<String> urls;
	news n1;
	int page_flag=-1; //-1:keyword, 2:title, 3:web
	
	JButton b0 = new JButton("0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");

	String command2;
	ButtonListener listener = new ButtonListener();
	String key=null;
	

	   public news_c() throws MalformedURLException, IOException {

	      setLayout(null);   
	      JLabel a = new JLabel("news page");
	      a.setBounds(500, 110,100,15);   
	      Color myColor = Color.decode("#FAC823");
	      setBackground(myColor);
	      keyword = new news_keyword();      
	      keyword.setBounds(0, 0, 1600, 900);
	      add_button();
	      add(keyword);


	      JButton BACK = new JButton("BACK");
	      BACK.setActionCommand("BACK");
	      BACK.addActionListener(listener);
	      BACK.setBounds(1460, 10, 80, 40);

	      BACK.setOpaque(false);
	      BACK.setContentAreaFilled(false);
	      BACK.setBorderPainted(false);
	      add(BACK);         
	      
	      JLabel home = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//home.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
	      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));			       				
     home.setBounds(1470, 70,60,60);	
	   add(home); 
			
	   }

	   void add_button(){
	      b0.setBounds(410, 200, 230, 230);
	      b1.setBounds(670, 200, 230, 230);
	      b2.setBounds(930, 200, 230, 230);
	      b3.setBounds(410, 470, 230, 230);
	      b4.setBounds(670, 470, 230, 230);
	      b5.setBounds(930, 470, 230, 230);
	      
	      b0.setOpaque(false);
	      b0.setContentAreaFilled(false);
	      b0.setBorderPainted(false);
	      
	      b1.setOpaque(false);
	      b1.setContentAreaFilled(false);
	      b1.setBorderPainted(false);
	      
	      b2.setOpaque(false);
	      b2.setContentAreaFilled(false);
	      b2.setBorderPainted(false);
	      
	      b3.setOpaque(false);
	      b3.setContentAreaFilled(false);
	      b3.setBorderPainted(false);
	      
	      b4.setOpaque(false);
	      b4.setContentAreaFilled(false);
	      b4.setBorderPainted(false);
	      
	      b5.setOpaque(false);
	      b5.setContentAreaFilled(false);
	      b5.setBorderPainted(false);

	      b0.setActionCommand("economy");
	      b0.addActionListener(listener);
	      b1.setActionCommand("politics");
	      b1.addActionListener(listener);
	      b2.setActionCommand("online-game");
	      b2.addActionListener(listener);
	      b3.setActionCommand("environment");
	      b3.addActionListener(listener);
	      b4.setActionCommand("kitchen");
	      b4.addActionListener(listener);
	      b5.setActionCommand("korea");
	      b5.addActionListener(listener);

	      keyword.add(b0);
	      keyword.add(b1);
	      keyword.add(b2);
	      keyword.add(b3);
	      keyword.add(b4);
	      keyword.add(b5);
	      
	      commands = new ArrayList<String>();
	      
	      commands.add("economy");
	      commands.add("politics");
	      commands.add("online-game");
	      commands.add("environment");
	      commands.add("kitchen");
	      commands.add("korea");
	      }
	   
	   
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
				int flag = -1;
				
				if(page_flag==-1){ //-1:keyword, 2:title, 3:web
					for (int i = 0; i < commands.size(); i++) {
						if (commands.get(i).equals(command)) {
							remove(keyword);
							try {
								title = new news_title(commands.get(i));
								key=commands.get(i);
								createNews_title(title);
							} catch (MalformedURLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							main.where_panel = 3;
							title.setBounds(0, 0, 1600, 900);
							add(title);
							revalidate();
							repaint();
							
							page_flag=2;
						}
					}
				}
				else if(page_flag==2){ //title					
					if(command.equals("BACK"))
					{		
						keyword = new news_keyword();	
						remove(title);				
						keyword.setBounds(0, 0, 1600, 900);
						add_button();
						main.where_panel = 2;
						add(keyword);
						revalidate();
						repaint();	
						page_flag=-1; 
						key=null;
					}
					else{
						int temp = -1;
						String url;					
						temp = Integer.parseInt(command);
						temp = temp -1;
						
						if(!(temp==-1)){	
							url = title.copy_urls.get(temp);
							n1 = new news(url);
							n1.setBounds(0, 0, 1600, 900);
							remove(title);
							add(n1);
				            revalidate();
				            repaint();  
				            page_flag=3;
						}
					}
				}
				else if(page_flag==3){ //web					
					if(command.equals("BACK"))
					{							
						try {
							System.out.println(key);
							title = new news_title(key);
							title.setBounds(0, 0, 1600, 900);
							createNews_title(title);
							remove(n1);
							add(title);
				            revalidate();
				            repaint();  
				            page_flag=2;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					}					
				}				
		}
		
		

		private void createNews_title(news_title title) {
			// Button 추가하는 부분
			JButton c1 = new JButton();
			c1.setActionCommand("1");
			c1.addActionListener(listener);
			c1.setBounds(80, 40, 600, 40);
			c1.setOpaque(false);
			c1.setContentAreaFilled(false);
			c1.setBorderPainted(false);

			JButton c2 = new JButton();
			c2.setActionCommand("2");
			c2.addActionListener(listener);
			c2.setBounds(80, 80, 600, 40);
			c2.setOpaque(false);
			c2.setContentAreaFilled(false);
			c2.setBorderPainted(false);

			JButton c3 = new JButton();
			c3.setActionCommand("3");
			c3.addActionListener(listener);
			c3.setBounds(80, 120, 600, 40);
			c3.setOpaque(false);
			c3.setContentAreaFilled(false);
			c3.setBorderPainted(false);

			JButton c4 = new JButton();
			c4.setActionCommand("4");
			c4.addActionListener(listener);
			c4.setBounds(80, 160, 600, 40);
			c4.setOpaque(false);
			c4.setContentAreaFilled(false);
			c4.setBorderPainted(false);

			JButton c5 = new JButton();
			c5.setActionCommand("5");
			c5.addActionListener(listener);
			c5.setBounds(80, 200, 600, 40);
			c5.setOpaque(false);
			c5.setContentAreaFilled(false);
			c5.setBorderPainted(false);

			JButton c6 = new JButton();
			c6.setActionCommand("6");
			c6.addActionListener(listener);
			c6.setBounds(80, 240, 600, 40);
			c6.setOpaque(false);
			c6.setContentAreaFilled(false);
			c6.setBorderPainted(false);

			JButton c7 = new JButton();
			c7.setActionCommand("7");
			c7.addActionListener(listener);
			c7.setBounds(80, 280, 600, 40);
			c7.setOpaque(false);
			c7.setContentAreaFilled(false);
			c7.setBorderPainted(false);

			JButton c8 = new JButton();
			c8.setActionCommand("8");
			c8.addActionListener(listener);
			c8.setBounds(80, 320, 600, 40);
			c8.setOpaque(false);
			c8.setContentAreaFilled(false);
			c8.setBorderPainted(false);

			JButton c9 = new JButton();
			c9.setActionCommand("9");
			c9.addActionListener(listener);
			c9.setBounds(80, 360, 600, 40);
			c9.setOpaque(false);
			c9.setContentAreaFilled(false);
			c9.setBorderPainted(false);

			JButton c10 = new JButton();
			c10.setActionCommand("10");
			c10.addActionListener(listener);
			c10.setBounds(80, 400, 600, 40);
			c10.setOpaque(false);
			c10.setContentAreaFilled(false);
			c10.setBorderPainted(false);
			
			
			title.add(c1);
			title.add(c2);
			title.add(c3);
			title.add(c4);
			title.add(c5);
			title.add(c6);
			title.add(c7);
			title.add(c8);
			title.add(c9);
			title.add(c10);	
		}
	}
	
	


}
