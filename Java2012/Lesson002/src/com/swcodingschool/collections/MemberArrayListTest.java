package com.swcodingschool.collections;

public class MemberArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberArrayList memberArrayList = new MemberArrayList();
		
		Member member1 = new Member(1001, "이다인");
		Member member2 = new Member(1002, "홍  의");
		Member member3 = new Member(1003, "이태영");
		Member member4 = new Member(1004, "김한샘");
		Member member5 = new Member(1005, "정윤주");
		// 나혼자 코딩
		Member member6 = new Member(1006, "나혼자");
		
		memberArrayList.addMember(member1);
		memberArrayList.addMember(member2);
		memberArrayList.addMember(member3);
		memberArrayList.addMember(member4);
		memberArrayList.addMember(member5);
		// 나혼자 코딩
		memberArrayList.addMember(1, member6);
		
		memberArrayList.showAllMember();
		System.out.println("===================================\n");
		memberArrayList.removeMember(member1.getMemberId());
		
		memberArrayList.showAllMember();
		
		
	}

}
