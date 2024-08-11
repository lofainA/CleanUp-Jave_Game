package main;

import javax.swing.JFrame;

import tile.MapGenerator;

public class Main {
	
	public static void main (String [] args) {
		
		
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setTitle("Clean Up");
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		GamePanel gp = new GamePanel();
		window.add(gp);
		
		window.pack();

		gp.setupGame();
		gp.startThread();
		
		window.setVisible(true);
		
	}
}

