package org.college;

public class Student extends Department{

	//Methods   :studentName(),studentDept(),studentId()

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student objstu=new Student();
		objstu.collegeName();
		objstu.collegeCode();
		objstu.collegeRank();
		objstu.deptName();
		objstu.studentName();
		objstu.studentId();
		objstu.studentDept();
	}

	public void studentName() {
		System.out.println("Student Name: Supriya");
	}
	public void studentDept() {
		System.out.println("Student Department: EEE");
		
	}
	public void studentId() {
		System.out.println("Student ID:600056");
	}
}
