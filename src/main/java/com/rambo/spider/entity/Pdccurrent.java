package com.rambo.spider.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(PdccurrentPK.class)
public class Pdccurrent {
    private String mode;
    private String code;
    private String description;
    private String status;

    @Id
    @Column(name = "mode")
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

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
        Pdccurrent that = (Pdccurrent) o;
        return Objects.equals(mode, that.mode) &&
                Objects.equals(code, that.code) &&
                Objects.equals(description, that.description) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mode, code, description, status);
    }
}
