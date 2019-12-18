package GUI;

import Persistence.DBController;
import Persistence.Recipe;
import com.mysql.cj.protocol.a.TextRowFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowRecipeController implements Initializable{

    @FXML
    private Label titleText;

    @FXML
    private Label ingredientsText;

    @FXML
    private Label stepByStepText;

    DBController dbController = new DBController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleText.setText(dbController.getRecipeName());
        String ingredients = "";
        for(int i = 0; i < dbController.getIngredientsForRecipe().size(); i++) {
            ingredients = ingredients + (dbController.getIngredientsForRecipe().get(i)+"\n");
        }
        ingredientsText.setText(ingredients);
        stepByStepText.setText(dbController.getStepByStepForRecipe());
        System.out.println(dbController.getStepByStepForRecipe());
    }
}
