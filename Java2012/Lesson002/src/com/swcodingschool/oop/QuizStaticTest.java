package com.swcodingschool.oop;
/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */
public class QuizStaticTest {
	public static void main(String[] args) {
		// 상점 인스턴스 생성
		QuizStaticStore store1 = QuizStaticStore.getInstance();
		QuizStaticStore store2 = QuizStaticStore.getInstance();
		store1.showinfo();
		store2.showinfo();
		
		// 손님 인스턴스 생성
		QuizStaticGuest guest1 = new QuizStaticGuest(10000);
		QuizStaticGuest guest2 = new QuizStaticGuest(500);
		guest1.showinfo();
		guest2.showinfo();
		
		// 가게 들어가고 난 후 손님과 상점의 정보.
		guest1.takeStore(store1);
		guest1.showinfo();
		
		guest2.takeStore(store2);
		guest2.showinfo();
	
		store1.showinfo();
		store2.showinfo();
		
		// 가게 나감.
		System.out.println("가게 나감");
		guest1.takeOffStore(store2);
		store1.showinfo();
		store2.showinfo();
		
	}
	
} // end of QuizStaticTest
