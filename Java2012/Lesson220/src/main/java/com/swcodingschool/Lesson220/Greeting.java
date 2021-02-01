package com.swcodingschool.Lesson220;
/*
 * Step 2. Create Resource Representation Class
 */
public class Greeting {
	private final long id;
	private final String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}// end constructor

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	/*
	 * next : Step 3. create resource controller 
	 * GreetingController.java
	 */
}//end of class

