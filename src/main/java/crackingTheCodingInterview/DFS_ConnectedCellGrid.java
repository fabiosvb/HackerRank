package crackingTheCodingInterview;

import java.util.Scanner;

public class DFS_ConnectedCellGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}

		System.out.println(calculateGreatestRegion(grid, n, m));
		in.close();

	}

	public static int calculateGreatestRegion(int[][] grid, int n, int m) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] != 0 && !isChecked(grid[i][j])) {
					int count = dft(grid, i, j);
					if (count > max) {
						max = count;
					}
				}
			}
		}
		return max;
	}

	public static int dft(int[][] grid, int r, int c) {
		int count = 0;
		if (isValid(grid, r, c) && grid[r][c] == 1) {
			grid[r][c] = -1;
			count = count + 1;
			count = count + dft(grid, r, c + 1);
			count = count + dft(grid, r + 1, c + 1);
			count = count + dft(grid, r + 1, c);
			count = count + dft(grid, r + 1, c - 1);
			count = count + dft(grid, r, c - 1);
			count = count + dft(grid, r - 1, c - 1);
			count = count + dft(grid, r - 1, c);
		}
		return count;
	}

	public static boolean isChecked(int value) {
		return value == -1;
	}

	public static boolean isValid(int[][] grid, int r, int c) {
		return r >= 0 && c >= 0 && r < grid.length && c < grid[r].length;
	}

	public static void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}