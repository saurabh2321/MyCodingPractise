package com.saurabh.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	
	public Node mergeKLists(Node[] lists) { 
        Comparator<Node> cmp;
        cmp = new Comparator<Node>() {  
        @Override
        public int compare(Node o1, Node o2) {
            // TODO Auto-generated method stub
            return o1.data-o2.data;
        }
        };
 
        Queue<Node> minQueue = new PriorityQueue<Node>(cmp);
        for(Node l : lists){
            if(l!=null){
            	minQueue.add(l);
            }        
        }
        Node head = new Node(0);
        Node current = head;
        
        while(!minQueue.isEmpty()){
            
            current.next = minQueue.poll();
            current = current.next;
            if(current.next != null)
                minQueue.add(current.next);
            
        }
        return head.next;
    }
	

	public static void main(String[] args) {
		
		MergeKSortedLists MergeKSortedLists = new MergeKSortedLists();
		LinkedList list1 = new LinkedList();
		list1.insertNode(3);
		list1.insertNode(2);
		list1.insertNode(1);
		LinkedList list2 = new LinkedList();
		list2.insertNode(4);
		list2.insertNode(3);
		list2.insertNode(1);
		LinkedList list3 = new LinkedList();
		list3.insertNode(5);
		list3.insertNode(4);
		list3.insertNode(2);
		list1.printList(list1.head);
		list2.printList(list2.head);
		list3.printList(list3.head);
		LinkedList list = new LinkedList();
		list.head = MergeKSortedLists.mergeKLists(new Node[] {list1.head, list2.head, list3.head});
		list.printList(list.head);
 
	}

}

