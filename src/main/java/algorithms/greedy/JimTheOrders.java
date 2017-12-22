package algorithms.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class JimTheOrders {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] arr = new long[n];
		HashMap<Long, Queue<Long>> order = new HashMap<Long, Queue<Long>>();

		for (int i = 0; i < n; i++) {
			long t = in.nextInt();
			long d = in.nextInt();
			long value = t + d;
			arr[i] = value;
			put(order, value, i + 1);
		}
		Arrays.sort(arr);
		StringJoiner joiner = new StringJoiner(" ");
		Arrays.stream(arr).forEach(x -> joiner.add(String.valueOf(get(order, x))));
		System.out.println(joiner.toString());
		in.close();
	}

	static void put(HashMap<Long, Queue<Long>> order, long key, long value) {
		Queue<Long> queue = order.get(key);
		if (queue == null) {
			queue = new LinkedList<Long>();
			order.put(key, queue);
		}
		queue.add(value);
	}

	static Long get(HashMap<Long, Queue<Long>> order, long key) {
		Queue<Long> queue = order.get(key);
		return queue.poll();
	}

}