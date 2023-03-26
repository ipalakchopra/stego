import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;

public class MP {
    public static void main(String[] args) throws IOException{
		
		File base_file = new File("base.png");
		BufferedImage base =  ImageIO.read(base_file);

		File code_file = new File("code.png");
		BufferedImage code =  ImageIO.read(code_file);
		
		Encrypt(code,base);
		WriteImage(base, "op.png");
	}

	public static void Encrypt(BufferedImage code, BufferedImage base){
		int w_b = base.getWidth();
        int h_b = base.getHeight();
        int rgb;

		int w_c = code.getWidth();
        int h_c = code.getHeight();

        System.out.println(w_b + " " + h_b);

		for(int row = 0; row<h_b; row++){
			for(int col = 0; col<w_b; col++){
				
				rgb = base.getRGB(col, row); 
				Color color = new Color(rgb, true);

				int c_arr[] = {color.getRed(),color.getGreen(),color.getBlue()};
				String c_arr_bin[]={"0","0","0"};

				for(int l = 0; l<3; l++){
					//System.out.println("\nint");
					//System.out.println(c_arr[l]);

					c_arr_bin[l] = Integer.toBinaryString(c_arr[l]);
					
					while(c_arr_bin[l].length()<8){
						c_arr_bin[l] = "0" + c_arr_bin[l];
					}
					//4 bits of base image 4 bits of code image
					c_arr_bin[l] = c_arr_bin[l].substring(0,4);
				
				}
				
				int nrgb  = 65536 * Integer.parseInt(c_arr_bin[0], 2) + 256 * Integer.parseInt(c_arr_bin[1], 2) + Integer.parseInt(c_arr_bin[2], 2) ;
                base.setRGB(col, row, nrgb);		
			}	
		}

		System.out.println(w_c + " " + h_c);
		System.out.println(code.getRGB(1, 1));



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