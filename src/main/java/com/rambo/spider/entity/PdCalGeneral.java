package com.rambo.spider.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pd_cal_general", schema = "pdc", catalog = "")
public class PdCalGeneral {
    private int id;
    private String calMethod;
    private String product;
    private String calMode;
    private String currentCal;
    private Integer currentYear;
    private String daLevel;
    private String basis;
    private String sicr;
    private String defaultPoint;
    private Integer stage;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cal_method")
    public String getCalMethod() {
        return calMethod;
    }

    public void setCalMethod(String calMethod) {
        this.calMethod = calMethod;
    }

    @Basic
    @Column(name = "product")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "cal_mode")
    public String getCalMode() {
        return calMode;
    }

    public void setCalMode(String calMode) {
        this.calMode = calMode;
    }

    @Basic
    @Column(name = "current_cal")
    public String getCurrentCal() {
        return currentCal;
    }

    public void setCurrentCal(String currentCal) {
        this.currentCal = currentCal;
    }

    @Basic
    @Column(name = "current_year")
    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    @Basic
    @Column(name = "da_level")
    public String getDaLevel() {
        return daLevel;
    }

    public void setDaLevel(String daLevel) {
        this.daLevel = daLevel;
    }

    @Basic
    @Column(name = "basis")
    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    @Basic
    @Column(name = "sicr")
    public String getSicr() {
        return sicr;
    }

    public void setSicr(String sicr) {
        this.sicr = sicr;
    }

    @Basic
    @Column(name = "default_point")
    public String getDefaultPoint() {
        return defaultPoint;
    }

    public void setDefaultPoint(String defaultPoint) {
        this.defaultPoint = defaultPoint;
    }

    @Basic
    @Column(name = "stage")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdCalGeneral that = (PdCalGeneral) o;
        return id == that.id &&
                Objects.equals(calMethod, that.calMethod) &&
                Objects.equals(product, that.product) &&
                Objects.equals(calMode, that.calMode) &&
                Objects.equals(currentCal, that.currentCal) &&
                Objects.equals(currentYear, that.currentYear) &&
                Objects.equals(daLevel, that.daLevel) &&
                Objects.equals(basis, that.basis) &&
                Objects.equals(sicr, that.sicr) &&
                Objects.equals(defaultPoint, that.defaultPoint) &&
                Objects.equals(stage, that.stage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, calMethod, product, calMode, currentCal, currentYear, daLevel, basis, sicr, defaultPoint, stage);
    }
}
