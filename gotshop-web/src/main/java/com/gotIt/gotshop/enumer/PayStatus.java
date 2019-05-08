package com.gotIt.gotshop.enumer;

public enum PayStatus {
    UNPAID("未支付",0),
    PAID("已支付",1);
    private String name;

    private int index;

    PayStatus(String name, int index) {
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
