package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Box extends SuperObject{

    public Obj_Box() {
        
        name = "Box";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Box.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } 
        collision = true;  
        openable = true;
    } 
}
