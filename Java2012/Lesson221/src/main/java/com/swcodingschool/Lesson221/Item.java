package com.swcodingschool.Lesson221;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
  private static final String temp[]= {"Hello", "Hong Gilddong","Park Munsu"};
  private static final AtomicLong counter = new AtomicLong();
  
  private Long id;
  private String quote;

  public Item() {
	  int i = (int)(Math.random()*3);
	  this.id = counter.incrementAndGet();
	  this.quote = temp[i];
  }

  public Long getId() {
    return this.id;
  }

  public String getQuote() {
    return this.quote;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", quote='" + quote + '\'' +
        '}';
  }
}