package com.swcodingschool.oop;
/*
 * 클래스 객체를 (instance로)만드는 방법을 설명한다.
 */
public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stYounju = new Student();
		Student stDain = new Student();
		
		stYounju.studentName = "정윤주";
		stYounju.grade = 1;
		
		stDain.studentName = "이다인";
		stDain.grade = 2;
		
		stYounju.study();
		stDain.study();
		
	}

}
