package com.marsh.codecheck;

public class SingletonThreadTest implements Runnable {
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		System.out.println("Current thread " + Thread.currentThread().getName() + " is running...");
		Singleton singleton = null;
		singleton = singleton.getSingletonInstance();
	}
	
	
	public static void main(String[] args) {
		SingletonThreadTest test = new SingletonThreadTest();
		Thread thread1 = new Thread(test);
		thread1.setName("Thread1");
		Thread thread2 = new Thread(test);
		thread2.setName("Thread2");
		Thread thread3 = new Thread(test);
		thread3.setName("Thread3");
		Thread thread4 = new Thread(test);
		thread4.setName("Thread4");
		Thread thread5 = new Thread(test);
		thread5.setName("Thread5");
		thread1.start(); 
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
