package Entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;

		screenX = gp.screenWidth/2 - gp.TileSize/2;
		screenY = gp.screenHeight/2 - gp.TileSize/2;

		hitBox = new Rectangle();
		hitBox.x = 12;
		hitBox.y = 33;
		hitBox.width = 24;
		hitBox.height = 15;

		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() { 
		worldX = gp.TileSize * 25;
		worldY = gp.TileSize * 20;
		speed = 4;
		direction = "front";
	}
	
	public void getPlayerImage() {
		
		try {
			
			front1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_frony_walk_1.png"));
			front2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_front_walk_2.png"));
			
			back1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_back_walk_1.png"));
			back2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_back_walk_2.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right_walk_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right_walk_2.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left_walk_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left_walk_2.png"));
			
			sFront1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_front _still_1.png"));
			sFront2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_front_still_2.png"));
			
			sBack1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_back_still_1.png"));
			sBack2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_back_still_2.png"));
			
			sRight1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right_still_1.png"));
			sRight2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_right_still_2.png"));
			
			sLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left_still_1.png"));
			sLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/Guy_left_still_2.png"));
			
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() { 
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "back";
				if (worldY < 0) worldY = 0;
			}
			
			else if(keyH.downPressed == true) {
				direction = "front";
				if (worldY > gp.maxWorldRow * gp.TileSize - gp.TileSize) {
					worldY = gp.maxWorldRow * gp.TileSize - gp.TileSize;
				}
			}
			
			else if(keyH.rightPressed == true) {
				direction = "right";
				if (worldX > gp.maxWorldCol * gp.TileSize - gp.TileSize) {
					worldX = gp.maxWorldCol * gp.TileSize - gp.TileSize;
				}
			}
			
			else if(keyH.leftPressed == true) {
				direction = "left";
				if (worldX < 0) worldX = 0;
			}

			//Check Tile collision
			collisionOn = false;
			gp.collDetect.detectTile(this);
			
			//if collision is false player can move
			if(collisionOn == false) {
				switch(direction) {
					case "back":
						worldY -= speed;
						break;
					case "front":
						worldY += speed;
						break;
					case "left":
						worldX -= speed;;
						break;
					case "right":
						worldX += speed;
						break;
				}
			}

			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNumber == 1) {
					spriteNumber = 2;
				}
				
				else if(spriteNumber == 2) {
					spriteNumber = 1;
				}
				spriteCounter = 0;
			}
		}
		
		
		//Tried to create still animation, it didn't work :/
		
		/*
		 * else if (keyH.upPressed == false || keyH.downPressed == false ||
		 * keyH.leftPressed == false || keyH.rightPressed == false) {
		 * 
		 * 
		 * if(keyH.upPressed == false) { direction = "back"; }
		 * 
		 * else if(keyH.downPressed == false) { direction = "front"; }
		 * 
		 * else if(keyH.rightPressed == false) { direction = "right"; }
		 * 
		 * else if(keyH.leftStill == false) { direction = "left"; }
		 * 
		 * spriteCounter++; if(spriteCounter > 12) { if(spriteNumber == 1) {
		 * spriteNumber = 2; }
		 * 
		 * else if(spriteNumber == 2) { spriteNumber = 1; } spriteCounter = 0; }
		 */
			
		
	}
	
	//updates frame every second
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.TileSize, gp.TileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		
		case "front":
			if (spriteNumber == 1) {
				image = front1;
			}
			if (spriteNumber == 2) {
				image = front2;
			}
			
			break;
		
		case "back":
			if (spriteNumber == 1) {
				image = back1;
			}
			if (spriteNumber == 2) {
				image = back2;
			}
			
			break;
			
		case "right":
			if (spriteNumber == 1) {
				image = right1;
			}
			if (spriteNumber == 2) {
				image = right2;
			}
			break;
			
		case "left":
			if (spriteNumber == 1) {
				image = left1;
			}
			if (spriteNumber == 2) {
				image = left2;
			}
			break;
			
		}
		
		g2.drawImage(image, screenX, screenY, gp.TileSize, gp.TileSize, null);
	}
}

