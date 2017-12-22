package crackingTheCodingInterview;

import java.util.Scanner;

public class MergeSort_CountingInversions {

	static long countInversions(int[] arr) {
		Counter swap = new Counter();
		mergeSort(arr, new int[arr.length], 0, arr.length - 1, swap);
		return swap.count;
	}

	protected static void mergeSort(int[] arr, int[] helper, int start, int end, Counter swap) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, helper, start, middle, swap);
			mergeSort(arr, helper, middle + 1, end, swap);
			merge(arr, helper, start, middle, end, swap);
		}
	}

	private static void merge(int[] arr, int[] helper, int start, int middle, int end, Counter swap) {
		for (int i = start; i <= end; i++) {
			helper[i] = arr[i];
		}

		int i = start;
		int j = middle + 1;
		int k = start;
		while (i <= middle && j <= end) {
			if (helper[i] <= helper[j]) {
				arr[k] = helper[i];
				i++;
			} else {
				arr[k] = helper[j];
				j++;
				swap.count = swap.count + (middle + 1) - i;
			}
			k++;
		}

		while (i <= middle) {
			arr[k++] = helper[i++];
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			long result = countInversions(arr);
			System.out.println(result);
		}
		in.close();
	}
}

class Counter {
	long count;
}