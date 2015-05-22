package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

import chrriis.dj.nativeswing.NativeSwing;

public class news_title  extends JPanel {

	/**
	 * Create the panel.
	 */
	private JLabel title1;
	private JLabel title2;
	private JLabel title3;
	private JLabel title4;
	private JLabel title5;
	private JLabel title6;
	private JLabel title7;
	private JLabel title8;
	private JLabel title9;
	private JLabel title10;

	private static ArrayList<String> results;
	private static ArrayList<String> titles;
	private static ArrayList<String> urls;
	private static ArrayList<String> iurls;
	
	
	news n1;
	
	// TODO Auto-generated method stub
			URL url;
			HttpURLConnection conn;
			BufferedReader rd;
			String line;
			String result = "";
			String content = null;
			URLConnection connection = null;
			ArrayList<String> copy_urls = new ArrayList<String>();
			
			
	
	public news_title(String command) throws MalformedURLException, IOException {
		
		initialize_variable();
		
		
		
		String prefix = "http://www.faroo.com/api?q=";
		String postfix = "&start=1&length=10&l=en&src=news&i=false&f=json&jsoncallback=mycallback&key=8pWhkMp8WVapj8qzIkogG4mu1EA_";
		String All = prefix + command + postfix;
		connection = new URL(All)
				.openConnection();
		Scanner scanner = new Scanner(connection.getInputStream());
		scanner.useDelimiter("\\Z");
		content = scanner.next();

		

		while (content.contains("\"title\":")) {
			String temp = null;
			temp = content.substring(content.indexOf("\"title\":"),
					content.indexOf("}", content.indexOf("\"title\":")));

			results.add(temp);
			content = content.substring(content.indexOf("}") + 1);
		}

		for (int i = 0; i < results.size(); i++) {
			String temp = results.get(i);
			String buffer;

			buffer = temp.substring(temp.indexOf("\"title\":") + 10,
					temp.indexOf("\",", temp.indexOf("\"title\":") + 10));
			titles.add(buffer);

			temp = temp.substring(temp.indexOf("\",") + 1);

			buffer = temp.substring(temp.indexOf("\"url\":") + 8,
					temp.indexOf("\",", temp.indexOf("\"url\":") + 8));
			urls.add(buffer);

			temp = temp.substring(temp.indexOf("\",") + 1);

			buffer = temp.substring(temp.indexOf("\"iurl\":") + 9,
					temp.indexOf("\",", temp.indexOf("\"iurl\":") + 9));
			iurls.add(buffer);
		}
		
		initialize(titles, urls);
		copy_urls = urls;
	}
	
	


	private void initialize_variable() {
		// TODO Auto-generated method stub
		results = new ArrayList<String>();
		titles =  new ArrayList<String>();
		urls =  new ArrayList<String>();
		iurls = new ArrayList<String>();
	}




	public void initialize(ArrayList<String> t1, ArrayList<String> u1) {

		// Label 추가 하는 부분
		
		setLayout(null);
	
	
		
		title1 = new JLabel(titles.get(0));
		title2 = new JLabel(titles.get(1));
		title3 = new JLabel(titles.get(2));
		title4 = new JLabel(titles.get(3));
		title5 = new JLabel(titles.get(4));
		title6 = new JLabel(titles.get(5));
		title7 = new JLabel(titles.get(6));
		title8 = new JLabel(titles.get(7));
		title9 = new JLabel(titles.get(8));
		title10 = new JLabel(titles.get(9));

		title1.setBounds(80, 40, 800, 40);
		title2.setBounds(80, 80, 800, 40);
		title3.setBounds(80, 120, 800, 40);
		title4.setBounds(80, 160, 800, 40);
		title5.setBounds(80, 200, 800, 40);
		title6.setBounds(80, 240, 800, 40);
		title7.setBounds(80, 280, 800, 40);
		title8.setBounds(80, 320, 800, 40);
		title9.setBounds(80, 360, 800, 40);
		title10.setBounds(80, 400, 800, 40);

		add(title1);
		add(title2);
		add(title3);
		add(title4);
		add(title5);
		add(title6);
		add(title7);
		add(title8);
		add(title9);
		add(title10);

		

	}


}
