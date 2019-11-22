package com.loneliness.client.view;

public class PathManager {
    private static PathManager instance = new PathManager();

    public static PathManager getInstance() {
        return instance;
    }

    private PathManager() {
    }

   public String getAuthorisationForm(){return "/AuthorisationForm.fxml";}


}
