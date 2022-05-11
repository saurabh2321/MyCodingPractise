package com.saurabh.leetcode;

public class LinkedList {

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
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

}
