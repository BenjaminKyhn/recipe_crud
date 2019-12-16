package GUI;

import Persistence.Ingredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ChooseIngredientsController implements Initializable{
    @FXML
    private Button closeButton;

    @FXML
    public Button findRecipesButton;

    @FXML
    private javafx.scene.control.TableView<Ingredient> TableView;

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
    private TableColumn<CheckBox, Boolean> selectColumn;

    public void executeQuery(String query) {
        Connection conn = getConnection();
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
        showIngredients();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/idealfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "CodeWarrior8");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Ingredient> getIngredientsList(){
        ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM ingredients";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Ingredient ingredient;
            while(rs.next()) {
                ingredient = new Ingredient(rs.getInt("Id"),rs.getString("Name"),rs.getDouble("Calories"),rs.getDouble("Protein"),rs.getDouble("Fat"),rs.getDouble("Carbohydrates"));
                ingredientsList.add(ingredient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }

    public void showIngredients() {
        ObservableList<Ingredient> list = getIngredientsList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("fat"));
        carbohydratesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("carbohydrates"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<CheckBox, Boolean>("select"));

        TableView.setItems(list);
    }

    public void closePopUpChooseIngredient() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void changeSceneCloseChooseIngredientsPopup() {
        Stage stage = (Stage) findRecipesButton.getScene().getWindow();
        stage.close();
    }
}
