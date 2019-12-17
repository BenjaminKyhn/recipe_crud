package GUI;

import Persistence.DBController;
import Persistence.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChooseIngredientsController implements Initializable{
    public ObservableList<Ingredient> chosenIngredients = FXCollections.observableArrayList();
    Ingredient chosenIngredient;
    ObservableList<Ingredient> list;
    static public ArrayList<Integer> selected = new ArrayList<>();


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

    // Method for adding chosen ingredients to an arraylist
    public String chooseIngredients(){
//        Ingredient chosenIngredient2 = getIngredientsList().get(0);
//        boolean isSelected = chosenIngredient2.getSelect().isSelected();
//        chosenIngredient = TableView.getSelectionModel().getSelectedItem();
//
//        String qeury = "SELECT r.id, r.name FROM recipes AS r JOIN ingredientamount AS i ON r.id = i.RecipeID WHERE i.IngredientID = " + selected;
        String query = "SELECT DISTINCT r.id, r.name, count(RecipeID) AS count FROM recipes AS r join ingredientamount AS i ON r.id = i.RecipeID where i.IngredientID IN (";

        for (int i = 0; i < selected.size(); i++) {
            if(i!=0){
                query=query+",";
            }
            query = query + selected.get(i);
        }
        query=query+") GROUP BY RecipeID";
        return query;
    }

    @FXML
    private void closeButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void getSelected() {
        for (int i = 0; i < list.size(); i++) {
            if (selectColumn.getCellObservableValue(i).getValue().isSelected()) {
                selected.add(i+1);
            }
        }
    }

    public void changeSceneToShowRecipes() throws Exception {
        getSelected();


//        if (list.get(0).getSelect().isSelected()) {
//            chosenIngredient = list.get(0);
//        }
//            System.out.println(chosenIngredient);
//        chooseIngredients();
        //        chooseIngredients();
//        for (int i = 0; i < TableView.getItems().size(); i++) {
//            if (TableView.getItems().get(i).getSelect())
//                chosenIngredient = TableView.getItems.get(i);
//        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseRecipe.fxml"));
        Stage showRecipe = fxmlLoader.load();
        Stage stage = (Stage) showRecipesButton.getScene().getWindow();
        stage.close();
        showRecipe.initModality(Modality.APPLICATION_MODAL);
        showRecipe.show();

    }
}
