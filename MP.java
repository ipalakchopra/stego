import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer.*;
import java.util.Arrays;

public class MP {
    public static void main(String[] args) throws IOException{
		
		File base_file = new File("base.png");			//reads the base image 
		BufferedImage base =  ImageIO.read(base_file);

		File code_file = new File("code.png");
		BufferedImage code =  ImageIO.read(code_file);

        int w_b = base.getWidth();
        int h_b = base.getHeight();
        
		int w_c = code.getWidth();
        int h_c = code.getHeight();
		
		Encode(code, base, w_b, h_b, w_c, h_c);
		WriteImage(base, "encoded.png");

        File base_file2 = new File("encoded.png");
		BufferedImage base2 =  ImageIO.read(base_file2);

        //Decode(base2, w_c, h_c);
        //WriteImage(base2, "op2.png");
        
	}

	public static void Encode(BufferedImage code, BufferedImage base, int w_b, int h_b, int w_c, int h_c){

        int rgb_base, rgb_code;

        System.out.println(w_b + " " + h_b);
		
		System.out.println(w_c + " " + h_c);

		for(int row = 0; row<h_c; row++){
			
			//System.out.println("\nRow "+row);

			String row_base[] = new String[w_b];
			String row_code[] = new String[w_c];

			//creating base binary array

			for(int col = 0; col<w_b; col++){
				rgb_base = base.getRGB(col, row); 
				Color color_base = new Color(rgb_base, true);

				int c_arr_base[] = {color_base.getRed(),color_base.getGreen(),color_base.getBlue()};
				String c_arr_bin_base[]={"0","0","0"};

				for(int l = 0; l<3; l++){

					c_arr_bin_base[l] = Integer.toBinaryString(c_arr_base[l]);
					
					while(c_arr_bin_base[l].length()<8){
						c_arr_bin_base[l] = "0" + c_arr_bin_base[l];
					}
			
				}
				row_base[col] = c_arr_bin_base[0] + c_arr_bin_base[1] + c_arr_bin_base[2];
			}

			//creating code binary array

			for(int col = 0; col<w_c; col++){

                rgb_code = code.getRGB(col, row); 
				Color color_code = new Color(rgb_code, true);

				int c_arr_code[] = {color_code.getRed(),color_code.getGreen(),color_code.getBlue()};
				String c_arr_bin_code[]={"0","0","0"};

				for(int l = 0; l<3; l++){

                    c_arr_bin_code[l] = Integer.toBinaryString(c_arr_code[l]);
					
					while(c_arr_bin_code[l].length()<8){
						c_arr_bin_code[l] = "0" + c_arr_bin_code[l];
					}				
				}
				row_code[col] = c_arr_bin_code[0] + c_arr_bin_code[1] + c_arr_bin_code[2];
			}	

			//row_base & row_code
			
			//creating 2d base array

			int[][] base_arr = new int[row_base.length][2];
			int temp;

			for(int i = 0; i < base_arr.length; i++) {
				temp = Integer.parseInt(row_base[i],2);
				base_arr[i] = new int[] { temp, i};
			}

			Arrays.sort(base_arr, (a, b) -> Integer.compare(a[0], b[0]));

			//creating 2d code array

			int[][] code_arr = new int[row_code.length][2];

			for(int i = 0; i < code_arr.length; i++) {
				temp = Integer.parseInt(row_code[i],2);
				code_arr[i] = new int[] { temp, i};
			}

			//applying closest pixel algorithm

			int[][] base_copy=base_arr, base_copy2 = base_arr;	
			int row_ind[] = new int[w_c];

			int assigned_size = 0;

			while(assigned_size<w_c){
			
				int ind = 0;
	
				for(int i = 0; i<base_copy.length;i++){
					if(code_arr[assigned_size][0]>base_copy[i][0]){
						ind++;
					}
					else{
						break;
					}
				}
				
				if(ind == base_copy.length){
					row_ind[assigned_size] = base_copy[ind-1][1];
					ind = ind - 1;
				}
				else if(ind == 0){
					row_ind[assigned_size] = base_copy[ind][1];
	
				}
				else if(Math.abs(code_arr[assigned_size][0]-base_copy[ind][0])<Math.abs(code_arr[assigned_size][0]-base_copy[ind-1][0])){
					row_ind[assigned_size] = base_copy[ind][1];
	
				}
				else{
					row_ind[assigned_size] = base_copy[ind-1][1];
					ind = ind - 1;
	
				}
				for(int i=0, k=0;i<base_copy.length;i++){
					if(i!=ind){
						base_copy2[k]=base_copy[i];
						k++;
					}
				}base_copy=base_copy2;
				
				assigned_size++;
			}

			Arrays.sort(base_arr, (a, b) -> Integer.compare(a[1], b[1]));

			if(row == 1){
				for(int i = 0; i<5;i++){
					System.out.println(row_base[row_ind[i]]+" "+row_code[i]);
				}
			}

			//binary row_base, row_code; int row_ind
			String[] temp_col = new String[3]; // r g b
			if(row == 1){
				for(int i = 0; i<5; i++){
					temp_col[0] = row_base[row_ind[i]].substring(0, 4)+row_code[i].substring(0, 4);
					temp_col[1] = row_base[row_ind[i]].substring(8, 12)+row_code[i].substring(8, 12);
					temp_col[2] = row_base[row_ind[i]].substring(16, 20)+row_code[i].substring(16, 20);	
					
					System.out.println(temp_col[0]+temp_col[1]+temp_col[2]);
				}
			}
			

			for(int i = 0; i<w_c; i++){
				temp_col[0] = row_base[row_ind[i]].substring(0, 4)+row_code[i].substring(0, 4);
				temp_col[1] = row_base[row_ind[i]].substring(8, 12)+row_code[i].substring(8, 12);
				temp_col[2] = row_base[row_ind[i]].substring(16, 20)+row_code[i].substring(16, 20);		
				
				int nrgb  = 65536 * Integer.parseInt(temp_col[0], 2) + 256 * Integer.parseInt(temp_col[1], 2) + Integer.parseInt(temp_col[2], 2) ;
                base.setRGB( row_ind[i],row, nrgb);		
			}

			//remember to make sure there are 24 bits when converting back to bin		

			
		}
	}

    /*public static void Decode(BufferedImage base, int w_c, int h_c){
        BufferedImage dcd = new BufferedImage(w_c, h_c, BufferedImage.TYPE_INT_RGB);

        int rgb_base;

        for(int row = 0; row<h_c; row++){
            for(int col = 0; col<w_c; col++){

                rgb_base = base.getRGB(col, row);
                Color color_base = new Color(rgb_base, true);

                int c_arr_base[] = {color_base.getRed(),color_base.getGreen(),color_base.getBlue()};
				String c_arr_bin_base[]={"0","0","0"};

                for(int l = 0; l<3; l++){

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
    }*/

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