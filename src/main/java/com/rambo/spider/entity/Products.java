package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Products {
    private String code;
    private String name;
    private String status;
    private String basis;
    private String sicr;
    private String defaultpoint;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "defaultpoint")
    public String getDefaultpoint() {
        return defaultpoint;
    }

    public void setDefaultpoint(String defaultpoint) {
        this.defaultpoint = defaultpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(code, products.code) &&
                Objects.equals(name, products.name) &&
                Objects.equals(status, products.status) &&
                Objects.equals(basis, products.basis) &&
                Objects.equals(sicr, products.sicr) &&
                Objects.equals(defaultpoint, products.defaultpoint);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, name, status, basis, sicr, defaultpoint);
    }
}
