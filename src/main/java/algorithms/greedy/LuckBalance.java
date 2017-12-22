package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class LuckBalance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		TreeSet<Integer> imp = new TreeSet<Integer>((a, b) -> {
			int comp = Integer.compare(b, a);
			return comp != 0 ? comp : 1;
		});
		List<Integer> notImp = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int luck = in.nextInt();
			int important = in.nextInt();
			if (important == 1) {
				imp.add(luck);
			} else {
				notImp.add(luck);
			}
		}
		long sum = 0;
		for (Integer luck : imp) {
			if (k > 0) {
				k--;
				sum = sum + luck;
			} else {
				sum = sum - luck;
			}
		}
		for (Integer luck : notImp) {
			// if (k > 0){
			// k--;
			sum = sum + luck;
			// }else{
			// sum = sum - luck;
			// }
		}
		System.out.println(sum);
		in.close();
	}
}