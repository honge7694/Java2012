package com.swcodingschool.oop;

public class Shopping5_4 {
    private long no;
    private String id;
    private String date;
    private String name;
    private String pno;
    private String addr;

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void shoppingPrint() {
        System.out.println("주문번호 : " + no);
        System.out.println("주문자 아이디 : " + id);
        System.out.println("주문 날짜 : " + date);
        System.out.println("주문자 이름 : " + name);
        System.out.println("주문 상품 번호 : " + pno);
        System.out.println("배송 주소 : " + addr);
    }
}
