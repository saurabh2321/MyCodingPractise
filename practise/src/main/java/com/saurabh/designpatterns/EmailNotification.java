package com.saurabh.designpatterns;

public class EmailNotification implements Notification {
	
	@Override
	public void notifyUser() {
		System.out.println("sending an Email notification");
	}
}
