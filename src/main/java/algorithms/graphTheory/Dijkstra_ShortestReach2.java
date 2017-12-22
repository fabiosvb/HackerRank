package algorithms.graphTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra_ShortestReach2 {
	public static final String BLANK = " ";
	public static final String SEPARATOR = "_";

	public static HashMap<Integer, Vertex> getVerteces(int n) {
		HashMap<Integer, Vertex> map = new HashMap<Integer, Vertex>(n);
		for (int i = 1; i <= n; i++) {
			map.put(i, new Vertex(i));
		}
		return map;
	}

	public static void main(String[] arg) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String[] line = in.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			HashMap<Integer, Vertex> mapVertex = getVerteces(n);
			HashMap<String, Edge> mapEdge = new HashMap<String, Edge>(m);

			Vertex v1;
			Vertex v2;
			int length;
			String edgeId;
			Edge edge;
			for (int j = 0; j < m; j++) {
				line = in.readLine().split(" ");
				v1 = mapVertex.get(Integer.parseInt(line[0]));
				v2 = mapVertex.get(Integer.parseInt(line[1]));
				length = Integer.parseInt(line[2]);
				edgeId = Edge.toId(v1.value, v2.value);
				edge = mapEdge.get(edgeId);
				if (edge == null) {
					edge = new Edge(v1, v2, length);
					mapEdge.put(edgeId, edge);
				} else if (edge.length > length) {
					edge.length = length;
				}
			}
			int s = Integer.parseInt(in.readLine());

			Vertex start = mapVertex.get(s);
			start.prevVertexLength = 0;

			// List<Vertex> vertices = new ArrayList<Vertex>(1);
			// vertices.add(start);

			calculate(start);

			builder.append(print(mapVertex, s, n));

		}
		System.out.println(builder.toString());
		in.close();
	}

	public static void calculate(Vertex vertex) {
		// List<Vertex> queue = new ArrayList<Vertex>();
		Vertex v1;
		Vertex v2;
		int length;
		Edge edge;
		// for (int i = 0; i < vertices.size(); i++){
		v1 = vertex;
		if (v1.edges != null) {
			for (int j = 0; j < v1.edges.size(); j++) {
				edge = v1.edges.get(j);
				v2 = v1 == edge.v1 ? edge.v2 : edge.v1;
				length = edge.length + v1.prevVertexLength;
				if (length < v2.prevVertexLength) {
					v2.prevVertexLength = length;
					v2.prevVertexValue = v1.value;
					if (v2.edges.size() > 1) {
						// queue.add(v2);
						calculate(v2);
					}
				}
			}
		}
		// }
		// if (queue.size() > 0){
		// calculate(queue);
		// }
	}

	public static String print(HashMap<Integer, Vertex> map, int s, int n) {
		StringBuilder string = new StringBuilder();
		Vertex v;
		long value;

		for (int i = 1; i <= n; i++) {
			if (i != s) {
				v = map.get(i);
				value = v.prevVertexValue == 0 ? -1 : v.prevVertexLength;
				string.append(value).append(Dijkstra_ShortestReach2.BLANK);
			}
		}
		return string.toString().trim() + "\n";
	}
}

class Edge {
	int length = 0;
	Vertex v1 = null;
	Vertex v2 = null;

	Edge(Vertex v1, Vertex v2, int length) {
		this.v1 = v1.value < v2.value ? v1 : v2;
		this.v2 = v1.value < v2.value ? v2 : v1;

		this.length = length;
		v1.edges.add(this);
		v2.edges.add(this);
	}

	static String toId(int v1, int v2) {
		int a = v1 < v2 ? v1 : v2;
		int b = v1 < v2 ? v2 : v1;
		return new StringBuilder().append(a).append(Dijkstra_ShortestReach2.SEPARATOR).append(b).toString();
	}

}

class Vertex {
	int value;
	ArrayList<Edge> edges = new ArrayList<Edge>();

	int prevVertexValue = 0;
	int prevVertexLength = Integer.MAX_VALUE;

	Vertex(int value) {
		this.value = value;
	}

}
