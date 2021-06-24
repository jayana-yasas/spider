package com.rambo.spider.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class YearcurrentPK implements Serializable {
    private int defineyear;
    private String currentyear;

    @Column(name = "defineyear")
    @Id
    public int getDefineyear() {
        return defineyear;
    }

    public void setDefineyear(int defineyear) {
        this.defineyear = defineyear;
    }

    @Column(name = "currentyear")
    @Id
    public String getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(String currentyear) {
        this.currentyear = currentyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearcurrentPK that = (YearcurrentPK) o;
        return defineyear == that.defineyear &&
                Objects.equals(currentyear, that.currentyear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(defineyear, currentyear);
    }
}
