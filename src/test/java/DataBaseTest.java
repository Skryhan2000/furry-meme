import com.github.javafaker.Faker;
import com.loneliness.entity.UserData;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.controller.ControllerException;
import com.loneliness.server.dao.DataBaseConnection;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataBaseTest {
    private Faker faker=new Faker();
    private int quantity=1;


    private Map<Integer,UserData> createUser(int quantity){
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

    @BeforeClass
    public static void connectionTest() throws PropertyVetoException, SQLException {
        Assert.assertNotNull(DataBaseConnection.getInstance().getConnection());
    }
    @Test public void addUser() throws ControllerException {
        UserData userData;
        int c=0;
        for(int i=0;i<quantity;i++){
           userData=createUser(1).values().iterator().next();
            if(CommandProvider.getCommandProvider().getCommand(CommandName.CREATE_USER).
                    execute(userData).equals("Данные успешно добавлены")){
                c++;
            }

        }

        Assert.assertEquals(c,quantity);
    }
    @Test public void updateUser() throws ControllerException {
      int updateQuantity=0;
      int[] bound={0,5};
        Map<Integer,UserData> dataMap=(Map<Integer, UserData>) CommandProvider.getCommandProvider().getCommand(CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
        for (UserData user :
                dataMap.values()) {
            user.setEmail("invalidTestEmail");
            if(CommandProvider.getCommandProvider().getCommand(CommandName.UPDATE_USER).
                    execute(user).equals("Данные обновлены")){
                updateQuantity++;
            }
        }
        Assert.assertEquals(updateQuantity,quantity);
    }
    @Test public void deleteUser() throws ControllerException {
        int deleteQuantity = 0;
        int[] bound = {deleteQuantity, deleteQuantity+quantity};
        Map<Integer, UserData> dataMap = (Map<Integer, UserData>) CommandProvider.getCommandProvider().getCommand(CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound);
        for (UserData user :
                dataMap.values()) {
            user.setEmail("invalidTestEmail");
            if (CommandProvider.getCommandProvider().getCommand(CommandName.DELETE_USER).
                    execute(user).equals("Данные удалены")) {
                deleteQuantity++;
            }
        }
        Assert.assertEquals(deleteQuantity,quantity);
    }
    @Test public void authoriseUserPos() throws ControllerException {
        boolean valid=false;
        int[] bound = {0, 1};
        UserData userData = ((Map<Integer, UserData>) CommandProvider.getCommandProvider().
                getCommand(CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound)).values().iterator().next();
        userData.setType(UserData.Type.ADMIN);
        if(CommandProvider.getCommandProvider().getCommand(CommandName.UPDATE_USER).
                execute(userData).equals("Данные обновлены")){
            if (CommandProvider.getCommandProvider().getCommand(CommandName.AUTHORISE_USER).
                execute(userData).equals(UserData.Type.ADMIN)) {
            valid=true;
        }
        }

        Assert.assertTrue(valid);
    }
    @Test public void authoriseUserNeg() throws ControllerException {
        boolean invalid=false;
        int[] bound = {0, 1};
        UserData userData = ((Map<Integer, UserData>) CommandProvider.getCommandProvider().
                getCommand(CommandName.RECEIVE_ALL_USERS_IN_LIMIT).execute(bound)).values().iterator().next();
        userData.setType(UserData.Type.ADMIN);

        if(CommandProvider.getCommandProvider().getCommand(CommandName.UPDATE_USER).
                execute(userData).equals("Данные обновлены")){
            userData.setPassword(" ");
            if (CommandProvider.getCommandProvider().getCommand(CommandName.AUTHORISE_USER).
                    execute(userData).equals(UserData.Type.NO_TYPE)) {
                invalid=true;
            }
        }
        Assert.assertTrue(invalid);
    }

}
