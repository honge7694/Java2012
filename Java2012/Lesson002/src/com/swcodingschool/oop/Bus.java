package com.swcodingschool.oop;

public class Bus {
    int busNumber;
    int passengerCount;
    int money;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    } // end of Bus

    public void take(int money) {
        this.money += money;
        passengerCount++;
    }

    public void takeOffBus() {
        passengerCount--;
    }

    public void showInfo() {
        System.out.println("버스 " + busNumber + "번의 승객은 " + passengerCount + " 수입은 " + money + "입니다.");
    } // end of showInfo()

} // end of class Bus
