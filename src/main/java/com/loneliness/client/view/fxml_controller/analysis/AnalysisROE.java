package com.loneliness.client.view.fxml_controller.analysis;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.entity.InitialData;
import com.loneliness.entity.ROE;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AnalysisROE {

    private CommandProvider provider = CommandProvider.getCommandProvider();
    private ROE leftROE;
    private ROE rightROE;
    private InitialData leftInitialData;
    private InitialData rightInitialData;
    @FXML
    private Stage dialogStage;

    @FXML
    private Text leftEBIT;

    @FXML
    private Text leftAssets;

    @FXML
    private Text leftEquity;

    @FXML
    private Text leftProfR;

    @FXML
    private Text leftRONA;

    @FXML
    private Text leftFL;

    @FXML
    private Text leftPBIT;

    @FXML
    private Text rightEBIT;

    @FXML
    private Text deltaEBIT;

    @FXML
    private Text rightPBIT;

    @FXML
    private Text deltaPBIT;

    @FXML
    private Text rightAssets;

    @FXML
    private Text rightEquity;

    @FXML
    private Text rightProfR;

    @FXML
    private Text rightRONA;

    @FXML
    private Text rightFL;

    @FXML
    private Text deltaAssets;

    @FXML
    private Text deltaEquity;

    @FXML
    private Text deltaProfR;

    @FXML
    private Text deltaRONA;

    @FXML
    private Text deltaFL;



    @FXML
    private Text leftROEField;

    @FXML
    private Text rightROEField;

    @FXML
    private Text deltaROEField;


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setAllROE(ROE left, ROE right) {
        setLeftROE(left);
        setRightROE(right);
        deltaAll();
    }

    public ROE getLeftROE() {
        return leftROE;
    }

    public void setLeftROE(ROE leftROE) {
        this.leftROE = leftROE;
        try {
            leftInitialData.setInitialDataId(leftROE.getInitialDataId());
            leftInitialData = (InitialData) provider.getCommand(CommandName.RECEIVE_INITIAL_DATA).execute(leftInitialData);
            setLeftField(leftInitialData);
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Поиск данных",
                    "Поиск невозможен", e.getMessage(),
                    this.dialogStage, "ERROR");
        }
        setLeftField(leftROE);
    }

    public ROE getRightROE() {
        return rightROE;
    }

    public void setRightROE(ROE rightROE) {
        this.rightROE = rightROE;
        try {
            rightInitialData.setInitialDataId(rightROE.getInitialDataId());
            rightInitialData = (InitialData) provider.getCommand(CommandName.RECEIVE_INITIAL_DATA).execute(rightInitialData);
            setRightField(rightInitialData);
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Поиск данных",
                    "Поиск невозможен", e.getMessage(),
                    this.dialogStage, "ERROR");
        }
        setRightField(rightROE);

    }

    public InitialData getLeftInitialData() {
        return leftInitialData;
    }

    public void setLeftInitialData(InitialData leftInitialData) {
        this.leftInitialData = leftInitialData;
    }

    public InitialData getRightInitialData() {
        return rightInitialData;
    }

    public void setRightInitialData(InitialData rightInitialData) {
        this.rightInitialData = rightInitialData;
    }

    private void setLeftField(InitialData leftInitialData) {
        leftPBIT.setText(leftInitialData.getPBIT().toString());
        leftAssets.setText(leftInitialData.getAssets().toString());
        leftEquity.setText(leftInitialData.getEquity().toString());
    }

    private void setRightField(InitialData rightInitialData) {
        rightPBIT.setText(rightInitialData.getPBIT().toString());
        rightAssets.setText(rightInitialData.getAssets().toString());
        rightEquity.setText(rightInitialData.getEquity().toString());
    }

    private void setRightField(ROE rightROE) {
        rightEBIT.setText(rightROE.getEBIT().toString());
        rightProfR.setText(rightROE.getProfR().toString());
        rightRONA.setText(rightROE.getRONA().toString());
        rightROEField.setText(rightROE.getROE().toString());
        rightFL.setText(rightROE.getFL().toString());
    }

    private void setLeftField(ROE leftROE) {
        leftEBIT.setText(leftROE.getEBIT().toString());
        leftProfR.setText(leftROE.getProfR().toString());
        leftRONA.setText(leftROE.getRONA().toString());
        leftROEField.setText(leftROE.getROE().toString());
        leftFL.setText(leftROE.getFL().toString());
    }

    public void deltaAll(){
        deltaEBIT.setText(calculateDifference(leftEBIT,rightEBIT));
        deltaProfR.setText(calculateDifference(leftProfR,rightProfR));
        deltaRONA.setText(calculateDifference(leftRONA,rightRONA));
        deltaROEField.setText(calculateDifference(leftROEField,rightROEField));
        deltaFL.setText(calculateDifference(leftFL,rightFL));
        deltaPBIT.setText(calculateDifference(leftPBIT,rightPBIT));
        deltaAssets.setText(calculateDifference(leftAssets,rightAssets));
        deltaEquity.setText(calculateDifference(leftEquity,rightEquity));
    }

    private String calculateDifference(Text leftText,Text rightText){
        try {
            BigDecimal left = new BigDecimal(leftText.getText());
            BigDecimal right = new BigDecimal(rightText.getText());
            return left.divide(right,4, RoundingMode.HALF_UP).toString();
        }
        catch (NumberFormatException|ArithmeticException ex){
            return "Не корректные данные";
        }
    }

    @FXML
    private void goBack() {
        dialogStage.close();
    }
}
