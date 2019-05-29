package com.gotIt.gotshop.enumer;

public enum CouponSituation {

    COMMON("通用",0);

    private String name;

    private int index;

    CouponSituation(String name, int index) {
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
