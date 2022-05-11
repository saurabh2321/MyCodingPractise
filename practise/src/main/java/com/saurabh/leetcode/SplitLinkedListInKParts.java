package com.saurabh.leetcode;

public class SplitLinkedListInKParts {
	
	static class SplitLinkedList{
		
		Node head;
		
		public SplitLinkedList() {
			this.head = null;
		}
		
		public void insertNode(int data) {
			
			Node node = new Node(data);
			if(this.head != null) {
				
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
		
		public static Node[] splitListToParts(Node root, int k) {
			
			Node cur = root;
			int N=0;
			while(cur != null) {
				cur = cur.next;
				N++;
			}
			
			int width = N/k, rem = N%k;
			
			Node[] output = new Node[k];
			cur = root;
			
			for(int i=0; i<k;i++) {
				Node head = new Node(0), write = head;
				
				for(int j=0; j< width+ (i<rem ? 1:0); j++) {
					write =  write.next = new Node(cur.data);
					if(cur != null)
						cur = cur.next;
				}
				output[i] = head.next;
			}
			return output;
		}
		
		public static void main(String[] args) {
			
			SplitLinkedList llist = new SplitLinkedList();
			llist.insertNode(8);
			llist.insertNode(7);
			llist.insertNode(6);
			llist.insertNode(5);
            llist.insertNode(4);
			llist.insertNode(3);
			llist.insertNode(2);
            llist.insertNode(1);
            llist.printList(llist.head);
            System.out.println("after split");
          Node [] ans = splitListToParts(llist.head, 3);
          for(Node node : ans) {
        	  llist.printList(node);
        	  System.out.println();
          }
			
		}
	}

}
