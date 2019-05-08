package com.gotIt.gotshop.enumer;

public enum CategoryStatus {

    EFFECTIVE("有效",0),
    ineffective("无效",1);

    private String name;

    private int index;

    CategoryStatus(String name, int index) {
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
