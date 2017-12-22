package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = new String(in.next());
		}
		String[] sorted = sort(unsorted);
		Arrays.stream(sorted).forEach(System.out::println);
		in.close();
	}

	static String[] sort(String... arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	static void quickSort(String[] arr, int start, int end) {
		int i = start;
		int j = end;
		int pivot = (start + end) / 2;
		String pivotValue = arr[pivot];
		do {
			while (arr[i].length() < pivotValue.length()
					|| (arr[i].length() == pivotValue.length() && arr[i].compareTo(pivotValue) < 0)) {
				i++;
			}
			while (arr[j].length() > pivotValue.length()
					|| (arr[j].length() == pivotValue.length() && arr[j].compareTo(pivotValue) > 0)) {
				j--;
			}
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}

		} while (i <= j);

		if (start < j) {
			quickSort(arr, start, j);
		}

		if (i < end) {
			quickSort(arr, i, end);
		}
	}

	static String[] swap(String[] arr, int from, int to) {
		String tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
		return arr;
	}
}