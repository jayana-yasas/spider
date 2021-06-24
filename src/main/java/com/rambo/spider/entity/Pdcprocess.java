package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pdcprocess {
    private int id;
    private Integer stage;
    private Integer currentYear;
    private String calMode;
    private String currentCal;
    private String sicr;
    private String defaultPoint;
    private String calMethod;
    private String daLevel;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stage")
    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
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
    @Column(name = "cal_method")
    public String getCalMethod() {
        return calMethod;
    }

    public void setCalMethod(String calMethod) {
        this.calMethod = calMethod;
    }

    @Basic
    @Column(name = "da_level")
    public String getDaLevel() {
        return daLevel;
    }

    public void setDaLevel(String daLevel) {
        this.daLevel = daLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdcprocess that = (Pdcprocess) o;
        return id == that.id &&
                Objects.equals(stage, that.stage) &&
                Objects.equals(currentYear, that.currentYear) &&
                Objects.equals(calMode, that.calMode) &&
                Objects.equals(currentCal, that.currentCal) &&
                Objects.equals(sicr, that.sicr) &&
                Objects.equals(defaultPoint, that.defaultPoint) &&
                Objects.equals(calMethod, that.calMethod) &&
                Objects.equals(daLevel, that.daLevel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stage, currentYear, calMode, currentCal, sicr, defaultPoint, calMethod, daLevel);
    }
}