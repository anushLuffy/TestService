package com.company.testService.java8Features.threads;

 class MultithreadingDemo extends Thread{
	
	 public void run() 
	    { 
	        try
	        { 
	            // Displaying the thread that is running 
	            System.out.println ("Thread " + 
	                  Thread.currentThread().getId() + 
	                  " is running"); 
	  
	        } 
	        catch (Exception e) 
	        { 
	            // Throwing an exception 
	            System.out.println ("Exception is caught"); 
	        } 
	    } 
	} 

 class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    
    RunnableDemo( String name) {
       threadName = name;
       System.out.println("Creating " +  threadName );
    }
    
    public void run() {
       System.out.println("Running " +  threadName );
       try {
          for(int i = 4; i > 0; i--) {
             System.out.println("Thread: " + threadName + ", " + i);
             // Let the thread sleep for a while.
             Thread.sleep(50);
          }
       } catch (InterruptedException e) {
          System.out.println("Thread " +  threadName + " interrupted.");
       }
       System.out.println("Thread " +  threadName + " exiting.");
    }
    
    public void start () {
       System.out.println("Starting " +  threadName );
       if (t == null) {
          t = new Thread (this, threadName);
          t.start ();
       }
    }
 }

public class Multithread 
{ 
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
        
//       

    } 
}
