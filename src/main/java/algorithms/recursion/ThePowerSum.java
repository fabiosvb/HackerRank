package algorithms.recursion;

import java.util.Scanner;

public class ThePowerSum {

	private static int calculate(int n, int pow, int max, int start, double sum) {
		if (sum == n) {
			return 1;
		}

		int times = 0;
		for (int i = start; i <= max; i++) {
			times += calculate(n, pow, max, i + 1, sum + Math.pow(i, pow));
		}
		return times;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int pow = in.nextInt();
		System.out.println(calculate(n, pow, (int) Math.pow(n, 1.0 / pow), 1, 0));
		in.close();
	}
}
