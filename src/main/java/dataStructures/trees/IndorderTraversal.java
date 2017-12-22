package dataStructures.trees;

public class IndorderTraversal {

	void inOrder(Node root) {
		if (root.left != null && root.right != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}else if (root.left != null && root.right == null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
		}else if (root.left == null && root.right != null) {
			System.out.print(root.data + " ");
			inOrder(root.right);
		}else {
			System.out.print(root.data + " ");
		}


}

}
