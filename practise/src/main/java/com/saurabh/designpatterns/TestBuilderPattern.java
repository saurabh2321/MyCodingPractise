package com.saurabh.designpatterns;

import java.util.List;

public class TestBuilderPattern  {
	
	public static void main(String[] args) {

		Computer computer = new Computer.ComputerBuilder("4gb", "500gb").setIsBluetoothEnabled(true).setIsGraphicsEnabled(true).build();
	}

}
