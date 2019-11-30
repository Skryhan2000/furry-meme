package com.loneliness.client.dao;

import com.loneliness.client.dao.server_request.CalculateIndexRequest;
import com.loneliness.client.dao.server_request.*;
import com.loneliness.client.dao.server_request.SGRequest;
import com.loneliness.client.dao.server_request.UserRequest;

public class FactoryDAO {
    private static final FactoryDAO instance=new FactoryDAO();
    private final UserRequest userRequest=new UserRequest();
    private final SGRequest sgRequest=SGRequest.getInstance();
    private final ROERequest roeRequest=ROERequest.getInstance();
    private final CalculateIndexRequest calculateIndexRequest=new CalculateIndexRequest();
    private final ReportingPeriodRequest reportingPeriodRequest=ReportingPeriodRequest.getInstance();
    private final InitialDataRequest initialDataRequest=InitialDataRequest.getInstance();
    private final DividendRequest dividendRequest=DividendRequest.getInstance();
    private final CreditRequest creditRequest=CreditRequest.getInstance();
    private final ContactDetailRequest contactDetailRequest=ContactDetailRequest.getInstance();
    private final CompanyRequest companyRequest=CompanyRequest.getInstance();

    public static FactoryDAO getInstance() {
        return instance;
    }
    private FactoryDAO(){}


    public UserRequest getUserRequest() {
        return userRequest;
    }

    public SGRequest getSgRequest() {
        return sgRequest;
    }

    public ROERequest getRoeRequest() {
        return roeRequest;
    }

    public ReportingPeriodRequest getReportingPeriodRequest() {
        return reportingPeriodRequest;
    }

    public InitialDataRequest getInitialDataRequest() {
        return initialDataRequest;
    }

    public DividendRequest getDividendRequest() {
        return dividendRequest;
    }

    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    public ContactDetailRequest getContactDetailRequest() {
        return contactDetailRequest;
    }

    public CompanyRequest getCompanyRequest() {
        return companyRequest;
    }

    public CalculateIndexRequest getCalculateIndexRequest() {
        return calculateIndexRequest;
    }
}
