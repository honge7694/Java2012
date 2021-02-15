package com.swcodingschool.test;

public class KoreaCarFactory {

    private String name;
    private int count;

    KoreaCarFactory(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void makeCar(KoreaCarCompany company) {
        company.produceCar(count);
    }

    public void info() {
        System.out.println("생산 지역 : " + name + " 생산 수 : " + count);
    }
}
