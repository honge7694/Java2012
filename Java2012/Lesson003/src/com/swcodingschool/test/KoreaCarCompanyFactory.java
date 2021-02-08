package com.swcodingschool.test;

public class KoreaCarCompanyFactory {
	public static void main(String[] args) {
		KoreaCarCompany cheongju = KoreaCarCompany.getInstance();
		KoreaCarFactory car = new KoreaCarFactory("청주", 5);
		car.makeCar(cheongju);
		car.info();
		
		KoreaCarCompany ulsan = KoreaCarCompany.getInstance();
		KoreaCarFactory car2 = new KoreaCarFactory("울산", 3);
		car2.makeCar(ulsan);
		car2.info();
		
		cheongju.showInfo();
		ulsan.showInfo();
	}
}
