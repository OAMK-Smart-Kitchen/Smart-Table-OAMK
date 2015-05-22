package SMARTTABLE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
/*
import SMARTTABLE.fridge_c.ButtonListener;*/
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class fridge extends JPanel {

   /**
    * Create the panel.
    */
   /*
   private String[] col = { "1","2","3","4","5","6","7","8"};
   private Object[][] data = {{"우진이표피자","우진이표라이스","특미오무라이스","10000 원 (★★★★★)","10000 원 (★★★★★)","8000 원 (★★★★★)","우진이표라이스","특미오무라이스"}};
   */
   
   //배경, 라벨 추가, cc버틍뉘치이동, back지우기
   
   fridge_function fridge_1 = new fridge_function(1,"BANANA","no.1", "fruit", "30kcal", "left-side in the fruit space", "4 pieces", getDate("2015-04-23"));
   fridge_function fridge_2 = new fridge_function(2,"KIWI","no.2", "fruit", "50kcal", "right-side in the fruit space", "6 pieces", getDate("2015-04-04"));
   fridge_function fridge_3 = new fridge_function(3,"RIB EYE","no.3", "meat", "1000kcal", "in the freezer", "4 pieces", getDate("2015-06-06"));
   fridge_function fridge_4 = new fridge_function(4,"CHEESE","no.4", "milk product", "200kcal", "second shelf", "13 pieces", getDate("2015-05-01"));
   fridge_function fridge_5 = new fridge_function(5,"MILK","no.5", "milk product", "300kcal", "third shelf", "2 bottles", getDate("2015-04-25"));

   String [] col = {"","","","","","","",""};
   String [][] data = {};
   private DefaultTableModel tableModel1 = new DefaultTableModel(data, col);
   private JTable table1 = new JTable(tableModel1);
   JLabel l0,l1,l2;
	
   public fridge() {
      setLayout(null);         
		JLabel a = new JLabel("fridge page");
		a.setBounds(500, 110,100,15);	
		Color myColor = Color.decode("#794A9D");
		setBackground(myColor);		

		JLabel l0 = new JLabel(new ImageIcon(((new ImageIcon("whether_icon/FRIDGE_ICON.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
		l0.setBounds(7, 10,60,60);
		add(l0); 

		l1 = new JLabel("FRIDGE");
		l1.setBounds(70, 18, 297, 38);
		l1.setFont(new Font("-윤고딕340", Font.BOLD, 40));
		l1.setForeground(Color.white);
		add(l1);	

		l2 = new JLabel("You can check the fridge!");
		l2.setBounds(600, 100, 800, 38);
		l2.setFont(new Font("-윤고딕340", Font.BOLD, 30));
		l2.setForeground(Color.white);
		add(l2);
		

	       JLabel home = new JLabel(new ImageIcon(((new ImageIcon("whether_icon//home.png")).getImage()).getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH)));
			      //back.setIcon(new javax.swing.ImageIcon("whether_icon/back.png"));			       				
		     home.setBounds(1470, 70,60,60);	
			   add(home); 
		
      String[] text = {"Id","Name","Category","Calories","Address","Quantity","ExpirationDate","Availibility"};
      Object[] text_ob=text;
      tableModel1.addRow(text_ob);
      tableModel1.addRow(fridge_1.getAll());
      tableModel1.addRow(fridge_2.getAll());
      tableModel1.addRow(fridge_3.getAll());
      tableModel1.addRow(fridge_4.getAll());
      tableModel1.addRow(fridge_5.getAll());
      table1.updateUI();   

      table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table1.setRowHeight(0,100);  
      table1.setRowHeight(1,100);  
      table1.setRowHeight(2,100);  
      table1.setRowHeight(3,100);  
      table1.setRowHeight(4,100);  
      table1.setRowHeight(5,100);  
            
      table1.getTableHeader().setReorderingAllowed(false); //열 이동 고정
      table1.getTableHeader().setResizingAllowed(false);//열 크기 고정 
      table1.setCellSelectionEnabled(true); // 셀단위로 선택
      
      table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      table1.getColumnModel().getColumn(0).setPreferredWidth(15);
      table1.getColumnModel().getColumn(1).setPreferredWidth(80);
      table1.getColumnModel().getColumn(2).setPreferredWidth(70);
      table1.getColumnModel().getColumn(3).setPreferredWidth(80);
      table1.getColumnModel().getColumn(4).setPreferredWidth(220);
      table1.getColumnModel().getColumn(5).setPreferredWidth(120);
      table1.getColumnModel().getColumn(6).setPreferredWidth(152);
      table1.getColumnModel().getColumn(7).setPreferredWidth(60);
      
      table1.setBounds(200,170,1200,600);
      table1.setFont(new Font("-윤고딕340", Font.BOLD,15));
      add(table1); 
   }

   public static Date getDate(String date2){
      /*Formatting about date*/
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
         date = formatter.parse(date2);
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
        return date;      
   }
}

