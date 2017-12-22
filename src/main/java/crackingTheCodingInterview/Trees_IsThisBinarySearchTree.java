package crackingTheCodingInterview;

public class Trees_IsThisBinarySearchTree {
	  boolean checkBST(Node root) {
	        if (root == null){
	            return true;
	        }
	        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }
	    
	    boolean checkBST(Node node, int min, int max) {
	        if (node == null){
	            return true;
	        }
	        
	        if (node.data > min && node.data < max){
	            if (checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max)){
	                return true;
	            }
	        }
	        return false;
	    }

}

class Node {
    int data;
    Node left;
    Node right;
 }
