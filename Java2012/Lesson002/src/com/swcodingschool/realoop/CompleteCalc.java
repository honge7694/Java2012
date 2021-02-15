package com.swcodingschool.realoop;

public class CompleteCalc extends Calculator {

    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return Calc.ERROR;
        }
    }

    @Override
    public void description() {
        // TODO Auto-generated method stub
        super.description(); // 지우면 Calc의  디폴트 사라짐.
        System.out.println("디폴트메서드 재정의");
    }

    public void showInfo() {
        System.out.println("Calc 인터페이스를 구현하였습니다.");
    }
}
