package crackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeComplexity_Primality {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> primos = new ArrayList<String>();
		for (int i = 0; i < n; i++){
			int value = in.nextInt();
			if (isPrime(value)){
				primos.add("Prime");
			}else{
				primos.add("Not prime");
			}
		}
		primos.stream().forEach(System.out::println);
		in.close();
	}
	public static boolean isPrime(int value){
		switch (value) {
			case 1: 
				return false;
			case 2: 
				return true;
			case 3: 
				return true;
			case 4: 
				return false;
			default :
				if (value % 2 == 0) {
					return false;
				}
                for (int i = 2; i <= Math.sqrt(value); i++) {
					if (value % i  == 0){
						return false;
					}			
				}
				return true;
		}
	}
}