package com.loneliness.server.controller;

public enum  CommandName {
    CREATE_USER, AUTHORISE_USER, DELETE_USER, RECEIVE_ALL_USERS,
    RECEIVE_USER, UPDATE_USER,RECEIVE_ALL_USERS_IN_LIMIT, RECEIVE_ALL_MANAGER,

    CALCULATE_PROFITABILITY, CALCULATE_NET_ASSET_TURNOVER, CALCULATE_RONA, CALCULATE_SG,
    CALCULATE_FL, CALCULATE_ROE, CALCULATE_ALL_DIFFERENTIAL_INDICATORS, CALCULATE_WACC, CALCULATE_ALL_ROE_DATA,
    GET_STATE,

    CREATE_DIFFERENTIAL_INDICATORS, DELETE_DIFFERENTIAL_INDICATORS, RECEIVE_ALL_DIFFERENTIAL_INDICATORS,
    RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT, RECEIVE_DIFFERENTIAL_INDICATORS, UPDATE_DIFFERENTIAL_INDICATORS,

    CREATE_COMPANY, DELETE_COMPANY, RECEIVE_ALL_COMPANY, RECEIVE_ALL_COMPANY_IN_LIMIT, RECEIVE_COMPANY, UPDATE_COMPANY,

    CREATE_CONTACT_DETAIL, DELETE_CONTACT_DETAIL, RECEIVE_ALL_CONTACT_DETAIL, RECEIVE_ALL_CONTACT_DETAIL_IN_LIMIT,
    RECEIVE_CONTACT_DETAIL, UPDATE_CONTACT_DETAIL,

    CREATE_CREDIT, DELETE_CREDIT, FIND_CREDIT_IN_PERIOD, RECEIVE_ALL_CREDIT, RECEIVE_ALL_CREDIT_IN_LIMIT, RECEIVE_CREDIT,
    UPDATE_CREDIT,

    CREATE_DIVIDEND, DELETE_DIVIDEND, RECEIVE_ALL_DIVIDEND, RECEIVE_ALL_DIVIDEND_IN_LIMIT, RECEIVE_DIVIDEND, UPDATE_DIVIDEND,

    CREATE_INITIAL_DATA, DELETE_INITIAL_DATA, FIND_FUTURE_EQUITY, FIND_PREVIOUS_EQUITY, RECEIVE_ALL_INITIAL_DATA,
    RECEIVE_ALL_INITIAL_DATA_IN_LIMIT, RECEIVE_INITIAL_DATA, UPDATE_INITIAL_DATA,

    CREATE_REPORTING_PERIOD, DELETE_REPORTING_PERIOD, RECEIVE_ALL_REPORTING_PERIOD, RECEIVE_ALL_REPORTING_PERIOD_IN_LIMIT,
    RECEIVE_REPORTING_PERIOD, UPDATE_REPORTING_PERIOD,

    CREATE_ROE, DELETE_ROE, RECEIVE_ALL_ROE, RECEIVE_ALL_ROE_IN_LIMIT, RECEIVE_ROE, UPDATE_ROE, FIND_ROE_BY_REPORTING_PERIOD_ID,
    FIND_ROE_BY_REPORTING_PERIOD_YEAR,

    CREATE_SG, DELETE_SG, RECEIVE_ALL_SG, RECEIVE_ALL_SG_IN_LIMIT, RECEIVE_SG, UPDATE_SG, FIND_SG_BY_REPORTING_PERIOD_ID,

    CREATE_COMPANY_REPRESENTATIVES, DELETE_COMPANY_REPRESENTATIVES, RECEIVE_ALL_COMPANY_REPRESENTATIVES, RECEIVE_ALL_COMPANY_REPRESENTATIVES_IN_LIMIT,
    RECEIVE_COMPANY_REPRESENTATIVES, UPDATE_COMPANY_REPRESENTATIVES,
}
