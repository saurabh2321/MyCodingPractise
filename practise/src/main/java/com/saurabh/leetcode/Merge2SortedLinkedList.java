package com.saurabh.leetcode;

public class Merge2SortedLinkedList {

	public static Node merge2sortedlists(Node list1, Node list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		if (list1.data < list2.data) {
			list1.next = merge2sortedlists(list1.next, list2);
			return list1;
		} else {
			list2.next = merge2sortedlists(list2.next, list1);
			return list2;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		for(int i= 4 ;i>0; i-- ) {
			list1.insertNode(i);
		}
		for(int i= 6 ;i>2; i-- ) {
			list2.insertNode(i);
		}
		
		list1.printList(list1.head);
		list2.printList(list2.head);
		System.out.println("");
		Node node = merge2sortedlists(list1.head, list2.head);
		list1.printList(node);
		
	}

}
