package algorithms.bitManipulation;

import java.io.IOException;
import java.util.Scanner;

public class Cipher {
	//It did not pass #9 #10 #11
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int l = in.nextInt();
		int n = in.nextInt() - 1;
		
		char[] input = in.next().toCharArray();
		
		byte[] arr = new byte[l];
		arr[0] =  input[0] == 48 ? (byte) 0 : 1; 

		byte value;
		int col = 1;
		while (col < l) {
			value =  input[col] == 48 ? (byte) 0 : 1;
			calcular(arr, col, n , value);
			col++;
		}
		
		for (int i = 0; i < l; i++) {
			System.out.print(arr[i]);
		}		
		
		in.close();
	}

	private static void calcular(byte[] arr, int col, int n, int value) {
		int shift = col - n > 0 ? col - n : 0;   
		byte shiftValue = arr[shift];
		byte result = (byte) (value  ^ shiftValue);
		shift++;
		while (shift < col) {
			shiftValue = arr[shift];
			if (shiftValue == 1) {
				result = (byte) (result == 0 ? 1 : 0); 
			}
			shift++;
		}
		arr[col] = result;
	}
}
