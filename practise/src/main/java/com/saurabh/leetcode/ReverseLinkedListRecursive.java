package com.saurabh.leetcode;

public class ReverseLinkedListRecursive {
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class LinkedList{
		
		Node head;
		
		public LinkedList() {
			this.head = null;
		}
		
		public void insertNode(int data) {
			Node node = new Node(data);
			if(this.head != null) {
				node.next = head;
			}
				this.head = node;
		}
		
		public static void printList(Node node) {
			while(node != null) {
				System.out.print(node.data+ " ");
				node = node.next;
			}
		}
		
		public static Node reverse(Node head) {
			if(head == null || head.next == null)
				return head;
			Node reverse = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return reverse;
		}
		
		public static void main(String[] args) {
			
			LinkedList llist =  new LinkedList();
			llist.insertNode(20);
			llist.insertNode(4);
            llist.insertNode(15);
            llist.insertNode(85);
            System.out.println("Given linked list:"); 
           printList(llist.head);
           System.out.println();
           System.out.println("Reversed Linked list:");
           Node reverselist = reverse(llist.head);
           printList(reverselist);
		}
	}

}
