package algorithms.sorting;

import java.util.Scanner;

public class IntroTutorialChallenges {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		int n = in.nextInt();

		int[] arr = new int[n];
		int index = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if (value == arr[i]) {
				index = i;
				break;
			}
		}
		System.out.println(index);
		in.close();
	}
}
