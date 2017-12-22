package dataStructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SparseArrays {

	private static int count(List<String> list, String query) {
		int count = 0;
		for (String string : list) {
			if (string.equals(query)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> list = new ArrayList<String>();
		for (int a_i = 0; a_i < n; a_i++) {
			list.add(in.next());
		}
		int q = in.nextInt();
		int counts[] = new int[q];
		for (int a_i = 0; a_i < q; a_i++) {
			String query = in.next();
			counts[a_i] = count(list, query);
		}
		for (int a_i = 0; a_i < q; a_i++) {
			System.out.println(counts[a_i]);
		}

		in.close();
	}
}