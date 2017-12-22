package support.tree;

import java.io.Serializable;

public class TreeAVL implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 6, 5 };
		AVLNode root = null;
		for (int value : arr) {
			if (value != -1) {
				root = insert(root, value);
			} else {
				break;
			}
		}
	}

	static AVLNode insert(AVLNode root, int value) {
		if (root == null) {
			root = new AVLNode();
			root.val = value;
		} else if (value < root.val) {
			root.left = insert(root.left, value);
		} else if (value > root.val) {
			root.right = insert(root.right, value);
		}

		int balanceFactor = height(root.left) - height(root.right);

		if (balanceFactor == 2) {
			balanceFactor = height(root.left.left) - height(root.left.right);
			if (balanceFactor == -1) {
				root.left = rotateLeftRight(root.left);
			}
			root = rotateRightRight(root);
		} else if (balanceFactor == -2) {
			balanceFactor = height(root.right.left) - height(root.right.right);
			if (balanceFactor == 1) {
				root.right = rotateRightLeft(root.right);
			}
			root = rotateLeftLeft(root);
		}

		root.ht = maxHeight(root.left, root.right);
		return root;
	}

	static AVLNode rotateRightRight(AVLNode root) {
		AVLNode newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static AVLNode rotateLeftRight(AVLNode root) {
		AVLNode newRoot = root.right;
		newRoot.left = root;
		root.right = null;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static AVLNode rotateLeftLeft(AVLNode root) {
		AVLNode newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static AVLNode rotateRightLeft(AVLNode root) {
		AVLNode newRoot = root.left;
		newRoot.right = root;
		root.left = null;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static int maxHeight(AVLNode left, AVLNode right) {
		int height = 0;
		if (left != null && right == null) {
			height = left.ht + 1;
		} else if (right != null && left == null) {
			height = right.ht + 1;
		} else if (right != null && left != null) {
			height = left.ht > right.ht ? left.ht + 1 : right.ht + 1;
		}
		return height;
	}

	static int height(AVLNode node) {
		return node != null ? node.ht : -1;
	}

}

class AVLNode {
	int val;
	int ht;
	AVLNode left;
	AVLNode right;
	int fc;

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("value: ").append(this.val);
		string.append(", height: ").append(this.ht);
		string.append(", fact: ").append(fc);
		string.append(", left: {");
		if (this.left != null) {
			string.append("value: ").append(this.left.val).append(", height: ").append(this.left.ht).append(", fact: ")
					.append(fc);// .append(", parent: ").append(this.left.parent.value);
		}
		string.append("}, right: {");
		if (this.right != null) {
			string.append("value: ").append(this.right.val).append(", height: ").append(this.right.ht)
					.append(", fact: ").append(fc);// .append(", parent: ").append(this.right.parent.value);
		}
		string.append("}");
		return string.toString();
	}
}