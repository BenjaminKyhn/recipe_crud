package GUI;

import Persistence.DBController;
import Logic.Ingredient;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseIngredientsController implements Initializable{
    ObservableList<Ingredient> list;
    static public ArrayList<Integer> selectedIngredients = new ArrayList<>();

    @FXML
    private Button closeButton;

    @FXML
    public Button showRecipesButton;

    @FXML
    private TableView<Ingredient> TableView;

    @FXML
    private TableColumn<Ingredient, Integer> idColumn;

    @FXML
    private TableColumn<Ingredient, String> nameColumn;

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

    DBController dbController = new DBController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showIngredients();
    }

    public void showIngredients() {
        list = dbController.getIngredientsList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("fat"));
        carbohydratesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("carbohydrates"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,CheckBox>("select"));

        TableView.setItems(list);
    }

    // Method for creating the sql qeury
    public String chooseIngredients(){
        String query = "SELECT DISTINCT r.id, r.name, count(RecipeID) AS count FROM recipes AS r JOIN ingredientamount AS i ON r.id = i.RecipeID where i.IngredientID IN (";

        for (int i = 0; i < selectedIngredients.size(); i++) {
            if(i!=0){
                query=query+",";
            }
            query = query + selectedIngredients.get(i);
        }
        query=query+") GROUP BY RecipeID";
        return query;
    }

    @FXML
    private void closeButton() {
        close();
    }

    public void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void getSelected() {
        for (int i = 0; i < list.size(); i++) {
            if (selectColumn.getCellObservableValue(i).getValue().isSelected()) {
                selectedIngredients.add(i+1);
            }
        }
    }

    public void changeSceneToShowRecipes() throws Exception {
        getSelected();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseRecipe.fxml"));
        Stage showAllRecipes = fxmlLoader.load();
        Stage stage = (Stage) showRecipesButton.getScene().getWindow();
        showAllRecipes.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                selectedIngredients.clear();
            }
        });
        stage.close();
        showAllRecipes.initModality(Modality.APPLICATION_MODAL);
        showAllRecipes.show();

    }
}
