package algorithms.recursion;

import java.util.Scanner;

public class RecursiveDigitSum {
	public static String super_digit(String string, int k) {
		if (string.length() <= 1) {
			return string;
		}

		long number = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			number = number + Long.parseLong(Character.toString(c));
		}
		number = number * k;

		return super_digit(String.valueOf(number), 1);

	}

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		int k = in.nextInt();
		System.out.println(super_digit(n, k));
		in.close();
	}
}
