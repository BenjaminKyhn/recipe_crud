package GUI;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

//GUI.. popup window with users inserted Ingredients
public class StartController {
    public void popupChooseIngredients (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage popUp = fxmlLoader.load();
        popUp.initModality(Modality.APPLICATION_MODAL); // Freezes stage behind the window
        popUp.show();
    }
//GUI popup window with list of ingredients that allows user to insert/remove ingredients
    public void popupListOfIngredients(javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/listofingredients.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
