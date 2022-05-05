package com.saurabh.leetcode;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
	
	private final int poolSize;
	private final WorkerThread[] workers;
	private final LinkedBlockingQueue<Runnable> queue;
	
	public CustomThreadPoolExecutor(int poolSize) {
		this.poolSize = poolSize;
		this.workers = new WorkerThread[poolSize];
		this.queue = new LinkedBlockingQueue<>();
		
		for(int i =0; i < poolSize ; i++) {
			workers[i] =  new WorkerThread();
			workers[i].start();
		}
	}
	
	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}
	
	public void shutdown() {
		
		for(int i =0; i < poolSize ; i++) {
			workers[i] =  null;
		}
		System.out.println("Shutting down threadpool");
	}
	
	private class WorkerThread extends Thread{
		
		public void run() {
			Runnable task;
			
			while(true) {
				
				synchronized (queue) {
					
					while(queue.isEmpty()) {
						try {
							queue.wait();
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = queue.poll();
				}
				try {
				task.run();
				} catch(RuntimeException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(2);
		for(int i=0; i<=5; i++) {
			Task task = new Task("task "+i);
			System.out.println("created: "+ task.getName());
			executor.execute(task);
		}
		executor.shutdown();
	}

}
