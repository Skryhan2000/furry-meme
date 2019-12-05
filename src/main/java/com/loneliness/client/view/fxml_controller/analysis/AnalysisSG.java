package com.loneliness.client.view.fxml_controller.analysis;

import com.loneliness.client.controller.CommandName;
import com.loneliness.client.controller.CommandProvider;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.view.FilledAlert;
import com.loneliness.entity.InitialData;
import com.loneliness.entity.ROE;
import com.loneliness.entity.SG;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class AnalysisSG {
    private CommandProvider provider=CommandProvider.getCommandProvider();
    private SG leftSg=new SG();
    private SG rightSg=new SG();;
    private InitialData leftInitialData=new InitialData();
    private InitialData rightInitialData=new InitialData();
    private ROE leftRoe=new ROE();
    private ROE rightRoe=new ROE();
    @FXML
    private Stage dialogStage;

    @FXML
    private Text leftEquityBegin;

    @FXML
    private Text leftEquityIncrease;

    @FXML
    private Text leftROEField;

    @FXML
    private Text leftReinvestmentProfit;

    @FXML
    private Text leftPBIT;

    @FXML
    private Text leftReinvestmentRatio;

    @FXML
    private Text leftEquityEnd;

    @FXML
    private Text rightEquityBegin;

    @FXML
    private Text deltaEquityBegin;

    @FXML
    private Text rightEquityEnd;

    @FXML
    private Text deltaEquityEnd;

    @FXML
    private Text rightEquityIncrease;

    @FXML
    private Text rightROEField;

    @FXML
    private Text rightReinvestmentProfit;

    @FXML
    private Text rightPBIT;

    @FXML
    private Text rightReinvestmentRatio;

    @FXML
    private Text deltaEquityIncrease;

    @FXML
    private Text deltaROE;

    @FXML
    private Text deltaReinvestmentProfit;

    @FXML
    private Text deltaPBIT;

    @FXML
    private Text deltaReinvestmentRatio;

    @FXML
    private Text leftSGField;

    @FXML
    private Text rightSGField;

    @FXML
    private Text deltaSG;



    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setAllSg(SG leftSg,SG rightSg){
        setLeftSg(leftSg);
        setRightSg(rightSg);
        deltaAll();
    }

    public SG getLeftSg() {
        return leftSg;
    }

    public void setLeftSg(SG leftSg) {
        this.leftSg = leftSg;

        try {
            if(((Set<ConstraintViolation<SG>>)provider.getCommand(CommandName.SG_VALIDATION).execute(leftSg)).size()==0) {
                setLeftField(leftSg);
                leftInitialData.setInitialDataId(leftSg.getInitialDataId());
                leftInitialData = (InitialData) provider.getCommand(CommandName.RECEIVE_INITIAL_DATA).execute(leftInitialData);
                leftPBIT.setText(leftInitialData.getPBIT().toString());
                leftEquityBegin.setText((provider.getCommand(CommandName.FIND_PREVIOUS_EQUITY).execute(leftInitialData)).toString());
                leftEquityEnd.setText((provider.getCommand(CommandName.FIND_FUTURE_EQUITY).execute(leftInitialData)).toString());
                leftRoe.setROEId(leftSg.getRoeId());
                leftROEField.setText(((ROE) (provider.getCommand(CommandName.RECEIVE_ROE).execute(leftRoe))).getROE().toString());
                leftEquityIncrease.setText(calculateEquityIncrease(leftEquityBegin, leftEquityEnd));
            }
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Поиск данных",
                    "Поиск невозможен", e.getMessage(),
                    this.dialogStage, "ERROR");
        }
    }

    public SG getRightSg() {
        return rightSg;
    }

    public void setRightSg(SG rightSg) {
        this.rightSg = rightSg;

        try {
            if(((Set<ConstraintViolation<SG>>)provider.getCommand(CommandName.SG_VALIDATION).execute(rightSg)).size()==0) {
                setRightField(rightSg);
                setLeftField(rightSg);
                rightInitialData.setInitialDataId(rightSg.getInitialDataId());
                rightInitialData = (InitialData) provider.getCommand(CommandName.RECEIVE_INITIAL_DATA).execute(rightInitialData);
                rightPBIT.setText(rightInitialData.getPBIT().toString());
                rightEquityBegin.setText((provider.getCommand(CommandName.FIND_PREVIOUS_EQUITY).execute(rightInitialData)).toString());
                rightEquityEnd.setText((provider.getCommand(CommandName.FIND_FUTURE_EQUITY).execute(rightInitialData)).toString());
                rightRoe.setROEId(rightSg.getRoeId());
                rightROEField.setText(((ROE) (provider.getCommand(CommandName.RECEIVE_ROE).execute(rightRoe))).getROE().toString());
                rightEquityIncrease.setText(calculateEquityIncrease(rightEquityBegin, rightEquityEnd));
            }
        } catch (ControllerException e) {
            FilledAlert.getInstance().showAlert("Поиск данных",
                    "Поиск невозможен", e.getMessage(),
                    this.dialogStage, "ERROR");
        }
    }

    @FXML
    private void goBack() {
        dialogStage.close();
    }

    private void setLeftField(SG leftSg){
        leftReinvestmentProfit.setText(leftSg.getReinvestmentProfit().toString());
        leftReinvestmentRatio.setText(leftSg.getReinvestmentRatio().toString());
        leftSGField.setText(leftSg.getSG().toString());
    }
    private void setRightField(SG rightSg){
        rightReinvestmentProfit.setText(rightSg.getReinvestmentProfit().toString());
        rightReinvestmentRatio.setText(rightSg.getReinvestmentRatio().toString());
        rightSGField.setText(rightSg.getSG().toString());
    }
    private String calculateEquityIncrease(Text equityBegin,Text equityEnd){
        try {
            BigDecimal left = new BigDecimal(equityBegin.getText());
            BigDecimal right = new BigDecimal(equityEnd.getText());
            return left.divide(right,4, RoundingMode.HALF_UP).toString();
        }
        catch (NumberFormatException|ArithmeticException ex){
            return "Не корректные данные";
        }
    }

    public void deltaAll(){
        deltaEquityBegin.setText(calculateDifference(leftEquityBegin,rightEquityBegin));
        deltaEquityEnd.setText(calculateDifference(leftEquityEnd,rightEquityEnd));
        deltaEquityIncrease.setText(calculateDifference(leftEquityIncrease,rightEquityIncrease));
        deltaROE.setText(calculateDifference(leftROEField, rightROEField));
        deltaReinvestmentProfit.setText(calculateDifference(leftReinvestmentProfit,rightReinvestmentProfit));
        deltaPBIT.setText(calculateDifference(leftPBIT,rightPBIT));
        deltaReinvestmentRatio.setText(calculateDifference(leftReinvestmentRatio,rightReinvestmentRatio));
        deltaSG.setText(calculateDifference(leftSGField,rightSGField));
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
}
