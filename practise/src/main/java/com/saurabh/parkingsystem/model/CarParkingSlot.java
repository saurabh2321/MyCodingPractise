package com.saurabh.parkingsystem.model;

public class CarParkingSlot extends ParkingSlot {
	
	public CarParkingSlot(int slotNumber, boolean availability) {
		this.availability = availability;
		this.slotNumber = slotNumber;
	}

}
