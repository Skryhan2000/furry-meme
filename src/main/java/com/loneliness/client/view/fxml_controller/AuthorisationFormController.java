package com.loneliness.client.view.fxml_controller;


import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.launcher.Reconnect;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.entity.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AuthorisationFormController {
        @FXML
        private Stage dialogStage;
        private UserData userData=new UserData();
        @FXML
        private PasswordField passwordField;

        @FXML
        private TextField loginField;

        @FXML
        void finishWork(MouseEvent event) {

        }
        private UserData getAllData(){
                userData.setPassword(passwordField.getText());
                userData.setLogin(loginField.getText());
                return userData;
        }
        private boolean isValid(){
                boolean valid=false;
                if(userData.getPassword()!=null&&userData.getPassword().length()!=0){
                        if(userData.getLogin()!=null&&userData.getLogin().length()!=0){
                                CommandProvider.getCommandProvider().getCommand(CommandName.AUTHORISE_USER).execute(userData);
                        }
                }
                return false;
        }
        @FXML
        public void initialize() {

                FilledAlert.getInstance().showAlert("furry-meme","Добро пожаловать в furry-meme","Сдесь должна быть заставка, но ее съели мыши",dialogStage,"INFORMATION");
                while (!Reconnect.getInstance().getCancel().get()) {
                        if (!FilledAlert.getInstance().showAlert("Ошибка подключения",
                                "Подключение к серверу отсутствует",
                                "Нажмите ок для переподключения", dialogStage, "ERROR")) {
                                System.exit(0);
                        }
                }
        }
}

