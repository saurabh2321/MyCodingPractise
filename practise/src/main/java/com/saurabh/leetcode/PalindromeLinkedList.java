package com.saurabh.leetcode;

import com.saurabh.leetcode.FindCommonElementsIn2LinkedList.LinkedList;

public class PalindromeLinkedList {
	
	public static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) { //odd nodes
			slow = slow.next;
		}
		
		slow = reverse(slow);
		fast = head;
		
		while(slow != null) {
			if(fast.data != slow.data)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	public static Node reverse(Node head) {
		
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
		
		LinkedList list = new LinkedList();
		
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(3);
		list.insertNode(2);
		list.insertNode(1);
		System.out.println(isPalindrome(list.head));
	}

}
