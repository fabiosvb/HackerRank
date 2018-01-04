package algorithms.bitManipulation;

import java.util.Scanner;

public class Flippingbits {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		for (int i = 0; i < n; i++) {
			long number = in.nextLong();
			String numberAsString = Long.toBinaryString(~number);
			String fixed = numberAsString.substring(32);
			System.out.println(Long.parseLong(fixed, 2));
		}
		in.close();
	}
}
