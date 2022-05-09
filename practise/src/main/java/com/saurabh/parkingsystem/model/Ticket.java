package com.saurabh.parkingsystem.model;

import java.sql.Date;

public class Ticket {
	
	private int slotNumber;
	private long startTime;
	private Date date;
	private Vehicle vehicle;
	
	public Ticket(int slotNumber, long startTime, Date date, Vehicle vehicle) {
		this.slotNumber = slotNumber;
		this.date =date;
		this.startTime = startTime;
		this.vehicle = vehicle;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
