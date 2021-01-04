package com.swcodingschool.oop;

public class CarCompanyFactory {
	public static void main(String[] args) {
		CarCompany hyundai = CarCompany.getInstance();
		hyundai.showInfo();
		
		CarFactory cheongju = new CarFactory("청주", 500);
		cheongju.showInfo();
		
		cheongju.makeCar(hyundai);
		hyundai.showInfo();
		
		CarCompany usahyundai = CarCompany.getInstance();
		CarFactory usa = new CarFactory("미국", 1000);
		usa.makeCar(usahyundai);
		usahyundai.showInfo();
		
	}
}
