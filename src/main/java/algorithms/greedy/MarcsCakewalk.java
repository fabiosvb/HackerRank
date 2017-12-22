package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarcsCakewalk {
	public static void reverseOrder(int[] calories) {
		Arrays.sort(calories);
		for (int calories_i = 0; calories_i < calories.length; calories_i++) {
			calories[calories_i] = -1 * calories[calories_i];
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] calories = new int[n];
		for (int calories_i = 0; calories_i < n; calories_i++) {
			calories[calories_i] = -1 * in.nextInt();
		}
		reverseOrder(calories);

		long minMiles = 0;
		for (int calories_i = 0; calories_i < calories.length; calories_i++) {
			minMiles = minMiles + (calories[calories_i] * (long) Math.pow(2, calories_i));
		}
		System.out.println(minMiles);
		in.close();
	}
}
