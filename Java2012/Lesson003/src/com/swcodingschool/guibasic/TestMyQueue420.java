package com.swcodingschool.guibasic;

import java.util.ArrayList;

class MyQueue {
    private ArrayList<String> arrayQueue = new ArrayList<String>();

    public void enQueue(String data) {
        arrayQueue.add(data);
    }

    public String deQueue() {
        int len = arrayQueue.size();

        if (len == 0) {
            System.out.println("arrayQueue는 비어있습니다.");
            return null;
        }

        return arrayQueue.remove(0);
    }
}

public class TestMyQueue420 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyQueue myqueue = new MyQueue();

        myqueue.enQueue("A");
        myqueue.enQueue("B");
        myqueue.enQueue("C");

        System.out.println(myqueue.deQueue());
        System.out.println(myqueue.deQueue());
        System.out.println(myqueue.deQueue());

    }

}
