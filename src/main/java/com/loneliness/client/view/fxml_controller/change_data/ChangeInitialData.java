package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.fxml_controller.ManagerStartWindowController;
import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class ChangeInitialData {
    @FXML
    private Stage dialogStage;

    private String action;

    private InitialData initialData;

    private CommandProvider commandProvider=CommandProvider.getCommandProvider();

    @FXML
    private TextField companyIdField;

    @FXML
    private TextField reportingDateIdField;

    @FXML
    private TextField salesField;

    @FXML
    private TextField assetsField;

    @FXML
    private TextField equityField;

    @FXML
    private TextField PBITField;

    @FXML
    private TextField creditField;

    public void setDialogStage(Stage dialogStage, String action,  InitialData initialData) {
        this.dialogStage = dialogStage;
        this.action = action;
        this.initialData=initialData;
        Set<ConstraintViolation<Object>> errors = null;
        try {
            errors = (Set<ConstraintViolation<Object>>)commandProvider.
                    getCommand(CommandName.INITIAL_DATA_VALIDATION).execute(initialData);
            if(errors.size() == 0){
                setData(initialData);
            }
        } catch (ControllerException e) {
        }

    }
    private void setData(InitialData initialData){
        companyIdField.setText(String.valueOf(initialData.getCompanyId()));
        reportingDateIdField.setText(String.valueOf(initialData.getReportingDateId()));
        salesField.setText(initialData.getSales().toString());
        assetsField.setText(initialData.getAssets().toString());
        equityField.setText(initialData.getEquity().toString());
        PBITField.setText(initialData.getPBIT().toString());
        creditField.setText(initialData.getCredit().toString());
    }

    private boolean isValid(){
        try {
            InitialData initialData=new InitialData();
            initialData.setInitialDataId(this.initialData.getInitialDataId());
            initialData.setCompanyId(Integer.parseInt(companyIdField.getText()));
            initialData.setReportingDateId(Integer.parseInt(reportingDateIdField.getText()));
            initialData.setSales(new BigDecimal(salesField.getText()));
            initialData.setAssets(new BigDecimal(assetsField.getText()));
            initialData.setEquity(new BigDecimal(equityField.getText()));
            initialData.setPBIT(new BigDecimal(PBITField.getText()));
            initialData.setCredit(new BigDecimal(creditField.getText()));

            Set<ConstraintViolation<Object>> errors = (Set<ConstraintViolation<Object>>)commandProvider.
                    getCommand(CommandName.INITIAL_DATA_VALIDATION).execute(initialData);
            if (errors.size() == 0) {
                this.initialData=initialData;
                return true;
            } else {
                FilledAlert.getInstance().showAlert("Валидация ", "Ошибка ", errors, dialogStage, "ERROR");
                return false;
            }
        }
        catch (NumberFormatException e){
            FilledAlert.getInstance().showAlert("Валидация данных",
                    "Не валидные данные", "В полях должны быть заданы числовые значения",
                    this.dialogStage, "ERROR");

        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Сбой программы", "Целостность нарушена",
                    e.getMessage(), dialogStage, "ERROR");
        }
        return false;
    }

    @FXML
    void finishWork(ActionEvent event) {
        if (isValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "CREATE":
                        ManagerStartWindowController.setInitialData(initialData);
                        break;
                    case "UPDATE":
                        answer = (String) commandProvider.getCommand(CommandName.UPDATE_INITIAL_DATA).execute(initialData);
                        break;
                    case "ADD":
                        answer = (String) commandProvider.getCommand(CommandName.CREATE_INITIAL_DATA).execute(initialData);
                        break;
                }

                FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных");
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Подсчет данных",
                        "Ошибка", e.getMessage(),
                        this.dialogStage, "ERROR");
            }
        }
    }

    @FXML
    void goBack(ActionEvent event) {}
}
