import java.io.*;
import java.awt.Color;
import java.awt.image.*;

import javax.imageio.ImageIO;

public class Sample {

    public static void main(String args[]) throws IOException{
        File file = new File("code.png");
        BufferedImage k = ImageIO.read(file);
        System.out.println("Image Read Completed");

        for(int i=0; i<k.getHeight(); i++) {
            for(int j=0; j<k.getWidth(); j++) {

                int color = k.getRGB(j, i);
                int Blue = color & 0x80;
                int Green = (color & 0x80) >> 8;
                int Red = (color & 0x80) >> 16;
                Color c = new Color(Red+Green+Blue,Red+Green+Blue,Red+Green+Blue);
                k.setRGB(j, i, c.getRGB());
            }
        }
        file = new File("op11.jpg");
        ImageIO.write(k, "jpg", file);
        System.out.println("Image Write Completed");
    }
}

