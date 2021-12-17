package com.rambo.spider.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Datafile  {
    private String idData;
    private String product;
    private Date month;
    private Integer stage;
    private String facilityNo;
    private String clientFullName;
    private String nicBr;
    private String address;
    private Integer facilityPeriod;
    private Double facilityAmount;
    private String facilityStatus;
    private Date activateDate;
    private Double rentalAmount;
    private String facilityType;
    private Double interestRate;
    private Double noOfArr;
    private String pNpFlag;
    private Double futureCapital;
    private Double futureInterest;
    private Double interestInSuspence;
    private Integer vatInSuspence;
    private Double overPayBalance;
    private Integer unUtilizedPrepayment;
    private Double rntCap;
    private Double rntInt;
    private Double prePre;
    private Double rnoRno;
    private Double gsoGso;
    private Double insIns;
    private Double inoCap;
    private Double inoGst;
    private Double gstGst;
    private Double chrCap;
    private Double chrGst;
    private Double upsUps;
    private Double rmvRmv;
    private Double ndpNdp;
    private Double ochCap;
    private Double ochGst;
    private Double incCap;
    private Double incGat;
    private Double othGst;
    private Double sifSif;
    private Double lglLgl;
    private Double ostOst;
    private Double wchWch;
    private Double hyfHyf;
    private Double schCap;
    private Double schGst;
    private Double advAdv;
    private Double othCap;
    private Double cavCav;
    private Double luxLux;
    private Double tcTc;
    private Double cloClo;
    private Double cloCap;
    private Double cloOth;
    private Integer fallenDueRentals;
    private Double setteld;
    private Double totOutstanding;
    private Double totOutBalance;
    private Double rntAmtArrears;
    private String equipType;
    private String equipDescription;
    private Double age;
    private Double dc;
    private Double first;
    private String last;
    private Double worst;
    private String islast;
    private Date expDate;
    private String sector;
    private String district;

    public Datafile() {
    }

    public Datafile(String idData, String product, Date month,Integer stage, String facilityNo, String clientFullName, String nicBr, String address, Integer facilityPeriod, Double facilityAmount, String facilityStatus, Date activateDate, Double rentalAmount, String facilityType, Double interestRate, Double noOfArr, String pNpFlag, Double futureCapital, Double futureInterest, Double interestInSuspence, Integer vatInSuspence, Double overPayBalance, Integer unUtilizedPrepayment, Double rntCap, Double rntInt, Double prePre, Double rnoRno, Double gsoGso, Double insIns, Double inoCap, Double inoGst, Double gstGst, Double chrCap, Double chrGst, Double upsUps, Double rmvRmv, Double ndpNdp, Double ochCap, Double ochGst, Double incCap, Double incGat, Double othGst, Double sifSif, Double lglLgl, Double ostOst, Double wchWch, Double hyfHyf, Double schCap, Double schGst, Double advAdv, Double othCap, Double cavCav, Double luxLux, Double tcTc, Double cloClo, Double cloCap, Double cloOth, Integer fallenDueRentals, Double setteld, Double totOutstanding, Double totOutBalance, Double rntAmtArrears, String equipType, String equipDescription, Double age, Date expDate, String sector, String district) {
        this.idData = idData;
        this.product = product;
        this.month = month;
        this.stage = stage;
        this.facilityNo = facilityNo;
        this.clientFullName = clientFullName;
        this.nicBr = nicBr;
        this.address = address;
        this.facilityPeriod = facilityPeriod;
        this.facilityAmount = facilityAmount;
        this.facilityStatus = facilityStatus;
        this.activateDate = activateDate;
        this.rentalAmount = rentalAmount;
        this.facilityType = facilityType;
        this.interestRate = interestRate;
        this.noOfArr = noOfArr;
        this.pNpFlag = pNpFlag;
        this.futureCapital = futureCapital;
        this.futureInterest = futureInterest;
        this.interestInSuspence = interestInSuspence;
        this.vatInSuspence = vatInSuspence;
        this.overPayBalance = overPayBalance;
        this.unUtilizedPrepayment = unUtilizedPrepayment;
        this.rntCap = rntCap;
        this.rntInt = rntInt;
        this.prePre = prePre;
        this.rnoRno = rnoRno;
        this.gsoGso = gsoGso;
        this.insIns = insIns;
        this.inoCap = inoCap;
        this.inoGst = inoGst;
        this.gstGst = gstGst;
        this.chrCap = chrCap;
        this.chrGst = chrGst;
        this.upsUps = upsUps;
        this.rmvRmv = rmvRmv;
        this.ndpNdp = ndpNdp;
        this.ochCap = ochCap;
        this.ochGst = ochGst;
        this.incCap = incCap;
        this.incGat = incGat;
        this.othGst = othGst;
        this.sifSif = sifSif;
        this.lglLgl = lglLgl;
        this.ostOst = ostOst;
        this.wchWch = wchWch;
        this.hyfHyf = hyfHyf;
        this.schCap = schCap;
        this.schGst = schGst;
        this.advAdv = advAdv;
        this.othCap = othCap;
        this.cavCav = cavCav;
        this.luxLux = luxLux;
        this.tcTc = tcTc;
        this.cloClo = cloClo;
        this.cloCap = cloCap;
        this.cloOth = cloOth;
        this.fallenDueRentals = fallenDueRentals;
        this.setteld = setteld;
        this.totOutstanding = totOutstanding;
        this.totOutBalance = totOutBalance;
        this.rntAmtArrears = rntAmtArrears;
        this.equipType = equipType;
        this.equipDescription = equipDescription;
        this.age = age;
        this.dc = dc;
        this.expDate = expDate;
        this.sector = sector;
        this.district = district;
    }

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
    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
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
    @Column(name = "facility_no")

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
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
    @Column(name = "nic_br")

    public String getNicBr() {
        return nicBr;
    }

    public void setNicBr(String nicBr) {
        this.nicBr = nicBr;
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
    @Column(name = "facility_period")
    public Integer getFacilityPeriod() {
        return facilityPeriod;
    }

    public void setFacilityPeriod(Integer facilityPeriod) {
        this.facilityPeriod = facilityPeriod;
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
    @Column(name = "facility_status")
    public String getFacilityStatus() {
        return facilityStatus;
    }

    public void setFacilityStatus(String facilityStatus) {
        this.facilityStatus = facilityStatus;
    }

    @Basic
    @Column(name = "activate_date")
    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
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
    @Column(name = "facility_type")
    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
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
    @Column(name = "no_of_arr")
    public Double getNoOfArr() {
        return noOfArr;
    }

    public void setNoOfArr(Double noOfArr) {
        this.noOfArr = noOfArr;
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
    @Column(name = "interest_in_suspence")
    public Double getInterestInSuspence() {
        return interestInSuspence;
    }

    public void setInterestInSuspence(Double interestInSuspence) {
        this.interestInSuspence = interestInSuspence;
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
    @Column(name = "over_pay_balance")
    public Double getOverPayBalance() {
        return overPayBalance;
    }

    public void setOverPayBalance(Double overPayBalance) {
        this.overPayBalance = overPayBalance;
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
    @Column(name = "pre_pre")
    public Double getPrePre() {
        return prePre;
    }

    public void setPrePre(Double prePre) {
        this.prePre = prePre;
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
    @Column(name = "gso_gso")
    public Double getGsoGso() {
        return gsoGso;
    }

    public void setGsoGso(Double gsoGso) {
        this.gsoGso = gsoGso;
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
    @Column(name = "gst_gst")
    public Double getGstGst() {
        return gstGst;
    }

    public void setGstGst(Double gstGst) {
        this.gstGst = gstGst;
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
    @Column(name = "ups_ups")
    public Double getUpsUps() {
        return upsUps;
    }

    public void setUpsUps(Double upsUps) {
        this.upsUps = upsUps;
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
    @Column(name = "ndp_ndp")
    public Double getNdpNdp() {
        return ndpNdp;
    }

    public void setNdpNdp(Double ndpNdp) {
        this.ndpNdp = ndpNdp;
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
    @Column(name = "oth_gst")
    public Double getOthGst() {
        return othGst;
    }

    public void setOthGst(Double othGst) {
        this.othGst = othGst;
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
    @Column(name = "lgl_lgl")
    public Double getLglLgl() {
        return lglLgl;
    }

    public void setLglLgl(Double lglLgl) {
        this.lglLgl = lglLgl;
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
    @Column(name = "wch_wch")
    public Double getWchWch() {
        return wchWch;
    }

    public void setWchWch(Double wchWch) {
        this.wchWch = wchWch;
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
    @Column(name = "adv_adv")
    public Double getAdvAdv() {
        return advAdv;
    }

    public void setAdvAdv(Double advAdv) {
        this.advAdv = advAdv;
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
    @Column(name = "cav_cav")
    public Double getCavCav() {
        return cavCav;
    }

    public void setCavCav(Double cavCav) {
        this.cavCav = cavCav;
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
    @Column(name = "tc_tc")
    public Double getTcTc() {
        return tcTc;
    }

    public void setTcTc(Double tcTc) {
        this.tcTc = tcTc;
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
    @Column(name = "clo_cap")
    public Double getCloCap() {
        return cloCap;
    }

    public void setCloCap(Double cloCap) {
        this.cloCap = cloCap;
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
    @Column(name = "fallen_due_rentals")
    public Integer getFallenDueRentals() {
        return fallenDueRentals;
    }

    public void setFallenDueRentals(Integer fallenDueRentals) {
        this.fallenDueRentals = fallenDueRentals;
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
    @Column(name = "tot_outstanding")
    public Double getTotOutstanding() {
        return totOutstanding;
    }

    public void setTotOutstanding(Double totOutstanding) {
        this.totOutstanding = totOutstanding;
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
    @Column(name = "rnt_amt_arrears")
    public Double getRntAmtArrears() {
        return rntAmtArrears;
    }

    public void setRntAmtArrears(Double rntAmtArrears) {
        this.rntAmtArrears = rntAmtArrears;
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
    @Column(name = "equip_description")
    public String getEquipDescription() {
        return equipDescription;
    }

    public void setEquipDescription(String equipDescription) {
        this.equipDescription = equipDescription;
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
    @Column(name = "exp_date")
    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
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
    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datafile datafile = (Datafile) o;
        return idData == datafile.idData &&
                Objects.equals(product, datafile.product) &&
                Objects.equals(month, datafile.month) &&
                Objects.equals(stage, datafile.stage) &&
                Objects.equals(facilityNo, datafile.facilityNo) &&
                Objects.equals(clientFullName, datafile.clientFullName) &&
                Objects.equals(nicBr, datafile.nicBr) &&
                Objects.equals(address, datafile.address) &&
                Objects.equals(facilityPeriod, datafile.facilityPeriod) &&
                Objects.equals(facilityAmount, datafile.facilityAmount) &&
                Objects.equals(facilityStatus, datafile.facilityStatus) &&
                Objects.equals(activateDate, datafile.activateDate) &&
                Objects.equals(rentalAmount, datafile.rentalAmount) &&
                Objects.equals(facilityType, datafile.facilityType) &&
                Objects.equals(interestRate, datafile.interestRate) &&
                Objects.equals(noOfArr, datafile.noOfArr) &&
                Objects.equals(pNpFlag, datafile.pNpFlag) &&
                Objects.equals(futureCapital, datafile.futureCapital) &&
                Objects.equals(futureInterest, datafile.futureInterest) &&
                Objects.equals(interestInSuspence, datafile.interestInSuspence) &&
                Objects.equals(vatInSuspence, datafile.vatInSuspence) &&
                Objects.equals(overPayBalance, datafile.overPayBalance) &&
                Objects.equals(unUtilizedPrepayment, datafile.unUtilizedPrepayment) &&
                Objects.equals(rntCap, datafile.rntCap) &&
                Objects.equals(rntInt, datafile.rntInt) &&
                Objects.equals(prePre, datafile.prePre) &&
                Objects.equals(rnoRno, datafile.rnoRno) &&
                Objects.equals(gsoGso, datafile.gsoGso) &&
                Objects.equals(insIns, datafile.insIns) &&
                Objects.equals(inoCap, datafile.inoCap) &&
                Objects.equals(inoGst, datafile.inoGst) &&
                Objects.equals(gstGst, datafile.gstGst) &&
                Objects.equals(chrCap, datafile.chrCap) &&
                Objects.equals(chrGst, datafile.chrGst) &&
                Objects.equals(upsUps, datafile.upsUps) &&
                Objects.equals(rmvRmv, datafile.rmvRmv) &&
                Objects.equals(ndpNdp, datafile.ndpNdp) &&
                Objects.equals(ochCap, datafile.ochCap) &&
                Objects.equals(ochGst, datafile.ochGst) &&
                Objects.equals(incCap, datafile.incCap) &&
                Objects.equals(incGat, datafile.incGat) &&
                Objects.equals(othGst, datafile.othGst) &&
                Objects.equals(sifSif, datafile.sifSif) &&
                Objects.equals(lglLgl, datafile.lglLgl) &&
                Objects.equals(ostOst, datafile.ostOst) &&
                Objects.equals(wchWch, datafile.wchWch) &&
                Objects.equals(hyfHyf, datafile.hyfHyf) &&
                Objects.equals(schCap, datafile.schCap) &&
                Objects.equals(schGst, datafile.schGst) &&
                Objects.equals(advAdv, datafile.advAdv) &&
                Objects.equals(othCap, datafile.othCap) &&
                Objects.equals(cavCav, datafile.cavCav) &&
                Objects.equals(luxLux, datafile.luxLux) &&
                Objects.equals(tcTc, datafile.tcTc) &&
                Objects.equals(cloClo, datafile.cloClo) &&
                Objects.equals(cloCap, datafile.cloCap) &&
                Objects.equals(cloOth, datafile.cloOth) &&
                Objects.equals(fallenDueRentals, datafile.fallenDueRentals) &&
                Objects.equals(setteld, datafile.setteld) &&
                Objects.equals(totOutstanding, datafile.totOutstanding) &&
                Objects.equals(totOutBalance, datafile.totOutBalance) &&
                Objects.equals(rntAmtArrears, datafile.rntAmtArrears) &&
                Objects.equals(equipType, datafile.equipType) &&
                Objects.equals(equipDescription, datafile.equipDescription) &&
                Objects.equals(age, datafile.age) &&
                Objects.equals(dc, datafile.dc) &&
                Objects.equals(first, datafile.first) &&
                Objects.equals(last, datafile.last) &&
                Objects.equals(worst, datafile.worst) &&
                Objects.equals(islast, datafile.islast) &&
                Objects.equals(expDate, datafile.expDate) &&
                Objects.equals(sector, datafile.sector) &&
                Objects.equals(district, datafile.district);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idData, product, month, facilityNo, clientFullName, nicBr, address, facilityPeriod, facilityAmount, facilityStatus, activateDate, rentalAmount, facilityType, interestRate, noOfArr, pNpFlag, futureCapital, futureInterest, interestInSuspence, vatInSuspence, overPayBalance, unUtilizedPrepayment, rntCap, rntInt, prePre, rnoRno, gsoGso, insIns, inoCap, inoGst, gstGst, chrCap, chrGst, upsUps, rmvRmv, ndpNdp, ochCap, ochGst, incCap, incGat, othGst, sifSif, lglLgl, ostOst, wchWch, hyfHyf, schCap, schGst, advAdv, othCap, cavCav, luxLux, tcTc, cloClo, cloCap, cloOth, fallenDueRentals, setteld, totOutstanding, totOutBalance, rntAmtArrears, equipType, equipDescription, age, expDate, sector, district);
    }

    @Override
    public String toString() {
        return "Datafile{" +
                "idData=" + idData +
                ", product='" + product + '\'' +
//                ", month=" + month.toString().replace(" 00:00:00.0","") +
//                ", stage=" + stage +
                ", facilityNo='" + facilityNo + '\'' +
                ", age=" + age +
                ", dc=" + dc +
                ", first=" + first +
                ", last=" + last +
                ", worst=" + worst +
                ", islast=" + islast +
                ", clientFullName='" + clientFullName + '\'' +
//                ", nicBr='" + nicBr + '\'' +
//                ", address='" + address + '\'' +
//                ", facilityPeriod=" + facilityPeriod +
//                ", facilityAmount=" + facilityAmount +
//                ", facilityStatus='" + facilityStatus + '\'' +
//                ", activateDate=" + activateDate +
//                ", rentalAmount=" + rentalAmount +
//                ", facilityType='" + facilityType + '\'' +
//                ", interestRate=" + interestRate +
//                ", noOfArr=" + noOfArr +
//                ", pNpFlag='" + pNpFlag + '\'' +
//                ", futureCapital=" + futureCapital +
//                ", futureInterest=" + futureInterest +
//                ", interestInSuspence=" + interestInSuspence +
//                ", vatInSuspence=" + vatInSuspence +
//                ", overPayBalance=" + overPayBalance +
//                ", unUtilizedPrepayment=" + unUtilizedPrepayment +
//                ", rntCap=" + rntCap +
//                ", rntInt=" + rntInt +
//                ", prePre=" + prePre +
//                ", rnoRno=" + rnoRno +
//                ", gsoGso=" + gsoGso +
//                ", insIns=" + insIns +
//                ", inoCap=" + inoCap +
//                ", inoGst=" + inoGst +
//                ", gstGst=" + gstGst +
//                ", chrCap=" + chrCap +
//                ", chrGst=" + chrGst +
//                ", upsUps=" + upsUps +
//                ", rmvRmv=" + rmvRmv +
//                ", ndpNdp=" + ndpNdp +
//                ", ochCap=" + ochCap +
//                ", ochGst=" + ochGst +
//                ", incCap=" + incCap +
//                ", incGat=" + incGat +
//                ", othGst=" + othGst +
//                ", sifSif=" + sifSif +
//                ", lglLgl=" + lglLgl +
//                ", ostOst=" + ostOst +
//                ", wchWch=" + wchWch +
//                ", hyfHyf=" + hyfHyf +
//                ", schCap=" + schCap +
//                ", schGst=" + schGst +
//                ", advAdv=" + advAdv +
//                ", othCap=" + othCap +
//                ", cavCav=" + cavCav +
//                ", luxLux=" + luxLux +
//                ", tcTc=" + tcTc +
//                ", cloClo=" + cloClo +
//                ", cloCap=" + cloCap +
//                ", cloOth=" + cloOth +
//                ", fallenDueRentals=" + fallenDueRentals +
//                ", setteld=" + setteld +
//                ", totOutstanding=" + totOutstanding +
//                ", totOutBalance=" + totOutBalance +
//                ", rntAmtArrears=" + rntAmtArrears +
//                ", equipType='" + equipType + '\'' +
//                ", equipDescription='" + equipDescription + '\'' +
//                ", expDate=" + expDate +
//                ", sector='" + sector + '\'' +
//                ", district='" + district + '\'' +
                '}';
    }
}
