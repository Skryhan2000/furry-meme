package com.loneliness.client.view.fxml_controller;

import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.PathManager;
import com.loneliness.client.view.ViewException;
import com.loneliness.client.view.WorkWithFXMLLoader;
import com.loneliness.client.view.fxml_controller.change_data.ChangeIndex;
import com.loneliness.client.view.fxml_controller.change_data.ChangeRoe;
import com.loneliness.client.view.fxml_controller.change_data.ChangeSG;
import com.loneliness.client.view.fxml_controller.search_data.SearchByDateAndNameOrIdController;
import com.loneliness.entity.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerStartWindowController {
        private static Company company;
        private static Credit credit;
        private static Dividend dividend;
        private static InitialData initialData;
        private static ReportingPeriod reportingPeriod;
        private static ROE roe;
        private static SG sg;
        @FXML
        private Stage dialogStage;
        @FXML
        private AnchorPane mainPane;
        @FXML
        private Scene centerScene;

        public static void setCompany(Company company) {
                ManagerStartWindowController.company = company;
        }

        public static void setCredit(Credit credit) {
                ManagerStartWindowController.credit = credit;
        }

        public static void setDividend(Dividend dividend) {
                ManagerStartWindowController.dividend = dividend;
        }

        public static void setInitialData(InitialData initialData) {
                ManagerStartWindowController.initialData = initialData;
        }

        public static void setReportingPeriod(ReportingPeriod reportingPeriod) {
                ManagerStartWindowController.reportingPeriod = reportingPeriod;
        }

        public static void setRoe(ROE roe) {
                ManagerStartWindowController.roe = roe;
        }

        public static void setSg(SG sg) {
                ManagerStartWindowController.sg = sg;
        }



        @FXML
        void calculateAllInDetail(ActionEvent event) {

        }


        @FXML
        void calculateSG() {
                try {
                        if (roe == null) {
                                FilledAlert.getInstance().showAlert("Подсчёт данных",
                                        "Недостаточность данных", "сначала заполните ROE",
                                        this.dialogStage, "WARNING");
                                calculateRoe();
                        }
                        dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                                getChangeSg(), "Изменение данных");
                        ChangeSG changeSg = WorkWithFXMLLoader.getInstance().getLoader().getController();
                        sg.setCompanyId(company.getCompanyId());
                        changeSg.setDialogStage(dialogStage, "CREATE", sg);
                        mainPane.getChildren().add(WorkWithFXMLLoader.getInstance().getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Подсчёт данных",
                                "Подсчёт невозможен", "Что то пошло не так",
                                this.dialogStage, "ERROR");
                }
        }

        @FXML
        private void calculateRoe() {
                try {
                        dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                                getChangeRoe(), "Изменение данных");
                        ChangeRoe changeRoe = WorkWithFXMLLoader.getInstance().getLoader().getController();
                        roe.setCompanyId(company.getCompanyId());
                        changeRoe.setDialogStage(dialogStage, "CREATE", roe);
                        mainPane.getChildren().add(WorkWithFXMLLoader.getInstance().getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Подсчёт данных",
                                "Подсчёт невозможен", "Что то пошло не так",
                                this.dialogStage, "ERROR");
                }
        }

        @FXML
        void initialize() {
                AnchorPane.setTopAnchor(mainPane, 5.0);
                AnchorPane.setLeftAnchor(mainPane, 5.0);
                AnchorPane.setRightAnchor(mainPane, 5.0);
                AnchorPane.setBottomAnchor(mainPane, 5.0);
                company = new Company();
                company.setCompanyId(1);
                credit = new Credit();
                dividend = new Dividend();
                initialData = new InitialData();
                reportingPeriod = new ReportingPeriod();
                roe = new ROE();
                sg = new SG();
        }
}
