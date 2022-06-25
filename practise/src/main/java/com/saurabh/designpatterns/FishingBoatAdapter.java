package com.saurabh.designpatterns;

//now lets say pirates are coming and our captain needs to escape but there is only fishing boat avaialable
//We need to create an adapter that allows the captain to operate the fishing boat with his rowing boat skills
public class FishingBoatAdapter implements RowingBoat {

	private FishingBoat fishingBoat;
	
	public FishingBoatAdapter() {
		fishingBoat = new FishingBoat();
	}
	@Override
	public void row() {
		fishingBoat.sail();
	}
}
