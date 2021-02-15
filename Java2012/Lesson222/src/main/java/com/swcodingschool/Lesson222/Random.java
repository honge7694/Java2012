package com.swcodingschool.Lesson222;

import java.util.concurrent.atomic.AtomicLong;

/*
 * Step 2. Create Resource Representation Class
 */
public class Random {

    private String type;
    private Item item;

    public Random() {
        this.type = "success";
        this.item = new Item();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getValue() {
        return item;
    }

    public void setValue(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Random{" +
                "type='" + type + '\'' +
                ", item =" + item +
                '}';
    }

}//end of class

