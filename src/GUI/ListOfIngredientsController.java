package GUI;

import Persistence.DBController;
import Logic.Ingredient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ListOfIngredientsController implements Initializable {

    DBController dbController = new DBController();


    @FXML
    private Button closeButton;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField caloriesField;

    @FXML
    private TextField proteinField;

    @FXML
    private TextField fatField;

    @FXML
    private TextField carbohydratesField;

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
    private void insertButton() {
        insert();
        showIngredients();
    }

    public void insert() {
        String query = "insert into ingredients values("+idField.getText()+",'"+nameField.getText()+"','"+caloriesField.getText()+"',"+proteinField.getText()+","+fatField.getText()+","+carbohydratesField.getText()+")";
        executeQuery(query);
    }

    @FXML
    private void closeButton() {
        close();
    }

    private void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void deleteButton() {
        delete();
        showIngredients();
    }

    private void delete() {
        String query = "DELETE FROM ingredients WHERE ID="+idField.getText()+"";
        executeQuery(query);
    }


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
        showIngredients();
    }

    public void showIngredients() {
        ObservableList<Ingredient> list = dbController.getIngredientsList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("fat"));
        carbohydratesColumn.setCellValueFactory(new PropertyValueFactory<Ingredient,Double>("carbohydrates"));

        TableView.setItems(list);
    }
}
