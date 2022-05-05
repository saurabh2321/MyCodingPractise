package com.saurabh.ds;


public class DoublyLinkedList {
		
		private DoublyLinkedNode head;
		

		public void insertAtHead (int data) {
			
			DoublyLinkedNode newNode =  new DoublyLinkedNode(data);
			newNode.next = this.head;
			if(this.head != null) {
				this.head.previous = newNode;
			}
			this.head = newNode;
		}
		
		public void printList(DoublyLinkedNode head) {
			DoublyLinkedNode n = head;
			while (n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
		}
		
		public int length() {
			int length =0;
			DoublyLinkedNode current = head;
			while (current != null) {
				length++;
				current = current.next;
			}
			return length;
		}
		
		
		private class DoublyLinkedNode {
		
		private int data;
		private DoublyLinkedNode next;
		private DoublyLinkedNode previous;
		
		public DoublyLinkedNode(int data) {
			this.data = data;
		}
	}
		
		public static void main(String args[]) {
			DoublyLinkedList list = new DoublyLinkedList();
			list.insertAtHead(10);
			list.insertAtHead(20);
			list.insertAtHead(30);
			System.out.println("size: "+list.length());
			list.printList(list.head);
		}

}
