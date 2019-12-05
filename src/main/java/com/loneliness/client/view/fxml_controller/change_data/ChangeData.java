package com.loneliness.client.view.fxml_controller.change_data;

import com.loneliness.client.controller.CommandProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ChangeData implements SetData {
    protected CommandProvider commandProvider=CommandProvider.getCommandProvider();
    protected final Logger logger = LogManager.getLogger();
    protected String action;
    @FXML
    protected Stage dialogStage;
    @FXML
    protected Button deleteButton;
    @FXML
    protected void initialize(){
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
        addButton.setDisable(true);
        addButton.setVisible(false);
    }
    @FXML
    void goBack(ActionEvent event) {
        dialogStage.close();
    }
    public void setDialogStage(Stage dialogStage, String action)  {
        this.dialogStage = dialogStage;
        this.action = action;
    }
    @FXML
    protected Button addButton;
}
