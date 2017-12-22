package dataStructures.trees;

public class HeightBinaryTree {
	
	static int height(Node root) {
		return height(root, 0);
	}

	static int height(Node root, int level) {
		if (root != null) {
			int leftLevel = height(root.left, level + 1);
			int rightLevel = height(root.right, level + 1);
			return leftLevel > rightLevel ? leftLevel : rightLevel;
		}
		return level - 1;
	}
}
