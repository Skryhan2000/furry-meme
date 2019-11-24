package client;

import com.github.javafaker.Faker;
import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.launcher.Client;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.launcher.ServerLauncher;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientUserCommandTest {
    private Faker faker=new Faker();
    private int quantity=1;


    private Map<Integer, UserData> createUser(int quantity){
        Map<Integer,UserData> data=new ConcurrentHashMap<>();
        UserData userData;
        for(int i=0;i<quantity;i++) {
            userData = new UserData();
            userData.setLogin(faker.funnyName().name());
            userData.setPassword(faker.internet().password());
            UserData.Type type;
            switch (faker.number().numberBetween(0, 2)) {
                case 0:
                    type = UserData.Type.ADMIN;
                    break;
                case 1:
                    type = UserData.Type.MANAGER;
                    break;
                default:
                    type = UserData.Type.NO_TYPE;
            }
            userData.setType(type);
            userData.setEmail(faker.internet().emailAddress());
            data.put(userData.getId(),userData);
        }
        return data;
    }

    @BeforeClass public static void createConnection()  {
        //ServerLauncher.main(new String[]{"args"});
        Assert.assertTrue(Client.connect("localhost",8000));
    }

    @Test public void createUser() throws com.loneliness.client.controller.ControllerException {
        boolean success=false;
        UserData userData=createUser(1).values().iterator().next();
        if(CommandProvider.getCommandProvider().getCommand(CommandName.CREATE_USER).execute(userData).
                equals("Данные успешно добавлены")){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test public void updateUser() throws ControllerException, com.loneliness.client.controller.ControllerException {
        boolean success=false;
        int[] bound={0,1};
        Map<Integer,UserData> dataMap=(Map<Integer, UserData>) com.loneliness.server.
                controller.CommandProvider.getCommandProvider().getCommand(com.loneliness.server.
                controller.CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
        UserData user=dataMap.values().iterator().next();
        user.setEmail("testInvalidEmail");
        if(CommandProvider.getCommandProvider().getCommand(CommandName.UPDATE_USER).execute(user).
                equals("Данные обновлены")){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test public void deleteUser() throws ControllerException, com.loneliness.client.controller.ControllerException {
        boolean success=false;
        int[] bound={0,1};
        Map<Integer,UserData> dataMap=(Map<Integer, UserData>) com.loneliness.server.
                controller.CommandProvider.getCommandProvider().getCommand(com.loneliness.server.
                controller.CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
        if(CommandProvider.getCommandProvider().getCommand(CommandName.DELETE_USER).execute(dataMap.values().
                iterator().next()).equals("Данные удалены")){
            success=true;
        }
        Assert.assertTrue(success);
    }
    @Test public void receiveUser() throws ControllerException, com.loneliness.client.controller.ControllerException {

        int[] bound={0,1};
        Map<Integer,UserData> dataMap=(Map<Integer, UserData>) com.loneliness.server.
                controller.CommandProvider.getCommandProvider().getCommand(com.loneliness.server.
                controller.CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
        UserData RECEIVE_ALL_USERS_IN_LIMIT=dataMap.values().iterator().next();
        Assert.assertEquals(RECEIVE_ALL_USERS_IN_LIMIT, CommandProvider.getCommandProvider().getCommand(CommandName.
                RECEIVE_USER).execute(RECEIVE_ALL_USERS_IN_LIMIT));
    }
    @Test public void authoriseUser() throws ControllerException, com.loneliness.client.controller.ControllerException {
        int[] bound={0,1};
        UserData RECEIVE_ALL_USERS_IN_LIMIT;
        while (true) {
            Map<Integer, UserData> dataMap = (Map<Integer, UserData>) com.loneliness.server.
                    controller.CommandProvider.getCommandProvider().getCommand(com.loneliness.server.
                    controller.CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
           RECEIVE_ALL_USERS_IN_LIMIT = dataMap.values().iterator().next();
            if(RECEIVE_ALL_USERS_IN_LIMIT.getType()!= UserData.Type.NO_TYPE){
                break;
            }
        }
        Assert.assertEquals(RECEIVE_ALL_USERS_IN_LIMIT.getType(), CommandProvider.getCommandProvider().getCommand(CommandName.
                AUTHORISE_USER).execute(RECEIVE_ALL_USERS_IN_LIMIT));
    }

}
