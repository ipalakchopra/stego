import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;

public class MP2 {
    public static void main(String[] args) throws IOException{
		
		File base_file = new File("base.png");//reads the base image 
		BufferedImage base =  ImageIO.read(base_file);

		File code_file = new File("code.png");
		BufferedImage code =  ImageIO.read(code_file);

        int w_b = base.getWidth();
        int h_b = base.getHeight();
        
		int w_c = code.getWidth();
        int h_c = code.getHeight();
		
		Encrypt(code, base, w_b, h_b, w_c, h_c);
		WriteImage(base, "encoded.png");

        File base_file2 = new File("encoded.png");
		BufferedImage base2 =  ImageIO.read(base_file2);

        Decode(base2, w_c, h_c);
        //WriteImage(base2, "op2.png");
        
	}

	public static void Encrypt(BufferedImage code, BufferedImage base, int w_b, int h_b, int w_c, int h_c){

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
					c_arr_bin_base[l] = c_arr_bin_base[l].substring(0,4) + c_arr_bin_code[l].substring(0,4) ;
				
				}
				
				int nrgb  = 65536 * Integer.parseInt(c_arr_bin_base[0], 2) + 256 * Integer.parseInt(c_arr_bin_base[1], 2) + Integer.parseInt(c_arr_bin_base[2], 2) ;
                base.setRGB(col, row, nrgb);		
			}	
		}

		//System.out.println(w_c + " " + h_c);
		//System.out.println(code.getRGB(1, 1));

	}

    public static void Decode(BufferedImage base, int w_c, int h_c){
        BufferedImage dcd = new BufferedImage(w_c, h_c, BufferedImage.TYPE_INT_RGB);

        int rgb_base;

        for(int row = 0; row<h_c; row++){
            for(int col = 0; col<w_c; col++){

                rgb_base = base.getRGB(col, row);
                Color color_base = new Color(rgb_base, true);

                int c_arr_base[] = {color_base.getRed(),color_base.getGreen(),color_base.getBlue()};
				String c_arr_bin_base[]={"0","0","0"};

                for(int l = 0; l<3; l++){
					//System.out.println("\nint");
					//System.out.println(c_arr[l]);

					c_arr_bin_base[l] = Integer.toBinaryString(c_arr_base[l]);
					
					while(c_arr_bin_base[l].length()<8){
						c_arr_bin_base[l] = "0" + c_arr_bin_base[l];
					}

                    c_arr_bin_base[l] = c_arr_bin_base[l].substring(4,8) + "1111" ;
				
                }
                int nrgb  = 65536 * Integer.parseInt(c_arr_bin_base[0], 2) + 256 * Integer.parseInt(c_arr_bin_base[1], 2) + Integer.parseInt(c_arr_bin_base[2], 2) ;
                dcd.setRGB(col, row, nrgb);

            }
        }
        WriteImage(dcd, "decoded.png");
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