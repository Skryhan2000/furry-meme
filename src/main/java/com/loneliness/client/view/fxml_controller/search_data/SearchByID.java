package com.loneliness.client.view.fxml_controller.search_data;

import com.loneliness.client.view.FilledAlert;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchByID {

    @FXML
    private Stage dialogStage;
    @FXML
    private TextField id;

    private String action;



    public void setData(Stage dialogStage){
        this.dialogStage=dialogStage;
    }
    @FXML
    void finishWork() {
        if(isValid()){
            goBack();
        }
    }

    private boolean isValid(){
        boolean valid=false;
        String err="";
        try {
            if (id.getText() == null || id.getText().length() == 0) {
                err += "Id данных должно быть задано";
            } else if (Integer.parseInt(id.getText()) < 0) {
                err += "Id данных болжно быть положительным";
            } else valid = true;
        } catch (NumberFormatException ex){
            err+="В поле должны быть числовые значения";
        }
        if(!valid){
            FilledAlert.getInstance().showAlert("Валидация данных",
                    "Не валидные данные", err,
                    this.dialogStage, "ERROR");
        }
        return valid;
    }

    @FXML
    void goBack() {
        dialogStage.close();
    }

    public int getId() {
        return Integer.parseInt(id.getText());
    }
}
