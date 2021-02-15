package com.swcodingschool.oop;

public class CarCompany {
    public static int carCompanyProduct;

    private static CarCompany instance = new CarCompany();

    private CarCompany() {
        instance.carCompanyProduct = 0;
    }


    public static CarCompany getInstance() {
        if (instance == null) {
            instance = new CarCompany();
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
	
