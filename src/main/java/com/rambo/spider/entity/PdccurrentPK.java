package com.rambo.spider.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PdccurrentPK implements Serializable {
    private String mode;
    private String code;

    @Column(name = "mode")
    @Id
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Column(name = "code")
    @Id
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdccurrentPK that = (PdccurrentPK) o;
        return Objects.equals(mode, that.mode) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mode, code);
    }
}
