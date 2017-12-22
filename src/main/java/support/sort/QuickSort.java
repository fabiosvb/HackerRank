package support.sort;

public class QuickSort{
	
	public int[] sort(int... arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}
	
	private void quickSort(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int pivot = (start + end) / 2;
		int pivotValue = arr[pivot];
		do {
			while (arr[i] < pivotValue) {
				i++;	
			}
			while (arr[j] > pivotValue) {
				j--;	
			}
			if (i <= j) {
				swap(arr, i, j);
				 i++;
		         j--;				
			}

		} while (i <= j);
		
		if(start < j) {
			quickSort(arr, start, j);
		}
			      
		if(i < end) {
			quickSort(arr, i, end);
		}
	}
	
	private int[] swap(int[] arr, int from, int to){
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
		return arr;
	}	
		
}
