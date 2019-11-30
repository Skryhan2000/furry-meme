package com.loneliness.client.controller;

import com.loneliness.client.controller.command_impl.company.*;
import com.loneliness.client.controller.command_impl.contact_detail.*;
import com.loneliness.client.controller.command_impl.credit.*;
import com.loneliness.client.controller.command_impl.dividend.*;
import com.loneliness.client.controller.command_impl.initial_data.*;
import com.loneliness.client.controller.command_impl.reporting_period.*;
import com.loneliness.client.controller.command_impl.roe.*;
import com.loneliness.client.controller.command_impl.sg.*;
import com.loneliness.client.controller.command_impl.user.*;
import com.loneliness.client.controller.command_impl.validation_command.IndexValidation;
import com.loneliness.client.controller.command_impl.validation_command.UserDataValidation;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final CommandProvider commandProvider=new CommandProvider();
    private CommandProvider(){
        repository.put(CommandName.CREATE_USER,new CreateUser());
        repository.put(CommandName.AUTHORISE_USER,new AuthoriseUser());
        repository.put(CommandName.DELETE_USER,new DeleteUser());
        repository.put(CommandName.RECEIVE_ALL_USERS,new ReceiveAllUsers());
        repository.put(CommandName.UPDATE_USER,new UpdateUser());
        repository.put(CommandName.RECEIVE_ALL_USERS_IN_LIMIT,new ReceiveAllUsersInLimit());
        repository.put(CommandName.RECEIVE_USER,new ReceiveUser());
        repository.put(CommandName.USER_DATA_VALIDATION,new UserDataValidation());

        repository.put(CommandName.CREATE_COMPANY,new CreateCompany());
        repository.put(CommandName.DELETE_COMPANY,new DeleteCompany());
        repository.put(CommandName.RECEIVE_ALL_COMPANY,new ReceiveAllCompany());
        repository.put(CommandName.RECEIVE_ALL_COMPANY_IN_LIMIT,new ReceiveAllCompanyInLimit());
        repository.put(CommandName.RECEIVE_COMPANY,new ReceiveCompany());
        repository.put(CommandName.UPDATE_COMPANY,new UpdateCompany());


        repository.put(CommandName.CREATE_CONTACT_DETAIL,new CreateContactDetail());
        repository.put(CommandName.DELETE_CONTACT_DETAIL,new DeleteContactDetail());
        repository.put(CommandName.RECEIVE_ALL_CONTACT_DETAIL,new ReceiveAllContactDetail());
        repository.put(CommandName.RECEIVE_ALL_CONTACT_DETAIL_IN_LIMIT,new ReceiveAllContactDetailInLimit());
        repository.put(CommandName.RECEIVE_CONTACT_DETAIL,new ReceiveContactDetail());
        repository.put(CommandName.UPDATE_CONTACT_DETAIL,new UpdateContactDetail());


        repository.put(CommandName.CREATE_CREDIT,new CreateCredit());
        repository.put(CommandName.DELETE_CREDIT,new DeleteCredit());
        repository.put(CommandName.FIND_CREDIT_IN_PERIOD,new FindCreditInPeriod());
        repository.put(CommandName.RECEIVE_ALL_CREDIT,new ReceiveAllCredit());
        repository.put(CommandName.RECEIVE_ALL_CREDIT_IN_LIMIT,new ReceiveAllCreditInLimit());
        repository.put(CommandName.RECEIVE_CREDIT,new ReceiveCredit());
        repository.put(CommandName.UPDATE_CREDIT,new UpdateCredit());


        repository.put(CommandName.CREATE_DIVIDEND,new CreateDividend());
        repository.put(CommandName.DELETE_DIVIDEND,new DeleteDividend());
        repository.put(CommandName.RECEIVE_ALL_DIVIDEND,new ReceiveAllDividend());
        repository.put(CommandName.RECEIVE_ALL_DIVIDEND_IN_LIMIT,new ReceiveAllDividendInLimit());
        repository.put(CommandName.RECEIVE_DIVIDEND,new ReceiveDividend());
        repository.put(CommandName.UPDATE_DIVIDEND,new UpdateDividend());


        repository.put(CommandName.CREATE_INITIAL_DATA,new CreateInitialData());
        repository.put(CommandName.DELETE_INITIAL_DATA,new DeleteInitialData());
        repository.put(CommandName.FIND_FUTURE_EQUITY,new FindFutureEquity());
        repository.put(CommandName.FIND_PREVIOUS_EQUITY,new FindPreviousEquity());
        repository.put(CommandName.RECEIVE_ALL_INITIAL_DATA,new ReceiveAllInitialData());
        repository.put(CommandName.RECEIVE_ALL_INITIAL_DATA_IN_LIMIT,new ReceiveAllInitialDataInLimit());
        repository.put(CommandName.RECEIVE_INITIAL_DATA,new ReceiveInitialData());
        repository.put(CommandName.UPDATE_INITIAL_DATA,new UpdateInitialData());


        repository.put(CommandName.CREATE_REPORTING_PERIOD,new CreateReportingPeriod());
        repository.put(CommandName.DELETE_REPORTING_PERIOD,new DeleteReportingPeriod());
        repository.put(CommandName.RECEIVE_ALL_REPORTING_PERIOD,new ReceiveAllReportingPeriod());
        repository.put(CommandName.RECEIVE_ALL_REPORTING_PERIOD_IN_LIMIT,new ReceiveAllReportingPeriodInLimit());
        repository.put(CommandName.RECEIVE_REPORTING_PERIOD,new ReceiveReportingPeriod());
        repository.put(CommandName.UPDATE_REPORTING_PERIOD,new UpdateReportingPeriod());


        repository.put(CommandName.CREATE_ROE,new CreateROE());
        repository.put(CommandName.DELETE_ROE,new DeleteROE());
        repository.put(CommandName.RECEIVE_ALL_ROE,new ReceiveAllROE());
        repository.put(CommandName.RECEIVE_ALL_ROE_IN_LIMIT,new ReceiveAllROEInLimit());
        repository.put(CommandName.RECEIVE_ROE,new ReceiveROE());
        repository.put(CommandName.UPDATE_ROE,new UpdateROE());


        repository.put(CommandName.CREATE_SG,new CreateSG());
        repository.put(CommandName.DELETE_SG,new DeleteSG());
        repository.put(CommandName.RECEIVE_ALL_SG,new ReceiveAllSG());
        repository.put(CommandName.RECEIVE_ALL_SG_IN_LIMIT,new ReceiveAllSGInLimit());
        repository.put(CommandName.RECEIVE_SG,new ReceiveSG());
        repository.put(CommandName.UPDATE_SG,new UpdateSG());

        repository.put(CommandName.INDEX_VALIDATION,new IndexValidation());

    }
    public Map<CommandName, Command> getRepository() {
        return repository;
    }
    public static CommandProvider getCommandProvider() {
        return commandProvider;
    }

    public Command getCommand(CommandName name){
        Command command=repository.get(name);
        return repository.get(name);
    }
}
