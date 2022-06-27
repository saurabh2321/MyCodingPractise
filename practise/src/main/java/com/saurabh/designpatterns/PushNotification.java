package com.saurabh.designpatterns;

public class PushNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("sending a Push notification");
	}
}
