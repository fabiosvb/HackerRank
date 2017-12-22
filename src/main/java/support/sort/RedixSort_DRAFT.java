package support.sort;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;

public class RedixSort_DRAFT {

	// Just proof of concept
	public static void main(String[] args) {
		int arr[] = { 3, 2, 500, 4, 20, 3, 1, 5,100 };
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		arr = sort(arr);
		
		System.out.println();
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		
		System.out.println();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int[] sort(int[] arr) {
		LinkedList[] bucket = new LinkedList[10];
		for (int k = 2; k >= 0; k--) {
			for (int i = 0; i < arr.length; i++) {
				int pos = getPosition(arr[i], k);
				addBucket(bucket, pos, arr[i]);
			}
			arr = getValues(bucket, arr.length);
			bucket = new LinkedList[10];
		}
		
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	private static int[] getValues(@SuppressWarnings("rawtypes") LinkedList[] bucket, int length) {
		int[] result = new int[length];
		int index = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != null) {
				LinkedList<Integer> list = bucket[i];
				for (Integer value : list) {
					result[index++] = value;
				}
			}
		}
		return result;
	}

	private static int getPosition(int value, int digitPosition) {
		String s = new DecimalFormat("000").format(value);
		int digt =  Integer.parseInt(String.valueOf(s.charAt(digitPosition)));
		return digt;
	}

	private static void addBucket(LinkedList<Integer>[] bucket, int pos, int value) {
		LinkedList<Integer> slot = bucket[pos];
		if (slot == null) {
			slot = new LinkedList<Integer>();
			bucket[pos] = slot;
		}
		slot.add(value);
	}
}
