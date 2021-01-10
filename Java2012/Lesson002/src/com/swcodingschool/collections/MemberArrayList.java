package com.swcodingschool.collections;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Member class를 ArrayList 형태로 구성
 */
public class MemberArrayList {
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public void addMember(int idx, Member member) {
		arrayList.add(idx, member);
	}
	
	public boolean removeMember(int memberID) {
//		for(int i = 0; i < arrayList.size(); i++) {
//			Member member = arrayList.get(i);
//			
//			int tempID = member.getMemberId();
//			
//			if(tempID == memberID) {
//				arrayList.remove(i);
//				return true;
//			}
		Iterator<Member> ir = arrayList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			
			if(tempId == member.getMemberId()) {
				arrayList.remove(member);
				return true;
			}
		}
		System.out.println(memberID + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}
}// end of class
