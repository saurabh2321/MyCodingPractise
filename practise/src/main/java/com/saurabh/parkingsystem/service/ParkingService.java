package com.saurabh.parkingsystem.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.saurabh.parkingsystem.model.Bike;
import com.saurabh.parkingsystem.model.BikeParkingSlot;
import com.saurabh.parkingsystem.model.Car;
import com.saurabh.parkingsystem.model.CarParkingSlot;
import com.saurabh.parkingsystem.model.ParkingLotCapacity;
import com.saurabh.parkingsystem.model.ParkingSlot;
import com.saurabh.parkingsystem.model.Ticket;
import com.saurabh.parkingsystem.model.Vehicle;
import com.saurabh.parkingsystem.model.VehicleType;

public class ParkingService {

	private List<BikeParkingSlot> bikeParkingSlots;
	private List<CarParkingSlot> carParkingSlots;
	private Date date;
	List<Ticket> tickets = null;
	private static final int minimumTime = 60;
	private static final double fee = 20;
	
	public void createParkingLot(ParkingLotCapacity parkingLotCapacity, String name) {
		
		ParkingLot parkingLot = new ParkingLot(name);
		tickets = new ArrayList<>();
		
		carParkingSlots = parkingLot.getCarParkingSlots(parkingLotCapacity.getCarCapacity());
		bikeParkingSlots = parkingLot.getBikeParkingSlots(parkingLotCapacity.getBikeCapacity());
		
	}
	
	public Ticket park(Vehicle vehicle) {
		
		ParkingSlot parkingSlot = null;
		
		if(vehicle instanceof Car) {
			parkingSlot = checkAvailabiltyCar(vehicle);
		} else if(vehicle instanceof Bike) {
			parkingSlot = checkAvailabiltyBike(vehicle);
		}
		
		if(parkingSlot != null) {
			long startTimeMilliseconds =  System.currentTimeMillis();
			
			Ticket ticket = new Ticket(parkingSlot.getSlotNumber(), startTimeMilliseconds, date, vehicle);
			tickets.add(ticket);
			parkingSlot.setAvailability(false);
			return ticket;
		}
		else {
			System.out.println("There is no Space available right now in this parking lot");
		}
		return null;
	}
	
	public synchronized CarParkingSlot checkAvailabiltyCar(Vehicle vehicle) {
		
		for(int i =0; i< carParkingSlots.size(); i++) {
			CarParkingSlot carParkingSlot = carParkingSlots.get(i);
			if(carParkingSlot.getAvailability() == true) {
				return carParkingSlot;
			}
		}
		return null;
	}
	
	public synchronized BikeParkingSlot checkAvailabiltyBike(Vehicle vehicle) {
		
		for(int i =0; i< bikeParkingSlots.size(); i++) {
			BikeParkingSlot bikeParkingSlot = bikeParkingSlots.get(i);
			if(bikeParkingSlot.getAvailability() == true) {
				return bikeParkingSlot;
			}
		}
		return null;
	}
	
	public double exit(Ticket ticket) {
		validateTicketNbr(ticket.getSlotNumber());
		long timeParked = calculateTotalMinutes(ticket);
		double amount = getTotalFee(timeParked);
		makeSlotAvailable(ticket);
		return amount;
	}
	
	public boolean validateTicketNbr(int ticketNbrEntered) {
		 boolean isValid = false;
		 
		 for(int i = 0; i< tickets.size(); i++) {
			 int slotNumber = tickets.get(i).getSlotNumber();
			 
			 if(ticketNbrEntered == slotNumber) {
				 isValid = true;
				 break;
			 }
		 }
		 return isValid;
	}
	
	private long calculateTotalMinutes(Ticket ticket) {
		long endTimeMilliseconds = System.currentTimeMillis();
		long durationMilliseconds = endTimeMilliseconds - ticket.getStartTime();
		String durationParked =  convertTimeFormat(durationMilliseconds);
		String[] time = durationParked.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);
		return (hours * 60) + minutes + (seconds/60);
	}
	
	private String convertTimeFormat(long durationMilliseconds) {
		long totalSeconds = durationMilliseconds/1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds/60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes/60;
		long currentHour = totalHours % 24;
		return currentHour + ":" + currentMinute + ":" + currentSecond;
	}

	private double getTotalFee(long timeInMinutes) {
		double totalFee = 0;
		if(timeInMinutes < 60)
			totalFee =30;
		else{
			totalFee = (timeInMinutes / minimumTime) * fee;
		}
		return totalFee;
	}
	private void makeSlotAvailable(Ticket ticket) {
		
		if(ticket.getVehicle().getVehicleType() == VehicleType.CAR) {
			for(CarParkingSlot carParkingSlot: carParkingSlots) {
				int slotNumber = carParkingSlot.getSlotNumber();
				
				if(ticket.getSlotNumber() == slotNumber) {
					carParkingSlot.setAvailability(true);
				}
			}
		} else {
			for(BikeParkingSlot bikeParkingSlot: bikeParkingSlots) {
				int slotNumber = bikeParkingSlot.getSlotNumber();
				
				if(ticket.getSlotNumber() == slotNumber) {
					bikeParkingSlot.setAvailability(true);
				}
			}
		}
	}
	
}
