package tile;

// import java.awt.Color;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;

// import javax.imageio.ImageIO;

// import main.GamePanel;

public class MapGenerator {

    // boolean generateMap = true;

    // public void GenerateMap(GamePanel gp) {

    //     String color[] = new String[100];
    //     color[0] = "rgb(79, 225, 19)";
    //     color[1] = "rgb(72, 72, 72)";
    //     color[2] = "rgb(7, 152, 164)";
    //     color[3] = "rgb(100, 66, 2)";
    //     color[4] = "rgb(71, 171, 30)";
    //     color[5] = "rgb(231, 199, 80)";
    //     color[6] = "rgb(139, 97, 0)";

    //     try {
	// 		if(generateMap) {
	// 			FileWriter writer = new FileWriter("D:/Eclipse workspace/CleanUp/res/maps/map03.txt");
		 
	// 			File file= new File("D:/Eclipse workspace/CleanUp/res/maps/WorldMap2.png");
	// 			BufferedImage img = ImageIO.read(file);
	
	// 			for (int y = 0; y < img.getHeight(); y++) {
	// 				for (int x = 0; x < img.getWidth(); x++) {
						
	// 					if(x == 0 && y != 0){
	// 						writer.append("\n");
	// 					}
	
	// 					int pixel = img.getRGB(x,y);
						
	// 					Color pixColor = new Color(pixel, true);
	
	// 					String red = Integer.toString(pixColor.getRed());
	// 					String green = Integer.toString(pixColor.getGreen());
	// 					String blue = Integer.toString(pixColor.getBlue());
	
	// 					String pixelRGB = "rgb(" + red + ", " + green + ", " + blue + ")";
	// 					System.out.println(pixelRGB);
	
	// 					for(int i = 0; i <= color.length; i++) {
    //                         if(color[i].equals(pixelRGB)) {
    //                             writer.append(i + " ");
    //                         }
    //                     }
	// 				}
	// 			}
	// 			writer.close();
	// 			System.out.println("RGB values at each pixel are stored in the specified file");
	// 		}
	// 	} catch(IOException e) {
	// 		e.printStackTrace();
	// 	}
    // }
}   
