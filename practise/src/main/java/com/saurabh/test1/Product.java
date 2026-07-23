package com.saurabh.test1;

public class Product {
	
	private final String productId;
	private int totalStock;
	private int reservedStock;
	
	public Product(String productId, int totalStock) {
		super();
		this.productId = productId;
		this.totalStock = totalStock;
	}
	
	public String getProductId() {
		return productId;
	}

	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
	public int getReservedStock() {
		return reservedStock;
	}
	public void setReservedStock(int reservedStock) {
		this.reservedStock = reservedStock;
	}
	public int getAvailableStock() {
		return totalStock - reservedStock;
	}
	public void reserve(int qty) {
		reservedStock = reservedStock + qty;
	}
	public void release(int qty) {
		reservedStock = reservedStock - qty;
	}
	
	public void deduct(int qty) {
		reservedStock = reservedStock - qty;
		totalStock = totalStock - qty;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", totalStock=" + totalStock + ", reservedStock=" + reservedStock
				+ "]";
	}
	
	
	
	

}
