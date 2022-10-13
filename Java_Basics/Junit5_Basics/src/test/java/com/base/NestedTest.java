package com.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class NestedTest {
	
	private MathUtils initObj ;
	
	@BeforeEach
	void initEach() {
		 initObj = new MathUtils();
	}
	
	@Nested
	class AddTest{
		@Test
			void testAddPositive() {
			int expected = 20;
			int actual = initObj.add(10,10);
			assertEquals(expected,actual);
			}
	
		@Test
			void testAddNeg() {
			int expected = -20;
			int actual = initObj.add(-10,-10);
			assertEquals(expected,actual);
			}
	}
	
	@Test
	void testMultiply() {
		assertAll(
				()-> assertEquals(0,initObj.multiply(0,10)),
				()-> assertEquals(10,initObj.multiply(1,10)),
				()-> assertEquals(100,initObj.multiply(10,10))
				);
	}
	
	@Test
	void testArea() {
		assertEquals(0,initObj.area(0));
	}
	
	@Test
	void testDivision() {
		assertThrows(ArithmeticException.class,()-> initObj.divide(1,0),"cannot divide by 0");
	}
}


