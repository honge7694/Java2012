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
	} // end constructor

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	/*
	 * Next : Step 3. Resource Controller 생성 및 이동.
	 * GreetingController.java
	 */
} // end of Greeting


