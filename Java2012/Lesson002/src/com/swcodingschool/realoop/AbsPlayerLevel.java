package com.swcodingschool.realoop;

public abstract class AbsPlayerLevel {
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	
	final public void go(int count) {
		showLevelMessage();
		run();
		for(int i = 1; i <= count; i++) {
			jump();
		} // end of for
		turn();
		
	} // end of go()
} // end of class
