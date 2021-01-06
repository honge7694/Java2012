package com.swcodingschool.realoop;
/*
 * 인터페이스 : 추상메서드와 상수로만 구성
 * 				직접 인스턴스를 생성할 수 없다.
 */
public interface Calc {
	// Member Property (멤버변수) : 상수로만 구성된다.
	// 컴파일 과정에서 final 상수로 변환 처리
	double PI = 3.14;
	int ERROR = -9999999;
	
	// Methods : abstract methods로만 구성
	// 컴파일 과정에서 abstract 변환 처리
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("디폴트 정수 계산기를 구현합니다.");
	}
}
