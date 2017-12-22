package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutingTwoArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];

			for (int j = 0; j < n; j++) {
				a[j] = in.nextInt();
			}
			for (int j = 0; j < n; j++) {
				b[j] = in.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
			boolean result = true;
			int bindex = b.length - 1;
			for (int j = 0; j < n; j++) {
				if (a[j] + b[bindex] < k) {
					result = false;
					break;
				}
				bindex--;
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}
}