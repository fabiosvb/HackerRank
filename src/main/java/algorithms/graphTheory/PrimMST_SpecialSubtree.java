package algorithms.graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class PrimMST_SpecialSubtree {

		public static HashMap<Integer, PVertex> getVertices(int n){
			HashMap<Integer, PVertex>  map = new HashMap<Integer,PVertex>();
			for (int i = 1; i <= n; i++){
				map.put(i, new PVertex(i));
			}
			return map;
		}
		
		public static PEdge bind(HashMap<String, PEdge> mapEdges, PVertex v1, PVertex v2, int length){
			String id = PEdge.toId(v1.value, v2.value);
			PEdge edge = mapEdges.get(id);
			if (edge == null){
				edge = new PEdge(v1, v2, length);
				mapEdges.put(id, edge);
			}else if (edge.length > length){
				edge.length = length;
			}
			return edge;	
		}
		
		public static void main (String[] arg) throws IOException{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String[] line = in.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			
			HashMap<Integer, PVertex> mapVerices = getVertices(n);
			HashMap<String, PEdge> mapPEdges = new HashMap<String, PEdge>();
			
			for (int i = 0; i < m; i++){
				line = in.readLine().split(" ");
				int v1 = Integer.parseInt(line[0]);
				int v2 = Integer.parseInt(line[1]);
				int length = Integer.parseInt(line[2]);
				PVertex vertex1 = mapVerices.get(v1);
				PVertex vertex2 = mapVerices.get(v2);
				bind(mapPEdges, vertex1, vertex2, length);
			}
			int s = Integer.parseInt(in.readLine());
			
			PVertex start = mapVerices.get(s);
			
			HashSet<Integer> visitedVertcies = new HashSet<Integer>();
			visitedVertcies.add(start.value);
			
			TreeSet<Direction> directions = Direction.toDirection(start);
			
			int length = processPrimMST(visitedVertcies, directions,  mapVerices.size());
			
			System.out.println(length);
			
			in.close();
		}
		
		
		public static int processPrimMST(HashSet<Integer> visitedVertcies, TreeSet<Direction> directions, int n){
			int length = 0;
			while (visitedVertcies.size() < n){
				Iterator<Direction> it = directions.iterator();
				TreeSet<Direction> newDirections = null;
				if (it.hasNext()){
					Direction dir = it.next();
					if (!visitedVertcies.contains(dir.v2.value)){
						dir.edge.checked = true;
						length = length + dir.edge.length;
						visitedVertcies.add(dir.v2.value);
						newDirections = Direction.toDirection(dir.v2);
					}
					it.remove();
				}
				if (newDirections != null) {
					directions.addAll(newDirections);
				}
			}
			return length;
		}
	}

	class Direction{
		PVertex v1 = null;
		PVertex v2 = null;
		PEdge edge = null;
		
		public static TreeSet<Direction> toDirection(PVertex v){
			TreeSet<Direction> directions = new TreeSet<Direction>(new DirectionComparator());
			for (PEdge edge : v.edges){
				Direction direction = new Direction();
				direction.v1 = v;
				direction.v2 = edge.v1 == v ? edge.v2 : edge.v1;
				direction.edge = edge;
				directions.add(direction);
			}
			return directions;
		}
	}

	class PEdge {
		int length = 0;
		PVertex v1 = null;
		PVertex v2 = null;
		boolean checked = false;
		
		PEdge(PVertex v1, PVertex v2, int length) {
			this.v1 = v1.value < v2.value ? v1 : v2;
			this.v2 = v1.value < v2.value ? v2 : v1;

			this.length = length;
			v1.edges.add(this);
			v2.edges.add(this);
		}

		static String toId(int v1, int v2) {
			int a = v1 < v2 ? v1 : v2;
			int b = v1 < v2 ? v2 : v1;
			return new StringBuilder().append(a).append("_").append(b).toString();
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("v").append(v1.value).append(" -> v").append(v2.value).append(" length: ").append(length);
			return s.toString();
		}

	}

	class PVertex {
		int value;
		TreeSet<PEdge> edges = new TreeSet<PEdge>(new PEdgeComparator());

		PVertex(int value) {
			this.value = value;
		}
		
		public String toString() {
			return "value: " + this.value;
		}

	}

	class PEdgeComparator implements Comparator<PEdge>{
		
		public int compare(PEdge e1, PEdge e2){
			return PEdgeComparator._compare(e1,e2);
		}
		
		public static int _compare(PEdge e1, PEdge e2){
			int comp = Integer.compare(e1.length, e2.length);
			if (comp == 0){
				comp = -1;
			}
			return comp;
		}
	}

	class DirectionComparator implements Comparator<Direction>{
		
		public int compare(Direction e1, Direction e2){
			return  PEdgeComparator._compare(e1.edge,e2.edge);
		}
	}