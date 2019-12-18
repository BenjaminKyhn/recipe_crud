package Persistence;

import GUI.ChooseIngredientsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

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
                ingredient = new Ingredient(rs.getInt("Id"), rs.getString("Name"), rs.getDouble("Calories"), rs.getDouble("Protein"), rs.getDouble("Fat"), rs.getDouble("carbohydrates"));
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

    public String getRecipeName() {
        String recipeName = "";
        Connection connection = getConnection();
        String query = "SELECT name FROM recipes WHERE ID=1";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()){
                recipeName = rs.getString("Name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeName;
    }

    public ArrayList<String> getIngredientsForRecipe() {
        ArrayList<String> ingredientsList = new ArrayList<>();
        Connection connection = getConnection();
        String query = "SELECT IngredientID FROM ingredientamount WHERE RecipeID=1";
        String query2 = "SELECT name FROM ingredients JOIN ingredientamount ON ingredientamount.IngredientID = ingredients.id WHERE RecipeID=1";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query2);
            while (rs.next()) {
                ingredientsList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }
}
