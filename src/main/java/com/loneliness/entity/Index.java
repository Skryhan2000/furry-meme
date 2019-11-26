package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Index implements Serializable {
    // TODO: 26.11.2019 отсутствуют объёмы продаж
    // TODO: 26.11.2019 отсутствует средняя сумма процента по кредиту
    // TODO: 26.11.2019 отсутствует ливеридж
    private int indexID;
    @NotNull(message = "Задайте id компании ")
    private int companyID;
    @NotNull(message = "Должен быть задан отчетный период")
    private LocalDate reportingDate;
    @NotNull(message = "Должен быть задан квартал")
    private Quarter quarter;
    @NotNull(message = "Задайте чистую прибыль ")
    private BigDecimal PBIT;
    @NotNull(message = "Задайте выручка от реализации ")
    private BigDecimal sales;
    @NotNull(message = "Задайте активы ")
    private BigDecimal assets;
    @NotNull(message = "Задайте собственный капитал ")
    private BigDecimal equity;
    @NotNull(message = "Задайте привлеченный капитал ")
    private BigDecimal credit;
    @NotNull(message = "Задайте коэффициент реинвестирования ")
    private BigDecimal ratioRec;
    @NotNull(message = "Задайте оперативную прибыль ")
    private BigDecimal EBIT;
    @NotNull(message = "Задайте собственный капитал на текущий период ")
    private BigDecimal E;
    @NotNull(message = "Задайте собственный капитал на начало года ")
    private BigDecimal E1;
    @NotNull(message = "Задайте собственный капитал на конец года ")
    private BigDecimal E2;
    @NotNull(message = "Задайте кредитную ставка банка ")
    private BigDecimal R;
    @NotNull(message = "Задайте сумму кредитов банка ")
    private BigDecimal L;
    @NotNull(message = "Задайте процент дивидендов ")
    private BigDecimal D;
    public Index() {

    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getAssets() {
        return assets;
    }

    public void setAssets(BigDecimal assets) {
        this.assets = assets;
    }

    public BigDecimal getEquity() {
        return equity;
    }

    public void setEquity(BigDecimal equity) {
        this.equity = equity;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getPBIT() {
        return PBIT;
    }

    public void setPBIT(BigDecimal PBIT) {
        this.PBIT = PBIT;
    }

    public BigDecimal getRatioRec() {
        return ratioRec;
    }

    public void setRatioRec(BigDecimal ratioRec) {
        this.ratioRec = ratioRec;
    }

    public BigDecimal getEBIT() {
        return EBIT;
    }

    public void setEBIT(BigDecimal EBIT) {
        this.EBIT = EBIT;
    }

    public BigDecimal getE1() {
        return E1;
    }

    public void setE1(BigDecimal e1) {
        E1 = e1;
    }

    public BigDecimal getE2() {
        return E2;
    }

    public void setE2(BigDecimal e2) {
        E2 = e2;
    }

    public BigDecimal getR() {
        return R;
    }

    public void setR(BigDecimal r) {
        R = r;
    }

    public BigDecimal getL() {
        return L;
    }

    public void setL(BigDecimal l) {
        L = l;
    }

    public BigDecimal getD() {
        return D;
    }

    public void setD(BigDecimal d) {
        D = d;
    }

    public BigDecimal getE() {
        return E;
    }

    public void setE(BigDecimal e) {
        E = e;
    }

    public int getIndexID() {
        return indexID;
    }

    public void setIndexID(int indexID) {
        this.indexID = indexID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public LocalDate getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
    }
}
