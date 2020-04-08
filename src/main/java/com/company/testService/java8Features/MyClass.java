package com.company.testService.java8Features;


//https://www.journaldev.com/2389/java-8-features-with-examples
public class MyClass implements Interface1{

//	@Override
//	public void method2() {
//		System.out.println("default logging::");
//		
//	}

	@Override
	public void method1(String str) {
		System.out.println("default logging::"+str);
		
	}

//	@Override
//	public void log(String str) {
//		// TODO Auto-generated method stub
//		Interface1.super.log(str);
////		Interface2.super.log(str);
//	}
	
	public static void main(String[] a) {
		MyClass cl = new MyClass();
		cl.log("aaaaaaaa");
		cl.method1("cccccccccc");
//		cl.method2();
	}

}

@FunctionalInterface
 interface Interface1{
	 
	 void method1(String str);
	 default void log(String str){
			System.out.println("I1 logging::"+str);
		}
		
		static void print(String str){
			System.out.println("Printing "+str);
		}
		//trying to override Object method gives compile-time error as
		//"A default method cannot override a method from java.lang.Object"
		
//		default String toString(){
//			return "i1";
//		}
		
		// function or lambda expressions
		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("My Runnable");
			}};
			
			Runnable r1 = () -> {
				System.out.println("My Runnable");
			};
}

@FunctionalInterface
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}