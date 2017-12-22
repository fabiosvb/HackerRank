package algorithms.search;

import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			// if (n > 2){

			long leftSum = 0;
			int pivot = 1;
			long rightSum = 0;

			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
				if (j > 0) {
					rightSum = rightSum + arr[j];
				}
			}

			boolean equal = n == 1;

			if (!equal) {

				while (pivot < n) {
					leftSum = leftSum + arr[pivot - 1];
					rightSum = rightSum - arr[pivot];

					if (leftSum == rightSum) {
						equal = true;
						break;
					}
					pivot++;
				}
			}

			// 1 1 2 3
			// }
			if (equal) {
				builder.append("YES");
			} else {
				builder.append("NO");
			}
			builder.append("\n");

		}
		System.out.println(builder.toString().trim());
		in.close();
	}
}