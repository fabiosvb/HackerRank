package support.sort;

public class BubbeSort{
	
	protected int[] swap(int[] arr, int from, int to){
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
		return arr;
	}	
	
	public int[] sort(int... arr) {
		for (int i = arr.length; i > 0; i--) {
			for (int j = 0 ; j < i - 1; j++) {
				if (arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}
			}	
		}
		return arr;
	}	

}
