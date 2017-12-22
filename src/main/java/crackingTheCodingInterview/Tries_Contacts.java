package crackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tries_Contacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrieTree root = new TrieTree();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if ("add".equals(op)){
                add(root, contact);            
            }else{
                System.out.println(find(root, contact));
            }
        }
        in.close();
    }
    
    public static void add(TrieTree node, String word){
    	TrieTree child = null;
    	
    	for (int i = 0; i < word.length(); i++){
        	node.word = node.word + 1;

    		char c = word.charAt(i);
    		child = node.letters.get(c);

            if (child == null){
            	child = new TrieTree(c);
            	node.letters.put(c, child);
            }
        	node = child;
    	}
        node.word = 1;
    }
    
    public static int find(TrieTree node, String word){
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            node = node.letters.get(c);
            if (node == null){
                break;
            }
        }
        if (node != null){
            return node.word;// + count(node);
        }
        return 0;
    }
    
    public static int count(TrieTree node){
        int sum  = 0;
        for (TrieTree child : node.letters.values()){
            sum += child.word;
            if (child.letters.size() > 0){
        	   sum += count(child);
            }
        }
        return sum;
    }
}

class TrieTree{
    Map<Character, TrieTree> letters = new HashMap<Character, TrieTree>();    
    int word = 0;
    char c;
    
    TrieTree(){
    }    
    TrieTree(char c){
    	this.c = c;
    }
    
    public String toString() {
    	return String.valueOf(c);
    }
}
