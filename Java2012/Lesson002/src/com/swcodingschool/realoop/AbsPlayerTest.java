package com.swcodingschool.realoop;

public class AbsPlayerTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbsPlayerLevel c1 = new AbsPlayerBeginner();
        AbsPlayerLevel c2 = new AbsPlayerAdvanced();
        AbsPlayerLevel c3 = new AbsPlayerSuper();

        c1.go(1);
        c2.go(2);
        c3.go(3);
    } // end of main

} // end of class
