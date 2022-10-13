package com.root;

public class Course {
	public int courseID;
	public String courseName;
	public String courseTeacher;
	public double courseDuration;
	public double courseFee;
	
	public Course(int courseID, String courseName, String courseTeacher, double courseDuration, double courseFee) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseDuration = courseDuration;
		this.courseFee = courseFee;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public double getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(double courseDuration) {
		this.courseDuration = courseDuration;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", courseTeacher=" + courseTeacher
				+ ", courseDuration=" + courseDuration + ", courseFee=" + courseFee + "]"+"\n";
	}
	
	
}
