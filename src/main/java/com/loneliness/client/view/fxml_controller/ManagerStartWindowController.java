package com.loneliness.client.view.fxml_controller;

import com.loneliness.client.view.FilledAlert;
import com.loneliness.client.view.PathManager;
import com.loneliness.client.view.ViewException;
import com.loneliness.client.view.WorkWithFXMLLoader;
import com.loneliness.client.view.fxml_controller.change_data.ChangeIndex;
import com.loneliness.client.view.fxml_controller.search_data.SearchByDateAndNameOrIdController;
import com.loneliness.entity.Index;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerStartWindowController {
        private Index index;
        @FXML
        private Stage dialogStage;
        @FXML
        private AnchorPane mainPane;
        @FXML
        private Scene centerScene;
        @FXML
        void addDifferentialIndicators() {
                try {
                        dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                                getChangeIndex(), "Изменение данных");
                        ChangeIndex changeDifferentialIndicators = WorkWithFXMLLoader.getInstance().getLoader().getController();
                        changeDifferentialIndicators.setDialogStage(dialogStage,"update");
                        mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(PathManager.getInstance().
                                getChangeIndex())));

                } catch (IOException | ViewException e) {
                        FilledAlert.getInstance().showAlert("Неизвестная ошибка",
                                "Нарушение целостности программы", "Попробуйте повторить действие позже" +
                                        " или принудительно закройте программу",
                                this.dialogStage, "ERROR");
                }
        }

        @FXML
        void calculateAllInDetail(ActionEvent event) {

        }

        @FXML
        void calculateProfitability(ActionEvent event) {

        }

        @FXML
        void calculateROE(ActionEvent event) {

        }

        @FXML
        void calculateRONA(ActionEvent event) {

        }

        @FXML
        void calculateSG(ActionEvent event) {

        }

        @FXML
        void calculateWACC(ActionEvent event) {

        }

        @FXML
        void deleteDifferentialIndicators(ActionEvent event) {
                try {
                        Index index=findDifferentialIndicators();
                        if(index.getIndexID()>0){
                                if (!FilledAlert.getInstance().showAlert("Требуется подтверждение",
                                        "Удаление дифференциальных показателей",
                                        "Нажмите ок для подтверждения", dialogStage, "INFORMATION")) {
                                        // TODO: 25.11.2019 команда для удаления
                                }
                        }
                        else {
                                FilledAlert.getInstance().showAlert("Поиск данных",
                                        "Не валидные данные", "Нет таких данных",
                                        this.dialogStage, "INFORMATION");
                        }
                } catch (ViewException e) {
                        e.printStackTrace();
                }
        }

        @FXML
        void updateDifferentialIndicators() {
                try {
                        Index index =findDifferentialIndicators();
                        if(index.getIndexID()>0) {
                                dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                                        getChangeIndex(), "Изменение данных");
                                ChangeIndex changeDifferentialIndicators = WorkWithFXMLLoader.getInstance().getLoader().getController();
                                changeDifferentialIndicators.setData(index);
                                changeDifferentialIndicators.setDialogStage(dialogStage, "update");
                                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource(PathManager.getInstance().
                                        getChangeIndex())));

                        }
                        else {
                                FilledAlert.getInstance().showAlert("Поиск данных",
                                "Не валидные данные", "Нет таких данных",
                                this.dialogStage, "INFORMATION");
                        }

                }
                catch (ViewException | IOException e) {
                        FilledAlert.getInstance().showAlert("Поиск данных",
                                "Поиск невозможен", "Что то пошло не так",
                                this.dialogStage, "ERROR");
                }
        }

        @FXML
        void initialize() {
                AnchorPane.setTopAnchor(mainPane, 5.0);
                AnchorPane.setLeftAnchor(mainPane, 5.0);
                AnchorPane.setRightAnchor(mainPane, 5.0);
                AnchorPane.setBottomAnchor(mainPane,5.0);
        }

        private Index findDifferentialIndicators() throws ViewException {
                dialogStage = WorkWithFXMLLoader.getInstance().createStage(PathManager.getInstance().
                        getSearchByDateAndNameOrId(), "Поиск данных");
                SearchByDateAndNameOrIdController controller = WorkWithFXMLLoader.getInstance().getLoader().
                        getController();
                controller.setDialogStage(dialogStage);
                dialogStage.showAndWait();
                return controller.getIndex();
        }
}
