package com.lambda.supplier;

import java.util.function.Supplier;

public class GetDemo {
	
	public static void main(String[] args) {
	
	Supplier<Double> randomNumber = ()-> Math.random();
	
	System.out.println(randomNumber.get());
	}
	
}
