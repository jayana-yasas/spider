package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pdcbasis {
    private String code;
    private String description;
    private String status;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdcbasis pdcbasis = (Pdcbasis) o;
        return Objects.equals(code, pdcbasis.code) &&
                Objects.equals(description, pdcbasis.description) &&
                Objects.equals(status, pdcbasis.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, description, status);
    }
}
