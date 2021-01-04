package com.swcodingschool.oop;
/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */
public class QuizStaticStore {
	public int storeCount;
	public int storeMoney;
	
	// 생성자
	private QuizStaticStore(){};
	
	// 싱글톤 인스턴스 생성
	private static QuizStaticStore instance = new QuizStaticStore();
	
	// 인스턴스 접근 메서드
	public static QuizStaticStore getInstance() {
		if(instance == null) {
			instance = new QuizStaticStore();
		}
		return instance;
	} // end of QuizStaticStore getInstance 
	
	public void into(int storeMoney) {
		storeCount++;
		this.storeMoney += storeMoney;
	}
	
	public void out() {
		storeCount--;
	}
	
	public void showinfo() {
		System.out.println("수입은 : " + storeMoney + "이고, 손님은 " + storeCount + "명 있다");
	}
	
}// end of QuizStaicStore
