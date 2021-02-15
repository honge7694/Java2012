package com.swcodingschool.hello;

import java.util.Scanner;

public class QuizConditionalStmt {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력해주세요 : ");
        int grade = sc.nextInt();
        sc.close();

        if (grade >= 90) {
            System.out.println("if : A");
        } else if (grade >= 80) {
            System.out.println("if : B");
        } else if (grade >= 70) {
            System.out.println("if : C");
        } else {
            System.out.println("if : F");
        }// if end

        System.out.println("");

        switch (grade / 10) {
            case 10:
            case 9:
                System.out.println("switch : A");
                break;
            case 8:
                System.out.println("switch : B");
                break;
            case 7:
                System.out.println("switch : C");
                break;
            default:
                System.out.println("switch : F");
        }

    } // main

} // class
