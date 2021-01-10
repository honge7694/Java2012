package com.swcodingschool.guibasic;
/*
 * Collection Framework의 이해와 활용
 * ArrayList에서 사용할 기본 클래스
 */
public class TestMember {
	private int memberId;
	private String memberName;
	
	public TestMember(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	// 427p [S]
	@Override
	public int hashCode() {
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TestMember) { // obj가 Member자료형이면 
			TestMember member = (TestMember)obj;
			
			if(this.memberId == member.memberId) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	// 427p [E]
	@Override
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
	}
	
	
	
} // end of class
