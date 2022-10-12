package com.lamda.consumer;

import java.util.function.Consumer;
import java.util.*;

public class AcceptDemo {
	public static void main(String[] args) {
		Consumer<Integer> display= (a)-> System.out.println(a);
		display.accept(101);
		
		Consumer<List<Integer>> displayList =
				list-> list.stream().forEach(a-> System.out.println(a+ " "));
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(10);
		numberList.add(100);
		numberList.add(1000);
		
		displayList.accept(numberList);
		
	}
}
