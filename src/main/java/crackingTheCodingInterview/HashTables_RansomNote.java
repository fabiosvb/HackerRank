package crackingTheCodingInterview;

import java.util.Scanner;

public class HashTables_RansomNote {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
		}

		boolean find = false;
		for (String word : ransom) {
			find = false;
			for (int magazine_i = 0; magazine_i < m; magazine_i++) {
				if (magazine[magazine_i].equals(word)) {
					magazine[magazine_i] = "";
					find = true;
					break;
				}
			}
			if (!find) {
				break;
			}
		}
		System.out.println(find ? "Yes" : "No");
		in.close();
	}
}