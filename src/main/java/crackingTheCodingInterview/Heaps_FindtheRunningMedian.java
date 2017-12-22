package crackingTheCodingInterview;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Heaps_FindtheRunningMedian {

	// must use 2 heaps...
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		PriorityQueue<Integer> min = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
		PriorityQueue<Integer> max = new PriorityQueue<Integer>();

		for (int i = 0; i < a.length; i++) {
			int value = a[i];
			addValue(value, min, max);
			balance(min, max);
			System.out.println(median(min, max));
		}
		in.close();
	}

	private static double median(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		int ratio = min.size() - max.size();
		if (Math.abs(ratio) > 0) {
			PriorityQueue<Integer> heap = min.size() > max.size() ? min : max;
			return heap.peek();
		}

		return (double) (min.peek() + max.peek()) / 2;

	}

	private static void balance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		int ratio = min.size() - max.size();
		if (Math.abs(ratio) > 1) {
			PriorityQueue<Integer> smaller = min.size() > max.size() ? max : min;
			PriorityQueue<Integer> greater = min.size() > max.size() ? min : max;
			smaller.add(greater.poll());
		}
	}

	private static void addValue(int value, PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		if (min.size() == 0 || value < min.peek()) {
			min.add(value);
		} else {
			max.add(value);
		}
	}

}