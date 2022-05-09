package com.saurabh.parkingsystem.model;

public abstract class ParkingSlot {

	int slotNumber;
	boolean availability;
	
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	
}
