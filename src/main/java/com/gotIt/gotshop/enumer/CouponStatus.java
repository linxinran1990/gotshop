package com.gotIt.gotshop.enumer;

public enum CouponStatus {

    UNUSED("未使用",0),
    USED("已使用",1),
    EXPIRED("已过期",2);

    private String name;

    private int index;

    CouponStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
