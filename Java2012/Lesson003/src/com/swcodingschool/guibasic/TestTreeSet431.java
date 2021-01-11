package com.swcodingschool.guibasic;


import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet431 {
	private TreeSet<TestMember> tree;
	
	TestTreeSet431(){
		tree = new TreeSet<TestMember>();
	}
	
	public void addMember(TestMember member) {
		tree.add(member);
	}
	
	public boolean removeMember(int memberId) {
		Iterator<TestMember> ir = tree.iterator();
		
		while(ir.hasNext()) {
			TestMember member = ir.next();
			
			int tempId = member.getMemberId();
			
			if(tempId == memberId) {
				tree.remove(member);
				return true;
			}
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(TestMember member : tree) {
			System.out.println(member);
		}
		System.out.println("");
	}
}
