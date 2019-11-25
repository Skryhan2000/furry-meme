package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DifferentialIndicators implements Serializable {
    private int id;
    @NotNull(message = "Задайте id компании ")
    private int companyID;
    @NotNull(message = "Должен быть задан отчетный период")
    private LocalDate reportingDate;
    @NotNull(message = "Должен быть задан квартал")
    private Quarter quarter;
    @NotNull(message = "Должна быть задана рентабельность продаж ")
    private BigDecimal profR;
    @NotNull(message = "Должна быть задана оборачиваемость чистых активов ")
    private BigDecimal netA;
    @NotNull(message = "Должна быть задана RONA ")
    private BigDecimal RONA;
    @NotNull(message = "Должна быть задана FL ")
    private BigDecimal FL;
    @NotNull(message = "Должна быть задана ROE ")
    private BigDecimal ROE;
    @NotNull(message = "Должна быть задана SG ")
    private BigDecimal SG;
    @NotNull(message = "Должна быть задана WACC ")
    private BigDecimal WACC;

    public DifferentialIndicators() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
    }

    public BigDecimal getProfR() {
        return profR;
    }

    public void setProfR(BigDecimal profR) {
        this.profR = profR;
    }

    public BigDecimal getNetA() {
        return netA;
    }

    public void setNetA(BigDecimal netA) {
        this.netA = netA;
    }

    public BigDecimal getRONA() {
        return RONA;
    }

    public void setRONA(BigDecimal RONA) {
        this.RONA = RONA;
    }

    public BigDecimal getFL() {
        return FL;
    }

    public void setFL(BigDecimal FL) {
        this.FL = FL;
    }

    public BigDecimal getROE() {
        return ROE;
    }

    public void setROE(BigDecimal ROE) {
        this.ROE = ROE;
    }

    public BigDecimal getSG() {
        return SG;
    }

    public void setSG(BigDecimal SG) {
        this.SG = SG;
    }

    public BigDecimal getWACC() {
        return WACC;
    }

    public void setWACC(BigDecimal WACC) {
        this.WACC = WACC;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }
}
