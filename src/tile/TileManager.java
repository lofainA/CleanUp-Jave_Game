package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile; //array to store diff types of tiles
	public int mapTileNum[][]; //map data will be stored here
	boolean generateMap = true;
	//MapGenerator mg = new MapGenerator();
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		tile = new Tile[100]; //change if need to add more than 100 types of tiles

		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/WorldMap #1");

	}

	public void getTileImage() {

		setup(0, "1 grass", false);
		setup(1, "brickwall", true);
		setup(2, "Bush", false);
		setup(3, "Dirt", false);
		setup(4, "grass var", false);
		setup(5, "mud", false);
		setup(6, "path var", false);
		setup(7, "path-grass bottom-left-corner", false);
		setup(8, "path-grass bottom-left", false);
		setup(9, "path-grass bottom-right-corner", false);
		setup(10, "path-grass bottom-right", false);
		setup(11, "path-grass bottom", false);
		setup(12, "path-grass left", false);	
		setup(13, "path-grass right", false);	
		setup(14, "path-grass top-left-corner", false);	
		setup(15, "path-grass top-left", false);	
		setup(16, "path-grass top-right-corner", false);	
		setup(17, "path-grass top-right", false);	
		setup(18, "path-grass top", false);	
		setup(19, "path", false);	
		setup(20, "Sand", false);
		setup(21, "stonewall", true);	
		setup(22, "Tree", true);
		setup(23, "water var", true);	
		setup(24, "water-grass bottom-left-corner", true);	
		setup(25, "water-grass bottom-left", true);	
		setup(26, "water-grass bottom-right-corner", true);	
		setup(27, "water-grass bottom-right", true);	
		setup(28, "water-grass bottom", true);	
		setup(29, "water-grass left", true);	
		setup(30, "water-grass right", true);	
		setup(31, "water-grass top-left-corner", true);	
		setup(32, "water-grass top-left", true);	
		setup(33, "water-grass top-right-corner", true);	
		setup(34, "water-grass top-right", true);	
		setup(35, "water-grass top", true);	
		setup(36, "water", true);
		setup(37, "yellow house (1)", true);
		setup(38, "yellow house (10)", false);
		setup(39, "yellow house (11)", false);
		setup(40, "yellow house (12)", false);
		setup(41, "yellow house (2)", true);
		setup(42, "yellow house (3)", true);
		setup(43, "yellow house (4)", true);
		setup(44, "yellow house (5)", true);
		setup(45, "yellow house (6)", true);
		setup(46, "yellow house (7)", true);
		setup(47, "yellow house (8)", true);
		setup(48, "yellow house (9)", true);	
	}

	public void setup(int count, String name, boolean collision) {
		try {
			tile[count] = new Tile();
			tile[count].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + name +".png"));
			tile[count].collision = collision;
		} 
		
		catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void loadMap(String file) {
		try {
			System.out.println("Loading map from: " + file);
			InputStream is = getClass().getResourceAsStream(file);
			BufferedReader br  = new BufferedReader(new InputStreamReader(is));		
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col ++;
				}
				
				if(col == gp.maxWorldCol) {
					row++;
					col = 0;
				}
			}
			br.close();
			
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	//updates frame every second
	public void draw(Graphics2D g2) {
		
		//g2.drawImage(tile[0].image, 0, 0, gp.TileSize, gp.TileSize, null);
		//g2.drawImage(tile[1].image, 48, 0, gp.TileSize, gp.TileSize, null);
		//g2.drawImage(tile[2].image, 96, 0, gp.TileSize, gp.TileSize, null);
		
		//in order to store map we use a text file
		
		int worldCol = 0;
		int worldRow= 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow]; //we're loading data from mapTileNum[][]
			
			int worldX  = worldCol * gp.TileSize;
			int worldY  = worldRow * gp.TileSize;

			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;

			if(worldX + gp.TileSize > gp.player.worldX - gp.player.screenX && 
			   worldX - gp.TileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.TileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.TileSize < gp.player.worldY + gp.player.screenY) {

				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.TileSize, gp.TileSize, null);
			}

			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldRow++;
				worldCol = 0;
			}
		}
	}
}
