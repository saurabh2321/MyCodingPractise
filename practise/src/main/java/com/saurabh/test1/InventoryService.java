package com.saurabh.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
	
	private final Map<String, Product> products = new ConcurrentHashMap<>();
	private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();
	
	public void addProduct(String productId, int stock) {
		
		products.put(productId, new Product(productId, stock));
			
		}
	
	public void removeProduct(String productId){
		
		products.remove(productId);
		
	}
	
	public synchronized String reserve(Map<String,Integer> requestedItems ) {
		
		List<ReservationItem> reservationItems = new ArrayList<>();
		
		for(Map.Entry<String, Integer> entry : requestedItems.entrySet()) {
			
			Product product = products.get(entry.getKey());
			if(product == null) {
				System.out.println("Product not available" + product);
				return null;
			}
			if(product.getAvailableStock() < entry.getValue()) {
				System.out.println("requested is more than available stock" + product.getAvailableStock());
				return null;
			}
			product.reserve(entry.getValue());
			reservationItems.add(new ReservationItem(entry.getKey(), entry.getValue()));
		}
		
		String reservationId = UUID.randomUUID().toString();
		Reservation reservation = new Reservation(reservationId, reservationItems, ReservationStatus.RESERVED);
		reservations.put(reservationId, reservation);
		
		
		return reservationId;
	}
	
	public synchronized void confirm(String reservationId) {
		if(reservationId != null) { 
		Reservation reservation = reservations.getOrDefault(reservationId, null);
		
		if(reservation == null) {
			System.out.println("Invalid reservation" + reservationId);
			return;
		}
		for(ReservationItem item : reservation.getItems()) {
			
			Product product = products.get(item.getProductId());
			
			product.deduct(item.getQuantity());
		}
		reservation.setStatus(ReservationStatus.CONFIRMED);	
		System.out.println("order confirmed for Product and qty " + reservationId);
		}
		
	}
	
	public synchronized void cancel(String reservationId) {
		
		if(reservationId != null) { 
			
		
		Reservation reservation = reservations.get(reservationId);
		
		if(reservation == null) {
			System.out.println("Invalid reservation" + reservationId);
			return;
		}
		for(ReservationItem item : reservation.getItems()) {
			
			Product product = products.get(item.getProductId());
			
			product.release(item.getQuantity());
		}
		reservation.setStatus(ReservationStatus.CANCELLED);	
		}
		
	}
	
	public void getInventory() {
		for(Product product : products.values()) {
			System.out.println(product);
		}
	}
	
	
	
	
	
	

}
