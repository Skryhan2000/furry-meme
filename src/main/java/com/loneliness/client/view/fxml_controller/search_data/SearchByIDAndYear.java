package com.loneliness.client.view.fxml_controller.search_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.PathManager;
import com.loneliness.client.view.ViewException;
import com.loneliness.client.view.WorkWithFXMLLoader;
import com.loneliness.client.view.fxml_controller.chart.ROEChart;
import com.loneliness.entity.Quarter;
import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Map;

public class SearchByIDAndYear {
    @FXML
    private Stage dialogStage;
    @FXML
    private TextField company_id;

    @FXML
    private TextField year;

    private String action;

    private String title;

    public void setData(String action){
        this.action=action;
        this.title=title;
    }
    @FXML
    void finishWork() {
        if(isValid()){
            try {
                Stage dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                        getROEChart(), "График экономических показателйе");
                ROEChart chart=WorkWithFXMLLoader.getInstance().getLoader().getController();
                ReportingPeriod reportingPeriod=new ReportingPeriod();
                reportingPeriod.setYear(Integer.parseInt(year.getText()));
                reportingPeriod.setCompanyId(Integer.parseInt(company_id.getText()));
                chart.setData((Map< Quarter, ROE >)CommandProvider.getCommandProvider().
                        getCommand(CommandName.FIND_ROE_BY_REPORTING_PERIOD_YEAR).execute(reportingPeriod),Integer.parseInt(year.getText()),action);
                dialogStage.show();
            } catch (ViewException | ControllerException e) {
                FilledAlert.getInstance().showAlert("Поиск данных",
                        "Поиск невозможен", e.getMessage(),
                        this.dialogStage, "ERROR");
            }
        }

    }

    private boolean isValid(){
        boolean valid=false;
        String err="";
        try {
            if (company_id.getText() == null || company_id.getText().length() == 0) {
                err += "Id компании должно быть задано";
            } else if (Integer.parseInt(company_id.getText()) < 0) {
                err += "Id компании болжно быть положительным";
            } else if (year.getText() == null || year.getText().length() == 0) {
                err += "Id начального отчётного периода должно быть задано";
            } else if (Integer.parseInt(year.getText()) < 0) {
                err += "Id начального отчётного периода болжно быть положительным";
            } else valid = true;
        } catch (NumberFormatException ex){
            err+="В полях должны быть числовые значения";
        }
        if(!valid){
            FilledAlert.getInstance().showAlert("Валидация данных",
                    "Не валидные данные", err,
                    this.dialogStage, "ERROR");
        }
        return valid;
    }

    @FXML
    void goBack(ActionEvent event) {
        dialogStage.close();
    }
}
