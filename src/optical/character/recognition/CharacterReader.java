package optical.character.recognition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CharacterReader {
	
	public void readImage(File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		byte[][] pixels = new byte[image.getWidth()][image.getHeight()];
		System.out.print("new float[] {");

		for(int x=0;x<image.getWidth()-1;x++) {
			pixels[x] = new byte[image.getHeight()];

			for(int y=0;y<image.getHeight()-1;y++) {
				//if it is a white pixel we assign 0 otherwise we assign 1
				pixels[x][y] = (byte) (image.getRGB(x, y) == 0xFFFFFFFF ? 0 : 1);
				System.out.print(pixels[x][y]+",");
			}
	
		}
		pixels[image.getWidth()-1][image.getHeight()-1] = (byte) (image.getRGB(image.getWidth()-1, image.getHeight()-1) == 0xFFFFFFFF ? 0 : 1);
		System.out.print(pixels[image.getWidth()-1][image.getHeight()-1]);
		
		System.out.println("},");
		
	}
 	
	
}
