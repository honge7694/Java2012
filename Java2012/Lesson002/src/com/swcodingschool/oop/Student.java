package com.swcodingschool.oop;

public class Student {
	
	int studentID;
	String studentName;
	int grade;
	String address;
	
	// 메서드
	// 접근제어자 리턴타입 메서드이름(패러미터리스트)
	public void study() {
		System.out.println(studentName + "이(가) 공부를 합니다.");
	} // end of study
}// end of class 
