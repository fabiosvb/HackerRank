package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GridChallenge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<String> answerList = new ArrayList<String>();
		for (int c = 0; c < t; c++) {
			int n = in.nextInt();
			char[][] g = new char[n][n];
			String word;
			String answer = "YES";
			for (int i = 0; i < n; i++) {
				word = in.next();
				g[i] = word.toCharArray();
				Arrays.sort(g[i]);
				if (i > 0 && answer.equals("YES")) {
					for (int j = 0; j < g[i].length; j++) {
						if (g[i - 1][j] > g[i][j]) {
							answer = "NO";
						}
					}
				}
			}
			answerList.add(answer);
		}
		answerList.stream().forEach(System.out::println);
		in.close();
	}
}
