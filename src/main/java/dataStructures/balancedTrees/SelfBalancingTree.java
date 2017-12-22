package dataStructures.balancedTrees;

public class SelfBalancingTree {

	static Node insert(Node root, int value) {
		if (root == null) {
			root = new Node();
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
			root = rotateLeftLeft(root);
		} else if (balanceFactor == -2) {
			balanceFactor = height(root.right.left) - height(root.right.right);
			if (balanceFactor == 1) {
				root.right = rotateRightLeft(root.right);
			}
			root = rotateRightRight(root);
		}

		root.ht = maxHeight(root.left, root.right);
		return root;
	}

	static Node rotateLeftLeft(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static Node rotateLeftRight(Node root) {
		Node newRoot = root.right;
		newRoot.left = root;
		root.right = null;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static Node rotateRightRight(Node root) {
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static Node rotateRightLeft(Node root) {
		Node newRoot = root.left;
		newRoot.right = root;
		root.left = null;
		root.ht = maxHeight(root.left, root.right);
		newRoot.ht = maxHeight(newRoot.left, newRoot.right);
		return newRoot;
	}

	static int maxHeight(Node left, Node right) {
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

	static int height(Node node) {
		return node != null ? node.ht : -1;
	}

}

class Node {
	int val; // Value
	int ht; // Height
	Node left; // Left child
	Node right; // Right child
}
