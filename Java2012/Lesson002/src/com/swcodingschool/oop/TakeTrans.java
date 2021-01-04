package com.swcodingschool.oop;
 
// 학생, 버스 객체간의 협력을 보여주는 프로그램

public class TakeTrans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 객체생성
		Student175 studentJames = new Student175("James", 10000);
		Student175 studentTomas = new Student175("토마스", 20000);
		Bus bus823 = new Bus(823);
		
		// 객체 생성 정보 
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		
		// 객체 데이터 넣은 후 정보
		studentJames.takeBus(bus823);
		studentTomas.takeBus(bus823);
		
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		
		//버스 내리다.
		studentJames.takeoffBus(bus823);
		
		bus823.showInfo();
	}

}
