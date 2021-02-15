package com.swcodingschool.oop;

public class Person5_4 {
    private int age;
    private String name;
    private boolean marry;
    private int child;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public void introduce() {
        System.out.println("나이 : " + age);
        System.out.println("이름 : " + name);
        System.out.println("결혼여부 : " + marry);
        System.out.println("자녀 수 : " + child);
    }

}
