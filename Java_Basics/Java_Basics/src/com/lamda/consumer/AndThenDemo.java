package com.lamda.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AndThenDemo {
	public static void main(String[] args) {
		Consumer<List<Integer>> displayList = list-> list.stream().forEach(a-> System.out.println(a+ " "));
		
		Consumer<List<Integer>> modify = list-> 
		{
			for(int i=0 ;i<list.size();i++) {
				list.set(i, 2*list.get(i));
			}
		};
			
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(10);
		numberList.add(100);
		numberList.add(1000);
		
		modify.andThen(displayList).accept(numberList);
		
	}
}
