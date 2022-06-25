package com.saurabh.designpatterns;
//consider a captain that can only use rowing boat and cannot sail
// a captain expects an implementation of rowing boat interface to be able to move
public class Captain {

	private RowingBoat rowingBoat;
	
	public Captain( RowingBoat rowingBoat) {
		this.rowingBoat = rowingBoat;
	}
	public void row() {
		rowingBoat.row();
	}
}
