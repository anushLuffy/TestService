package com.company.testService.java8Features;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8ForEachExample {
	
	public static void main(String[]  args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++) list.add(i);
		
		//traversing using Iterator
		long t1 = System.currentTimeMillis();
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
					Integer i = it.next();
					System.out.println("Iterator Value::"+i);
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		MyConsumer action = new MyConsumer();
		list.forEach(action);
		
		long t3 = System.currentTimeMillis();
		System.out.println(t3-t2);
		
		
		list.forEach(( a )->{
			System.out.println("Foreach  Value::"+a);
		});
		long t4 = System.currentTimeMillis();
		System.out.println(t4-t3);
	}

}
//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}


}
