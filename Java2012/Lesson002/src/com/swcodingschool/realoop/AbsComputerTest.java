package com.swcodingschool.realoop;

public class AbsComputerTest {

    public static void main(String[] args) {
        //AbsComputer c1 = new AbsComputer();
        AbsComputer c2 = new AbsDesktop();
        //AbsComputer c3 = new AbsNotebook();
        AbsComputer c4 = new AbsMyNotebook();

        c2.display();
        c2.typing();
        c4.display();
        c4.typing();
    }

}
