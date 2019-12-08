package com.loneliness.entity;

import java.io.Serializable;

public class Transmission implements Serializable {
    private String command;
    private int[] bounds;
    private Index index;
    private UserData userData;
    private Company company;
    private ContactDetail contactDetail;
    private Credit credit;
    private Dividend dividend;
    private InitialData initialData;
    private Quarter quarter;
    private ReportingPeriod reportingPeriod;
    private ROE roe;
    private SG sg;
    private Integer id;
    private CompanyRepresentatives companyRepresentatives;

    public CompanyRepresentatives getCompanyRepresentatives() {
        return companyRepresentatives;
    }

    public void setCompanyRepresentatives(CompanyRepresentatives companyRepresentatives) {
        this.companyRepresentatives = companyRepresentatives;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public int[] getBounds() {
        return bounds;
    }

    public void setBounds(int[] bounds) {
        this.bounds = bounds;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactDetail getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(ContactDetail contactDetail) {
        this.contactDetail = contactDetail;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Dividend getDividend() {
        return dividend;
    }

    public void setDividend(Dividend dividend) {
        this.dividend = dividend;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(InitialData initialData) {
        this.initialData = initialData;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public ReportingPeriod getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(ReportingPeriod reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    public ROE getRoe() {
        return roe;
    }

    public void setRoe(ROE roe) {
        this.roe = roe;
    }

    public SG getSg() {
        return sg;
    }

    public void setSg(SG sg) {
        this.sg = sg;
    }
}
