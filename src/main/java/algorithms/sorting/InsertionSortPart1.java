package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortPart1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int index = -1;
        for(int i=0; i < n; i++){
        	arr[i] = in.nextInt();
        	if (i > 0 && arr[i - 1] > arr[i]) {
        		index = i;	
        	}
        }
        int i = index;
        while (i > 0 && arr[i] < arr[i - 1]) {
        	int tmp = arr[i];
        	arr[i] = arr[i - 1];
        	print(arr);
        	arr[i - 1] = tmp;
        	i--;
        }
    	print(arr);
    	in.close();
        
    }	
	
	static void print(int[] arr) {
		Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
		System.out.println();
	}
}