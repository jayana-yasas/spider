package com.rambo.spider.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(DefinesicrPK.class)
public class Definesicr {
    private String pdcbasis;
    private String sicr;
    private String description;

    @Id
    @Column(name = "pdcbasis")
    public String getPdcbasis() {
        return pdcbasis;
    }

    public void setPdcbasis(String pdcbasis) {
        this.pdcbasis = pdcbasis;
    }

    @Id
    @Column(name = "sicr")
    public String getSicr() {
        return sicr;
    }

    public void setSicr(String sicr) {
        this.sicr = sicr;
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
        Definesicr that = (Definesicr) o;
        return Objects.equals(pdcbasis, that.pdcbasis) &&
                Objects.equals(sicr, that.sicr) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pdcbasis, sicr, description);
    }
}
