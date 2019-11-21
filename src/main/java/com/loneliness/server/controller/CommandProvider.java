package com.loneliness.server.controller;

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

    }
    public Map<CommandName, Command> getRepository() {
        return repository;
    }
    public static CommandProvider getCommandProvider() {
        return commandProvider;
    }

    public <s>Command getCommand(CommandName name){
        Command <s,s>command=repository.get(name);
        return repository.get(name);
    }
}
