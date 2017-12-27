package algorithms.bitManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {

	// XOR operation
    static int lonelyinteger(int[] arr) {
        Arrays.sort(arr);
        int num = 0;
        for (int i = 0; i < arr.length ; i++){
        	int value = arr[i];
        	num = num ^ value;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
        in.close();
    }
}
