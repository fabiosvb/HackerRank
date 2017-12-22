package support.tree;

public class TreeRedBlack {

	public static void main (String[] arg) {
		
		int[] arr = new int[]{10, 15, 5, 25, 13, 30, 35, 40};
		
		RBNode root = null;
		for (Integer value : arr) {
			root = insert(root, value);
			System.out.println("...");
		}
		System.out.println("fim");
		
	}
	
	public static RBNode insert(RBNode root, int value) {
		if (root == null) {
			root = new RBNode(value, Color.BLACK);
			return root;
		}
		RBNode parent = root;
		RBNode item = null;
		do {
			if (value < parent.value) {
				if (parent.left == null) {
					item = new RBNode(value, Color.RED, parent);
					parent.left = item;
					parent = null;
				}else {
					parent = parent.left;
				}

			}else if (value > parent.value) {
				if (parent.right == null) {
					item = new RBNode(value, Color.RED, parent);
					parent.right = item;
					parent = null;
				}else {
					parent = parent.right;
				}
			}
		} while (parent != null);
		
		return balance(root, item);
	}

	private static RBNode balance(RBNode root, RBNode node) {
		while (node != null) {
			if (node.color == Color.RED && parentColor(node) == Color.RED) {
				if (siblingColor(parent(node)) == Color.RED) {
					reverseColor(parent(node));
				}else if (isLeft(parent(node))){
					if (isRight(node)) {
						rotateLeft(parent(node));
					}
					rotateRight(parent(parent(node)));
				}else if (isRight(parent(node))) {
					if (isLeft(node)) {
						rotateRight(parent(node));
					}
					rotateLeft(parent(parent(node)));
				}
			}
			if (node.parent == null) {
				root = node;
			}
			node = node.parent;
		}
		return root;
	}
	
	private static void rotateLeft(RBNode root) {
		RBNode node = root.right;
		root.right = node.left;
		root.color = Color.flip(root.color);

		node.left = root;
		node.color  = Color.flip(node.color);
		
		node.parent = root.parent;
		root.parent = node;

		fixParent(node);
	
	}	

	private static void rotateRight(RBNode root) {
		RBNode node = root.left;
		root.left = node.right;
		root.color = Color.flip(root.color);
		
		node.right = root;
		node.color  = Color.flip(node.color);

		node.parent = root.parent;
		root.parent = node;
		
		fixParent(node);
	}

	private static void fixParent(RBNode node) {
		if (parent(node) != null) {
			if (node.value <  parent(node).value) {
				parent(node).left = node;
			}else {
				parent(node).right = node;
			}
		}
	}

	private static boolean isLeft(RBNode node) {
		RBNode parent = parent(node);
		if (parent != null && node.value < parent.value) {
			return true;
		}
		return false;
	}

	private static boolean isRight(RBNode node) {
		RBNode parent = parent(node);
		if (parent != null && node.value > parent.value) {
			return true;
		}
		return false;
	}

	private static RBNode reverseColor(RBNode node) {
		node.color = Color.BLACK;
		sibling(node).color = Color.BLACK;
		if (parent(node) != null && parent(node).parent != null) {
			//verifica se e o root, se for não troca a cor
			parent(node).color = Color.RED;
		}
		return parent(node);
	}

	
	private static Color siblingColor(RBNode node) {
		RBNode sibling = sibling(node);
		if (sibling != null) {
			return sibling.color;
		}
		return Color.NULL;
	}
	
	private static RBNode sibling(RBNode node) {
		RBNode parent = parent(node);
		if (parent != null && node.value < parent.value) {
			return node.parent.right;
		}
		return node.parent.left;
	}

	
	
	private static RBNode parent(RBNode node) {
		return node.parent;
	}

	private static Color parentColor(RBNode node) {
		RBNode parent = parent(node);
		if (parent != null) {
			return parent.color;
		}
		return Color.NULL;
	}
	
}


class RBNode {
	int value = 0;
	RBNode left;
	RBNode right;
	RBNode parent;
	Color color = Color.RED;
	
	RBNode(int value){
		this.value = value;
	}

	RBNode(int value, Color color){
		this.value = value;
		this.color = color;
	}
	
	RBNode(int value, Color color, RBNode parent){
		this.value = value;
		this.color = color;
		this.parent = parent;
	}
		
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("v: ").append(value).append(", c: ").append(this.color);
		if (this.left != null) {
			builder.append(", left: {v: ").append(this.left.value).append(", c: ").append(this.left.color).append("}");
		}
		if (this.right != null) {
			builder.append(", right: {v: ").append(this.right.value).append(", c: ").append(this.right.color).append("}");
		}
		return builder.toString();
	}

}

enum Color{
	BLACK, RED, NULL;	
	
	static Color flip(Color color) {
		if (color == RED) {
			return BLACK;
		}
		return RED;
	}
}
