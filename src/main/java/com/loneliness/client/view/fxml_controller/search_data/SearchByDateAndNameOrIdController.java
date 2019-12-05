package com.loneliness.client.view.fxml_controller.search_data;

import com.loneliness.client.view.FilledAlert;
import com.loneliness.entity.Index;
import com.loneliness.entity.Quarter;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.time.LocalDate;

public class
SearchByDateAndNameOrIdController {
    private Index index = new Index();
    @FXML
    private Stage dialogStage;
    @FXML
    private ToggleGroup quarterGroup = new ToggleGroup();
    @FXML
    private TextField idField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private RadioMenuItem Q1;

    @FXML
    private RadioMenuItem Q2;

    @FXML
    private RadioMenuItem Q3;

    @FXML
    private RadioMenuItem Q4;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private boolean isValid() {
        StringBuilder err = new StringBuilder();
        String quarter;
        boolean valid = false;
        try {
            index.setIndexID(Integer.parseInt(idField.getText()));
            if (index.getIndexID() > 0) {
                valid = true;
            }
        } catch (NumberFormatException e) {
            err.append("Id должен быть задан числом ");
        }
        if (!valid) {
            if (datePicker.getValue() != null && datePicker.getValue().isBefore(LocalDate.now())) {
                index.setReportingDate(datePicker.getValue());
                valid = true;
            } else {
                err.append("Дата должна задана в прошлом ");
            }
            quarter=getQuarter();
            if(!quarter.equals("err")){
                index.setQuarter(Quarter.valueOf(quarter));
            }
            else {
                err.append("Задайте квартал ");
            }
        }
        err.append("Задайте имя компании ");

        if (!valid) {
            FilledAlert.getInstance().showAlert("Не верный ввод", "Валидация не пройдена",
                    "долен быть задан ID либо дата отчета \n" + err, dialogStage, "ERROR");
        }
        return valid;
    }

    @FXML
    private void finishWork() {
        if (isValid()) {

        }
    }

    @FXML
    private void goBack() {
        dialogStage.close();
    }

    public Index getIndex() {
        return index;
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

    @FXML
    public void initialize() {
        Q1.setToggleGroup(quarterGroup);
        Q2.setToggleGroup(quarterGroup);
        Q3.setToggleGroup(quarterGroup);
        Q4.setToggleGroup(quarterGroup);
    }
}
