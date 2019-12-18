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
import java.util.ArrayList;
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

    public int chooseRecipe(){
        return selectedRecipe.getId();
    }

    public void clickedColumn (MouseEvent event){
        TablePosition tablePosition = TableView.getSelectionModel().getSelectedCells().get(0);
        int row = tablePosition.getRow();
        Recipe item=TableView.getItems().get(row);
//        TableColumn tableColumn = tablePosition.getTableColumn();
//        Object data = tableColumn.getCellObservableValue(item).getValue();
        selectedRecipe = item;
        System.out.println(chooseRecipe());
    }

    public void backButton() throws Exception {
        back();
    }

    public void back() throws IOException {
        ChooseIngredientsController.selectedIngredients.clear();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage showIngredients = fxmlLoader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        showIngredients.initModality(Modality.APPLICATION_MODAL);
        showIngredients.show();

    }

    public void changeSceneToShowRecipe () throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/showRecipe.fxml"));
        Stage stage = fxmlLoader.load();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
