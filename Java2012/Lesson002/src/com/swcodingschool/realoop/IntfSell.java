package com.swcodingschool.realoop;

public interface IntfSell {
    void Sell();

    void Bargainsale();


    default void order() {
        System.out.println("판매 주문");
    }
}
