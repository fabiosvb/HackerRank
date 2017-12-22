package crackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class BFS_ShortestReachInGraph {

public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		StringBuilder builder = new StringBuilder();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			HashMap<Integer, BFSNode> map = getNodes(n);
			for (int a1 = 0; a1 < m; a1++) {
				int u = in.nextInt();
				int v = in.nextInt();
				BFSNode node1 = map.get(u);
				BFSNode node2 = map.get(v);
				if (node1.value != node2.value) {
					node1.bind(node2);
				}
			}
			int s = in.nextInt();
			
			int[] distances = new int[n];
			distances[s - 1] = 1;
			
			BFSNode nodeS = map.get(s);
			
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

	public static void calculateLength(Collection<BFSNode> nodes, int level, int[] distances) {
		List<BFSNode> queue = new ArrayList<BFSNode>();
		for (BFSNode node : nodes) {
			if (distances[node.value - 1] == 0) {
				distances[node.value - 1] = 6 * level;
				if (node.nodes.size() > 0) {
					for (BFSNode child : node.nodes.values()) {
						queue.add(child);
					}
				}
			}
		}

		if (queue.size() > 0) {
			calculateLength(queue, level + 1, distances);
		}
	}

	public static HashMap<Integer, BFSNode> getNodes(int n) {
		HashMap<Integer, BFSNode> nodes = new HashMap<Integer, BFSNode>();
		for (int i = 1; i <= n; i++) {
			nodes.put(i, new BFSNode(i));
		}
		return nodes;
	}
}

class BFSNode {
	int value = 0;
	TreeMap<Integer, BFSNode> nodes = new TreeMap<Integer, BFSNode>();

	BFSNode(int value) {
		this.value = value;
	}

	void bind(BFSNode node) {
		this.nodes.put(node.value, node);
		node.nodes.put(this.value, this);
	}
	
	public String toString() {
		return String.valueOf(this.value);
	}

}