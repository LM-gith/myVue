package com.lm.optional.bean;

public class Country {
    String isocode;

    public Country(String isocode) {
        this.isocode = isocode;
    }

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }
}
