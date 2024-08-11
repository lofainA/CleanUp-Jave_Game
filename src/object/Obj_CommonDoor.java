package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_CommonDoor extends SuperObject{
    
    public Obj_CommonDoor() {

        name = "Door";

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/CommonDoor.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }

        collision = true;
        unlockable = true;
    }
}
