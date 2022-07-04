package com.saurabh.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LRUCacheDList {
	
	   int capacity;
	    DoublyListNode head = new DoublyListNode(-1, -1);
	    DoublyListNode tail = new DoublyListNode(-1, -1);
	    static Map<Integer, DoublyListNode> map = new HashMap<>();
	    
	    public LRUCacheDList(int capacity){
	        this.capacity = capacity;
	        join(head, tail);
	    }
	    
	    public int get(int key) {
	        
	        if(!map.containsKey(key)){
	            return -1;
	        }
	        DoublyListNode node = map.get(key);
	        
	        remove(node);
	        moveToHead(node);
	        return node.value;
	        
	    }
	    
	    public void put(int key, int value) {
	       if(map.containsKey(key)){ 
	           
	            DoublyListNode node = map.get(key); 
	           node.value = value;
	           remove(node);
	           moveToHead(node);
	           
	       }
	        else{
	            if(map.size() >= capacity){
	                if(tail.prev != head){
	                    map.remove(tail.prev.key);
	                    remove(tail.prev);
	                }
	            }
	            
	            DoublyListNode node = new DoublyListNode(key, value);
	            moveToHead(node);
	            map.put(key, node);
	        }
	    }
	    
	    public void join(DoublyListNode n1, DoublyListNode n2){
	        n1.next = n2;
	        n2.prev = n1;
	    }
	    
	    public void remove(DoublyListNode node){
	        
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }
	    
	    public void moveToHead(DoublyListNode node){
	        
	        DoublyListNode next = head.next;
	        join(head, node);
	        join(node, next);
	    }
	    
	    class DoublyListNode {
	        
	        DoublyListNode prev;
	        DoublyListNode next;
	        int key;
	        int value;
	        
	        public DoublyListNode(int key, int value){
	            this.key = key;
	            this.value = value;
	        }
	    }
	    
	    public static void main(String[] args) {
			LRUCacheDList cache = new LRUCacheDList(2);
			cache.put(1, 1);
			cache.put(2, 2);
			cache.put(3, 3);
			System.out.println(cache.map.values().stream().map(s -> s.key).collect(Collectors.toList()));
		}

}
