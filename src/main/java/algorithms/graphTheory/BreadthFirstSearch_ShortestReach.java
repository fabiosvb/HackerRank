package algorithms.graphTheory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class BreadthFirstSearch_ShortestReach {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			HashMap<Integer, Node> map = getNodes(n);
			for (int a1 = 0; a1 < m; a1++) {
				int u = in.nextInt();
				int v = in.nextInt();
				Node node1 = map.get(u);
				Node node2 = map.get(v);
				if (node1.value != node2.value) {
					node1.bind(node2);
				}
			}
			int s = in.nextInt();

			int[] distances = new int[n];
			distances[s - 1] = 1;

			Node nodeS = map.get(s);

			calculateLength(nodeS.nodes.values(), 1, distances);

			for (int i = 1; i <= distances.length; i++) {
				if (i != s) {
					builder.append(distances[i - 1] > 0 ? String.valueOf(distances[i - 1]) : "-1").append(" ");
				}
			}

			builder = new StringBuilder(builder.toString().trim()).append("\n");
		}

		System.out.println(builder.toString());
		in.close();
	}

	public static void calculateLength(Collection<Node> nodes, int level, int[] distances) {
		List<Node> queue = new ArrayList<Node>();
		for (Node node : nodes) {
			if (distances[node.value - 1] == 0) {
				distances[node.value - 1] = 6 * level;
				if (node.nodes.size() > 0) {
					for (Node child : node.nodes.values()) {
						queue.add(child);
					}
				}
			}
		}

		if (queue.size() > 0) {
			calculateLength(queue, level + 1, distances);
		}
	}

	public static HashMap<Integer, Node> getNodes(int n) {
		HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
		for (int i = 1; i <= n; i++) {
			nodes.put(i, new Node(i));
		}
		return nodes;
	}
}

class Node {
	int value = 0;
	TreeMap<Integer, Node> nodes = new TreeMap<Integer, Node>();

	Node(int value) {
		this.value = value;
	}

	void bind(Node node) {
		this.nodes.put(node.value, node);
		node.nodes.put(this.value, this);
	}

	public String toString() {
		return String.valueOf(this.value);
	}

}