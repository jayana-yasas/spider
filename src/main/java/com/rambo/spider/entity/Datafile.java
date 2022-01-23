package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Datafile {
    private String idData;
    private String product;
    private Timestamp month;
    private String facilityNo;
    private Timestamp activateDate;
    private String address;
    private Double advAdv;
    private Double ageRental;
    private Double age;
    private Double dc;
    private Double first;
    private String last;
    private Double worst;
    private String islast;
    private Double cavCav;
    private Double chrCap;
    private Double chrGst;
    private String clientFullName;
    private Double cloCap;
    private Double cloClo;
    private Double cloOth;
    private String district;
    private String equipDescription;
    private String equipType;
    private Timestamp expDate;
    private Double facilityAmount;
    private Integer facilityPeriod;
    private String facilityStatus;
    private String facilityType;
    private Integer fallenDueRentals;
    private Double futureCapital;
    private Double futureInterest;
    private Double gsoGso;
    private Double gstGst;
    private Double hyfHyf;
    private Double incCap;
    private Double incGat;
    private Double inoCap;
    private Double inoGst;
    private Double insIns;
    private Double interestInSuspence;
    private Double interestRate;
    private Double lglLgl;
    private Double luxLux;
    private Double ndpNdp;
    private String nicBr;
    private Double noOfArr;
    private Double ochCap;
    private Double ochGst;
    private Double ostOst;
    private Double othCap;
    private Double othGst;
    private Double overPayBalance;
    private String pNpFlag;
    private Double prePre;
    private Double rentalAmount;
    private Double rmvRmv;
    private Double rnoRno;
    private Double rntAmtArrears;
    private Double rntCap;
    private Double rntInt;
    private Double schCap;
    private Double schGst;
    private String sector;
    private Double setteld;
    private Double sifSif;
    private Integer stage;
    private Double tcTc;
    private Double totOutBalance;
    private Double totOutstanding;
    private Integer unUtilizedPrepayment;
    private Double upsUps;
    private Integer vatInSuspence;
    private Double wchWch;

    @Id
    @Column(name = "id_data")
    public String getIdData() {
        return idData;
    }

    public void setIdData(String idData) {
        this.idData = idData;
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
    @Column(name = "month")
    public Timestamp getMonth() {
        return month;
    }

    public void setMonth(Timestamp month) {
        this.month = month;
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
    @Column(name = "activate_date")
    public Timestamp getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Timestamp activateDate) {
        this.activateDate = activateDate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "adv_adv")
    public Double getAdvAdv() {
        return advAdv;
    }

    public void setAdvAdv(Double advAdv) {
        this.advAdv = advAdv;
    }

    @Basic
    @Column(name = "age_rental")
    public Double getAgeRental() {
        return ageRental;
    }

    public void setAgeRental(Double ageRental) {
        this.ageRental = ageRental;
    }

    @Basic
    @Column(name = "age")
    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Basic
    @Column(name = "dc")
    public Double getDc() {
        return dc;
    }

    public void setDc(Double dc) {
        this.dc = dc;
    }

    @Basic
    @Column(name = "first")
    public Double getFirst() {
        return first;
    }

    public void setFirst(Double first) {
        this.first = first;
    }

    @Basic
    @Column(name = "last")
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Basic
    @Column(name = "worst")
    public Double getWorst() {
        return worst;
    }

    public void setWorst(Double worst) {
        this.worst = worst;
    }

    @Basic
    @Column(name = "islast")
    public String getIslast() {
        return islast;
    }

    public void setIslast(String islast) {
        this.islast = islast;
    }

    @Basic
    @Column(name = "cav_cav")
    public Double getCavCav() {
        return cavCav;
    }

    public void setCavCav(Double cavCav) {
        this.cavCav = cavCav;
    }

    @Basic
    @Column(name = "chr_cap")
    public Double getChrCap() {
        return chrCap;
    }

    public void setChrCap(Double chrCap) {
        this.chrCap = chrCap;
    }

    @Basic
    @Column(name = "chr_gst")
    public Double getChrGst() {
        return chrGst;
    }

    public void setChrGst(Double chrGst) {
        this.chrGst = chrGst;
    }

    @Basic
    @Column(name = "client_full_name")
    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    @Basic
    @Column(name = "clo_cap")
    public Double getCloCap() {
        return cloCap;
    }

    public void setCloCap(Double cloCap) {
        this.cloCap = cloCap;
    }

    @Basic
    @Column(name = "clo_clo")
    public Double getCloClo() {
        return cloClo;
    }

    public void setCloClo(Double cloClo) {
        this.cloClo = cloClo;
    }

    @Basic
    @Column(name = "clo_oth")
    public Double getCloOth() {
        return cloOth;
    }

    public void setCloOth(Double cloOth) {
        this.cloOth = cloOth;
    }

    @Basic
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "equip_description")
    public String getEquipDescription() {
        return equipDescription;
    }

    public void setEquipDescription(String equipDescription) {
        this.equipDescription = equipDescription;
    }

    @Basic
    @Column(name = "equip_type")
    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    @Basic
    @Column(name = "exp_date")
    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "facility_amount")
    public Double getFacilityAmount() {
        return facilityAmount;
    }

    public void setFacilityAmount(Double facilityAmount) {
        this.facilityAmount = facilityAmount;
    }

    @Basic
    @Column(name = "facility_period")
    public Integer getFacilityPeriod() {
        return facilityPeriod;
    }

    public void setFacilityPeriod(Integer facilityPeriod) {
        this.facilityPeriod = facilityPeriod;
    }

    @Basic
    @Column(name = "facility_status")
    public String getFacilityStatus() {
        return facilityStatus;
    }

    public void setFacilityStatus(String facilityStatus) {
        this.facilityStatus = facilityStatus;
    }

    @Basic
    @Column(name = "facility_type")
    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    @Basic
    @Column(name = "fallen_due_rentals")
    public Integer getFallenDueRentals() {
        return fallenDueRentals;
    }

    public void setFallenDueRentals(Integer fallenDueRentals) {
        this.fallenDueRentals = fallenDueRentals;
    }

    @Basic
    @Column(name = "future_capital")
    public Double getFutureCapital() {
        return futureCapital;
    }

    public void setFutureCapital(Double futureCapital) {
        this.futureCapital = futureCapital;
    }

    @Basic
    @Column(name = "future_interest")
    public Double getFutureInterest() {
        return futureInterest;
    }

    public void setFutureInterest(Double futureInterest) {
        this.futureInterest = futureInterest;
    }

    @Basic
    @Column(name = "gso_gso")
    public Double getGsoGso() {
        return gsoGso;
    }

    public void setGsoGso(Double gsoGso) {
        this.gsoGso = gsoGso;
    }

    @Basic
    @Column(name = "gst_gst")
    public Double getGstGst() {
        return gstGst;
    }

    public void setGstGst(Double gstGst) {
        this.gstGst = gstGst;
    }

    @Basic
    @Column(name = "hyf_hyf")
    public Double getHyfHyf() {
        return hyfHyf;
    }

    public void setHyfHyf(Double hyfHyf) {
        this.hyfHyf = hyfHyf;
    }

    @Basic
    @Column(name = "inc_cap")
    public Double getIncCap() {
        return incCap;
    }

    public void setIncCap(Double incCap) {
        this.incCap = incCap;
    }

    @Basic
    @Column(name = "inc_gat")
    public Double getIncGat() {
        return incGat;
    }

    public void setIncGat(Double incGat) {
        this.incGat = incGat;
    }

    @Basic
    @Column(name = "ino_cap")
    public Double getInoCap() {
        return inoCap;
    }

    public void setInoCap(Double inoCap) {
        this.inoCap = inoCap;
    }

    @Basic
    @Column(name = "ino_gst")
    public Double getInoGst() {
        return inoGst;
    }

    public void setInoGst(Double inoGst) {
        this.inoGst = inoGst;
    }

    @Basic
    @Column(name = "ins_ins")
    public Double getInsIns() {
        return insIns;
    }

    public void setInsIns(Double insIns) {
        this.insIns = insIns;
    }

    @Basic
    @Column(name = "interest_in_suspence")
    public Double getInterestInSuspence() {
        return interestInSuspence;
    }

    public void setInterestInSuspence(Double interestInSuspence) {
        this.interestInSuspence = interestInSuspence;
    }

    @Basic
    @Column(name = "interest_rate")
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Basic
    @Column(name = "lgl_lgl")
    public Double getLglLgl() {
        return lglLgl;
    }

    public void setLglLgl(Double lglLgl) {
        this.lglLgl = lglLgl;
    }

    @Basic
    @Column(name = "lux_lux")
    public Double getLuxLux() {
        return luxLux;
    }

    public void setLuxLux(Double luxLux) {
        this.luxLux = luxLux;
    }

    @Basic
    @Column(name = "ndp_ndp")
    public Double getNdpNdp() {
        return ndpNdp;
    }

    public void setNdpNdp(Double ndpNdp) {
        this.ndpNdp = ndpNdp;
    }

    @Basic
    @Column(name = "nic_br")
    public String getNicBr() {
        return nicBr;
    }

    public void setNicBr(String nicBr) {
        this.nicBr = nicBr;
    }

    @Basic
    @Column(name = "no_of_arr")
    public Double getNoOfArr() {
        return noOfArr;
    }

    public void setNoOfArr(Double noOfArr) {
        this.noOfArr = noOfArr;
    }

    @Basic
    @Column(name = "och_cap")
    public Double getOchCap() {
        return ochCap;
    }

    public void setOchCap(Double ochCap) {
        this.ochCap = ochCap;
    }

    @Basic
    @Column(name = "och_gst")
    public Double getOchGst() {
        return ochGst;
    }

    public void setOchGst(Double ochGst) {
        this.ochGst = ochGst;
    }

    @Basic
    @Column(name = "ost_ost")
    public Double getOstOst() {
        return ostOst;
    }

    public void setOstOst(Double ostOst) {
        this.ostOst = ostOst;
    }

    @Basic
    @Column(name = "oth_cap")
    public Double getOthCap() {
        return othCap;
    }

    public void setOthCap(Double othCap) {
        this.othCap = othCap;
    }

    @Basic
    @Column(name = "oth_gst")
    public Double getOthGst() {
        return othGst;
    }

    public void setOthGst(Double othGst) {
        this.othGst = othGst;
    }

    @Basic
    @Column(name = "over_pay_balance")
    public Double getOverPayBalance() {
        return overPayBalance;
    }

    public void setOverPayBalance(Double overPayBalance) {
        this.overPayBalance = overPayBalance;
    }

    @Basic
    @Column(name = "p_np_flag")
    public String getpNpFlag() {
        return pNpFlag;
    }

    public void setpNpFlag(String pNpFlag) {
        this.pNpFlag = pNpFlag;
    }

    @Basic
    @Column(name = "pre_pre")
    public Double getPrePre() {
        return prePre;
    }

    public void setPrePre(Double prePre) {
        this.prePre = prePre;
    }

    @Basic
    @Column(name = "rental_amount")
    public Double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    @Basic
    @Column(name = "rmv_rmv")
    public Double getRmvRmv() {
        return rmvRmv;
    }

    public void setRmvRmv(Double rmvRmv) {
        this.rmvRmv = rmvRmv;
    }

    @Basic
    @Column(name = "rno_rno")
    public Double getRnoRno() {
        return rnoRno;
    }

    public void setRnoRno(Double rnoRno) {
        this.rnoRno = rnoRno;
    }

    @Basic
    @Column(name = "rnt_amt_arrears")
    public Double getRntAmtArrears() {
        return rntAmtArrears;
    }

    public void setRntAmtArrears(Double rntAmtArrears) {
        this.rntAmtArrears = rntAmtArrears;
    }

    @Basic
    @Column(name = "rnt_cap")
    public Double getRntCap() {
        return rntCap;
    }

    public void setRntCap(Double rntCap) {
        this.rntCap = rntCap;
    }

    @Basic
    @Column(name = "rnt_int")
    public Double getRntInt() {
        return rntInt;
    }

    public void setRntInt(Double rntInt) {
        this.rntInt = rntInt;
    }

    @Basic
    @Column(name = "sch_cap")
    public Double getSchCap() {
        return schCap;
    }

    public void setSchCap(Double schCap) {
        this.schCap = schCap;
    }

    @Basic
    @Column(name = "sch_gst")
    public Double getSchGst() {
        return schGst;
    }

    public void setSchGst(Double schGst) {
        this.schGst = schGst;
    }

    @Basic
    @Column(name = "sector")
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Basic
    @Column(name = "setteld")
    public Double getSetteld() {
        return setteld;
    }

    public void setSetteld(Double setteld) {
        this.setteld = setteld;
    }

    @Basic
    @Column(name = "sif_sif")
    public Double getSifSif() {
        return sifSif;
    }

    public void setSifSif(Double sifSif) {
        this.sifSif = sifSif;
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
    @Column(name = "tc_tc")
    public Double getTcTc() {
        return tcTc;
    }

    public void setTcTc(Double tcTc) {
        this.tcTc = tcTc;
    }

    @Basic
    @Column(name = "tot_out_balance")
    public Double getTotOutBalance() {
        return totOutBalance;
    }

    public void setTotOutBalance(Double totOutBalance) {
        this.totOutBalance = totOutBalance;
    }

    @Basic
    @Column(name = "tot_outstanding")
    public Double getTotOutstanding() {
        return totOutstanding;
    }

    public void setTotOutstanding(Double totOutstanding) {
        this.totOutstanding = totOutstanding;
    }

    @Basic
    @Column(name = "un_utilized_prepayment")
    public Integer getUnUtilizedPrepayment() {
        return unUtilizedPrepayment;
    }

    public void setUnUtilizedPrepayment(Integer unUtilizedPrepayment) {
        this.unUtilizedPrepayment = unUtilizedPrepayment;
    }

    @Basic
    @Column(name = "ups_ups")
    public Double getUpsUps() {
        return upsUps;
    }

    public void setUpsUps(Double upsUps) {
        this.upsUps = upsUps;
    }

    @Basic
    @Column(name = "vat_in_suspence")
    public Integer getVatInSuspence() {
        return vatInSuspence;
    }

    public void setVatInSuspence(Integer vatInSuspence) {
        this.vatInSuspence = vatInSuspence;
    }

    @Basic
    @Column(name = "wch_wch")
    public Double getWchWch() {
        return wchWch;
    }

    public void setWchWch(Double wchWch) {
        this.wchWch = wchWch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datafile datafile = (Datafile) o;
        return Objects.equals(idData, datafile.idData) &&
                Objects.equals(product, datafile.product) &&
                Objects.equals(month, datafile.month) &&
                Objects.equals(facilityNo, datafile.facilityNo) &&
                Objects.equals(activateDate, datafile.activateDate) &&
                Objects.equals(address, datafile.address) &&
                Objects.equals(advAdv, datafile.advAdv) &&
                Objects.equals(ageRental, datafile.ageRental) &&
                Objects.equals(age, datafile.age) &&
                Objects.equals(dc, datafile.dc) &&
                Objects.equals(first, datafile.first) &&
                Objects.equals(last, datafile.last) &&
                Objects.equals(worst, datafile.worst) &&
                Objects.equals(islast, datafile.islast) &&
                Objects.equals(cavCav, datafile.cavCav) &&
                Objects.equals(chrCap, datafile.chrCap) &&
                Objects.equals(chrGst, datafile.chrGst) &&
                Objects.equals(clientFullName, datafile.clientFullName) &&
                Objects.equals(cloCap, datafile.cloCap) &&
                Objects.equals(cloClo, datafile.cloClo) &&
                Objects.equals(cloOth, datafile.cloOth) &&
                Objects.equals(district, datafile.district) &&
                Objects.equals(equipDescription, datafile.equipDescription) &&
                Objects.equals(equipType, datafile.equipType) &&
                Objects.equals(expDate, datafile.expDate) &&
                Objects.equals(facilityAmount, datafile.facilityAmount) &&
                Objects.equals(facilityPeriod, datafile.facilityPeriod) &&
                Objects.equals(facilityStatus, datafile.facilityStatus) &&
                Objects.equals(facilityType, datafile.facilityType) &&
                Objects.equals(fallenDueRentals, datafile.fallenDueRentals) &&
                Objects.equals(futureCapital, datafile.futureCapital) &&
                Objects.equals(futureInterest, datafile.futureInterest) &&
                Objects.equals(gsoGso, datafile.gsoGso) &&
                Objects.equals(gstGst, datafile.gstGst) &&
                Objects.equals(hyfHyf, datafile.hyfHyf) &&
                Objects.equals(incCap, datafile.incCap) &&
                Objects.equals(incGat, datafile.incGat) &&
                Objects.equals(inoCap, datafile.inoCap) &&
                Objects.equals(inoGst, datafile.inoGst) &&
                Objects.equals(insIns, datafile.insIns) &&
                Objects.equals(interestInSuspence, datafile.interestInSuspence) &&
                Objects.equals(interestRate, datafile.interestRate) &&
                Objects.equals(lglLgl, datafile.lglLgl) &&
                Objects.equals(luxLux, datafile.luxLux) &&
                Objects.equals(ndpNdp, datafile.ndpNdp) &&
                Objects.equals(nicBr, datafile.nicBr) &&
                Objects.equals(noOfArr, datafile.noOfArr) &&
                Objects.equals(ochCap, datafile.ochCap) &&
                Objects.equals(ochGst, datafile.ochGst) &&
                Objects.equals(ostOst, datafile.ostOst) &&
                Objects.equals(othCap, datafile.othCap) &&
                Objects.equals(othGst, datafile.othGst) &&
                Objects.equals(overPayBalance, datafile.overPayBalance) &&
                Objects.equals(pNpFlag, datafile.pNpFlag) &&
                Objects.equals(prePre, datafile.prePre) &&
                Objects.equals(rentalAmount, datafile.rentalAmount) &&
                Objects.equals(rmvRmv, datafile.rmvRmv) &&
                Objects.equals(rnoRno, datafile.rnoRno) &&
                Objects.equals(rntAmtArrears, datafile.rntAmtArrears) &&
                Objects.equals(rntCap, datafile.rntCap) &&
                Objects.equals(rntInt, datafile.rntInt) &&
                Objects.equals(schCap, datafile.schCap) &&
                Objects.equals(schGst, datafile.schGst) &&
                Objects.equals(sector, datafile.sector) &&
                Objects.equals(setteld, datafile.setteld) &&
                Objects.equals(sifSif, datafile.sifSif) &&
                Objects.equals(stage, datafile.stage) &&
                Objects.equals(tcTc, datafile.tcTc) &&
                Objects.equals(totOutBalance, datafile.totOutBalance) &&
                Objects.equals(totOutstanding, datafile.totOutstanding) &&
                Objects.equals(unUtilizedPrepayment, datafile.unUtilizedPrepayment) &&
                Objects.equals(upsUps, datafile.upsUps) &&
                Objects.equals(vatInSuspence, datafile.vatInSuspence) &&
                Objects.equals(wchWch, datafile.wchWch);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idData, product, month, facilityNo, activateDate, address, advAdv, ageRental, age, dc, first, last, worst, islast, cavCav, chrCap, chrGst, clientFullName, cloCap, cloClo, cloOth, district, equipDescription, equipType, expDate, facilityAmount, facilityPeriod, facilityStatus, facilityType, fallenDueRentals, futureCapital, futureInterest, gsoGso, gstGst, hyfHyf, incCap, incGat, inoCap, inoGst, insIns, interestInSuspence, interestRate, lglLgl, luxLux, ndpNdp, nicBr, noOfArr, ochCap, ochGst, ostOst, othCap, othGst, overPayBalance, pNpFlag, prePre, rentalAmount, rmvRmv, rnoRno, rntAmtArrears, rntCap, rntInt, schCap, schGst, sector, setteld, sifSif, stage, tcTc, totOutBalance, totOutstanding, unUtilizedPrepayment, upsUps, vatInSuspence, wchWch);
    }

    @Override
    public String toString() {
        return "Datafile{" +
                "idData='" + idData + '\'' +
                ", product='" + product + '\'' +
                ", month=" + month +
                ", facilityNo='" + facilityNo + '\'' +
                ", age=" + age +
                ", dc=" + dc +
                ", first=" + first +
                ", last='" + last + '\'' +
                ", worst=" + worst +
                '}';
    }
}
