package dataStructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int queries = in.nextInt();
		int [][] seqList = new int[N][0];
		
		int lastAnwser = 0;
		StringBuilder response = new StringBuilder();
		for (int i = 0; i < queries; i++) {
			int queryType = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			int seq = (x ^ lastAnwser) % N;
			if (queryType == 1) {
				seqList[seq] = Arrays.copyOf(seqList[seq], seqList[seq].length + 1);
				seqList[seq][seqList[seq].length - 1] = y;
			}else {
				int newSeq = y % seqList[seq].length;
				lastAnwser = seqList[seq][newSeq];
				response.append(lastAnwser).append("\n");
			}
		}
		System.out.println(response.toString());
		in.close();
	}
}