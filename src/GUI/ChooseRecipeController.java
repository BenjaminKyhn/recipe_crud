package GUI;

import Persistence.DBController;
import Persistence.Ingredient;
import Persistence.Recipe;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseRecipeController implements Initializable {

    @FXML
    private javafx.scene.control.TableView<Recipe> TableView;

    @FXML
    private TableColumn<Recipe, Integer> idColumn;

    @FXML
    private TableColumn<Recipe, String> nameColumn;

    @FXML
    private TableColumn<Ingredient, Double> caloriesColumn;

    @FXML
    private TableColumn<Ingredient, Double> proteinColumn;

    @FXML
    private TableColumn<Ingredient, Double> fatColumn;

    @FXML
    private TableColumn<Ingredient, Double> carbohydratesColumn;

    @FXML
    private TableColumn<Ingredient, CheckBox> selectColumn;

    @FXML
    private Button backButton;

    @FXML
    private Button showRecipeButton;

    DBController dbController = new DBController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showRecipes();
    }

    public void showRecipes() {
        ObservableList<Recipe> list = dbController.getRecipesList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Recipe, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Recipe, String>("name"));

        TableView.setItems(list);
    }

    public void backButton() throws Exception {
        ChooseIngredientsController.selected.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage showIngredients = fxmlLoader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        showIngredients.initModality(Modality.APPLICATION_MODAL);
        showIngredients.show();
    }

   // public void changeSceneToShowRecipe() throws Exception {

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/showRecipe.fxml"));
//        AnchorPane showRecipe = fxmlLoader.load();
//        Stage stage = (Stage) showRecipeButton.getScene().getWindow();
//        stage.close();
//        showRecipe.initModality(Modality.APPLICATION_MODAL);
//        showRecipe.show();
//
//  }

    public void changeSceneToShowRecipe () throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/showRecipe.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
}
