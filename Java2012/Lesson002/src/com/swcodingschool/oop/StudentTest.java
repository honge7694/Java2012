package com.swcodingschool.oop;

/*
 * 1. 클래스 객체를 (instance로)만드는 방법을 설명한다.
 * 2. 접근제어자 class 클래스이름 { 멤버변수; 메서드; }
 * 3. 생성자 Construct
 */
public class StudentTest {

    public static void main(String[] args) {
        // 클래스 객체 생성하기
        // 생성자는 클래스의 이름과 동일한 메서드를 생성자라 한다.
        // 특히 파라미터가 없는 생성자를 디폴트 생성자라고 한다.
        // 기본 생성자를 통해 객체가 생성되었을 때 메모리 공간 안에서는 무슨일이 생길까?

        // ★오버로딩 동일안 함수이름을 가지고 여러개의 함수가 만들어질 수 있지만 패러미터 개수와 타입에 의해서 구분된다.★
        Student stYounju = new Student();
        Student stDain = new Student(2, "이다인", 2, "청주시");

        System.out.println(stYounju);
        System.out.println(stDain);
//		stYounju.studentName = "정윤주";
//		stYounju.grade = 1;
//		
//		stDain.studentName = "이다인";
//		stDain.grade = 2;

        stYounju.setStudentID(1);
        stYounju.setStudentName("정윤주");
//		
//		System.out.println(stYounju.getStudentID() + " " + stYounju.getStudentName());
//		

        stYounju.showInfo();
        stDain.showInfo();

//		stYounju.study();
//		stDain.study();

    }

}
