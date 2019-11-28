package com.loneliness.entity;

import java.time.LocalDate;

public class ReportingPeriod {
    private int reportingPeriodId;
    private int year;
    private Quarter quarter;
    private int companyId;

    public int getReportingPeriodId() {
        return reportingPeriodId;
    }

    public void setReportingPeriodId(int reportingPeriodId) {
        this.reportingPeriodId = reportingPeriodId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }
}
