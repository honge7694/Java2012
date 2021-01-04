package com.swcodingschool.oop;

public class TestKindergartenChilderen {
	public static void main(String[] args) {
		TestKindergarten garten = TestKindergarten.getGarten();
		garten.showInfo();
		
		TestChildren hong = new TestChildren(10000);
		hong.showInfo();
		
		hong.registerChild(garten);
		hong.showInfo();
		garten.showInfo();
		
	}
}
