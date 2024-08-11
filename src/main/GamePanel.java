package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	public final int originalTileSize = 16; //16 x 16 pixels will be the size of one tile
	
	public final int scale = 3; // to adjust to the resolution of the screen
	
	public final int maxColumns = 16;
	public final int maxRows = 12;
	public final int TileSize = originalTileSize * scale;
	
	public final int screenWidth = TileSize * maxColumns;
	public final int screenHeight = TileSize * maxRows;

	//World Settings
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;
	public final int worldWidth = TileSize * maxWorldCol;
	public final int worldHeight = TileSize * maxWorldRow;
	
	int FPS = 60;
	
	public TileManager tileMan = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public CollisionDetector collDetect = new CollisionDetector(this);
	public AssetPlacer assetPlacer = new AssetPlacer(this);
	Thread gameThread;
	public Player player =  new Player(this, keyH); 
	public SuperObject obj[] = new SuperObject[10];
	
	public GamePanel() { 
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}

	public void setupGame() {
		assetPlacer.placeObject();
	}
	
	public void startThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
			}	
		}
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//Tile
		tileMan.draw(g2); // tile is drawn below player as player will have to be on top of tile
		//Object
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		} 
		//Player
		player.draw(g2);
		
		g2.dispose();
		
	}
}
