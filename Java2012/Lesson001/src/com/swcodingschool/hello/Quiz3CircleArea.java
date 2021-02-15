package com.swcodingschool.hello;

import java.util.Scanner;

public class Quiz3CircleArea {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        sc.close();
        System.out.print("반지름을 입력하세요 : ");
        double radius = sc.nextDouble();
        final double PI = 3.141592; // Constant 상수

        System.out.println("원의 넓이는? " + radius * radius * PI);

    }
}
