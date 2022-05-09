package com.saurabh.parkingsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.saurabh.parkingsystem.model.BikeParkingSlot;
import com.saurabh.parkingsystem.model.CarParkingSlot;

public class ParkingLot {
	
	private String name;
	private List<BikeParkingSlot> bikeParkingSlots;
	private List<CarParkingSlot> carParkingSlots;
	
	public ParkingLot(String name) {
		this.name = name;
		bikeParkingSlots = new ArrayList<>();
		carParkingSlots = new ArrayList<>();
	}
	
	public List<CarParkingSlot> getCarParkingSlots(int slots){
		
		for(int i= 1; i<=slots;i++) {
			CarParkingSlot carParkingSlot = new CarParkingSlot(i, true);
			carParkingSlots.add(carParkingSlot);
		}
		return carParkingSlots;
	}
	
public List<BikeParkingSlot> getBikeParkingSlots(int slots){
		
		for(int i= 1; i<=slots;i++) {
			BikeParkingSlot bikeParkingSlot = new BikeParkingSlot(i, true);
			bikeParkingSlots.add(bikeParkingSlot);
		}
		return bikeParkingSlots;
	}
	

}
