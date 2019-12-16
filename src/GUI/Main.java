package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage root = FXMLLoader.load(getClass().getResource("/GUI/start.fxml"));
        root.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void popupChooseIngredients (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage root = fxmlLoader.load();
        root.show();
    }

    public void popupStoreIngredient (javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/listofingredients.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
