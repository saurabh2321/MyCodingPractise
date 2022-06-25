package com.saurabh.designpatterns;

import java.lang.reflect.Constructor;

public class BreakSingleton {
	//using reflection api
	/*public static void main(String[] args) {
		
		Singleton objOne = Singleton.getInstance("");
		Singleton objTwo = null;
		try {
			Constructor constructor = Singleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			objTwo = (Singleton) constructor.newInstance();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(objOne.hashCode());
		System.out.println(objTwo.hashCode());
	}*/
	//using clone method
	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton objOne = Singleton.getInstance("");
		Singleton objTwo = (Singleton) objOne.clone();
		System.out.println(objOne.hashCode());
		System.out.println(objTwo.hashCode());
	}

}
