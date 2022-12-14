package com.lambda.method;

import java.util.*;

class User{
	
	private String name ;
	private Integer age;
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	
}
public class StaticMethod {
	
	public static int compareByAge(User a, User b ) {
		return a.getAge().compareTo(b.getAge());
	}
	public static int compareByName(User a, User b ) {
		return a.getName().compareTo(b.getName());
	}
	
	public static void main(String[] args) {
		

	List<User> userList = new ArrayList<>();
	userList.add(new User("Gayathri",25));
	userList.add(new User("Sowji",55));
	userList.add(new User("Priya",15));
	userList.add(new User("Nami",20));
	
	Collections.sort(userList, StaticMethod::compareByAge );
	
	System.out.println("After sorting by age");
	userList.stream().map(u->u.getName()).forEach(System.out::println);
	
	Collections.sort(userList, StaticMethod::compareByName );
	
	System.out.println("After sorting by Name");
	userList.stream().map(u->u.getName()).forEach(System.out::println);
	
	
	}
}
