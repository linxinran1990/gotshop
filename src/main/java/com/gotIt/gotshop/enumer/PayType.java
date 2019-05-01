package com.gotIt.gotshop.enumer;

public enum PayType {
    ALIPAY("支付宝",0),
    WECHATPAY("微信支付",1);
    private String name;

    private int index;

    PayType(String name, int index) {
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
