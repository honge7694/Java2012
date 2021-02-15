package com.swcodingschool.guibasic;

import java.util.HashSet;
import java.util.Iterator;

public class TestMemberHashSet424 {
    private HashSet<TestMember> hashSet;

    TestMemberHashSet424() {
        hashSet = new HashSet<TestMember>();
    }

    // ArrayList or HashSet에 이런식으로 넣음 x list 배열이 2개가 되서 정보가 따로 저장.
    TestMemberHashSet424(int i, String string) {
        hashSet = new HashSet<TestMember>();
    }

    public void addMember(TestMember member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<TestMember> ir = hashSet.iterator();

        while (ir.hasNext()) {
            TestMember member = ir.next();
            int tempId = member.getMemberId();

            if (tempId == memberId) {
                hashSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (TestMember member : hashSet) {
            System.out.println(member);
        }

        System.out.println("");
    }
}
