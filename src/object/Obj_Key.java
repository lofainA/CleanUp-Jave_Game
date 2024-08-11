package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_Key extends SuperObject {
    
    public Obj_Key() {

        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
        pickUpable = true;
    }
}
