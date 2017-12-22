package crackingTheCodingInterview;

import java.util.Scanner;

public class Strings_MakingAnagrams {
	public static int numberNeeded(String first, String second) {
		StringBuilder a = new StringBuilder(first);
		StringBuilder b = new StringBuilder(second);
		int count = 0;
		while (a.length() > 0) {
			char c = a.charAt(0);
			int index = b.indexOf(String.valueOf(c));
			if (index != -1) {
				a.deleteCharAt(0);
				b.deleteCharAt(index);
			} else {
				a.deleteCharAt(0);
				count++;
			}
		}
		count = count + b.length();
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
		in.close();
	}
}
