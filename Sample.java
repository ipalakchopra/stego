import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.lang.Integer;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;
import java.lang.Math;

public class Sample {
    public static void main(String[] args) throws IOException{
	
		//obtaining base ind
		int base_val[] = {0,68,55,95,34};

		int[][] base = new int[base_val.length][2];

		for(int i = 0; i < base.length; i++) {
			base[i] = new int[] {base_val[i], i};
		}
		
		Arrays.sort(base, (a, b) -> Integer.compare(a[0], b[0]));

		for(int i = 0; i<base.length; i++){
			System.out.println(base[i][0] + " " + base[i][1]);
		}

		//obtaining code ind
		int code_val[] = {4,56,39,4};

		int[][] code = new int[code_val.length][2];

		for(int i = 0; i < code.length; i++) {
			code[i] = new int[] {code_val[i], i};
		}
		
		
		//finding closest value
		int[][] base_copy=base,base_copy2 = base;	
		int code_index[] = new int[code.length];

		int assigned_size = 0;

		while(assigned_size<code.length){
			
			int ind = 0;

			for(int i = 0; i<base_copy.length;i++){
				if(code[assigned_size][0]>base_copy[i][0]){
					ind++;
				}
				else{
					break;
				}
			}
			
			if(ind == base_copy.length){
				code_index[assigned_size] = base_copy[ind-1][1];
				ind = ind - 1;
			}
			else if(ind == 0){
				code_index[assigned_size] = base_copy[ind][1];

			}
			else if(Math.abs(code[assigned_size][0]-base_copy[ind][0])<Math.abs(code[assigned_size][0]-base_copy[ind-1][0])){
				code_index[assigned_size] = base_copy[ind][1];

			}
			else{
				code_index[assigned_size] = base_copy[ind-1][1];
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
		
		System.out.println("");

		Arrays.sort(base, (a, b) -> Integer.compare(a[1], b[1]));

		for(int i = 0; i<base.length; i++){
			System.out.println(base[i][0] + " " + base[i][1]);
		}

		System.out.println("");

		for(int i = 0; i<code.length; i++){
			System.out.println(code[i][0] + " " + code[i][1]);
		}

		for(int i = 0; i<code_index.length;i++){
			System.out.println(code_index[i]);
		}
	}
}