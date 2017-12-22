package dataStructures.arrays;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		long[] arr = new long[n];

		long max = 0;
		int a, b, i, a_i;
		long k;
		for (a_i = 0; a_i < m; a_i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			k = scan.nextLong();
			arr[a - 1] = arr[a - 1] + k;
			if (b < n) {
				arr[b] = arr[b] - k;
			}
		}
		long sum = 0;
		for (i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (max < sum) {
				max = sum;
			}
		}

		System.out.println(max);
		scan.close();
		// in.close();
	}
}
