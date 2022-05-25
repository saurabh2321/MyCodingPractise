package com.saurabh.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		
		list.add("one");
		list.add("two");
		
		Optional<String> op = list.stream().filter(s-> s.equals("one")).findFirst();
		String w = op.isPresent() ? op.get() : "not found";
		System.out.println(w);
		
		Thread t1 = new Thread(()-> {
			System.out.println("new runnable task");
		});
		int a=10;
		int b =5;
		
		a = a+b; //15
		b = a-b; //10
		a = a-b; // 15-10=5
	}
	

}

