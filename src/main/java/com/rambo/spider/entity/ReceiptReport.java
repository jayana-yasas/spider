package com.rambo.spider.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "receipt_report")
public class ReceiptReport {
    private String receipt;
    private String facilityNo;
    private Date date;
    private Double amount;
    private Integer dateGap;
    private Double pvFactor;
    private Double pvReceipt;

    @Id
    @Column(name = "receipt")
    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @Basic
    @Column(name = "facility_no")
    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date_gap")
    public Integer getDateGap() {
        return dateGap;
    }

    public void setDateGap(Integer dateGap) {
        this.dateGap = dateGap;
    }

    @Basic
    @Column(name = "pv_factor")
    public Double getPvFactor() {
        return pvFactor;
    }

    public void setPvFactor(Double pvFactor) {
        this.pvFactor = pvFactor;
    }

    @Basic
    @Column(name = "pv_receipt")
    public Double getPvReceipt() {
        return pvReceipt;
    }

    public void setPvReceipt(Double pvReceipt) {
        this.pvReceipt = pvReceipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptReport that = (ReceiptReport) o;
        return Objects.equals(receipt, that.receipt) &&
                Objects.equals(facilityNo, that.facilityNo) &&
                Objects.equals(date, that.date) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(dateGap, that.dateGap) &&
                Objects.equals(pvFactor, that.pvFactor) &&
                Objects.equals(pvReceipt, that.pvReceipt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(receipt, facilityNo, date, amount, dateGap, pvFactor, pvReceipt);
    }

    @Override
    public String toString() {
        return "ReceiptReport{" +
                "receipt='" + receipt + '\'' +
                ", facilityNo='" + facilityNo + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
