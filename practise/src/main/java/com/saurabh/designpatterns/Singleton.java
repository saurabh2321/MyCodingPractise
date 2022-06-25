package com.saurabh.designpatterns;

public class Singleton implements Cloneable {

	private static Singleton instance;
	private String value;

	private Singleton() {
		
		  if(instance != null) { throw new RuntimeException("Already instantiated!!!");
		  }
		 
	}
	private Singleton(String value) {
		this.value = value;
	}
	
	public static Singleton getInstance(String value) {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton(value);
				}
			}
		}
		return instance;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		//return super.clone();
		throw new CloneNotSupportedException();
	}
	
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance("hello");
		Singleton singleton2 = Singleton.getInstance("singleton");
		System.out.println(singleton.hashCode() + " "+ singleton.value);
		System.out.println(singleton2.hashCode() + " "+ singleton2.value);
	}
}