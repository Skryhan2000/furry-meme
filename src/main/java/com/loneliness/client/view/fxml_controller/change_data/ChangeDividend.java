package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.fxml_controller.ManagerStartWindowController;
import com.loneliness.entity.Dividend;
import com.loneliness.entity.InitialData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class ChangeDividend {
    @FXML
    private Stage dialogStage;

    private String action;

    private Dividend dividend;

    private CommandProvider commandProvider=CommandProvider.getCommandProvider();

    @FXML
    private TextField companyIdField;

    @FXML
    private TextField reportingPeriodIdField;

    @FXML
    private TextField dividendPercentageField;

    @FXML
    private TextField recipientField;

    @FXML
    void finishWork(ActionEvent event) {
        if (isValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "CREATE":
                        ManagerStartWindowController.setDividend(dividend);
                        break;
                    case "UPDATE":
                        answer = (String) commandProvider.getCommand(CommandName.UPDATE_DIVIDEND).execute(dividend);
                        break;
                    case "ADD":
                        answer = (String) commandProvider.getCommand(CommandName.CREATE_DIVIDEND).execute(dividend);
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
    void goBack(ActionEvent event) {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage, String action,  Dividend dividend) {
        this.dialogStage = dialogStage;
        this.action = action;
        this.dividend=dividend;
        Set<ConstraintViolation<Object>> errors = null;
        try {
            errors = (Set<ConstraintViolation<Object>>)commandProvider.
                    getCommand(CommandName.DIVIDEND_VALIDATION).execute(dividend);
            if(errors.size() == 0){
                setData(dividend);

            }
        } catch (ControllerException e) {

        }


    }
    private void setData(Dividend dividend){
        companyIdField.setText(String.valueOf(dividend.getCompanyId()));
        reportingPeriodIdField.setText(String.valueOf(dividend.getReportingPeriodId()));
        dividendPercentageField.setText(dividend.getDividendPercentage().toString());
        recipientField.setText(dividend.getRecipient());
    }

    private boolean isValid(){
        try {
            Dividend dividend=new Dividend();
            dividend.setDividendId(this.dividend.getDividendId());
            dividend.setCompanyId(Integer.parseInt(companyIdField.getText()));
            dividend.setReportingPeriodId(Integer.parseInt(reportingPeriodIdField.getText()));
            dividend.setDividendPercentage(new BigDecimal(dividendPercentageField.getText()));
            dividend.setRecipient(recipientField.getText());

            Set<ConstraintViolation<Object>> errors = (Set<ConstraintViolation<Object>>)commandProvider.
                    getCommand(CommandName.DIVIDEND_VALIDATION).execute(dividend);
            if (errors.size() == 0) {
                this.dividend=dividend;
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

}
