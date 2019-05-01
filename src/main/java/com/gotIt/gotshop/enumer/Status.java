package com.gotIt.gotshop.enumer;

public enum Status {

    USING("正常使用",0),
    ABANDON("废弃",1);

    private String name;

    private int index;

    Status(String name, int index) {
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
