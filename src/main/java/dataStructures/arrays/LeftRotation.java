package dataStructures.arrays;

import java.util.Scanner;

public class LeftRotation {
	static int[] swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
		return arr;
	}
	
	static int[] leftRotation(int[] a, int d) {
		d = d % a.length;
		int tmp = 0;
		for (int rotation = 0; rotation < d; rotation++) {
			for (int i = 0; i < a.length - 1; i++) {
				tmp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = tmp;
			}
		}
		return a;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
