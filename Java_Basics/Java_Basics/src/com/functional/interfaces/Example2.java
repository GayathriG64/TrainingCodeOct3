package com.functional.interfaces;
interface Square{
	public void square(int num1);
	
	default void print() {
		System.out.println("Default method has been executed.");
	}
}
public class Example2 implements Square{

	@Override
	public void square(int num1) {
		// TODO Auto-generated method stub
		System.out.println("The square of the num " + num1 + " is: "+ num1*num1 );
		
	}
	
	public static void main(String[] args) {
		Example2 e2 =new Example2();
		e2.square(5);
		e2.print();
	}

}
