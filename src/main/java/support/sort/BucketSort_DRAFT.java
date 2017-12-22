package support.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort_DRAFT {

	
	// Just proof of concept
	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, 4, 2, 3, 1, 5 };
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		
		arr = sort(arr, 5);
		
		System.out.println();
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		
		System.out.println();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int[] sort(int[] arr, int bucketSize) {
		LinkedList[] bucket = new LinkedList[bucketSize];
		for (int i = 0; i < arr.length; i++) {
			int pos = arr[i] <= bucketSize ? arr[i] : arr[i] / bucketSize;
			addBucket(bucket, pos - 1, arr[i]);
		}
		
		int[] result = new int[arr.length];
		
		int index = 0;
		for (int i = 0; i < bucketSize; i++) {
			if (bucket[i] != null) {
				LinkedList<Integer> list = bucket[i];
				Collections.sort(list);
				for (Integer value : list) {
					result[index++] = value;
				}
			}
		}
		return result;
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
