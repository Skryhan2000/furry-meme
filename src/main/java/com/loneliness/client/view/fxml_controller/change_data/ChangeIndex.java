package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.entity.Index;
import com.loneliness.entity.Quarter;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ChangeIndex {
    private String action;
    @FXML private ToggleGroup quarterGroup;
    @FXML
    private Stage dialogStage;
    private Index index = new Index();
    @FXML
    private TextField companyIdField;

    @FXML
    private TextField salesField;

    @FXML
    private TextField PBITField;

    @FXML
    private TextField assetsField;

    @FXML
    private TextField equityField;

    @FXML
    private TextField creditField;

    @FXML
    private TextField ratioRecField;

    @FXML
    private TextField EBITField;

    @FXML
    private DatePicker reportingPeriodDate;

    @FXML
    private RadioMenuItem Q1;

    @FXML
    private RadioMenuItem Q2;

    @FXML
    private RadioMenuItem Q3;

    @FXML
    private RadioMenuItem Q4;

    @FXML
    private TextField EField;

    @FXML
    private TextField E1Field;

    @FXML
    private TextField E2Field;

    @FXML
    private TextField RField;

    @FXML
    private TextField LField;

    @FXML
    private TextField DField;

    public boolean isInputValid() {
        Set<ConstraintViolation<Object>> errors = null;
        try {

            errors = (Set<ConstraintViolation<Object>>)
                    CommandProvider.getCommandProvider().getCommand(CommandName.
                            DIFFERENTIAL_INDICATORS_VALIDATION).execute(index);
            if (errors.size() == 0) {
                return true;
            } else {
                FilledAlert.getInstance().showAlert("Валидация заказа", "Ошибка", errors, dialogStage, "ERROR");
                return false;
            }
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Сбой программы", "Целостность нарушена",
                    e.getMessage(), dialogStage, "ERROR");
            return false;
        }
    }

    @FXML
    public void goBack() {
        dialogStage.close();
    }

    public void setData(Index index) {
        this.index = index;
        companyIdField.setText(String.valueOf(index.getCompanyID()));
        reportingPeriodDate.setValue(index.getReportingDate());
        setQuarter(index.getQuarter());
        PBITField.setText(index.getPBIT().toString());
        salesField.setText(index.getSales().toString());
        assetsField.setText(index.getAssets().toString());
        equityField.setText(index.getEquity().toString());
        creditField.setText(index.getCredit().toString());
        ratioRecField.setText(index.getRatioRec().toString());
        EBITField.setText(index.getEBIT().toString());
        EField.setText(index.getE().toString());
        E1Field.setText(index.getE1().toString());
        E2Field.setText(index.getE2().toString());
        RField.setText(index.getR().toString());
        LField.setText(index.getL().toString());
        DField.setText(index.getD().toString());
    }

    public void setDialogStage(Stage dialogStage, String action) {
        this.dialogStage = dialogStage;
        this.action = action;
    }

    @FXML
    public void finishWork() {
        if (isInputValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "create":
                        answer = (String) CommandProvider.getCommandProvider().getCommand(CommandName.
                                CREATE_DIFFERENTIAL_INDICATORS).execute(index);
                        break;
                    case "update":
                        answer = (String) CommandProvider.getCommandProvider().getCommand(CommandName.
                                UPDATE_DIFFERENTIAL_INDICATORS).execute(index);
                        break;
                }
                if (FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных")) {
                    goBack();
                }
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Сбой программы", "Целостность нарушена",
                        e.getMessage(), dialogStage, "ERROR");
            }
        }
    }
    private String getQuarter() {
        if (Q1.isSelected()) {
            return "Q1";
        } else if (Q2.isSelected()) {
            return "Q1";
        } else if (Q3.isSelected()) {
            return "Q1";
        } else if (Q4.isSelected()) {
            return "Q1";
        } else return "err";
    }
    private void setQuarter(Quarter quarter) {
        switch (quarter){
            case Q1:
                Q1.setSelected(true);
                break;
            case Q2:
                Q2.setSelected(true);
                break;
            case Q3:
                Q3.setSelected(true);
                break;
            case Q4:
                Q4.setSelected(true);
        }

    }

    @FXML
    public void initialize() {
        Q1.setToggleGroup(quarterGroup);
        Q2.setToggleGroup(quarterGroup);
        Q3.setToggleGroup(quarterGroup);
        Q4.setToggleGroup(quarterGroup);
    }
}
