package com.saurabh.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsIn2LinkedList {

	static class LinkedList {

		Node head;

		LinkedList() {
			this.head = null;
		}

		public void insertNode(int data) {

			Node node = new Node(data);
			if (this.head != null) {

				node.next = head;
			}
			this.head = node;
		}
		
		public void printList(Node node) {
			 while(node != null) {
				 System.out.print(node.data+ " ");
				 node = node.next;
			 }
		}

		public static Node findCommon(Node head1, Node head2) {

			Set<Integer> seen = new HashSet<>();

			while (head1 != null) {
				if (!seen.contains(head1.data))
					seen.add(head1.data);
				head1 = head1.next;
			}
			Node node = new Node();
			Node head = node;
			while (head2 != null) {
				if (seen.contains(head2.data)) {
					node.next = head2;
					node = node.next;
				}
				head2 = head2.next;
			}
			return head.next;
		}
		
		public static void main(String[] args) {
			
			LinkedList list1 = new LinkedList();
			LinkedList list2 = new LinkedList();
			
			list1.insertNode(4);
			list1.insertNode(3);
			list1.insertNode(3);
			list1.insertNode(2);
			list1.insertNode(1);
			
			list2.insertNode(4);
			list2.insertNode(7);
			list2.insertNode(6);
			list2.insertNode(3);
			list2.insertNode(1);
			
			list1.printList(list1.head);
			System.out.println();
			list2.printList(list2.head);
			System.out.println();
			list1.printList(findCommon(list1.head, list2.head));
			
		}
	}
}
