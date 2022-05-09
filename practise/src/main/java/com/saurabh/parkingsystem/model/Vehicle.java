package com.saurabh.parkingsystem.model;

public abstract class Vehicle {
	
	private String vehicleNo;
	private VehicleType vehicleType;
	
	public Vehicle(VehicleType vehicleType, String vehicleNo) {
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	

}
