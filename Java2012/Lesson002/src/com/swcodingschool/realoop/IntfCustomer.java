package com.swcodingschool.realoop;

public class IntfCustomer implements IntfBuy, IntfSell {

	@Override
	public void Sell() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void order() {
		// TODO Auto-generated method stub
		System.out.println("구매 판매 주문");
	}

	@Override
	public void Bargainsale() {
		// TODO Auto-generated method stub
		System.out.println("바겐세일");
	}

	@Override
	public void purchase() {
		// TODO Auto-generated method stub
		System.out.println("대량구매");
	}
	
	
}
