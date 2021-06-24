package com.rambo.spider.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(YearcurrentPK.class)
public class Yearcurrent {
    private int defineyear;
    private String currentyear;
    private String description;

    @Id
    @Column(name = "defineyear")
    public int getDefineyear() {
        return defineyear;
    }

    public void setDefineyear(int defineyear) {
        this.defineyear = defineyear;
    }

    @Id
    @Column(name = "currentyear")
    public String getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(String currentyear) {
        this.currentyear = currentyear;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yearcurrent that = (Yearcurrent) o;
        return defineyear == that.defineyear &&
                Objects.equals(currentyear, that.currentyear) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(defineyear, currentyear, description);
    }
}
