package crackingTheCodingInterview;

import java.util.Comparator;

public class Sorting_Comparator implements Comparator<Player>{
	public int compare(Player p1, Player p2) {
		int comp = Integer.compare(p2.score, p1.score);
		if (comp == 0) {
			comp = p1.name.compareTo(p2.name);
		}
		return comp;
	}
}

class Player{
	int score;
	String name;
}
