package com.saurabh.designpatterns;

public class SMSNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("sending an SMS notification");
	}
}
