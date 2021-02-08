package com.swcodingschool.test;


public class KoreaCarCompany {
public static int carCompanyProduct;
	
	private static KoreaCarCompany instance = new KoreaCarCompany();
	
	private KoreaCarCompany(){
		instance.carCompanyProduct = 0;
		}
	
	
	public static KoreaCarCompany getInstance() {
		if(instance == null) {
			instance = new KoreaCarCompany(); 
		}
		return instance;
	}
	
	public void produceCar(int carCompanyProduct) {
		this.carCompanyProduct += carCompanyProduct;
	}
	
	public void showInfo() {
		System.out.println("총 자동차 갯수 : " + carCompanyProduct);
	}
}
