package com.swcodingschool.guibasic;

public class TestMemberTreeSet432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestTreeSet431 tree = new TestTreeSet431();
		
		TestMember m1 = new TestMember(1001, "고길동");
		TestMember m2 = new TestMember(1002, "김둘리");
		TestMember m3 = new TestMember(1003, "도우너");
		TestMember m4 = new TestMember(1004, "고희동");
		
		tree.addMember(m1);
		tree.addMember(m2);
		tree.addMember(m3);
		tree.addMember(m4);
		tree.showAllMember();
		
		TestMember m5 = new TestMember(1003, "마이콜"); // 생성이 안되야 정상 Member 427[S] ~ [E] 있어야 작동.
		tree.addMember(m5);
		tree.showAllMember();
		
		tree.removeMember(1003);
		tree.showAllMember();
		
	}

}
