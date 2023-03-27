import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;

public class MP2 {
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
        
		int w_c = code.getWidth();
        int h_c = code.getHeight();

        int rgb_base, rgb_code;

        System.out.println(w_b + " " + h_b);

		for(int row = 0; row<h_c; row++){
			for(int col = 0; col<w_c; col++){
				
				rgb_base = base.getRGB(col, row); 
				Color color_base = new Color(rgb_base, true);

				int c_arr_base[] = {color_base.getRed(),color_base.getGreen(),color_base.getBlue()};
				String c_arr_bin_base[]={"0","0","0"};

                rgb_code = code.getRGB(col, row); 
				Color color_code = new Color(rgb_code, true);

				int c_arr_code[] = {color_code.getRed(),color_code.getGreen(),color_code.getBlue()};
				String c_arr_bin_code[]={"0","0","0"};

				for(int l = 0; l<3; l++){
					//System.out.println("\nint");
					//System.out.println(c_arr[l]);

					c_arr_bin_base[l] = Integer.toBinaryString(c_arr_base[l]);
					
					while(c_arr_bin_base[l].length()<8){
						c_arr_bin_base[l] = "0" + c_arr_bin_base[l];
					}

                    c_arr_bin_code[l] = Integer.toBinaryString(c_arr_code[l]);
					
					while(c_arr_bin_code[l].length()<8){
						c_arr_bin_code[l] = "0" + c_arr_bin_code[l];
					}

					//4 bits of base image 4 bits of code image
					c_arr_bin_base[l] = c_arr_bin_base[l].substring(0,4) + c_arr_bin_base[l].substring(0,4) ;
				
				}
				
				int nrgb  = 65536 * Integer.parseInt(c_arr_bin_base[0], 2) + 256 * Integer.parseInt(c_arr_bin_base[1], 2) + Integer.parseInt(c_arr_bin_base[2], 2) ;
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