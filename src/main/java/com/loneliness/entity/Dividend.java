package com.loneliness.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Dividend implements Serializable,Entity {
    private int dividendId;
    @Positive(message = "id компании должно быть положительным ")
    private int companyId;
    @NotNull(message = "Должны быть заданы проценты дивидента ")
    private BigDecimal dividendPercentage;
    @NotNull(message = "Должен быть задан получатель ")
    private String recipient;
    @Positive(message = "id отчётного периода должно быть положительным ")
    private int reportingPeriodId;

    @Override
    public IntegerProperty getIntegerId() {
        return new SimpleIntegerProperty(companyId);
    }

    @Override
    public StringProperty getStringValue() {
        return new SimpleStringProperty(recipient);
    }

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
