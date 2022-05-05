package com.saurabh.ds;

public class BasicLinkedList {

	Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			this.data = d;
			next = null;
		}
	}

	public void printList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	// method to push an element at the front of the linked list
	public void push(int data) {

		Node newNode = new Node(data);

		newNode.next = head;
		head = newNode;
	}

	// method to push an element after a given previous node
	public void insertAfter(Node previousNode, int data) {

		if (previousNode == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = previousNode.next;
		previousNode.next = newNode;

	}
	
	//Appends a new node at the end.
	public void append(int data) {
		
		if(head == null) {
			head = new Node(data);
			return;		
			}
		
		Node newNode = new Node(data);
		newNode.next = null;
		
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		
		last.next = newNode;
		return;
	}
	
	public void insertAt(int position, int data) {

		Node current = head;
		for(int i=0;i<position;i++) {
			current = current.next;
		}
		Node newNode = new Node(data);
		newNode.next = current.next;
		current.next = newNode;

	}
	
	//delete node that has input key
	public void deleteNode (int key) {
		
		Node temp = head;
		Node prev = null;
		
		//if head node itself is the key
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("key not found");
			return;
		}
		
		prev.next = temp.next;
		
	}
	
	//deletes the node at the given position
	public void deleteNodeAt (int position) {
		
		if(head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		
		Node temp = head;
		
		// If head needs to be removed
		if(position == 0) {
			temp.next = head;
			return;
		}
		
		for(int i=0; temp !=null && i<position-1; i++) {
			
			temp = temp.next;
		}
		
		if(temp == null || temp.next == null) {
		
			System.out.println("position is more than number of nodes");
			return;
		}
		
		Node next = temp.next.next;
		temp.next = next;
	}
	
	public Node search(int data) {
		
		Node current =this.head;
		while (current != null) {
			if(current.data == data) {
				return current;
			}
			current= current.next;
		}
				return null;
	}

	public static void main(String args[]) {
		BasicLinkedList list = new BasicLinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		list.head.next = second;
		second.next = third;
		list.printList(list.head);
		System.out.println();
		list.push(4);
		list.printList(list.head);
		System.out.println();
		list.insertAfter(list.head.next, 5);
		list.printList(list.head);
		System.out.println();
		list.insertAt(3, 6);
		list.printList(list.head);
		System.out.println();
		list.deleteNode(5);
		list.printList(list.head);
		System.out.println();
		list.deleteNodeAt(5);
		list.printList(list.head);
		System.out.println();
		list.append(7);
		list.printList(list.head);
		

	}

}
 