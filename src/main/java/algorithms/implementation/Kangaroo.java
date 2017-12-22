package algorithms.implementation;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] arg) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		boolean canLand = false;
		while (v1 > v2 && x1 < x2) {
			x1 = x1 + v1;
			x2 = x2 + v2;

			if (x1 == x2) {
				canLand = true;
				break;
			}
		}

		if (canLand) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		in.close();
	}
}