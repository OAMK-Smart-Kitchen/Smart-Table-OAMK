package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import chrriis.dj.nativeswing.NativeSwing;

public class main {

	public static JFrame index_frame;

	public static news_c news;
	
	
	public static int swipe_direction = 0;

	private static ArrayList<String> results = new ArrayList<String>();
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<String> urls = new ArrayList<String>();
	private static ArrayList<String> iurls = new ArrayList<String>();
	// public static main main;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		String content = null;
		URLConnection connection = null;
		NativeSwing.initialize();
		
		
		main window = new main();
		window.index_frame.setVisible(true);
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public main() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		//ButtonListener listener = new ButtonListener();
		index_frame = new JFrame();
		index_frame.setBounds(0, 0, 1600, 900);
		index_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		index_frame.getContentPane().setLayout(null);
		
		
		news = new news_c(titles,urls);
		news.setBounds(0, 0, 1600, 900);
		index_frame.getContentPane().add(news);
		
		
	
	}
}

