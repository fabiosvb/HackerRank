package dataStructures.linkedLists;

public class PrintTheElementsLinkedList {
	
	void Print(LLNode head) {
	     if (head != null){
	        System.out.println(head.data);
	        Print(head.next);
	     }
	}
}


class LLNode {
    int data;
    LLNode next;
 }