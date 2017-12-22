package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BitManipulation_LonelyInteger {

	public static int lonelyInteger(int[] a) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], true);
			} else {
				map.put(a[i], false);
			}
		}

		for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			if (!entry.getValue()) {
				return entry.getKey();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		System.out.println(lonelyInteger(a));
		in.close();
	}
}
