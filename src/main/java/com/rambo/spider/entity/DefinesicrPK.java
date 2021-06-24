package com.rambo.spider.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DefinesicrPK implements Serializable {
    private String pdcbasis;
    private String sicr;

    @Column(name = "pdcbasis")
    @Id
    public String getPdcbasis() {
        return pdcbasis;
    }

    public void setPdcbasis(String pdcbasis) {
        this.pdcbasis = pdcbasis;
    }

    @Column(name = "sicr")
    @Id
    public String getSicr() {
        return sicr;
    }

    public void setSicr(String sicr) {
        this.sicr = sicr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefinesicrPK that = (DefinesicrPK) o;
        return Objects.equals(pdcbasis, that.pdcbasis) &&
                Objects.equals(sicr, that.sicr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pdcbasis, sicr);
    }
}
