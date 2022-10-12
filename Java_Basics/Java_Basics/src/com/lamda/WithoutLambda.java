package com.lamda;

interface printName{
	public void print();
}

public class WithoutLambda {
	
public static void main(String[] args) {

	String name="GayathriG";
	
	printName myName = new printName() {
		@Override
		public void print() {
			System.out.println("Printing: " +name);
		}
	};
	myName.print();
	
	//printName myName1 = ()->System.out.println("Printing with lambda: " +name);
	//myName1.print();	
	
}
}
