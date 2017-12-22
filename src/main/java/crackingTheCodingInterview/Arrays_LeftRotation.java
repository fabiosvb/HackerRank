package crackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_LeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int rotation = k > n ? (int) k / n : k;
		for (int i = 0; i < rotation; i++) {
			int tmp = a[0];
			for (int j = 0; j < n - 1; j++) {
				a[j] = a[j + 1];
			}
			a[n - 1] = tmp;
		}
		StringBuilder builder = new StringBuilder();
		Arrays.stream(a).forEach(x -> builder.append(x).append(" "));
		System.out.println(builder.toString().trim());
		in.close();
	}
}
