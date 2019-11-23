package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class Index implements Serializable {
    // TODO: 23.11.2019  Коэффициент реинвестирования?
    // TODO: 23.11.2019 Оперативная прибыль?
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
}
