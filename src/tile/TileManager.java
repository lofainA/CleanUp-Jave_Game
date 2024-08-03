package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile; //array to store diff types of tiles
	public int mapTileNum[][]; //map data will be stored here
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		tile = new Tile[10]; //change if need to add more than 10 types of tile sprites
		
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("map02.txt");
	}

	public void getTileImage() {
		
		try {
			 tile[0] = new Tile();
			 tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass.png"));
			 
			 tile[1] = new Tile();
			 tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));
			 tile[1].collision = true;
			 
			 tile[2] = new Tile();
			 tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png"));
			 tile[2].collision = true;

			 tile[3] = new Tile();
			 tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree.png"));
			 tile[3].collision = true;

			 tile[4] = new Tile();
			 tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Bush.png"));
			 
			 tile[5] = new Tile();
			 tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sand.png"));
			 
			 tile[6] = new Tile();
			 tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Dirt.png"));
			 
			 tile[7] = new Tile();
			 tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass Dirt Trans Up.png"));
			 
			 tile[8] = new Tile();
			 tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass Dirt Trans Down.png"));
			
			
		} catch(IOException e1) {
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
