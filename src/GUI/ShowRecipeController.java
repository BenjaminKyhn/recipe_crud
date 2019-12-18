package GUI;

import Persistence.DBController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
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
