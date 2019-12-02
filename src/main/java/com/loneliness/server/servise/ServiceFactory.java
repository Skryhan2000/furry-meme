package com.loneliness.server.servise;

import com.loneliness.server.servise.service_impl.*;

import java.util.concurrent.locks.ReentrantLock;

public class ServiceFactory {
    private static final ReentrantLock locker = new ReentrantLock();
    private static ServiceFactory instance=new ServiceFactory();
    private final UserDataService userService=new UserDataService();
    private final BusinessServiceImpl businessService=new BusinessServiceImpl();
    private final DifferentialIndicatorsDataService differentialIndicatorsDataService= new DifferentialIndicatorsDataService();
    private final CompanyService companyService=CompanyService.getInstance();
    private final ContactDetailService contactDetailService =ContactDetailService.getInstance();
    private final CreditService creditService=CreditService.getInstance();
    private final DividendService dividendService=DividendService.getInstance();
    private final InitialDataService initialDataService =InitialDataService.getInstance();
    private final ReportingPeriodService reportingPeriodService=ReportingPeriodService.getInstance();
    private final ROEService roeService=ROEService.getInstance();
    private final SGService sgService=SGService.getInstance();
    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        locker.lock();
        if(instance==null){
            instance=new ServiceFactory();
        }
        locker.unlock();
        return instance;
    }

    public UserDataService getUserService() {
        return userService;
    }

    public BusinessServiceImpl getBusinessService() {
        return businessService;
    }

    public DifferentialIndicatorsDataService getDifferentialIndicatorsDataService() {
        return differentialIndicatorsDataService;
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
}
