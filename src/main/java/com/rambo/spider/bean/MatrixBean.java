package com.rambo.spider.bean;

import java.util.List;

public class MatrixBean {

    String lbl;
    List<Double> arr;

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    public List<Double> getArr() {
        return arr;
    }

    public void setArr(List<Double> arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "{" +
                "lbl='" + lbl + '\'' +
                ", arr=" + arr +
                '}';
    }
}
