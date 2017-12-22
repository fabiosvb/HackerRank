package crackingTheCodingInterview;

import java.util.Scanner;
import java.util.Stack;

public class Queues_TaleTwoStacks {
	 public static class MyQueue<T> {
	        Stack<T> stackNewestOnTop = new Stack<T>();
	        Stack<T> stackOldestOnTop = new Stack<T>();

	        public void enqueue(T value) {// Push onto newest stack
	            stackNewestOnTop.push(value);
	        }

	        public T peek() {
	            T t = null;
	            if (stackfy()){
	                t = stackOldestOnTop.peek();
	            }
	            return t;
	        }
	        
	        public T dequeue() {
	            T t = null;
	            if (stackfy()){
	                t = stackOldestOnTop.pop();
	            }
	            return t;
	        }
	        
	        private boolean stackfy(){
	            if (stackOldestOnTop.size() == 0){
	                while (stackNewestOnTop.size() > 0){
	                    stackOldestOnTop.push(stackNewestOnTop.pop());
	                }
	            }
	            return stackOldestOnTop.size() > 0;
	        }        
	    }

	    
	    public static void main(String[] args) {
	        MyQueue<Integer> queue = new MyQueue<Integer>();
	        
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        
	        for (int i = 0; i < n; i++) {
	            int operation = scan.nextInt();
	            if (operation == 1) { // enqueue
	                queue.enqueue(scan.nextInt());
	            } else if (operation == 2) { // dequeue
	                queue.dequeue();
	            } else if (operation == 3) { // print/peek
	                System.out.println(queue.peek());
	            }
	        }
	        scan.close();
	    }
	}