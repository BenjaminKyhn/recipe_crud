package GUI;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartController {
    public Button findRecipesButton;

    /*public void changeSceneCloseChooseIngredientsPopup() {
        Stage stage = (Stage) findRecipesButton.getScene().getWindow();
        stage.close();
    }*/

    public void popupChooseIngredients (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage popUp = fxmlLoader.load();
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.show();
    }

    public void popupStoreIngredient (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/listofingredients.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
