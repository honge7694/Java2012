package com.swcodingschool.oop;

/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */
public class QuizStaticGuest {
    private static int serialNumber = 1000;
    public int guestId;
    public int guestMoney;

    public QuizStaticGuest(int guestMoney) {
        this.guestId = serialNumber++;
        this.guestMoney = guestMoney;
    } // end 생성자

    public void takeStore(QuizStaticStore store) {
        store.into(100);
        this.guestMoney -= 100;
    }// end of takeStore

    public void takeOffStore(QuizStaticStore store) {
        store.out();
    }// end of takeOffStore

    public void showinfo() {
        System.out.println(guestId + "번은 돈을 " + guestMoney + "원을 가지고 있다.");
    }


} // end of QuizStaticGuest
