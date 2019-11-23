package com.loneliness.server.controller;

import com.loneliness.server.controller.command_implements.business_command.*;
import com.loneliness.server.controller.command_implements.differential_indicators_command.*;
import com.loneliness.server.controller.command_implements.user_command.*;

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


        repository.put(CommandName.CALCULATE_PROFITABILITY,new CalculateProfitability());
        repository.put(CommandName.CALCULATE_NET_ASSET_TURNOVER,new CalculateNetAssetTurnover());
        repository.put(CommandName.CALCULATE_RONA,new CalculateRONA());
        repository.put(CommandName.CALCULATE_FL,new CalculateFL());
        repository.put(CommandName.CALCULATE_ROE,new CalculateROE());
        repository.put(CommandName.CALCULATE_ALL_DIFFERENTIAL_INDICATORS,new CalculateAllDifferentialIndicators());
        repository.put(CommandName.CALCULATE_WACC,new CalculateWACC());
        repository.put(CommandName.CALCULATE_SG,new CalculateSG());

        repository.put(CommandName.CREATE_DIFFERENTIAL_INDICATORS, new CreateDifferentialIndicators());
        repository.put(CommandName.DELETE_DIFFERENTIAL_INDICATORS,new DeleteDifferentialIndicators());
        repository.put(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS,new ReceiveAllDifferentialIndicators());
        repository.put(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT,new ReceiveAllDifferentialIndicatorsInLimit());
        repository.put(CommandName.RECEIVE_DIFFERENTIAL_INDICATORS,new ReceiveDifferentialIndicators());
        repository.put(CommandName.UPDATE_DIFFERENTIAL_INDICATORS,new UpdateDifferentialIndicators());
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
