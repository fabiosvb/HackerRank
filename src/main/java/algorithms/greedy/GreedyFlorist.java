package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

	static int getMinimumCost(int n, int k, int[] arr) {
		Arrays.sort(arr);
		int cost = 0;
		int max = arr.length - 1;
		int x = 0;
		int buys = 0;
		while (n > 0) {
			if (buys == k) {
				buys = 0;
				x++;
			}
			cost = cost + ((x + 1) * arr[max--]);
			buys++;
			n--;
		}
		return cost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		int minimumCost = getMinimumCost(n, k, c);
		System.out.println(minimumCost);
		in.close();
	}
}
