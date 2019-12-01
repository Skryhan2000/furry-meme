package com.loneliness.client.view.fxml_controller;

import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.PathManager;
import com.loneliness.client.view.ViewException;
import com.loneliness.client.view.WorkWithFXMLLoader;
import com.loneliness.client.view.fxml_controller.change_data.*;
import com.loneliness.client.view.fxml_controller.search_data.FindWindow;
import com.loneliness.client.view.fxml_controller.search_data.SearchByIDAndYear;
import com.loneliness.entity.*;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagerStartWindowController {
        private PathManager pathManager=PathManager.getInstance();
        private WorkWithFXMLLoader loader=WorkWithFXMLLoader.getInstance();
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

        @FXML
        private void addReportingPeriod() {
                try {
                        dialogStage = loader.createStage(pathManager.
                                getChangeReportingPeriod(), "Добавление данных");

                        ChangeReportingPeriod changeReportingPeriod = loader.getLoader().getController();
                        changeReportingPeriod.setDialogStage(dialogStage, "CREATE", reportingPeriod);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void addROE(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeRoe(), "Добавление данных");
                        ChangeRoe changeRoe = loader.getLoader().getController();
                        changeRoe.setDialogStage(dialogStage, "CREATE", roe);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void addSG(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeSg(), "Добавление данных");
                        ChangeSG changeSG = loader.getLoader().getController();
                        changeSG.setDialogStage(dialogStage, "CREATE", sg);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void addDividend(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeDividend(), "Добавление данных");
                        ChangeDividend changeDividend = loader.getLoader().getController();
                        changeDividend.setDialogStage(dialogStage, "CREATE", dividend);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void addInitialData(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeInitialData(), "Добавление данных");
                        ChangeInitialData controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "CREATE", initialData);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void addCredit(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeCredit(), "Добавление данных");
                        ChangeCredit controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "CREATE", credit);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveRoe(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeRoe(), "Сохранение данных");
                        ChangeRoe controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", roe);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveSG(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeSg(), "Сохранение данных");
                        ChangeSG controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", sg);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveReportingPeriod(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeReportingPeriod(), "Сохранение данных");
                        ChangeReportingPeriod controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", reportingPeriod);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveROE(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeRoe(), "Сохранение данных");
                        ChangeRoe controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", roe);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveDividend(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeDividend(), "Сохранение данных");
                        ChangeDividend controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", dividend);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveInitialData(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeInitialData(), "Сохранение данных");
                        ChangeInitialData controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", initialData);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }
        @FXML
        private void saveCredit(){
                try {
                        dialogStage = loader.createStage(pathManager.getChangeCredit(), "Сохранение данных");
                        ChangeCredit controller = loader.getLoader().getController();
                        controller.setDialogStage(dialogStage, "ADD", credit);
                        mainPane.getChildren().add(loader.getPane());
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Добавление данных",
                                "Добавление невозможно", e.getMessage(),
                                this.dialogStage, "ERROR");
                }
        }

        @FXML
        private void analysisROE(){
                analysis("ANALYSIS_ROE");
        }

        @FXML
        private void analysisSG(){
                analysis("ANALYSIS_SG");
        }

        private void analysis(String action){
                try {
                        Stage dialogStage = loader.createStage(PathManager.getInstance().getFindWindow(), "Поиск данных");
                        FindWindow controller = loader.getLoader().getController();
                        switch (action) {
                                case "ANALYSIS_ROE":
                                        controller.setDialogStage(dialogStage, "ANALYSIS_ROE");
                                        break;
                                case "ANALYSIS_SG":
                                        controller.setDialogStage(dialogStage, "ANALYSIS_SG");
                                        break;
                        }
                        dialogStage.showAndWait();
                }
               catch (ViewException e) {
                       FilledAlert.getInstance().showAlert("Поиск данных",
                               "Поиск невозможен", e.getMessage(),
                               this.dialogStage, "ERROR");
                }

        }

        @FXML
        private void FlChart(){
                String chart="FL";
                createChart(chart);
        }
        @FXML
        private void ROEChart(){
                String chart="ROE";
                createChart(chart);
        }
        @FXML
        private void RONAChart(){
                String chart="RONA";
                createChart(chart);
        }
        @FXML
        private void profitabilityChart(){
                String chart="PROFITABILITY";
                createChart(chart);
        }



        private void createChart(String chart){
                Stage dialogStage = null;
                try {
                        dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                                getSearchByIDAndYear(), "График данных");
                        SearchByIDAndYear controller = WorkWithFXMLLoader.getInstance().getLoader().getController();
                        controller.setData(chart);
                        dialogStage.show();
                } catch (ViewException e) {
                        FilledAlert.getInstance().showAlert("Поиск данных",
                                "Поиск невозможен", e.getMessage(),
                                this.dialogStage, "ERROR");
                }

        }
}
