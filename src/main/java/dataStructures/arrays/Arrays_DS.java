package dataStructures.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arrays_DS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Collections.reverse(list);
		
		list.stream().forEach((value) -> System.out.print(value + " "));
		in.close();	
	}
}