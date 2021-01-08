package com.swcodingschool.collections;

public class TestJoin {
	private String JoinID;
	private String JoinName;
	
	TestJoin(){}
	
	TestJoin(String JoinID, String JoinName){
		this.JoinID = JoinID;
		this.JoinName = JoinName;
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JoinName + "님의 아이디는";
	}
	
	
}
