package com.saurabh.designpatterns;

// now the captain can use the fishing boat to escape
public class AdapterPatternTest {

	public static void main(String[] args) {

		Captain captain  = new Captain(new FishingBoatAdapter());
		captain.row();
	}

}
