import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;
import java.util.Arrays;
import java.util.stream.*;
import java.util.*;
import java.lang.Math;

public class Sample {
    public static void main(String[] args) throws IOException{
	
		//obtaining base ind
		int base_val[] = {24,12,65,42,39};

		int[][] base = new int[base_val.length][2];

		for(int i = 0; i < base.length; i++) {
			base[i] = new int[] {base_val[i], i};
		}
		
		Arrays.sort(base, (a, b) -> Integer.compare(a[0], b[0]));

		for(int i = 0; i<base.length; i++){
			System.out.println(base[i][0] + " " + base[i][1]);
		}

		//obtaining code ind
		int code_val[] = {46,95,25,4};

		int[][] code = new int[code_val.length][2];

		for(int i = 0; i < code.length; i++) {
			code[i] = new int[] {code_val[i], i};
		}
		
		System.out.println("");
		
		for(int i = 0; i<code.length; i++){
			System.out.println(code[i][0] + " " + code[i][1]);
		}

		//finding closest value
		List base_copy = Arrays.asList(base);	
		int code_index[] = new int[code.length];

		int assigned_size = 0;

		System.out.println();

		while(assigned_size<code.length){
			
			int ind = 0;

			for(int i = 0; i<base.length;i++){
			
				System.out.println(assigned_size+" "+i);
				System.out.println(code[assigned_size][0]+" "+base[i][0]);
				System.out.println();

				if(code[assigned_size][0]>base[i][0]){
					ind++;
				}
				else{
					
					break;
				}
			
				if(ind == base.length){
					code_index[assigned_size] = ind-1;
				}
				else if(Math.abs(code[assigned_size][0]-base[ind][0])<Math.abs(code[assigned_size][0]-base[ind-1][0])){
					code_index[assigned_size] = ind;
				}
				else{
					code_index[assigned_size] = ind - 1;
				}
				System.out.println(code_index[assigned_size]);

			}
			
			assigned_size++;
		}
		

		System.out.println("");

		for(int i = 0; i<code_index.length;i++){
			System.out.println(code_index[i]);
		}

	}
}