package dataStructures.arrays;

import java.util.Scanner;

public class TwoDArray_DS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i< 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		int maxSum =  Integer.MIN_VALUE; 
		//System.out.println("aaaa");
		for (int i = 0; i< 6; i++) {
			for (int j = 0; j < 6; j++) { 
				int sum = getHourGlassSum(arr, i, j);
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		System.out.println(maxSum);
		in.close();
	}
	
	private static int getHourGlassSum(int[][] arr, int row, int col) {
		boolean top =     isValid(arr, row, col)     && isValid(arr, row, col + 1)     &&  isValid(arr, row, col + 2);
		boolean middle =  isValid(arr, row + 1, col + 1) ;
		boolean bottom =  isValid(arr, row + 2, col) && isValid(arr, row + 2, col + 1) &&  isValid(arr, row + 2, col + 2) ;
		if (top && middle && bottom) {
			return sum(arr, row, col);
		}
		return Integer.MIN_VALUE;
	}

	private static int sum(int[][] arr, int row, int col) {
		int top =     arr[row][col] + arr[row][col + 1] + arr[row][col + 2];
		int middle =  arr[row + 1][col + 1]; 
		int bottom =  arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];
		return top + middle + bottom;
	}

	private static boolean isValid(int[][] arr, int row, int col) {
		return row < arr.length && col < arr[row].length;
	}
}