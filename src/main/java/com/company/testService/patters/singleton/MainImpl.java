package com.company.testService.patters.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainImpl {
	
	static void useSingleton() {
		Singleton s1 = Singleton.getInstance();
		print(s1);
	}
	
	public static void main(String[] args) throws Exception {
		
		// using reflections '
//				Class clazz = Class.forName("com.company.testService.patters.singleton.Singleton");
//				Constructor<Singleton> crr =  clazz.getDeclaredConstructor();
//				crr.setAccessible(true);
//				Singleton s3 = crr.newInstance();
//				print(s3);
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		print(s1);
		print(s2);
		// voilation constrains 
		
		// using reflections  exception will come 
//		Class clazz = Class.forName("com.company.testService.patters.singleton.Singleton");
//		Constructor<Singleton> crr =  clazz.getDeclaredConstructor();
//		crr.setAccessible(true);
//		Singleton s3 = crr.newInstance();
//		print(s3);
		
		// using serailisable
		ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("/tmp/sig.ser"));
		fos.writeObject(s2);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/sig.ser"));
		Singleton s4 =  (Singleton) ois.readObject();
		print(s4);
		
		// using clone 
		Singleton s5 =  (Singleton) s2.clone();
		print(s5);
		
		// mulitple threaded instrances 
		ExecutorService service1 = Executors.newFixedThreadPool(2) ;
		service1.submit(MainImpl::useSingleton);
		service1.submit(MainImpl::useSingleton);
		service1.shutdown();
	}

	private static void print(Singleton s1) {
		System.out.println(s1.hashCode());
	}

}
