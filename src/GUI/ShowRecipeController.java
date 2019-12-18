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
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
        //Insert title of recipe
        titleText.setText(dbController.getRecipeName());

        //Insert ingredients for recipe
        String ingredients = "";
        for (int i = 0; i < dbController.getIngredientsForRecipe().size(); i++) {
            ingredients = ingredients + (dbController.getIngredientsForRecipe().get(i) + "\n");
        }
        ingredientsText.setText(ingredients);

        //Insert step by step guide
        stepByStepText.setText(dbController.getStepByStepForRecipe());
        System.out.println(dbController.getStepByStepForRecipe());

        //Insert an image
        Image image = new Image("https://api.time.com/wp-content/uploads/2019/11/gettyimages-459761948.jpg?quality=85&crop=0px%2C74px%2C1024px%2C536px&resize=1200%2C628&strip");
        recipeImage.setImage(image);

    }
}



