package com.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
	String name;
	String role;
	
	User (String n,String r){
		name=n;
		role=r;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + "]";
	}
	
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<User>();
		users.add(new User("Gayathri","SrDev"));
		users.add(new User("Jahnvi","SrDev"));
		users.add(new User("Lucy","JrDev"));
		users.add(new User("Priya","JrDev"));
		users.add(new User("Minato","JrDev"));
		
		List<User> seniors = process(users, (u)-> u.getRole().equals("SrDev"));
		System.out.println(seniors);
	}

	private static List<User> process(List<User> users, Predicate<User> predicate) {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList<User> ();
		for(User user:users) {
			if(predicate.test(user))
				result.add(user);
		}
		return result;
	}
}
