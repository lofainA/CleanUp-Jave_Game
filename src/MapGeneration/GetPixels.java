package MapGeneration;

import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GetPixels {
   public static void main(String args[])throws Exception { 

      FileWriter writer = new FileWriter("D:/Eclipse workspace/CleanUp/res/maps/map02.txt");
     
      File file= new File("D:/Eclipse workspace/CleanUp/res/maps/WorldMap2.png");
      BufferedImage img = ImageIO.read(file);

      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
            
            if(x == 0 && y != 0){
                 writer.append("\n");
            }

            int pixel = img.getRGB(x,y);
            
            Color color = new Color(pixel, true);

            String red = Integer.toString(color.getRed());
            String green = Integer.toString(color.getGreen());
            String blue = Integer.toString(color.getBlue());

            String pixelRGB = "rgb(" + red + ", " + green + ", " + blue + ")";
            System.out.println(pixelRGB);
        
            if(pixelRGB.equals("rgb(72, 72, 72)")) {
                writer.append(1 + " ");
            }
            else if(pixelRGB.equals("rgb(79, 225, 19)")) {
                writer.append(0 + " ");
            }
            else if(pixelRGB.equals("rgb(7, 152, 164)")) {
                writer.append(2 + " ");
            }
            else if(pixelRGB.equals("rgb(100, 66, 2)")) {
                writer.append(3 + " ");
            }
            else if(pixelRGB.equals("rgb(71, 171, 30)")) {
                writer.append(4 + " ");
            }
            else if(pixelRGB.equals("rgb(231, 199, 80)")) {
                writer.append(5 + " ");
            }
            else if(pixelRGB.equals("rgb(139, 97, 0)")) {
                writer.append(6 + " ");
            }
         }
      }
      writer.close();
      System.out.println("RGB values at each pixel are stored in the specified file");
   }
}
