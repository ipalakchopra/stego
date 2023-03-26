import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;

public class Sample {
    public static void main(String[] args) throws IOException{
		
		File base_file = new File("base.png");
		BufferedImage base =  ImageIO.read(base_file);

		File code_file = new File("code.png");
		BufferedImage code =  ImageIO.read(code_file);
		
		Encrypt(code,base);
		//WriteImage(image, "op.png");
	}

	public static void Encrypt(BufferedImage code, BufferedImage base){
		int w_b = base.getWidth();
        int h_b = base.getHeight();
        int rgb;

        System.out.println(w_b + " " + h_b);

		rgb = base.getRGB(1, 1); 
		Color color = new Color(rgb, true);

		int c_arr[] = {color.getRed(),color.getGreen(),color.getBlue()};
		String c_arr_bin[]={"0","0","0"};

		for(int l = 0; l<3; l++){
			System.out.println("int");
			System.out.println(c_arr[l]);

			c_arr_bin[l] = Integer.toBinaryString(c_arr[l]);
			
			while(c_arr_bin[l].length()<8){
				c_arr_bin[l] = "0" + c_arr_bin[l];
			}

			System.out.println("bin");
			System.out.println(c_arr_bin[l]);
		
		}
		
		/*for(int i = 0; i<w_b; i++){
			for(int j = 0; j<w_h; j++){
				
				rgb = img.getRGB(j, i); 
				Color color = new Color(rgb, true);

				int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

				/*System.out.println(red);
				System.out.println(green);
				System.out.println(blue);
			}
		}*/
	}

	public static void WriteImage(BufferedImage img, String path){
        File ImageFile = new File(path);

        try{
            ImageIO.write(img,"png", ImageFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}