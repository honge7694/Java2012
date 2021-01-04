package com.swcodingschool.oop;
/*
 * 교재 P175 예제 클래스
 * 객체간 협력을 통한 객체지향프로그래밍 구현방법을 설명한다.
 */
public class Student175 {
	// Member Variables
	public String studentName;	// 학생 이름
	public int studentID;		// 학번
	public int grade;			// 학년
	public int money;			// 소지한 돈
	// static 변수 추가와 활용
	public static int serialNum = 1000;
	
	// Member Methods
	public Student175(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
		this.studentID = serialNum++;
	} // end of constructor Studnet175()
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	} // end of takeBus()
	
	public void takeoffBus(Bus bus) {
		bus.takeOffBus();		
	} // end of takeOffBus()
	
	public void showInfo() {
		System.out.println(studentID + "번 학생 " + studentName + "님의 남은 돈은" + money + "입니다.");
	} // end of showInfo()
} // end of class Student175
