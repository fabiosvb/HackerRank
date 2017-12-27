package algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Equals {
	
	// this did not pass #15
	// this solution should have worked as well, however the follow solution seems to be the only one works (Math.floor(x / 5) + Math.floor((x % 5) / 2) + (x % 5) % 2);
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int n = in.nextInt();
			long[] arr = new long[n]; 
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			
			Arrays.sort(arr);
			
			List<Long> counts = new ArrayList<Long>(); 
			
			long target = arr[0];

			long count = equalize(arr, target);
			counts.add(count);


			if (target >= 2) {
				count = equalize(arr, target - 2);
				counts.add(count);
			}
			
			if (target >= 1) {
				count = equalize(arr, target - 1);
				counts.add(count);
			}

			counts.sort((x,y) -> Long.compare(x, y));
			
			builder.append(counts.get(0)).append("\n");
		}
		System.out.println(builder.toString());
		in.close();
	}

	
	
	private static long equalize(long[] arr, long target) {
		long count = 0;
		for (int i = 0; i < arr.length; i++) {
			count = count + equalize(arr[i], target);
		}
		return count;
	}
	
/**
 *      
 *      ops += arr[i] / 5;
        ops += arr[i] % 5 / 2;
        ops += arr[i] % 5 % 2 / 1;
 */
	private static int equalize(long value, long target) {
		int count = 0;
		while (value > target) {
			if (value - 5 >= target) {
				value = value - 5;
				count++;
			}else if (value - 2 >= target) {
				value = value - 2;
				count++;
			}else if (value - 1 >= target){
				value = value - 1;
				count++;
			}
		}
		return count;
	}
}
