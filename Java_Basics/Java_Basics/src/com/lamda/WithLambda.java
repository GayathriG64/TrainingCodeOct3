package com.lamda;

interface printName1{
	public void print();
}
public class WithLambda {

	public static void main(String[] args) {
		String name = "GayathriG";
		printName1 myName= ()-> System.out.println("Printing using lambda: " + name);
		myName.print();
	}
}
