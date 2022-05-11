package com.saurabh.leetcode;

public class ReverseLinkedListRecursive {
	
	
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
			
			/*if(head == null || head.next == null)
				return head;
			Node reverse = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return reverse;
			*/
			//with using 2 pointers
			Node prev = null;
			Node curr = head;
		        
		        while(curr != null) {
		        	Node temp = curr.next;
		            curr.next = prev;
		            prev = curr;
		            curr = temp;
		        }
		        return prev;
		}
		
		public static void main(String[] args) {
			
			LinkedList llist =  new LinkedList();
			llist.insertNode(3);
			llist.insertNode(2);
            llist.insertNode(1);
            //llist.insertNode(85);
            System.out.println("Given linked list:"); 
           printList(llist.head);
           System.out.println();
           System.out.println("Reversed Linked list:");
           Node reverselist = reverse(llist.head);
           printList(reverselist);
		}
	}

}
