package crackingTheCodingInterview;

import java.util.ArrayList;

public class LinkedLists_DetectCycle {

	boolean hasCycle(LLDCNode head) {
		ArrayList<LLDCNode> list = new ArrayList<LLDCNode>();
		while (head != null) {
			if (list.contains(head)) {
				return true;
			}
			list.add(head);
			head = head.next;	
		}
		return false;

	}
}

class LLDCNode {
    int data;
    LLDCNode next;
}
