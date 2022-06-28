package com.saurabh.leetcode;

public class DetectAndRemoveCycle {
	
	public static Node identifyCycle(Node head) {
		
		Node slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				return slow;
			}
		}
		return null;
	}
	
	public static void removeCycle(Node slow, Node head) {
		
		int len =1;
		for(Node cur = head; cur != null; cur = cur.next) {
			
			Node ptr = slow;
			
			while(ptr.next != slow && ptr.next != cur) {
				ptr = ptr.next;
				len++;
			}
			 // If `ptr` meets `curr`, then that means there is a loop, and `curr`
            // points to the first node of the loop and `ptr` points to the last node
			if(ptr.next == cur) {
				ptr.next = null;
				return;
			}
			System.out.println("length of cycle"+ len);
		}
	}
	
	public static Node findMiddle(Node head) {
		Node slow = head, fast = head;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	
	public static void main(String[] args) {
		
		LinkedList list =  new LinkedList();
			for(int i= 5 ;i>0; i-- ) {
				list.insertNode(i);
			}
			list.printList(list.head);
			findMiddle(list.head);
			list.head.next.next.next.next.next = list.head.next;
			Node slow = identifyCycle(list.head);
			if(slow != null) {
				removeCycle(slow, list.head);
			} else {
				System.out.println("no cycle found");
			}
	}

}
