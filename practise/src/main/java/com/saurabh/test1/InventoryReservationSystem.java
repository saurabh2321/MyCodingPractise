package com.saurabh.test1;

import java.util.HashMap;
import java.util.Map;

public class InventoryReservationSystem {
	
	public static void main(String args[]) {
		
		InventoryService inventory = new InventoryService();
		
		inventory.addProduct("A", 10);
		inventory.addProduct("B", 15);
		
		Map<String, Integer> order1 = new HashMap<>();
		order1.put("A", 4);
		
		String reservation1 = inventory.reserve(order1);
		System.out.println("oreder 1 reserved");
		inventory.getInventory();
		
		Map<String, Integer> order2 = new HashMap<>();
		order2.put("B", 20);
		
		Map<String, Integer> order3 = new HashMap<>();
		order3.put("B", 10);
		
		String reservation2 = inventory.reserve(order2);
		System.out.println("oreder 2 reserved");
		String reservation3 = inventory.reserve(order3);
		System.out.println("oreder 3 reserved");

		inventory.confirm(reservation2);
		inventory.getInventory();
		
		inventory.cancel(reservation1);
		System.out.println("oreder 1 cancelled");
		inventory.confirm(reservation3);
		System.out.println("oreder 3 confirmed");

		
		
		System.out.println("------------------");
		inventory.getInventory();
		
		
		
		
		
		
		
		
		
	}

}
