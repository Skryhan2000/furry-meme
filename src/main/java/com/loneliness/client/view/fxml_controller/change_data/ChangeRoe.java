package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.fxml_controller.ManagerStartWindowController;
import com.loneliness.entity.ROE;
import com.loneliness.client.controller.CommandName;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class ChangeRoe {
    private CommandProvider commandProvider=CommandProvider.getCommandProvider();

    @FXML
    private Stage dialogStage;

    private String action;

    private ROE roe;

    @FXML
    private TextField companyIdField;

    @FXML
    private TextField initialDataIDField;

    @FXML
    private TextField creditIDField;

    @FXML
    private TextField dividendIDField;

    @FXML
    private TextField EBITField;

    @FXML
    private Text roeField;

    @FXML
    private Text profitabilityField;

    @FXML
    private Text RonaField;

    @FXML
    private Text FlField;

    public void setDialogStage(Stage dialogStage, String action,ROE roe) {
        this.dialogStage = dialogStage;
        this.action = action;
        this.roe=roe;
    }

    @FXML
    void calculate(MouseEvent event) {
        if(isValid()){
            try {
                roe=(ROE)commandProvider.getCommand(CommandName.CALCULATE_ALL_ROE_DATA).execute(roe);
                roeField.setText(roe.getROE().toString());
                profitabilityField.setText(roe.getProfR().toString());
                RonaField.setText(roe.getRONA().toString());
                FlField.setText(roe.getFL().toString());
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Подсчет данных",
                        "Ошибка", e.getMessage(),
                        this.dialogStage, "ERROR");
            }
        }
    }

    @FXML
    void finishWork() {
        if (isValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "CREATE":
                        break;
                    case "UPDATE":
                        answer = (String) commandProvider.getCommand(CommandName.UPDATE_ROE).execute(roe);
                        break;
                    case "ADD":
                        answer = (String) commandProvider.getCommand(CommandName.CREATE_ROE).execute(roe);
                        break;
                }
                ManagerStartWindowController.setRoe(roe);
                FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных");
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Подсчет данных",
                        "Ошибка", e.getMessage(),
                        this.dialogStage, "ERROR");
            }
        }
    }

    private boolean isValid(){
        try {
            ROE roe=new ROE();
            roe.setROEId(this.roe.getROEId());
            roe.setCompanyId(Integer.parseInt(companyIdField.getText()));
            roe.setInitialDataId(Integer.parseInt(initialDataIDField.getText()));
            roe.setCreditId(Integer.parseInt(creditIDField.getText()));
            roe.setDividendID(Integer.parseInt(dividendIDField.getText()));
            roe.setEBIT(new BigDecimal(EBITField.getText()));
            Set<ConstraintViolation<Object>> errors = (Set<ConstraintViolation<Object>>)commandProvider.
                    getCommand(CommandName.ROE_VALIDATION).execute(roe);
            if (errors.size() == 0) {
                this.roe=roe;
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
    private void goBack(){
        dialogStage.close();
    }
}
