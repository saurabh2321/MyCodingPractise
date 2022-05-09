package com.saurabh.parkingsystem.model;

public class BikeParkingSlot extends ParkingSlot {
	
	public BikeParkingSlot(int slotNumber, boolean availability) {
		this.availability = availability;
		this.slotNumber = slotNumber;
	}

}
