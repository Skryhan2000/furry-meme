package com.loneliness.client.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.util.Optional;
import java.util.Set;

public class FilledAlert {
    private static final FilledAlert instance = new FilledAlert();

    private FilledAlert() {
    }

    public static FilledAlert getInstance() {
        return instance;
    }

    public boolean showAlert(String title, String headerText, String contentText, Stage dialogStage, String type) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type));
        alert.initOwner(dialogStage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isEmpty()) {
            return false;
        }
        else if (result.get() == ButtonType.OK) {
            return true;
        }
        else if (result.get() == ButtonType.CANCEL) {
            return false;
        }
        return false;
    }
    public void showAlert(String title, String headerText, Set<ConstraintViolation<Object>> errors,
                          Stage dialogStage, String type){
        Alert alert = new Alert(Alert.AlertType.valueOf(type));
        StringBuilder errMessage=new StringBuilder();
        alert.initOwner(dialogStage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        for (ConstraintViolation<Object> violation : errors) {
           errMessage.append(violation.getMessage());
        }

        alert.setContentText(errMessage.toString());
        alert.showAndWait();
    }
    public boolean showAnswer(String answer, Stage dialogStage,String title){
        if(answer.startsWith("ERROR")){
            answer=answer.replace("ERROR","");
            showAlert(title, title+"ошибка ", answer, dialogStage, "ERROR");
            return false;
        }
        else {
            answer=answer.replace("ERROR","");
           showAlert(title, title+" успех", answer, dialogStage, "INFORMATION");
            return true;
        }
    }
}
