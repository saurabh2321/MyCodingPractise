package com.saurabh.leetcode;

import com.saurabh.leetcode.FindCommonElementsIn2LinkedList.LinkedList;

public  class ReorderKLinkedList {
	
    public static Node reorderList(Node head) {
        
        if(head == null)
        return null;
        
         //find middle element
        Node slow= head, fast = head;
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse second half
        Node prev = null, curr = slow, tmp;
        
        while(curr != null) {
            
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        //merge two sorted list
        
        Node first = head, second = prev;
        
        while(second.next != null){
            
            tmp = first.next;
            first.next = second;
            first = tmp;
            
            tmp = second.next;
            second.next = first;
            second = tmp;
        }
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
  		ReorderKLinkedList ReorderKLinkedList = new ReorderKLinkedList();
  		Node node = ReorderKLinkedList.reorderList(list1.head);
  		list1.printList(node);
  	 }

}
