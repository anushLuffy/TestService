package com.company.testService.java8Features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.company.testService.model.User;

public class StreamExample {
public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		Stream<Integer> streams = myList.stream();
		Stream<Integer> streams1 = myList.parallelStream();
		
		Stream<Integer> highNums = streams1.filter(p -> p > 90);
		
			highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = streams.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
		
		//first name comparator
		Comparator<User> compareByFirstName = Comparator.comparing( User::getFirstName );
		 
		//last name comparator
		Comparator<User> compareByEmail = Comparator.comparing( User::getEmailId );
		 
		//Compare by first name and then last name (multiple fields)
		Comparator<User> compareByFullName = compareByFirstName.thenComparing(compareByEmail);
		 
		//Using Comparator - pseudo code
//		list.stream().sorted( comparator ).collect();
		
		//Compare by first name and then last name
        Comparator<User> compareByName = Comparator
                                                .comparing(User::getFirstName)
                                                .thenComparing(User::getEmailId);
        myList.stream().sorted().collect(Collectors.toList());
//        List<User> sortedEmployees = employees.stream()
//                                        .sorted(compareByName)
//                                        .collect(Collectors.toList());
//         
        System.out.println(myList);
        
		
}
}
