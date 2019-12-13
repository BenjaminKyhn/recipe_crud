package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public Button storeIngredientButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage root = FXMLLoader.load(getClass().getResource("/view/start.fxml"));
        root.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void popupChooseIngredients (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chooseIngredients.fxml"));
        Stage root = fxmlLoader.load();
        root.show();

    }

    public void popupStoreIngredient (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/listofingredients.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

//    Denne metode hører til en fxml, som pt. ikke bruges
//    public void closeStoreIngredientsPopup() {
//        Stage stage = (Stage) storeIngredientButton.getScene().getWindow();
//        stage.close();
//    }
}
