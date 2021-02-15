package com.swcodingschool.oop;

public class TestChildren {
    private int childMoney;
    private int childId;

    private static int instance = 1000;

    TestChildren() {
    }

    TestChildren(int childMoney) {
        this.childMoney = childMoney;
        childId = instance;
        instance++;
    }

    public void registerChild(TestKindergarten garten) {
        garten.getChild(1000);
        this.childMoney -= 1000;
    }

    public void cancelChild(TestKindergarten garten) {
        garten.outChild();
    }

    public void showInfo() {
        System.out.println("어린이 번호 : " + childId);
        System.out.println("어린이 돈 : " + childMoney);
    }
}
