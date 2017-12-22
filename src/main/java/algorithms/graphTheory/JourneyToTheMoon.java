package algorithms.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class JourneyToTheMoon {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = in.nextInt();
		int a, b;

		JMNode root = new JMNode();
		for (int i = 0; i < p; i++) {
			a = in.nextInt();
			b = in.nextInt();
			root.add(a, b);
		}
		long timeId = 0;
		// long numPeople = 0;
		long timeSize = 0;
		List<Long> listTimesSize = new ArrayList<Long>();
		for (JMNode current : root.astronauts.values()) {
			if (current.timeId == 0) {
				current.timeId = ++timeId;
				timeSize = 1;
				if (current.astronauts.size() > 0) {
					timeSize = 1 + processGraph(current, new HashSet<Long>());
				}
				listTimesSize.add(timeSize);
				// numPeople+=timeSize;
			}
		}
		long ungroupedPeople = n - root.astronauts.values().size();


		long combination = 0;
		long val1, val2;
		for (int i = 0; i < listTimesSize.size() - 1 + ungroupedPeople; i++) {
			val1 = i < listTimesSize.size() ? listTimesSize.get(i) : 1;
			for (int j = i + 1; j < listTimesSize.size() + ungroupedPeople; j++) {
				val2 = j < listTimesSize.size() ? listTimesSize.get(j) : 1;
				combination = combination + (val1 * val2);
			}

		}

		System.out.println(combination);
		in.close();
	}

	static long processGraph(JMNode node, HashSet<Long> visited) {
		long sizeTime = 0;
		visited.add(node.astronautId);
		for (JMNode current : node.astronauts.values()) {
			if (!visited.contains(current.astronautId)) {
				sizeTime++;
				current.timeId = node.timeId;
				if (current.astronauts.size() > 0) {
					sizeTime += processGraph(current, visited);
				}
			}
		}
		return sizeTime;
	}

}

class JMNode {
	long astronautId = 0;
	HashMap<Long, JMNode> astronauts = new HashMap<Long, JMNode>();
	long timeId;

	JMNode() {

	}

	JMNode(long astronautId) {
		this.astronautId = astronautId;
	}

	void add(long a, long b) {
		JMNode a1 = getNode(a);
		JMNode a2 = getNode(b);
		a1.astronauts.put(a2.astronautId, a2);
		a2.astronauts.put(a1.astronautId, a1);
	}

	JMNode getNode(long id) {
		JMNode node = this.astronauts.get(id);
		if (node == null) {
			node = new JMNode(id);
			this.astronauts.put(id, node);
		}
		return node;
	}

}