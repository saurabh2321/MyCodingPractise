package com.saurabh.test1;

import java.util.List;

public class Reservation {
	
	private  String reservationId;
	
	private final List<ReservationItem> items;
	
	private ReservationStatus status;

	public Reservation(String reservationId, List<ReservationItem> items, ReservationStatus status) {
		super();
		this.reservationId = reservationId;
		this.items = items;
		this.status = status;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public List<ReservationItem> getItems() {
		return items;
	}


	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	
	
	

}
