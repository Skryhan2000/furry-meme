package com.loneliness.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Dividend implements Serializable {
    private int dividendId;
    @Positive(message = "id компании должно быть положительным ")
    private int companyId;
    @NotNull(message = "Должны быть заданы проценты дивидента ")
    private BigDecimal dividendPercentage;
    @NotNull(message = "Должен быть задан получатель ")
    private String recipient;
    @Positive(message = "id отчётного периода должно быть положительным ")
    private int reportingPeriodId;

    public int getDividendId() {
        return dividendId;
    }

    public void setDividendId(int dividendId) {
        this.dividendId = dividendId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getDividendPercentage() {
        return dividendPercentage;
    }

    public void setDividendPercentage(BigDecimal dividendPercentage) {
        this.dividendPercentage = dividendPercentage;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getReportingPeriodId() {
        return reportingPeriodId;
    }

    public void setReportingPeriodId(int reportingPeriodId) {
        this.reportingPeriodId = reportingPeriodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dividend dividend = (Dividend) o;
        return dividendId == dividend.dividendId &&
                companyId == dividend.companyId &&
                reportingPeriodId == dividend.reportingPeriodId &&
                dividendPercentage.equals(dividend.dividendPercentage) &&
                recipient.equals(dividend.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividendId, companyId, dividendPercentage, recipient, reportingPeriodId);
    }

    @Override
    public String toString() {
        return "Dividend{" +
                "dividendId=" + dividendId +
                ", companyId=" + companyId +
                ", dividendPercentage=" + dividendPercentage +
                ", recipient='" + recipient + '\'' +
                ", reportingPeriodId=" + reportingPeriodId +
                '}';
    }
}
