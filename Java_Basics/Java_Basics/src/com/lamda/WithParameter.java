package com.lamda;

interface printDesignation{
	public String publish(String designation);
}
public class WithParameter {
	
	public static void main(String[] args) {
		printDesignation d1= (des)-> {
			return "Your designation is: "+ des;
		};
		
		System.out.println(d1.publish("Software Engineer"));
	}
}
