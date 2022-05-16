package com.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RoomsAndKeys {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited= new HashSet<>();
        visited.add(0);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        while(!st.isEmpty()){
            List<Integer> keys= rooms.get(st.pop());
            for(int key:keys){
                if(!visited.contains(key)){
                    visited.add(key);
                    st.add(key);
                }
            }
        }
        return visited.size()==rooms.size();
    }
	
	public static void main(String[] args) {
		
		RoomsAndKeys RoomsAndKeys = new RoomsAndKeys();
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(1,3));
		lists.add(Arrays.asList(3,0,1));
		lists.add(Arrays.asList(2,3));
		lists.add(Arrays.asList(2));
		System.out.println(RoomsAndKeys.canVisitAllRooms(lists));
		
	}

}
