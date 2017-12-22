package support.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeHeap{

	public static List<Integer> heap = new ArrayList<Integer>();
	public static StringBuilder builder = new StringBuilder();

	public static void main (String[] arg){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int value = 0;
		for (int i = 0; i < q; i++){
			int c = in.nextInt();
			switch (c){
				case 1: 
					value = in.nextInt();
					add(value);
					break;
				case 2: 
					value = in.nextInt();
					delete(value);
					break;
				default: print();
					break;
			}
		}
		System.out.println(builder.toString().trim());
		in.close();
	}

	public static void print(){
		if (heap.size() > 0){
			builder.append(heap.get(0)).append("\n");
		}
	}

	public static void delete(int value){
		for (int index = 0; index < heap.size(); index++){
			if (heap.get(index) == value){
				
				swap(index, heap.size() - 1);
				heap.remove(heap.size() - 1);

				if (index > heap.size() - 1) {
					index = heap.size() > 0 ? heap.size() - 1 : 0;
				}

				heapfyUp(index);
				heapfyDown(index);
                break;
			}
		}
	}

	public static void add(int value){
		heap.add(value);
		int index = heap.size() - 1;
		heapfyUp(index);
	}

	public static void heapfyUp(int index){
		while (hasParent(index) && heap.get(index) < heap.get(parentIndex(index))){
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}	
	}
	
	public static void heapfyDown(int index) {
		while (hasLeftIndex(index)) {
			int smallestChildIndex = leftIndex(index);
			if (hasRightIndex(index) && rightIndex(index) > leftIndex(index)) {
				 smallestChildIndex = rightIndex(index);
			}
			
			if (heap.get(smallestChildIndex) < heap.get(index)) {
				swap(smallestChildIndex, index);
				index = smallestChildIndex;
			}else {
				break;
			}
		}
	}
	public static boolean hasLeftIndex(int index){
		return leftIndex(index) < heap.size(); 
	}	
	
	// index from 1
	// left = 2 * index
	// right = (2 * index) + 1
	// parent = inidex / 2
	
	// index from 0
	// left = (2 * index) + 1
	// right = (2 * index) + 2
	// parent = (inidex - 1 )/ 2
	public static int leftIndex(int index){
		return ((index * 2) + 1);
	}	
	
	public static boolean hasRightIndex(int index){
		return rightIndex(index) < heap.size(); 
	}	
	
	public static int rightIndex(int index){
		return ((index * 2) + 2); 
	}	

	public static boolean hasParent(int index){		
		if (index == 0) {
			return false;
		}
		return true; 
	}
	
	public static int parentIndex(int index){
		int parentIndex = (int) ((index - 2) / 2);
		return parentIndex > 0 ? parentIndex : 0; 
	}	

	public static void swap(int index1, int index2){
		int temp = heap.get(index1);
		heap.set(index1,  heap.get(index2));
		heap.set(index2,  temp);
	}
}
