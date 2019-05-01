package com.gotIt.gotshop.enumer;

public enum OrderStatus {
    UNPAID("待支付",0),
    CANCEL("已取消",1),
    UNDELIVER("待配送",2),
    UNRECEIVE("待收货",3),
    UNCOMMENT("待评价",4),
    REMOVE("已删除",5);

    private String name;

    private int index;

    OrderStatus(String name, int index) {
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
