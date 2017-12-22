package algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class RoadsLibraries {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		List<CityMap> cities = new ArrayList<CityMap>();
		for (int a0 = 0; a0 < q; a0++) {
			CityMap cityMap = new CityMap();
			cityMap.cities = in.nextInt();
			cityMap.roads = in.nextInt();
			cityMap.libPrice = in.nextLong();
			cityMap.roadPrice = in.nextLong();
			cities.add(cityMap);
			if (cityMap.libPrice <= cityMap.roadPrice) {
				cityMap.cost = cityMap.libPrice * cityMap.cities;
				for (int a1 = 0; a1 < cityMap.roads; a1++) {
					in.nextInt();
					in.nextInt();
				}
			} else {
				for (int a1 = 0; a1 < cityMap.roads; a1++) {
					int p1 = in.nextInt();
					int p2 = in.nextInt();
					cityMap.add(p1, p2, a1);
				}
				cityMap.calculateCost();
			}
		}
		for (CityMap city : cities) {
			System.out.println(city.cost);
		}
		in.close();
	}
	

}

class CityMap {
	long cities, roads, zone;
	long libPrice, roadPrice, cost;
	Node root = new Node(null);
	int zoneId;

	void add(int city1, int city2, int zoneId) {
		Node c1 = root.add(city1);
		Node c2 = root.add(city2);
		c1.connect(c2, zoneId);
	}

	void calculateCost() {
		int i = 0;
		HashMap<String, Integer> zones = new HashMap<String, Integer>();
		for (Node node : root.connections.values()) {
			if (i++ == 0 || node.zone == null) {
				node.zone = ++zoneId + "";
				int zoneSize = 1 + browser(node);
				zones.put(node.zone, zoneSize);
			}

		}

		for (Integer size : zones.values()) {
			long costCity = (size - 1) * this.roadPrice;
			this.cost = this.cost + costCity + this.libPrice;
		}

		long remains = (this.cities - this.root.connections.size()) * this.libPrice;
		this.cost = this.cost + remains;

	}

	int browser(Node pai) {
		int zoneZine = 0;
		for (Node current : pai.connections.values()) {
			if (current.zone == null) {
				zoneZine++;
				current.zone = pai.zone;
				zoneZine += browser(current);
			}
		}
		return zoneZine;
	}

}

class Node {
	Integer point = 0;
	TreeMap<Integer, Node> connections = new TreeMap<Integer, Node>();
	String zone;

	Node(Integer point) {
		this.point = point;
	}

	Node add(int point) {
		Node node = this.connections.get(point);
		if (node == null) {
			node = new Node(point);
			this.connections.put(point, node);
		}
		return node;
	}

	void connect(Node c, Integer zoneId) {
		this.connections.put(c.point, c);
		c.connections.put(this.point, this);
	}

	public String toString() {
		return "Point: " + point + " zone : " + zone;
	}

}
