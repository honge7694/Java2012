package com.swcodingschool.oop;
/*
 * static 변수와 static 메서드 이해하기
 */
public class Student187 {
	private static int serialNumber = 1000;
	int studentID;
	
	
	public Student187() {
		serialNumber++;
		this.studentID = serialNumber; 
	}


	public static int getSerialNumber() {
		return serialNumber;
	}


	public static void setSerialNumber(int serialNumber) {
		Student187.serialNumber = serialNumber;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
}
