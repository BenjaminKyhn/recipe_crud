package GUI;

import Persistence.DBController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;


public class ShowRecipeController implements Initializable {

    @FXML
    private Label titleText;

    @FXML
    private Label ingredientsText;

    @FXML
    private Label stepByStepText;

    @FXML
    private ImageView recipeImage;

    @FXML
    private Stage showRecipeStage;

    DBController dbController = new DBController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Insert title for the recipe
        titleText.setText(dbController.getRecipeName());

        //Insert ingredients for the recipe
        String ingredients = "";
        for (int i = 0; i < dbController.getIngredientsForRecipe().size(); i++) {
            ingredients = ingredients + (dbController.getIngredientsForRecipe().get(i) + "\n");
        }
        ingredientsText.setText(ingredients);

        //Insert step by step guide for the recipe
        stepByStepText.setText(dbController.getStepByStepForRecipe());

        //Insert an image for the recipe
        Image image = new Image("https://api.time.com/wp-content/uploads/2019/11/gettyimages-459761948.jpg?quality=85&crop=0px%2C74px%2C1024px%2C536px&resize=1200%2C628&strip");
        recipeImage.setImage(image);
    }
}
