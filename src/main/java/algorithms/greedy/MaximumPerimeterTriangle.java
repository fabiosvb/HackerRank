package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumPerimeterTriangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);

		int end = arr.length - 1;

		boolean found = false;
		while (end >= 2) {
			int max = arr[end];
			int mid = arr[end - 1];
			int min = arr[end - 2];
			if (mid + min > max) {
				System.out.print(min + " " + mid + " " + max);
				found = true;
				break;
			}
			end--;
		}

		if (!found) {
			System.out.println("-1");
		}
		in.close();
	}

}