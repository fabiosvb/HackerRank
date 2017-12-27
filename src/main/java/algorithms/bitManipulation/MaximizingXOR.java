package algorithms.bitManipulation;

import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(max(a, b));
		in.close();
	}

//	static int max (int left, int right) {
//		int max = 0;
//		for (int i = left; i <= right; i++) {
//			for (int j = left; j <= right; j++) {
//				int xor = i  ^ j;
//				if (xor > max) {
//					max = xor;
//				}
//			}
//		}
//		return max;
//	}
//	
	// My first solution was O (n **2)  for inside for.  but this one is much better. 
	// by Jeremy_roy explanation.  
	static int max(int left, int right) {
		int a = left ^ right;
		int max = 0;
		while (a != 0) {
			max = max | a;
			a = a >> 1;
		}
		return max;
	}
}
