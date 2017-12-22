package support.sort;

public class BinarySearch {

	public static void main (String[] arg){
		int[] arr = new int[]{0,1,2,3,4,5};
		int value = -1;
		int position = find(arr, 0, arr.length - 1, value);
		System.out.println(position);
	}

	public static int find(int[] arr, int start, int end, int value) {
		if (start > end) {
			return -1;
		}
		
		int pivot = (start + end) / 2;
		
		int pivotValue = arr[pivot];
		if (value == pivotValue) {
			return pivot;
		}

		if (value < pivotValue) {
			return find(arr, start, pivot - 1, value);
		} else {
			return find(arr, pivot + 1, end, value);
		}
	}

}
