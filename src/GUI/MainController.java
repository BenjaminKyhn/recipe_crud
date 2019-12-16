package GUI;


import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
    public Button findRecipesButton;

    public void changeSceneCloseChooseIngredientsPopup() {
        Stage stage = (Stage) findRecipesButton.getScene().getWindow();
        stage.close();
    }
}
