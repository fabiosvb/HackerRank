package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaToys {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);
		int pos = 0;
		int maxSum = 0;
		while (pos < n) {
			int weight = arr[pos];
			int maxWeight = weight + 4;
			int sum = 1;
			int nextPos = pos + 1;
			while (nextPos < n && weight <= arr[nextPos] && arr[nextPos] <= maxWeight) {
				nextPos++;
			}
			maxSum = maxSum + sum;
			pos = nextPos;
		}
		System.out.println(maxSum);
		in.close();
	}
}