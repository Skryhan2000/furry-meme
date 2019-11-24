package com.loneliness.client.controller;

import com.loneliness.client.controller.command_impl.differential_indicators.*;
import com.loneliness.client.controller.command_impl.user.*;
import com.loneliness.client.controller.command_impl.validation_command.DifferentialIndicatorsValidation;
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

        repository.put(CommandName.CREATE_DIFFERENTIAL_INDICATORS, new CreateDifferentialIndicators());
        repository.put(CommandName.DELETE_DIFFERENTIAL_INDICATORS,new DeleteDifferentialIndicators());
        repository.put(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS,new ReceiveAllDifferentialIndicators());
        repository.put(CommandName.RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT,new ReceiveAllDifferentialIndicatorsInLimit());
        repository.put(CommandName.RECEIVE_DIFFERENTIAL_INDICATORS,new ReceiveDifferentialIndicators());
        repository.put(CommandName.UPDATE_DIFFERENTIAL_INDICATORS,new UpdateDifferentialIndicators());
        repository.put(CommandName.DIFFERENTIAL_INDICATORS_VALIDATION,new DifferentialIndicatorsValidation());

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
