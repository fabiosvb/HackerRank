package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortPart2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		sort(arr);
		in.close();
	}

	static int[] sort(int... arr) {
		for (int i = 1; i < arr.length; i++) {
			int posTop = i;
			int pos = i - 1;
			while (pos >= 0 && arr[pos] > arr[posTop]) {
				swap(arr, pos, posTop);
				pos--;
				posTop--;
			}
			print(arr);
		}
		return arr;
	}

	static int[] swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
		return arr;
	}

	static void print(int[] arr) {
		Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
		System.out.println();
	}
}
