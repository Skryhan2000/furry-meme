package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class Index implements Serializable {
    // TODO: 22.11.2019 Нормальные названия полей
    @NotNull(message = "Задайте чистую прибыль ")
    private BigDecimal netProfit;
    @NotNull(message = "Задайте выручка от реализации ")
    private BigDecimal revenuesFromSales;
    @NotNull(message = "Задайте активы ")
    private BigDecimal assets;
    @NotNull(message = "Задайте собственный капитал ")
    private BigDecimal equity;
    @NotNull(message = "Задайте привлеченный капитал ")
    private BigDecimal attractedCapital;



    public Index() {

    }

    public BigDecimal getRevenuesFromSales() {
        return revenuesFromSales;
    }

    public void setRevenuesFromSales(BigDecimal revenuesFromSales) {
        this.revenuesFromSales = revenuesFromSales;
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

    public BigDecimal getAttractedCapital() {
        return attractedCapital;
    }

    public void setAttractedCapital(BigDecimal attractedCapital) {
        this.attractedCapital = attractedCapital;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }
}
