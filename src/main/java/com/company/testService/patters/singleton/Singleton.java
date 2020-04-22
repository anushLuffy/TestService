package com.company.testService.patters.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable , Cloneable {
/**
	 * 
	 */
	private static final long serialVersionUID = -6828499191188912405L;
	
//	public static Singleton singleton = new Singleton();// eager intialisation
	public static volatile Singleton singleton = null;
	private static boolean singletonInstance = false;
	
	private Singleton() {
		// private contructor
		// to solve reflections 
		if(singleton != null) {
			throw new RuntimeException("Please use getInstance method");
		}
		singletonInstance = true;
		System.out.println("inside contructor");
	}
	
//	public static Singleton getInstance() { // normal 
	public static synchronized Singleton getInstance() {// to handle muti thread not the best way but
//		return singleton;// got eager 
		if(singletonInstance && singleton == null) {
			throw new RuntimeException("instance already created with relections , cannot create now");
		}
		if(singleton == null) {
			synchronized(Singleton.class) { // better way for multi threaded
				if(singleton == null) { // double check  in muti thread ..... to remove this use volatile (remove half baked)
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	// with holder instance
	public static synchronized Singleton getInstance1() {
		return Holder.INSTANCE;
		
	}
	static class Holder {
		static final Singleton  INSTANCE =  new Singleton();
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
//		return super.clone();// normal clone method 
		return singleton;
	}
	
	// for serialisation and deserailiastion
	private Object readResolve() throws ObjectStreamException{
		System.out.println("in read resolve");
		return singleton;
		
	}
	

}
