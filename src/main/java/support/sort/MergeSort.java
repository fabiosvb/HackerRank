package support.sort;

import java.util.Arrays;

public class MergeSort {

	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 2, 4, 6};
		
		int[] helper = new int[arr.length];
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		
		mergeSort(arr, helper, 0, helper.length - 1);
		
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	}

	protected static void mergeSort(int[] arr, int[] helper, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, helper, start, middle);
			mergeSort(arr, helper, middle + 1, end);
			merge(arr, helper, start, middle, end);
		}
		
	}

	private static void merge(int[] arr, int[] helper, int start, int middle, int end) {
		for (int i = start; i <= end; i++) {
			helper[i] = arr[i];
		}
		
		int i = start;
	    int j = middle + 1;
	    int k = start;
	    while (i <= middle && j <= end) {
	    	if (helper[i] <= helper[j]) {
	    		arr[k] = helper[i];
	    		i++;
	    	}else {
	    		arr[k] = helper[j];
	    		j++;
	    		//swap = swap + ((middle + 1) - i);
	    	}
	    	k++;
	    }
	    
	    while (i <= middle) {
	    	arr[k++] = helper[i++];
	    }

	}

}
