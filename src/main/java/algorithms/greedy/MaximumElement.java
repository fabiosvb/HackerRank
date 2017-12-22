package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class MaximumElement {
	 private static List<Long> stack = new ArrayList<Long>();
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        StringJoiner result = new StringJoiner("\n");
	        for (int i = 0; i < n; i++){
	            int cmd = in.nextInt();
	            Long value = null;
	            switch (cmd){
	                case 1:
	                    value = in.nextLong();
	                    push(value);
	                    break;
	                case 2:
	                    remove();
	                    break;
	                    
	                default:
	                    value = pop();
	                    if (value != null){
	                        result.add(String.valueOf(value));
	                    }
	                    break;
	            }
	        }
	        System.out.println(result.toString());
	        in.close();
	    }
	    
	    static void push(long value){
	        stack.add(0, value);
	    }
	    
	    static Long pop(){
	        if (stack.size() > 0){
				Long value = null;
	            for (int i = 0; i < stack.size();i++) {
					if (value == null || value < stack.get(i)){
	                    value = stack.get(i);
	                }
				}
	            return value;
	        }
	        return null;
	    }
	    
	    static void remove(){
	        if (stack.size() > 0){
	            stack.remove(0);
	        }
	    }
	}