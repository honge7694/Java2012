package com.swcodingschool.hello;

public class ControlForLoop {
	public static void main(String [] args) {
		// 단일 for
		for(int number = 0; number < 10; number++) {
			System.out.printf("%4d",number);
		}// end of for
		System.out.println();
		
		// 다중 for
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}// end of outer for
		
		// for each : collection data를 이용한 반복 제어
		int array [] = {1, 2, 3, 4, 5};
		for(int numInArray : array) {
			System.out.printf("%3d", numInArray);
		}
	}// end of main
}// end of class