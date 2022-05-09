package com.saurabh.parkingsystem;

import com.saurabh.parkingsystem.model.Car;
import com.saurabh.parkingsystem.model.ParkingLotCapacity;
import com.saurabh.parkingsystem.model.Ticket;
import com.saurabh.parkingsystem.model.Vehicle;
import com.saurabh.parkingsystem.service.ParkingService;

public class ParkingSystemApplication {

	public static void main(String[] args) throws InterruptedException {
		
		ParkingService service = new ParkingService();
		ParkingLotCapacity capacity = new ParkingLotCapacity();
		capacity.setBikeCapacity(40);
		capacity.setCarCapacity(20);
		service.createParkingLot(capacity, "B");
		Vehicle vehicle =  new Car("UP 32 345");
		Ticket ticket = service.park(vehicle);
		Thread.sleep(10000);
		System.out.println(service.exit(ticket));
	}
}
