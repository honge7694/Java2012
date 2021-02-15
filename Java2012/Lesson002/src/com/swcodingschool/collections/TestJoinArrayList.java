package com.swcodingschool.collections;

import java.util.ArrayList;

public class TestJoinArrayList {
    private ArrayList<TestJoin> joinArray;

    TestJoinArrayList() {
        joinArray = new ArrayList<TestJoin>();
    }

    public void addJoin(TestJoin testJoin) {
        joinArray.add(testJoin);
    }

    public boolean deleteJoin(String memberID) {

        for (int i = 0; i < joinArray.size(); i++) {
            TestJoin testJoin = joinArray.get(i);

            if (testJoin == joinArray.get(i)) {
                joinArray.remove(memberID);
                return true;
            }
        }
        System.out.println("일치하는 ID가 없습니다.");
        return true;
    }

    public void showAll() {
        for (TestJoin join : joinArray) {
            System.out.println(join);
        }
        System.out.println();
    }


}
