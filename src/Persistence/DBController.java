package Persistence;

import GUI.ChooseIngredientsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBController {

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/idealfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "CodeWarrior8");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Ingredient> getIngredientsList() {
        ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM ingredients";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Ingredient ingredient;
            while (rs.next()) {
                ingredient = new Ingredient(rs.getInt("Id"), rs.getString("Name"), rs.getDouble("Calories"), rs.getDouble("Protein"), rs.getDouble("Fat"), rs.getDouble("Carbohydrates"));
                ingredientsList.add(ingredient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }

    public ObservableList<Recipe> getRecipesList() {
        ChooseIngredientsController chooseIngredientsController = new ChooseIngredientsController();
        ObservableList<Recipe> recipeList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = chooseIngredientsController.chooseIngredients();
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Recipe recipe;
            while (rs.next()) {
                if (rs.getInt("count") == GUI.ChooseIngredientsController.selected.size()) {
                    recipe = new Recipe(rs.getInt("Id"), rs.getString("Name"));
                    recipeList.add(recipe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    public void executeQuery(String query) {
        DBController dbController = new DBController();
        Connection conn = dbController.getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showChosenRecipe() {
        DBController dbController = new DBController();
        String stepByStepGuide = "";
        Connection connection = getConnection();
        String query = "SELECT howto FROM recipes WHERE id = 1";

       dbController.executeQuery(query);
    }
}