package com.swcodingschool.oop;

public class TestKindergarten {
    private int kindergartenMoney;
    private int kindergartenChild;

    private static TestKindergarten garten = new TestKindergarten();

    private TestKindergarten() {
    }

    public static TestKindergarten getGarten() {
        if (garten == null) {
            garten = new TestKindergarten();
        }
        return garten;
    }

    public void getChild(int kindergartenMoney) {
        kindergartenChild++;
        this.kindergartenMoney += kindergartenMoney;
    }

    public void outChild() {
        kindergartenChild--;
    }

    public void showInfo() {
        System.out.println("유치원 아이 수 : " + kindergartenChild);
        System.out.println("유치원 번 돈 : " + kindergartenMoney);
    }


}
