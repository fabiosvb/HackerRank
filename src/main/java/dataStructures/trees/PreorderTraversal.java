package dataStructures.trees;

public class PreorderTraversal {

	void preOrder(Node root) {
	    if (root != null) {
	        System.out.print(root.data + " ");
	        preOrder(root.left);
	        preOrder(root.right);
	    }
	}
}

class Node {
    int data;
    Node left;
    Node right;
}