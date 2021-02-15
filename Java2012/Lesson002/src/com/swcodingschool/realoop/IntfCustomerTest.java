package com.swcodingschool.realoop;

public class IntfCustomerTest extends IntfCustomer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IntfCustomer customer = new IntfCustomer();

        IntfBuy buys = customer;
        IntfSell sells = customer;

        buys.purchase();
        sells.Bargainsale();
        customer.order();
    }

}
