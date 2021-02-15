package com.swcodingschool.hello;

import java.util.Scanner;

public class Quiz2ForLoopStmt {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println(i + "단 end");
        }

    } // main

} // class
