package com.swcodingschool.oop;
/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */

public class TestAcademy {
	public int academyMoney;
	public int academyCount;
	
	// 생성자
	private TestAcademy() {}
	// 인스턴스
	private static TestAcademy instance = new TestAcademy();
	
	// 싱글톤 메서드
	public static TestAcademy getInstance() {
		if(instance == null) {
			instance = new TestAcademy();
		}
		return instance;
	}
	
	public void getStudent(int academyMoney) {
		academyCount++;
		this.academyMoney +=academyMoney;  
	}
	
	public void outStudent() {
		academyCount--;
	}
	
	public void showinfo() {
		System.out.println("학원 돈 : " + academyMoney);
		System.out.println("학원 사람 수: " + academyCount);
	}
}
