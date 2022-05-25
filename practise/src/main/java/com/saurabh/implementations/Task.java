package com.saurabh.implementations;

public class Task implements Runnable{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Task(String name) {
	this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Executing "+ this.name);
	}
	
}
