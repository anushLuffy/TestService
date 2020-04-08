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
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
					Integer i = it.next();
					System.out.println("Iterator Value::"+i);
		}
		list.forEach(( a )->{
			System.out.println("Foreach  Value::"+a);
		});
		
		MyConsumer action = new MyConsumer();
		list.forEach(action);
	}

}
//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}


}
