package com.swcodingschool.oop;

/*
 *  상점이 하나 있고, 상점과 거래하는 손님들이 있다.
 *  상점은 싱글톤패턴으로 구현하고, 다수의 손님들이 물건을 구매한다.
 *  이를 객체 지향 프로그램으로 시뮬레이션 해보자.
 *  손님 : 손님ID, money
 *  매장 : 손님카운트, money
 */
public class TestAcademyStudent {
    public static void main(String args[]) {
        System.out.println("-------객체생성-------");
        TestAcademy t1 = TestAcademy.getInstance();
        t1.showinfo();
        System.out.println("----------------------");
        TestStudent hong = new TestStudent(100000);
        hong.showinfo();

        System.out.println("-------학원등록-------");
        hong.registerAcademy(t1);
        hong.showinfo();
        System.out.println("----------------------");
        t1.showinfo();

        System.out.println("-------학원취소-------");
        hong.cancelAcademy(t1);
        hong.showinfo();
        System.out.println("----------------------");
        t1.showinfo();
    }
}
