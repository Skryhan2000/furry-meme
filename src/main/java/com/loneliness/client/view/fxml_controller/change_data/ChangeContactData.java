package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.fxml_controller.ManagerStartWindowController;
import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Credit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

public class ChangeContactData {
    @FXML
    private Stage dialogStage;

    private String action;

    private ContactDetail contactDetail;

    private CommandProvider commandProvider = CommandProvider.getCommandProvider();

    @FXML
    private TextField companyIdField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextArea info;

    public void setDialogStage(Stage dialogStage, String action, ContactDetail contactDetail) {
        this.dialogStage = dialogStage;
        this.action = action;
        this.contactDetail = contactDetail;
        Set<ConstraintViolation<Object>> errors = null;
        try {
            errors = (Set<ConstraintViolation<Object>>) commandProvider.
                    getCommand(CommandName.CONTACT_DETAIL_VALIDATION).execute(contactDetail);
            if (errors.size() == 0) {
                setData(contactDetail);
            }
        } catch (ControllerException e) {

        }

    }

    private void setData(ContactDetail contactDetail) {
        companyIdField.setText(String.valueOf(contactDetail.getCompanyId()));
        emailField.setText(String.valueOf(contactDetail.getEmail()));
        phoneNumberField.setText(contactDetail.getPhoneNumber());
        info.setText(contactDetail.getInfo());

    }

    @FXML
    void finishWork(ActionEvent event) {
        if (isValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "UPDATE":
                        answer = (String) commandProvider.getCommand(CommandName.UPDATE_CONTACT_DETAIL).execute(contactDetail);
                        break;
                    case "ADD":
                        answer = (String) commandProvider.getCommand(CommandName.CREATE_CONTACT_DETAIL).execute(contactDetail);
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

    private boolean isValid() {
        try {
            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setContactDetailId(this.contactDetail.getContactDetailId());
            contactDetail.setCompanyId(Integer.parseInt(companyIdField.getText()));
            contactDetail.setEmail(emailField.getText());
            contactDetail.setPhoneNumber(phoneNumberField.getText());
            contactDetail.setInfo(info.getText());


            Set<ConstraintViolation<Object>> errors = (Set<ConstraintViolation<Object>>) commandProvider.
                    getCommand(CommandName.CONTACT_DETAIL_VALIDATION).execute(contactDetail);
            if (errors.size() == 0) {
                this.contactDetail = contactDetail;
                return true;
            } else {
                FilledAlert.getInstance().showAlert("Валидация ", "Ошибка ", errors, dialogStage, "ERROR");
                return false;
            }
        } catch (NumberFormatException e) {
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
