package com.saurabh.implementations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Set<Callable<String>> callables = new HashSet<>();
		
		callables.add(new Callable<String>() {
			
			public String call() {
				return "task 1";
			}
		});
		
		callables.add(new Callable<String>() {
			
			public String call() {
				return "task 2";
			}
			});
		
		List<Future<String>> futures = service.invokeAll(callables);
		
		for(Future future : futures) {
			System.out.println(future.get());
		}
		service.shutdown();
	}

}
