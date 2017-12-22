package dataStructures.disjointSet;

import java.util.HashMap;
import java.util.Scanner;

public class ComponentsInGraph {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
		HashMap<Integer, Node> roots = new HashMap<Integer, Node>();
		for (int i = 0; i < n; i++) {
			int v1 = in.nextInt();
			int v2 = in.nextInt();
			Node vertex1 = getVertex(graph, v1);
			Node vertex2 = getVertex(graph, v2);
			union(roots, vertex1, vertex2);

		}

		int min = Integer.MAX_VALUE;
		int max = 0;
		for (Node node : roots.values()) {
			if (node.count > max) {
				max = node.count;
			}
			if (min > node.count) {
				min = node.count;
			}
		}
		System.out.println(min + " " + max);

		in.close();
	}

	public static Node getVertex(HashMap<Integer, Node> graph, int v) {
		Node vertex = graph.get(v);
		if (vertex == null) {
			vertex = new Node(v);
			graph.put(vertex.value, vertex);
		}
		return vertex;
	}

	public static void union(HashMap<Integer, Node> roots, Node v1, Node v2) {
		Node rv1 = find(v1);
		Node rv2 = find(v2);
		if (rv1 != rv2) {
			rv2.parent = rv1;
			rv1.count = rv1.count + rv2.count;
			roots.put(rv1.value, rv1);
			roots.remove(rv2.value);
		}
	}

	public static Node find(Node v) {
		while (v.parent != null) {
			v = v.parent;
		}
		return v;
	}

}

class Node {
	int value;
	int count;
	Node parent;

	public Node(int value) {
		this.value = value;
		this.count = 1;
	}
}
