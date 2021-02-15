package com.swcodingschool.realoop;

public class AbsPlayerBeginner extends AbsPlayerLevel {

    @Override
    public void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Jump할 줄 모름.");
    }

    @Override
    public void turn() {
        System.out.println("Turn할 줄 모름.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("*****초급자 레벨입니다.*****");
    }

} // end of class
