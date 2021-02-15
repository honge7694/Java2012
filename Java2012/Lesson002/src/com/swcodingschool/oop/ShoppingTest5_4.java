package com.swcodingschool.oop;

public class ShoppingTest5_4 {
    public static void main(String[] args) {
        Shopping5_4 sp = new Shopping5_4();

        sp.setNo(201803120001L);
        sp.setId("abc123");
        sp.setDate("2018년 3월 12일");
        sp.setName("홍길순");
        sp.setPno("PD0345-12");
        sp.setAddr("서울시 영등포구 여의도동 20번지");

        sp.shoppingPrint();
    }

}
