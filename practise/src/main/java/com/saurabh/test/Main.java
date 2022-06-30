package com.saurabh.test;

public class Main implements Interface1, Interface2 {
	
	public static void main(String[] args)
    {
        Main main = new Main();
        main.getGreeting();
    }
	
	@Override 
	public void getGreeting()
    {
        //return "Good Evening!";
		Interface1.super.getGreeting();
		Interface2.super.getGreeting();
    }
}
