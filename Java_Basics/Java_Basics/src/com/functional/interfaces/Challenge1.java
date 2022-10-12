package com.functional.interfaces;

import java.util.function.Predicate;


public class Challenge1 {
	public static void main(String[] args) {
		int tester=52525;
		
		
		Predicate<Integer> odd = (a)-> {
			if(a%2==0)
				return false;
			else return true;
		};
		if(odd.test(tester)) 
			System.out.println("ODD");
		else
			System.out.println("EVEN");
		
		Predicate<Integer> prime = (a)-> {
			if(a<2|| a%2==0)
				return false;
			if(a==2)
				return true;
			else {
				for(int i=3; i<a;i++) {
					if(a%i==0)
						return false;
				}
				return true;
			}
		};
		//System.out.println("test for prime: "+prime.test(tester));
		if(prime.test(tester)) {
			System.out.println("PRIME");
		}
		else System.out.println("COMPOSITE");
		
		Predicate<Integer> palin = (a)-> {
			String str= Integer.toString(a);
			StringBuilder sb = new StringBuilder(str);
			sb.reverse();
			String reverse=sb.toString();
			if (str.equals(reverse))
				return true;
			else return false;
		};
		//System.out.println("test for palindrome: "+palin.test(tester));
		
		if(palin.test(tester)) {
			System.out.println("PALINDROME");
		}
		else System.out.println("NOT PALINDROME");
		
	}
}
