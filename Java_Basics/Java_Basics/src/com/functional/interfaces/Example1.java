package com.functional.interfaces;

interface Message{
	void print(String msg);
} 

public class Example1 {
	public void print(String msg) {
		System.out.println(msg);
	}
	public static void main(String[] args) {
		Example1 e1 = new Example1();
		e1.print("Hello this is first functional interface.");
	}
}
