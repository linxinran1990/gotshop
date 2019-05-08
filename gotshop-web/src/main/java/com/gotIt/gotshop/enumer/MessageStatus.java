package com.gotIt.gotshop.enumer;

public enum MessageStatus {

    UNREAD("未读",0),
    READ("已读",1);
    private String name;

    private int index;

    MessageStatus(String name, int index) {
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
