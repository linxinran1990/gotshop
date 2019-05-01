package com.gotIt.gotshop.enumer;

public enum ProductStatus {
    NEW("上架",0),
    SOLDOUT("下架",1);

    private String name;

    private int index;

    ProductStatus(String name, int index) {
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
