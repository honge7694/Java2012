package com.swcodingschool.oop;

public class MyDate5 {
	private int day;
	private	int month;
	private int year;
	private boolean isValid = true;
	
	MyDate5(int day, int month, int year){
		setDay(day);
		setMonth(month);
		setYear(year);
		
		System.out.println(day + " " + month + " " + year + " " + isValid);
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		switch(month) {
		case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
			if(day <= 31 && day > 0) {
				this.day = day;
			}else{
				isValid = false;
			}
			break;
			
		case 2 :
			if(day <= 28 && day > 0) {
				this.day = day;
			}else{
				isValid = false;
			}
			break;
			
		case 4 : case 6 : case 9 : case 11 :
			if(day <= 30 && day > 0) {
				this.day = day;
			}else {
				isValid = false;
			}
			break;
//			default를 주면 옳은 값도 false가 나옴.
//		default :
//			isValid = false; 
		}
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		if(month > 0 && month < 13) {
			this.month = month;
		}else {
			isValid = false;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String isValid() {
		if(isValid) {
			return "유요한 날짜입니다.";
		}else {
			return "유효하지 않은 날짜입니다.";
		}
	}
	
	
}
