package GUI;

import Persistence.DBController;
import Persistence.Ingredient;
import Persistence.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private TableColumn<CheckBox, Boolean> selectColumn;

    DBController dbController = new DBController();

    public void executeQuery(String query) {
        Connection conn = dbController.getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showRecipes();
    }


    public ObservableList<Recipe> getRecipesList(){
        ChooseIngredientsController chooseIngredientsController = new ChooseIngredientsController();
        ObservableList<Recipe> recipeList = FXCollections.observableArrayList();
        Connection connection = dbController.getConnection();
        String query = "SELECT r.id, r.name FROM recipes AS r JOIN ingredientamount AS i ON r.id = i.RecipeID WHERE i.IngredientID = 1";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Recipe recipe;
            while(rs.next()) {
                recipe = new Recipe(rs.getInt("Id"),rs.getString("Name"));
                recipeList.add(recipe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    public void showRecipes() {
        ObservableList<Recipe> list = getRecipesList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Recipe,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Recipe,String>("name"));

        TableView.setItems(list);
    }

    public void backButton() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/chooseIngredients.fxml"));
        Stage showIngredients = fxmlLoader.load();
        Stage stage = (Stage) showIngredients.getScene().getWindow();
        stage.close();
        showIngredients.initModality(Modality.APPLICATION_MODAL);
        showIngredients.show();


    }
}
