package com.swcodingschool.guibasic;

public class TestMemberHashSet426 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestMemberHashSet424 hash = new TestMemberHashSet424();
        TestMemberHashSet424 t1 = new TestMemberHashSet424(1000, "병아리"); // ArrayList or HashSet에 이런식으로 넣음 x
        //list 배열이 2개가 되서 정보가 따로 저장.

        TestMember m1 = new TestMember(1001, "고길동");
        TestMember m2 = new TestMember(1002, "김둘리");
        TestMember m3 = new TestMember(1003, "도우너");
        TestMember m4 = new TestMember(1004, "고희동");

        hash.addMember(m1);
        hash.addMember(m2);
        hash.addMember(m3);
        hash.addMember(m4);
        hash.showAllMember();

        TestMember m5 = new TestMember(1003, "마이콜"); // 생성이 안되야 정상 Member 427[S] ~ [E] 있어야 작동.
        hash.addMember(m5);
        hash.showAllMember();

        hash.removeMember(1003);
        hash.showAllMember();

    }

}
