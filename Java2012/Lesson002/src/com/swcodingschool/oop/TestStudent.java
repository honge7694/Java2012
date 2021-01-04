package com.swcodingschool.oop;
/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */
public class TestStudent {
	public int studentMoney;
	public static int serialStudent = 1000;
	
	public TestStudent(int studentMoney) {
		this.studentMoney = studentMoney;
		this.serialStudent = serialStudent++;
	}
	
	public void registerAcademy(TestAcademy academy) {
		academy.getStudent(10000);
		this.studentMoney -= 10000;
	}
	
	public  void cancelAcademy(TestAcademy academy) {
		academy.outStudent();
	}
	
	public void showinfo() {
		System.out.println("학생 번호 : " + serialStudent);
		System.out.println("학생 돈 : " + studentMoney);
	}
}
