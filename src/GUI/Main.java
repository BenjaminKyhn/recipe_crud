package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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


}