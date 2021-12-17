package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Matrix {
    private int first;
    private Integer c1;
    private Integer c2;
    private Integer c3;
    private Integer c4;
    private Integer c5;
    private Integer c6;
    private Integer c7;
    private Integer c8;
    private Integer grandTotal;
    private Double percentage;

    @Id
    @Column(name = "first")
    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    @Basic
    @Column(name = "c1")
    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    @Basic
    @Column(name = "c2")
    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    @Basic
    @Column(name = "c3")
    public Integer getC3() {
        return c3;
    }

    public void setC3(Integer c3) {
        this.c3 = c3;
    }

    @Basic
    @Column(name = "c4")
    public Integer getC4() {
        return c4;
    }

    public void setC4(Integer c4) {
        this.c4 = c4;
    }

    @Basic
    @Column(name = "c5")
    public Integer getC5() {
        return c5;
    }

    public void setC5(Integer c5) {
        this.c5 = c5;
    }

    @Basic
    @Column(name = "c6")
    public Integer getC6() {
        return c6;
    }

    public void setC6(Integer c6) {
        this.c6 = c6;
    }

    @Basic
    @Column(name = "c7")
    public Integer getC7() {
        return c7;
    }

    public void setC7(Integer c7) {
        this.c7 = c7;
    }

    @Basic
    @Column(name = "c8")
    public Integer getC8() {
        return c8;
    }

    public void setC8(Integer c8) {
        this.c8 = c8;
    }

    @Basic
    @Column(name = "grand_total")
    public Integer getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Integer grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Basic
    @Column(name = "percentage")
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return first == matrix.first &&
                Objects.equals(c1, matrix.c1) &&
                Objects.equals(c2, matrix.c2) &&
                Objects.equals(c3, matrix.c3) &&
                Objects.equals(c4, matrix.c4) &&
                Objects.equals(c5, matrix.c5) &&
                Objects.equals(c6, matrix.c6) &&
                Objects.equals(c7, matrix.c7) &&
                Objects.equals(c8, matrix.c8) &&
                Objects.equals(grandTotal, matrix.grandTotal) &&
                Objects.equals(percentage, matrix.percentage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, c1, c2, c3, c4, c5, c6, c7, c8, grandTotal, percentage);
    }
}
