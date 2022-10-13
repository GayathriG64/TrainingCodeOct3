package com.root;
import java.util.*;

import com.root.Course;

public class SortCourses {
	public static void main(String[] args) {
	
		ArrayList<Course> courseList = new ArrayList<>();
		courseList.add(new Course(111,"JAVA7","Nishant",12,12000));
		courseList.add(new Course(112,"JAVA8","Vimal",15,15000));
		courseList.add(new Course(113,"JAVA11","Pooja",10,10000));
		courseList.add(new Course(114,"HTML","Nishant",5,5000));
		courseList.add(new Course(115,"CSS","Shilpa",6,6000));
		courseList.add(new Course(116,"BOOTSTRAP","John",8,8000));
		courseList.add(new Course(117,"SPRING","Stark",24,24000));
		courseList.add(new Course(118,"SPRINGBOOT","Nishant",30,30000));
		courseList.add(new Course(119,"JPA","Vimal",16,16000));
		courseList.add(new Course(120,"JAVASCRIPT","Pooja",26,26000));
		courseList.add(new Course(121,"TYPESCRIPT","Nishant",27,27000));
		courseList.add(new Course(122,"HIBERNATE","Shilpa",9,9000));
		courseList.add(new Course(123,"AWS","John",20,20000));
		courseList.add(new Course(124,"CLOUD BASICS","Stark",22,22000));
		courseList.add(new Course(124,"JDBC","Stark",3,3000));
		ArrayList<Course> sortedListByPriceAscending = new ArrayList<>();
		sortedListByPriceAscending=sortByPriceAscending(courseList);
		System.out.println("sorted List By Price Ascending:");
		System.out.println(sortedListByPriceAscending);
		
		ArrayList<Course> sortedListByPriceDescending = new ArrayList<>();
		sortedListByPriceDescending=sortByPriceDescending(courseList);
		System.out.println("sorted List By Price Descending:");
		System.out.println(sortedListByPriceDescending);
		
		ArrayList<Course> sortedListByDurationAscending = new ArrayList<>();
		sortedListByDurationAscending=sortByDurationAscending(courseList);
		System.out.println("sorted List By Duration Ascending:");
		System.out.println(sortedListByDurationAscending);
	}

	private static ArrayList<Course> sortByPriceAscending(ArrayList<Course> courseList) {
		// TODO Auto-generated method stub
		ArrayList<Course> resultList = new ArrayList<>();
		Collections.sort(courseList,(a,b)->{
			if(a.getCourseFee()==b.getCourseFee())
				return 0;
			else if(a.getCourseFee()>b.getCourseFee())
				return 1;
			else return -1;
		});
		resultList=courseList;
		return resultList;
	}
	
	private static ArrayList<Course> sortByPriceDescending(ArrayList<Course> courseList) {
		// TODO Auto-generated method stub
		ArrayList<Course> resultList = new ArrayList<>();
		Collections.sort(courseList,(a,b)->{
			if(a.getCourseFee()==b.getCourseFee())
				return 0;
			else if(a.getCourseFee()<b.getCourseFee())
				return 1;
			else return -1;
		});
		resultList=courseList;
		return resultList;
	}
	
	private static ArrayList<Course> sortByDurationAscending(ArrayList<Course> courseList) {
		// TODO Auto-generated method stub
		ArrayList<Course> resultList = new ArrayList<>();
		Collections.sort(courseList,(a,b)->{
			if(a.getCourseDuration()==b.getCourseDuration())
				return 0;
			else if(a.getCourseDuration()>b.getCourseDuration())
				return 1;
			else return -1;
		});
		resultList=courseList;
		return resultList;
	}
}
