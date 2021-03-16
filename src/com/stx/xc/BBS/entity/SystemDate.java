package com.stx.xc.BBS.entity;

public class SystemDate {
    String key;
    String value;

    public SystemDate() {
    }

    public SystemDate(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SystemDate{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

