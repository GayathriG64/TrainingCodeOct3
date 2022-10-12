package com.functional.interfaces;

import java.util.function.Predicate;

public class PredicateExample {
	public static Predicate<String> hasLengthOf = new Predicate<String> () {
		@Override
		public boolean test(String t)
		{
			return t.length()>10;
		}
	};
	
	public static void predicate_or() {
		Predicate<String> isContainsA = (s)-> s.contains("a");
		String str ="Gayathri";
		boolean outcome = hasLengthOf.or(isContainsA).test(str);
		System.out.println("outcome:"+outcome);
	}
	
	public static void main(String[] args) {
		
		Predicate<Integer> isAnAdult = (i) ->  i>=18;
		Predicate<Integer> notAnAdult = (i) ->  i<18;
		Predicate<Integer> isRetired = (i) ->  i>60;
		boolean result = isAnAdult.and(isRetired).test(16);
		
		System.out.println(result);
		
		predicate_or();
		
	}
	
}
