package algorithms.sorting;

import java.util.Scanner;

public class Quicksort1_Partition {
	static void swap(int[] arr, int i, int j) {
		int a = arr[i];
		arr[i] = arr[j];
		arr[j] = a;
	}

	static void partition(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		partition(arr, start, end);
		printArray(arr);
	}

	static void partition(int[] arr, int start, int end) {
		int l = start;
		int r = end;
		int pivot = (start + end) / 2;
		int pivotValue = arr[pivot];
		while (l <= r) {
			while (arr[l] < pivotValue) {
				l++;
			}
			while (arr[r] > pivotValue) {
				r--;
			}
			if (l <= r) {
				swap(arr, l, r);
				l++;
				r--;
			}
		}
		if (r > start) {
			partition(arr, start, r);
		}
		if (l < end) {
			partition(arr, l, end);
		}
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
		in.close();
	}
}
