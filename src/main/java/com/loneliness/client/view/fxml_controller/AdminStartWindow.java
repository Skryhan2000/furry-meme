package com.loneliness.client.view.fxml_controller;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.PathManager;
import com.loneliness.client.view.ViewException;
import com.loneliness.client.view.WorkWithFXMLLoader;
import com.loneliness.client.view.fxml_controller.change_data.*;
import com.loneliness.entity.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class AdminStartWindow {
    private final Logger logger = LogManager.getLogger();
    @FXML
    private Stage dialogStage;
    private CommandProvider commandProvider = CommandProvider.getCommandProvider();
    private Entity entity;
    private String dataType;
    private SetData changeData;

    @FXML
    private TableColumn<Entity, Number> id;

    @FXML
    private TableColumn<Entity, String> value;

    @FXML
    private AnchorPane editPane;

    @FXML
    private TableView<Entity> dataTable;

    private ObservableList<Entity> data = FXCollections.observableArrayList();

    public void setData(Map<Integer, Entity> map) {
        data.addAll(map.values());
    }

    @FXML
    private void workWithContactData() {
        dataType = "CONTACT_DETAIL";
        initialize();
    }

    @FXML
    private void workWithCompany() {
        dataType = "COMPANY";
        initialize();
    }
    @FXML
    private void workWithCredit(){
        dataType = "CREDIT";
        initialize();
    }
    @FXML
    private void workWithDividend(){
        dataType = "DIVIDEND";
        initialize();
    }
    @FXML
    private void workWithInitialData(){
        dataType = "INITIAL_DATA";
        initialize();
    }
    @FXML
    private void workWithReportingPeriod(){
        dataType = "REPORTING_PERIOD";
        initialize();
    }
    @FXML
    private void workWithRoe(){
        dataType = "ROE";
        initialize();
    }
    @FXML
    private void workWithSg(){
        dataType = "SG";
        initialize();
    }
    @FXML
    private void workWithUserData(){
        dataType = "USER_DATA";
        initialize();
    }

    @FXML
    private void update() {
        data.clear();
        try {

            switch (dataType) {
                case "CONTACT_DETAIL":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_CONTACT_DETAIL).execute(new Object()));
                    break;
                case "COMPANY":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_COMPANY).execute(new Object()));
                    break;
                case "CREDIT":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_CREDIT).execute(new Object()));
                    break;
                case "DIVIDEND":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_DIVIDEND).execute(new Object()));
                    break;
                case "INITIAL_DATA":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_INITIAL_DATA).execute(new Object()));
                    break;
                case "REPORTING_PERIOD":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_REPORTING_PERIOD).execute(new Object()));
                    break;
                case "ROE":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_ROE).execute(new Object()));
                    break;
                case "SG":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_SG).execute(new Object()));
                    break;
                case "USER_DATA":
                    setData((Map<Integer, Entity>) commandProvider.getCommand(CommandName.RECEIVE_ALL_USERS).execute(new Object()));
                    break;
            }
            dataTable.refresh();
            dataTable.setItems(data);
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Ошибка обновленя",
                    "Неизвестная ошибка", "Попробуйте повторить действие позже",
                    this.dialogStage, "ERROR");
            logger.catching(e);
        }

    }

    @FXML
    private void initialize() {
        if (dataType == null) {
            dataType = "CONTACT_DETAIL";
        }
        try {
            switch (dataType) {
                case "CONTACT_DETAIL":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeContactData(), "Изменение данных");

                    ChangeContactData changeContactData = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeContactData.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeContactData;
                    id.setText("id компании");
                    value.setText("email");

                    break;
                case "COMPANY":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeCompany(), "Изменение данных");
                    ChangeCompany changeCompany = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeCompany.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeCompany;


                    id.setText("id компании");
                    value.setText("Имя компании");
                    break;
                case "CREDIT":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeCredit(), "Изменение данных");
                    ChangeCredit changeCredit = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeCredit.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeCredit;


                    id.setText("id компании");
                    value.setText("сумма по кредиту");
                    break;
                case "DIVIDEND":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeDividend(), "Изменение данных");
                    ChangeDividend changeDividend = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeDividend.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeDividend;


                    id.setText("id компании");
                    value.setText("получатель");
                    break;

                case "INITIAL_DATA":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeInitialData(), "Изменение данных");
                    ChangeInitialData changeInitialData = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeInitialData.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeInitialData;


                    id.setText("id компании");
                    value.setText("ID отчетного периода");
                    break;
                case "REPORTING_PERIOD":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeReportingPeriod(), "Изменение данных");
                    ChangeReportingPeriod changeReportingPeriod = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeReportingPeriod.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeReportingPeriod;


                    id.setText("id компании");
                    value.setText("год");
                    break;
                case "ROE":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeRoe(), "Изменение данных");
                    ChangeRoe changeRoe = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeRoe.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeRoe;


                    id.setText("id компании");
                    value.setText("Id исходных данных ");
                    break;
                case "SG":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeSg(), "Изменение данных");
                    ChangeSG changeSG = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeSG.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeSG;


                    id.setText("id компании");
                    value.setText("Id исходных данных ");
                    break;
                case "USER_DATA":
                    dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                            getChangeUser(), "Изменение данных");
                    ChangeUser changeUser = WorkWithFXMLLoader.getInstance().getLoader().getController();
                    changeUser.setDialogStage(dialogStage, "UPDATE");
                    changeData=changeUser;


                    id.setText("id пользователя");
                    value.setText("email ");
                    break;
            }
            editPane.getChildren().add(WorkWithFXMLLoader.getInstance().getPane());
            dataTable.getSelectionModel().selectedItemProperty().addListener(
                    (observableValue, Entity, newEntity) -> changeData.setData(newEntity));

            id.setCellValueFactory(customerDataStringCellDataFeatures ->
                    customerDataStringCellDataFeatures.getValue().getIntegerId());
            value.setCellValueFactory(customerDataIntegerCellDataFeatures ->
                    customerDataIntegerCellDataFeatures.getValue().getStringValue());
            update();
        } catch (ViewException e) {
            FilledAlert.getInstance().showAlert("Ошибка обновленя",
                    "Неизвестная ошибка", "Попробуйте повторить действие позже",
                    this.dialogStage, "ERROR");
            logger.catching(e);
        }
    }
}
