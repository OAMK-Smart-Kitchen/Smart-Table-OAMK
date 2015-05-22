package SMARTTABLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SMARTTABLE.Weather_c.ButtonListener;

public class fridge_c extends JPanel {

	/**
	 * Create the panel.
	 */
	
	fridge fridge;
	JButton bt_back;
//	ButtonListener listener = new ButtonListener();
	
	public fridge_c() {
		setLayout(null);
		main.window.where_panel = 5;
		fridge = new fridge();
		fridge.setBounds(0, 0,1600,900);
		add(fridge);	
		/*
		bt_back = new JButton("back");
		bt_back.setBounds(10, 110,100,15);		
		bt_back.setActionCommand("BACK");
		//bt_back.addActionListener(listener); 
		fridge.add(bt_back);*/
	}	

	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command=e.getActionCommand();
				
			if(command.equals("BACK"))
			{		
				remove(fridge);		
				revalidate();
				repaint();				
			}
		}
	}	
}