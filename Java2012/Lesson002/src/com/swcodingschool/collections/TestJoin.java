package com.swcodingschool.collections; 

public class TestJoin {
	private String JoinID;
	private String JoinName;
	
	TestJoin(){}
	
	TestJoin(String JoinID, String JoinName){
		this.JoinID = JoinID;
		this.JoinName = JoinName;
	}

	public String getJoinID() {
		return JoinID;
	}

	public void setJoinID(String joinID) {
		JoinID = joinID;
	}

	public String getJoinName() {
		return JoinName;
	}

	public void setJoinName(String joinName) {
		JoinName = joinName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JoinName + "님의 아이디는" + JoinID + "입니다. ";
	}
	
	
}
