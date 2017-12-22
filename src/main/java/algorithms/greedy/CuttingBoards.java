package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CuttingBoards {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(reader.readLine());
		for (int i = 0; i < q; i++) {
			String[] line = reader.readLine().split(" ");
			int h = Integer.parseInt(line[0]);
			int w = Integer.parseInt(line[1]);
			int[] arrh = new int[h];
			int[] arrw = new int[w];

			arrh[0] = 0;
			arrw[0] = 0;

			line = reader.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				arrh[j + 1] = Integer.parseInt(line[j]);
			}

			line = reader.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				arrw[j + 1] = Integer.parseInt(line[j]);
			}

			long price = process(h, w, arrh, arrw);
			System.out.println(price % ((long) Math.pow(10, 9) + (long) 7));
		}
		reader.close();
	}

	private static long process(int h, int w, int[] arrh, int[] arrw) {
		Arrays.sort(arrh);
		Arrays.sort(arrw);
		int hi = 1;
		int wi = 1;
		long price = 0;
		Holder holder = new Holder();  
		while (hi < h && wi < w) {
			if (arrw[wi] <= arrh[hi]) {
				price = price + holder.cost(Direction.H, h, arrw[wi]);
				wi++;
			} else {
				price = price + holder.cost(Direction.W, w, arrh[hi]);
				hi++;
			}
		}
		while (wi < w) {
			price = price + holder.cost(Direction.H, h, arrw[wi]);
			wi++;
		}
		while (hi < h) {
			price = price + holder.cost(Direction.W, w, arrh[hi]);
			hi++;
		}
		return price;
	}


}

enum Direction {H, W};

class Holder{
	int countH = 0;
	int countW = 0;
	
	long cost(Direction direction, int axis, long cost) {
		int segs = 0;
		if (direction == Direction.H) {
			segs = axis - this.countW;
			this.countH = countH + 1;
		}else {
			segs = axis - this.countH;
			this.countW = countW + 1;
		}
		return segs * cost;
	}
}