package com.marsh.codecheck;

public class Singleton {
	
	// FIRST METHOD - Eager Initialization Method
	/*private static final Singleton SINGLETON_INSTANCE = new Singleton();
	private Singleton( ) {}
	public static Singleton getSingletonInstance() {
		return SINGLETON_INSTANCE;
	}*/
	
	// SECOND METHOD - Lazy Initialization Method
	private static Singleton singletonInstance = null;
	private Singleton() {}
	public static Singleton getSingletonInstance() {
		System.out.println("Inside getSingletonInstance method.");
		if (singletonInstance == null) {
			System.out.println(Thread.currentThread().getName() + " has entered the method.");
			synchronized (Singleton.class) {
				singletonInstance = new Singleton();
				System.out.println("Created new instance.");
			}
		}
		return singletonInstance;
	}
	
}
