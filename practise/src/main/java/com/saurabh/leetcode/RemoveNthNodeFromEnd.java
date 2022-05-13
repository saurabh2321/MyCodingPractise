package com.saurabh.leetcode;

import java.awt.List;

import com.saurabh.leetcode.FindCommonElementsIn2LinkedList.LinkedList;

public class RemoveNthNodeFromEnd {

	  public static Node removeNthFromEnd(Node head, int n) {
	        
		    Node current = head;
		        for(int i=0; i< n; i++) {
		            current = current.next;
		        }
		        
		        if(current == null)
		            return head.next;
		        
		        Node prevNodeToTheNodeToRemove = head;
		        
		        while(current.next != null) {
		            
		            current = current.next;
		            prevNodeToTheNodeToRemove = prevNodeToTheNodeToRemove.next;
		        }
		        prevNodeToTheNodeToRemove.next = prevNodeToTheNodeToRemove.next.next;
		        return head;
		    }
	 public static void main(String[] args) {
		
	  LinkedList list1 = new LinkedList();
		
		list1.insertNode(5);
		list1.insertNode(4);
		list1.insertNode(3);
		list1.insertNode(2);
		list1.insertNode(1);
		list1.printList(list1.head);
		System.out.println();
		RemoveNthNodeFromEnd RemoveNthNodeFromEnd = new RemoveNthNodeFromEnd();
		Node node = RemoveNthNodeFromEnd.removeNthFromEnd(list1.head, 2);
		list1.printList(node);
	 }
}
