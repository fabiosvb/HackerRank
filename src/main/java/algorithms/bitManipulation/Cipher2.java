package algorithms.bitManipulation;

import java.util.Scanner;

public class Cipher2 {

	// It has been based by @Codessci version . My version did not pass #9 #10 #11
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] base = new int[n + k - 1];

		String line = in.next();

		for (int i = 0; i < line.length(); i++) {
			base[i] = Character.getNumericValue(line.charAt(i));
		}

		int[] arr = new int[n];
		int sum = 0;
		int j = 0;
		int temp = 0;
		int value = 0;
		
		for (int i = 0; i < n; i++) {
			if (i >= k) {
				sum = sum - arr[j++];
			}
			
			temp = sum +  base[i];
			
			value = temp % 2 == 0 ? 0 : 1;
			
			sum = sum + value;
			
			arr[i] = value;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		in.close();
	}
	
//	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(System.in);
//		int l = in.nextInt();
//		int n = in.nextInt() - 1;
//		
//		char[] input = in.next().toCharArray();
//		
//		byte[] arr = new byte[l];
//		arr[0] =  input[0] == 48 ? (byte) 0 : 1; 
//
//		byte value;
//		int col = 1;
//		while (col < l) {
//			value =  input[col] == 48 ? (byte) 0 : 1;
//			calcular(arr, col, n , value);
//			col++;
//		}
//		
//		for (int i = 0; i < l; i++) {
//			System.out.print(arr[i]);
//		}		
//		
//		in.close();
//	}
//
//	private static void calcular(byte[] arr, int col, int n, int value) {
//		int shift = col - n > 0 ? col - n : 0;   
//		byte shiftValue = arr[shift];
//		byte result = (byte) (value  ^ shiftValue);
//		shift++;
//		while (shift < col) {
//			shiftValue = arr[shift];
//			if (shiftValue == 1) {
//				result = (byte) (result == 0 ? 1 : 0); 
//			}
//			shift++;
//		}
//		arr[col] = result;
//	}	
}
