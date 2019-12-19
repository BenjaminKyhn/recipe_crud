package GUI;

import Persistence.DBController;
import Logic.Ingredient;
import Logic.Recipe;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseRecipeController implements Initializable {
    public static Recipe selectedRecipe = new Recipe();

    @FXML
    private javafx.scene.control.TableView<Recipe> TableView;

    @FXML
    private TableColumn<Recipe, Integer> idColumn;

    @FXML
    private TableColumn<Recipe, String> nameColumn;

    @FXML
    private Button backButton;

    DBController dbController = new DBController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showRecipes();
    }

    //Method for showing the recipes, by matching the chosen Ingredients
    public void showRecipes() {
        ObservableList<Recipe> list = dbController.getRecipesList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Recipe, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Recipe, String>("name"));

        TableView.setItems(list);
    }

    //Method for returning the ID of the selected recipe
    public int chooseRecipe() {
        return selectedRecipe.getId();
    }

    //Method that returns the users selected recipe
    public void clickedColumn(MouseEvent event) {
        TablePosition tablePosition = TableView.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        Recipe item = TableView.getItems().get(row);
        selectedRecipe = item;
    }

    //Method for the back button
    public void backButton() throws Exception {
        back();
    }

    //Method for changing stage to previous stage
    public void back() throws IOException {
        ChooseIngredientsController.selectedIngredients.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage showIngredients = fxmlLoader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        showIngredients.initModality(Modality.APPLICATION_MODAL);
        showIngredients.show();

    }

    //Method for changing scene to showRecipe
    public void changeSceneToShowRecipe() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/showRecipe.fxml"));
        Stage stage = fxmlLoader.load();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
