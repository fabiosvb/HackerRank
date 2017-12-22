package algorithms.dynamicProgramming;

import java.math.BigDecimal;
import java.util.Scanner;

public class FibonacciModified {
	public static BigDecimal fibonacci(BigDecimal t1, BigDecimal t2, int n) {
		if (n == 1) {
			return t1;
		} else if (n == 2) {
			return t2;
		} else {
			if (n <= t2.intValue()) {
				return fibonacci(t1, t2, n - 1).add(fibonacci(t1, t2, n - 2));
			}
			return fibonacci(t1, t2, n - 1).pow(2).add(fibonacci(t1, t2, n - 2));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigDecimal t1 = new BigDecimal(in.nextInt());
		BigDecimal t2 = new BigDecimal(in.nextInt());
		int n = in.nextInt();
		System.out.println(fibonacci(t1, t2, n));
		in.close();
	}
}
