package algorithms.dynamicProgramming;

import java.util.HashMap;
import java.util.Scanner;

public class TheCoinChangeProblem {

	static HashMap<String, Long> memorization = new HashMap<String, Long>();

	static long getWays(long money, long[] arr, long sum, int index) {

		if (sum == money) {
			return 1;
		}

		if (index == arr.length) {
			return 0;
		}

		String key = index + "_" + sum;
		Long countMemo = memorization.get(key);
		if (countMemo != null) {
			return countMemo;
		}

		long count = 0;
		while (sum <= money) {
			long value = arr[index];
			count = count + getWays(money, arr, sum, index + 1);
			sum = sum + value;
		}

		memorization.put(key, count);

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] c = new long[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextLong();
		}
		long ways = getWays(n, c, 0, 0);
		System.out.println(ways);
		in.close();
	}
}