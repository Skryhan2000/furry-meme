package com.loneliness.client.view;

public class PathManager {
    private static PathManager instance = new PathManager();

    public static PathManager getInstance() {
        return instance;
    }

    private PathManager() {
    }

    public String getAuthorisationForm(){return "/AuthorisationForm.fxml";}
    public String getAddDifferentialIndicators(){return "/AddDifferentialIndicators.fxml";}
    public String getManagerStartWindow(){return "/ManagerStartWindow.fxml";}
    public String getAdminStartWindow(){return "/AdminStartWindow.fxml";}


}
