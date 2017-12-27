package algorithms.bitManipulation;

import java.util.Scanner;

public class TheGreatXOR {

    static long theGreatXor(long x){
    	int length = Long.toBinaryString(x).length();
    	x = ~ x;
    	int notLength = Long.toBinaryString(x).length();
    	String value = Long.toBinaryString(x).substring(notLength - length);
    	return Long.parseLong(value, 2);
    }

//    static long theGreatXor(long x){
//        long index = 0;
//        long max = 0;
//    	for (long a = 1; a < x; a++) {
//			long xor = a ^ x;
//			if (xor > x && max < xor) {
//				max = xor;
//				index = a;
//			}
//		}
//    	return index;
//    }    
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
        in.close();
    	


    }

}
