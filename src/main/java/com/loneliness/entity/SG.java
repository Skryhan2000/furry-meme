package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SG implements Serializable {
    private int SGId;
    @Positive(message = "Id исходных данных должно быть положительным")
    private int initialDataId;
    @NotNull(message = "Задайте ROE")
    private BigDecimal ROE;
    @Positive(message = "Id компании должно быть положительным")
    private int companyId;
    @Positive(message = "Id кредита должно быть положительным")
    private int creditId;
    @Positive(message = "Id дивиданда должно быть положительным")
    private int dividendID;
    @NotNull(message = "Задайте реинвестиционную прибыль")
    private BigDecimal reinvestmentProfit;
    @NotNull(message = "Задайте Коэффициент реинвестирования")
    private BigDecimal reinvestmentRatio;
    @NotNull(message = "SG")
    private BigDecimal SG;

    private ROE roe;

    public int getSGId() {
        return SGId;
    }

    public void setSGId(int SGId) {
        this.SGId = SGId;
    }

    public int getInitialDataId() {
        return initialDataId;
    }

    public void setInitialDataId(int initialDataId) {
        this.initialDataId = initialDataId;
    }

    public BigDecimal getROE() {
        return ROE;
    }

    public void setROE(BigDecimal ROE) {
        this.ROE = ROE;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public int getDividendID() {
        return dividendID;
    }

    public void setDividendID(int dividendID) {
        this.dividendID = dividendID;
    }

    public BigDecimal getReinvestmentProfit() {
        return reinvestmentProfit;
    }

    public void setReinvestmentProfit(BigDecimal reinvestmentProfit) {
        this.reinvestmentProfit = reinvestmentProfit;
    }

    public BigDecimal getReinvestmentRatio() {
        return reinvestmentRatio;
    }

    public void setReinvestmentRatio(BigDecimal reinvestmentRatio) {
        this.reinvestmentRatio = reinvestmentRatio;
    }

    public BigDecimal getSG() {
        return SG;
    }

    public void setSG(BigDecimal SG) {
        this.SG = SG;
    }

    public com.loneliness.entity.ROE getRoe() {
        return roe;
    }

    public void setRoe(com.loneliness.entity.ROE roe) {
        this.roe = roe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SG sg = (SG) o;
        return SGId == sg.SGId &&
                initialDataId == sg.initialDataId &&
                companyId == sg.companyId &&
                creditId == sg.creditId &&
                dividendID == sg.dividendID &&
                ROE.equals(sg.ROE) &&
                reinvestmentProfit.equals(sg.reinvestmentProfit) &&
                reinvestmentRatio.equals(sg.reinvestmentRatio) &&
                SG.equals(sg.SG);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SGId, initialDataId, ROE, companyId, creditId, dividendID, reinvestmentProfit, reinvestmentRatio, SG);
    }

    @Override
    public String toString() {
        return "SG{" +
                "SGId=" + SGId +
                ", sourceDataId=" + initialDataId +
                ", ROE=" + ROE +
                ", companyId=" + companyId +
                ", creditId=" + creditId +
                ", dividendID=" + dividendID +
                ", reinvestmentProfit=" + reinvestmentProfit +
                ", reinvestmentRatio=" + reinvestmentRatio +
                ", SG=" + SG +
                '}';
    }
}
