package com.saurabh.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

 public class LRUCache {
	
	int capacity;
	static private Map<Integer, Integer> map = new LinkedHashMap<>();
	private Queue<Integer> q = new ArrayDeque<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		
		if(map.containsKey(key)) {
			
			q.remove(key);
			q.offer(key);
			
			return map.get(key);
		}
		else
			return -1;
	}
	
	public void put(int key, int value) {
		
		if(map.containsKey(key)) {
			
			q.remove(key);
			q.offer(key);
			map.put(key, value);
		}
		
		else {
			if(q.size() >= capacity) {
				
				map.remove(q.poll());
				q.offer(key);
			} else {
				q.offer(key);
			}
			map.put(key, value);
		}
	}
	
	public static void main(String[] args) {
		
		LRUCache lRUCache =  new LRUCache(3);
		lRUCache.put(1, 1);
		lRUCache.put(2, 2);
		lRUCache.put(3, 3);
		System.out.println(map.toString());
		System.out.println(lRUCache.get(1));
		lRUCache.put(4, 4);
		System.out.println(map.toString());
		System.out.println(lRUCache.get(3));
		lRUCache.put(5, 5);
		System.out.println(map.toString());
		System.out.println(lRUCache.get(1));
		System.out.println(lRUCache.get(3));
		System.out.println(lRUCache.get(4));
		
	}

}
