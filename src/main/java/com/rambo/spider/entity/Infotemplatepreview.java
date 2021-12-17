package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Infotemplatepreview {
    private String id;
    private Date month;
    private Double bucket1;
    private Double bucket2;
    private Double bucket3;
    private Double bucket4;
    private Double bucket5;
    private Double bucket6;
    private Double bucket7;
    private Double bucket8;
    private int state;
    private Double pdb1;
    private Double pdb2;
    private Double pdb3;
    private Double pdb4;
    private Double pdb5;
    private Double pdb6;
    private Double pdb7;
    private Double pdb8;


    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "month")
    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    @Basic
    @Column(name = "bucket_1")
    public Double getBucket1() {
        return bucket1;
    }

    public void setBucket1(Double bucket1) {
        this.bucket1 = bucket1;
    }

    @Basic
    @Column(name = "bucket_2")
    public Double getBucket2() {
        return bucket2;
    }

    public void setBucket2(Double bucket2) {
        this.bucket2 = bucket2;
    }

    @Basic
    @Column(name = "bucket_3")
    public Double getBucket3() {
        return bucket3;
    }

    public void setBucket3(Double bucket3) {
        this.bucket3 = bucket3;
    }

    @Basic
    @Column(name = "bucket_4")
    public Double getBucket4() {
        return bucket4;
    }

    public void setBucket4(Double bucket4) {
        this.bucket4 = bucket4;
    }

    @Basic
    @Column(name = "bucket_5")
    public Double getBucket5() {
        return bucket5;
    }

    public void setBucket5(Double bucket5) {
        this.bucket5 = bucket5;
    }

    @Basic
    @Column(name = "bucket_6")
    public Double getBucket6() {
        return bucket6;
    }

    public void setBucket6(Double bucket6) {
        this.bucket6 = bucket6;
    }

    @Basic
    @Column(name = "bucket_7")
    public Double getBucket7() {
        return bucket7;
    }

    public void setBucket7(Double bucket7) {
        this.bucket7 = bucket7;
    }

    @Basic
    @Column(name = "bucket_8")
    public Double getBucket8() {
        return bucket8;
    }

    public void setBucket8(Double bucket8) {
        this.bucket8 = bucket8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infotemplatepreview that = (Infotemplatepreview) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(month, that.month) &&
                Objects.equals(bucket1, that.bucket1) &&
                Objects.equals(bucket2, that.bucket2) &&
                Objects.equals(bucket3, that.bucket3) &&
                Objects.equals(bucket4, that.bucket4) &&
                Objects.equals(bucket5, that.bucket5) &&
                Objects.equals(bucket6, that.bucket6) &&
                Objects.equals(bucket7, that.bucket7) &&
                Objects.equals(bucket8, that.bucket8);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, month, bucket1, bucket2, bucket3, bucket4, bucket5, bucket6, bucket7, bucket8);
    }

    @Basic
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "PDB_1")
    public Double getPdb1() {
        return pdb1;
    }

    public void setPdb1(Double pdb1) {
        this.pdb1 = pdb1;
    }

    @Basic
    @Column(name = "PDB_2")
    public Double getPdb2() {
        return pdb2;
    }

    public void setPdb2(Double pdb2) {
        this.pdb2 = pdb2;
    }

    @Basic
    @Column(name = "PDB_3")
    public Double getPdb3() {
        return pdb3;
    }

    public void setPdb3(Double pdb3) {
        this.pdb3 = pdb3;
    }

    @Basic
    @Column(name = "PDB_4")
    public Double getPdb4() {
        return pdb4;
    }

    public void setPdb4(Double pdb4) {
        this.pdb4 = pdb4;
    }

    @Basic
    @Column(name = "PDB_5")
    public Double getPdb5() {
        return pdb5;
    }

    public void setPdb5(Double pdb5) {
        this.pdb5 = pdb5;
    }

    @Basic
    @Column(name = "PDB_6")
    public Double getPdb6() {
        return pdb6;
    }

    public void setPdb6(Double pdb6) {
        this.pdb6 = pdb6;
    }

    @Basic
    @Column(name = "PDB_7")
    public Double getPdb7() {
        return pdb7;
    }

    public void setPdb7(Double pdb7) {
        this.pdb7 = pdb7;
    }

    @Basic
    @Column(name = "PDB_8")
    public Double getPdb8() {
        return pdb8;
    }

    public void setPdb8(Double pdb8) {
        this.pdb8 = pdb8;
    }

    @Override
    public String toString() {
        return "Infotemplatepreview{" +
                "id='" + id + '\'' +
                ", month=" + month +
                ", bucket1=" + bucket1 +
                ", bucket2=" + bucket2 +
                ", bucket3=" + bucket3 +
                ", bucket4=" + bucket4 +
                ", bucket5=" + bucket5 +
                ", bucket6=" + bucket6 +
                ", bucket7=" + bucket7 +
                ", bucket8=" + bucket8 +
                ", state=" + state +
                ", pdb1=" + pdb1 +
                ", pdb2=" + pdb2 +
                ", pdb3=" + pdb3 +
                ", pdb4=" + pdb4 +
                ", pdb5=" + pdb5 +
                ", pdb6=" + pdb6 +
                ", pdb7=" + pdb7 +
                ", pdb8=" + pdb8 +
                '}';
    }
}
