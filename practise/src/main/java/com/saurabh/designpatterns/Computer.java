package com.saurabh.designpatterns;

public class Computer {
	
	//required
	private String hdd;
	private String ram;
	
	//optional
	private boolean isBluetoothEnabled;
	private boolean isGraphicsEnabled;
	
	public String getHdd() {
		return hdd;
	}
	public String getRam() {
		return ram;
	}
	public boolean getIsBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	public boolean getIsGraphicsEnabled() {
		return isGraphicsEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.hdd = builder.hdd;
		this.ram = builder.ram;
		this.isBluetoothEnabled = builder.isBluetoothEnabled;
		this.isGraphicsEnabled  = builder.isGraphicsEnabled;
	}
	
	public static class ComputerBuilder{
		//required
		private String hdd;
		private String ram;
		
		//optional
		private boolean isBluetoothEnabled;
		private boolean isGraphicsEnabled;
		
		public ComputerBuilder(String ram, String hdd) {
			this.ram = ram;
			this.hdd = hdd;
		}
		
		public ComputerBuilder setIsBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		public ComputerBuilder setIsGraphicsEnabled(boolean isGraphicsEnabled) {
			this.isGraphicsEnabled = isGraphicsEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}
}
