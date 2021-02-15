package com.swcodingschool.realoop;

import java.util.ArrayList;

public class CustomerTest1 {


    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        Customer customerLee = new Customer();
        customerLee.setCustomerID(10010);
        customerLee.setCustomerName("이순신");
        customerLee.setBonusPoint(1000);

        VIPCustomer customerKim = new VIPCustomer();
        customerKim.setCustomerID(10020);
        customerKim.setCustomerName("김유신");
        customerKim.setBonusPoint(10000);

        GoldCustomer customerHong = new GoldCustomer();
        customerHong.setCustomerID(10030);
        customerHong.setCustomerName("홍길동");
        customerHong.setBonusPoint(10000);

        System.out.println(customerLee.showCustomerInfo());
        System.out.println(customerKim.showCustomerInfo());

        System.out.println("----------------------------");

        System.out.println("Lee의 지불액 : " + customerLee.calcPrice(10000));
        System.out.println("Kim의 지불액 : " + customerKim.calcPrice(10000));

        System.out.println(customerLee.showCustomerInfo());
        System.out.println(customerKim.showCustomerInfo());

        System.out.println("----------------------------");

        Customer customerGo = new VIPCustomer(1000, "고유");
        Customer customerAhn = new GoldCustomer(1001, "안유");
        Customer customerRyu = new Customer(1002, "류유");
        Customer customerOh = new VIPCustomer(1003, "오유");
        Customer customerPark = new Customer(1004, "박유");

        customerList.add(customerGo);
        customerList.add(customerAhn);
        customerList.add(customerRyu);
        customerList.add(customerOh);
        customerList.add(customerPark);

        int price = 1000;

        for (Customer c : customerList) {
            int cost = c.calcPrice(price);

            System.out.println(c.getCustomerName() + "님 이" + cost + "원 냈음. 보너스는 " + c.getBonusPoint());

        }

    }// end of main

} // end of class
