package com.swcodingschool.guibasic;

import java.util.ArrayList;
import java.util.LinkedList;

class MyStack {
    private ArrayList<String> arrayStack = new ArrayList<String>();

    public void push(String data) {
        arrayStack.add(data);
    }

    public String pop() {
        int len = arrayStack.size();
        if (len == 0) {
            System.out.println("스택이 비었습니다.");
            return "스택이 비었습니다.";
        }
        return (arrayStack.remove(len - 1));
    }

}

public class TestStack419 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyStack mystack = new MyStack();

        mystack.push("A");
        mystack.push("B");
        mystack.push("C");

        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());


    }

}
