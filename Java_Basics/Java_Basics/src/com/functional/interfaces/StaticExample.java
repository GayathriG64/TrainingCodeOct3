package com.functional.interfaces;
interface SayName{
	static void say() {
		System.out.println("Hello my name is GayathriG");
	}
	void age(int a); 
}
public class StaticExample implements SayName{
	@Override
	public void age(int a) {
		System.out.println(a);
	}
	public static void main(String[] args) {
	
	StaticExample e =new StaticExample();
	SayName.say();
	e.age(25);
}
}
