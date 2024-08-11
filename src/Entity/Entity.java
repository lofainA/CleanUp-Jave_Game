package Entity; 

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY; //entity position
	public int speed; //amount of pixels it will move
	
	public BufferedImage front1, front2, back1, back2, right1, right2, left1, left2, 
			sFront1, sFront2, sBack1, sBack2, sRight1, sRight2, sLeft1, sLeft2; //sprite animation images
	
	public String direction; //to update the values of keyhandler
	
	public int spriteCounter = 0; //for changing between spriteNumber = 1 and spriteNumber = 2, every specified amount of iterations
	public int spriteNumber = 1;  // for changing between both movement animations
	
	//public int stillSpriteCounter = 0;
	//public int stillSpriteNumber = 1;

	public Rectangle hitBox;
	public int hitBoxDefaultX, hitBoxDefaultY;
	public boolean collisionOn = false;
}
