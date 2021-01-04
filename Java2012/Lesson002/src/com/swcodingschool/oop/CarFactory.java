package com.swcodingschool.oop;

public class CarFactory {
	private String factoryName;
	private int productCounts;
	
	CarFactory(String factoryName, int productCounts){
		this.factoryName = factoryName;
		this.productCounts = productCounts;
	}
	
	public void makeCar(CarCompany company) {
		company.produceCar(productCounts);
	}
	
	public void showinfo() {
		System.out.println("공장 이름 : " + factoryName + "자동차 생산 갯수 : " + productCounts);
	}
	
}
