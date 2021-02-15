package com.swcodingschool.realoop;

public interface IntfBuy {
    void buy();

    void purchase();

    default void order() {
        System.out.println("구매 주문");
    }
}
