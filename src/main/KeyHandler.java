package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	//public boolean upStill, downStill, leftStill, rightStill;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			
			upPressed = true;
			//upStill =  false;
		}
		
		if (code == KeyEvent.VK_S) {
			
			downPressed = true;
			//downStill = false;
		}
		
		if (code == KeyEvent.VK_A) {
			
			leftPressed = true;
			//leftStill = false;
		
		}
		
		if (code == KeyEvent.VK_D) {
			
			rightPressed = true;
			//rightStill =  false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			
			upPressed = false;
			//upStill = true;
		}
		
		if (code == KeyEvent.VK_S) {
			
			downPressed = false;
			//downStill = true;
		}
		
		if (code == KeyEvent.VK_A) {
			
			leftPressed = false;
			//leftStill = true;
		
		}
		
		if (code == KeyEvent.VK_D) {
			
			rightPressed = false;
			//rightStill = true;
		}
		
	}

	
}
