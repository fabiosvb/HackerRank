package crackingTheCodingInterview;

import java.util.Scanner;

public class Sorting_BubbleSort {
	public static void swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
					count++;
				}
			}
		}

		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);
		in.close();
	}
}
