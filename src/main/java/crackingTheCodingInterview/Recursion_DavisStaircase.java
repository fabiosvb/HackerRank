package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

public class Recursion_DavisStaircase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			HashMap<Integer, Integer> memorization = new HashMap<Integer, Integer>();
			System.out.println(countSteps(memorization, n));
		}
		in.close();
	}

	public static int countSteps(HashMap<Integer, Integer> memorization, int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		}
		Integer steps = memorization.get(n);
		if (steps != null) {
			return steps;
		}
		steps = countSteps(memorization, n - 1) + countSteps(memorization, n - 2) + countSteps(memorization, n - 3);
		memorization.put(n, steps);
		return steps;
	}

}