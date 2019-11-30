package com.loneliness.client.view;

public class PathManager {
    private static PathManager instance = new PathManager();

    public static PathManager getInstance() {
        return instance;
    }

    private PathManager() {
    }

    public String getAuthorisationForm(){return "/AuthorisationForm.fxml";}
    public String getChangeIndex(){return "/ChangeRoe.fxml";}
    public String getManagerStartWindow(){return "/ManagerStartWindow.fxml";}
    public String getAdminStartWindow(){return "/AdminStartWindow.fxml";}
    public String getSearchByDateAndNameOrId(){return "/SearchByDateAndNameOrId.fxml";}


}
