package com.swcodingschool.realoop;

public class CustomerTest1 {

	public static void main(String[] args) {
		
		Customer customerLee = new Customer();
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.setBonusPoint(1000);
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("김유신");
		customerKim.setBonusPoint(10000);
		
		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
		
		System.out.println("----------------------------");
		
		System.out.println("Lee의 지불액 : " + customerLee.calcPrice(10000));
		System.out.println("Kim의 지불액 : " + customerKim.calcPrice(10000));
		
		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
		
	}// end of main

} // end of class
