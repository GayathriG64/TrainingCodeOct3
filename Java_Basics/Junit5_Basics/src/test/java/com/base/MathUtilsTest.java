package com.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class MathUtilsTest {
	@Test
	void test() {
		System.out.println("First test is run");
	}
	
	@Test
	void testAdd() {
		MathUtils testObj = new MathUtils();
		int expected = 20;
		int actual = testObj.add(10,10);
		assertEquals(expected,actual);
	}
	
	@Test
	void testSubtract() {
		MathUtils testObj = new MathUtils();
		int expected = 10;
		int actual = testObj.subtract(20,10);
		assertEquals(expected,actual);
	}
	
	@Test
	void testMultiply() {
		MathUtils testObj = new MathUtils();
		int expected = 100;
		int actual = testObj.multiply(10,10);
		assertEquals(expected,actual);
	}
	
	@Test
	void testDivide() {
		MathUtils testObj = new MathUtils();
		int expected = 1;
		int actual = testObj.divide(10,10);
		assertEquals(expected,actual);
		//assertArrayEquals
		//assertIterableEquals
		//
	}
	
	
	
}
