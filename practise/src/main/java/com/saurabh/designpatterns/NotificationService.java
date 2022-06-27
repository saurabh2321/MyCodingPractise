package com.saurabh.designpatterns;

public class NotificationService {
	
	public static void main(String[] args) {
		
		NotificationFactory factory = new NotificationFactory();
		Notification notification = factory.createNotification("Push");
		notification.notifyUser();
	}

}
