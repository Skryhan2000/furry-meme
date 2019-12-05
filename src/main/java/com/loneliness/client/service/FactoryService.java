package com.loneliness.client.service;

import com.loneliness.client.service.service_impl.*;

import java.util.concurrent.locks.ReentrantLock;

public class FactoryService {
    private static final ReentrantLock locker = new ReentrantLock();
    private static FactoryService instance;
    private final UserService userService=new UserService();
    private final CalculateIndexService calculateIndexRequest = CalculateIndexService.getInstance();
    private final CompanyService companyService=CompanyService.getInstance();
    private final ContactDetailService contactDetailService=ContactDetailService.getInstance();
    private final CreditService creditService =CreditService.getInstance();
    private final DividendService dividendService=DividendService.getInstance();
    private final InitialDataService initialDataService=InitialDataService.getInstance();
    private final ReportingPeriodService reportingPeriodService=ReportingPeriodService.getInstance();
    private final ROEService roeService=ROEService.getInstance();
    private final SGService sgService=SGService.getInstance();
    private final ReportService reportService=ReportService.getInstance();
    private FactoryService(){}

    public static FactoryService getInstance() {
        if(instance==null) {
            locker.lock();
            if (instance == null) {
                instance = new FactoryService();
            }
            locker.unlock();
        }
        return instance;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public ContactDetailService getContactDetailService() {
        return contactDetailService;
    }

    public CreditService getCreditService() {
        return creditService;
    }

    public DividendService getDividendService() {
        return dividendService;
    }

    public InitialDataService getInitialDataService() {
        return initialDataService;
    }

    public ReportingPeriodService getReportingPeriodService() {
        return reportingPeriodService;
    }

    public ROEService getRoeService() {
        return roeService;
    }

    public SGService getSgService() {
        return sgService;
    }

    public CalculateIndexService getCalculateIndexRequest() {
        return calculateIndexRequest;
    }

    public UserService getUserService() {
        return userService;
    }

    public ReportService getReportService() {
        return reportService;
    }
}
