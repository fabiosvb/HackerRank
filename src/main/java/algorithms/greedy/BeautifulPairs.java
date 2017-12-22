package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BeautifulPairs {
	 // this question has terrible explanation...
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++){
            arrA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++){
            arrB[i] = in.nextInt();
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n && j < n) {
            if (arrA[i] == arrB[j]){
            	i++;
            	j++;
            	count++;
            }else if (arrA[i] < arrB[j]) {
            	i++;
            }else {
            	j++;
            }
        }
        
        if (count == n) {
        	count = count - 1;
        }else {
        	count = count + 1;
        }
        
        System.out.println(count);
        in.close();
    }
}