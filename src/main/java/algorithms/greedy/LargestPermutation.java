package algorithms.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LargestPermutation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		Integer[] arr = new Integer[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			int value = in.nextInt();
			arr[i] = value;
			map.put(value, i);
		}

		Integer[] sortArr = arr.clone();
		Arrays.sort(sortArr, (a, b) -> Integer.compare(b, a));

		int current = 0;
		for (int i = 0; i < sortArr.length && k > 0; i++) {
			int value = sortArr[i];
			int index = map.get(value);
			if (current != index) {
				int oldValue = arr[current];
				swap(arr, index, current);
				map.put(oldValue, index);
				k--;
			}
			current++;
		}

		StringBuilder builder = new StringBuilder();
		Arrays.stream(arr).forEach((x) -> builder.append(x).append(" "));
		System.out.println(builder.toString());
		in.close();
	}

	public static void swap(Integer[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}
}