package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.fxml_controller.ManagerStartWindowController;
import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.entity.Entity;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ChangeCompanyRepresentatives extends ChangeData {

    private CompanyRepresentatives companyRepresentatives;

    @FXML
    private TextField companyIdField;
    @FXML
    private TextField userIdField;

    public void setDialogStage(Stage dialogStage, String action, CompanyRepresentatives companyRepresentatives)  {
        this.dialogStage = dialogStage;
        this.action = action;
        this.companyRepresentatives = companyRepresentatives;
        Set<ConstraintViolation<Object>> errors = null;
        try {
            errors = (Set<ConstraintViolation<Object>>) commandProvider.
                    getCommand(CommandName.COMPANY_REPRESENTATIVES_VALIDATION).execute(companyRepresentatives);
            if (errors.size() == 0){
                setAllIds();
                setData(companyRepresentatives);
                logger.info("валидация companyRepresentatives успешна");
            }
        } catch (ControllerException e) {
            logger.catching(e);
        }

    }

    public void setAllIds() throws ControllerException {
        setCompanyIds(companyIds,companyIdField);
        setUsersIds(usersIds,userIdField);
    }

    @FXML
    void finishWork() {
        if (isValid()) {
            try {
                String answer = "";
                switch (action) {
                    case "CREATE":
                        ManagerStartWindowController.setCompanyRepresentatives(companyRepresentatives);
                        break;
                    case "UPDATE":
                        answer = (String) commandProvider.getCommand(CommandName.UPDATE_COMPANY_REPRESENTATIVES).execute(companyRepresentatives);
                        break;
                    case "ADD":
                        answer = (String) commandProvider.getCommand(CommandName.CREATE_COMPANY_REPRESENTATIVES).execute(companyRepresentatives);
                        break;
                }

                FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных");
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Подсчет данных",
                        "Ошибка", e.getMessage(),
                        this.dialogStage, "ERROR");
                logger.catching(e);
            }
        }
    }

    private boolean isValid() {
        try {
            CompanyRepresentatives company = new CompanyRepresentatives();
            if(this.companyRepresentatives!=null)
            company.setId(this.companyRepresentatives.getId());
            else {
                action="ADD";
            }
            company.setManagerId(Integer.parseInt(userIdField.getText()));
            company.setCompanyId(Integer.parseInt(companyIdField.getText()));
            Set<ConstraintViolation<Object>> errors = (Set<ConstraintViolation<Object>>) commandProvider.
                    getCommand(CommandName.COMPANY_REPRESENTATIVES_VALIDATION).execute(company);
            if (errors.size() == 0) {
                this.companyRepresentatives = company;
                return true;
            } else {
                FilledAlert.getInstance().showAlert("Валидация ", "Ошибка ", errors, dialogStage, "ERROR");
                return false;
            }
        } catch (NumberFormatException e) {
            FilledAlert.getInstance().showAlert("Валидация данных",
                    "Не валидные данные", "В полях должны быть заданы числовые значения",
                    this.dialogStage, "ERROR");
            logger.catching(e);
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Сбой программы", "Целостность нарушена",
                    e.getMessage(), dialogStage, "ERROR");
            logger.catching(e);
        }
        return false;
    }

    @Override
    public void setData(Entity entity) {
        if(entity!=null) {
            CompanyRepresentatives company=(CompanyRepresentatives) entity;
            this.companyRepresentatives = company;
            companyIdField.setText(String.valueOf(company.getCompanyId()));
            userIdField.setText(String.valueOf(company.getManagerId()));
            deleteButton.setDisable(false);
            deleteButton.setVisible(true);
            addButton.setDisable(false);
            addButton.setVisible(true);
        }
    }

    @FXML
    private void delete(){
        String answer = null;
        if(companyRepresentatives!=null) {
            try {
                answer = (String) commandProvider.getCommand(CommandName.DELETE_COMPANY_REPRESENTATIVES).execute(companyRepresentatives);
                FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных");
            } catch (ControllerException e) {
                FilledAlert.getInstance().showAlert("Обновления данных",
                        "Ошибка", e.getMessage(),
                        this.dialogStage, "ERROR");
                logger.catching(e);
            }
        }
    }
    @FXML
    private void add(){
        if(isValid()) {
            String answer = null;
            if (companyRepresentatives != null) {
                try {
                    answer = (String) commandProvider.getCommand(CommandName.CREATE_COMPANY_REPRESENTATIVES).execute(companyRepresentatives);
                    FilledAlert.getInstance().showAnswer(answer, dialogStage, "Обновления данных");
                } catch (ControllerException e) {
                    FilledAlert.getInstance().showAlert("Обновления данных",
                            "Ошибка", e.getMessage(),
                            this.dialogStage, "ERROR");
                    logger.catching(e);
                }
            }
        }
    }
}
