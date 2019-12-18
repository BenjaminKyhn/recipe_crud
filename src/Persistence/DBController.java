package Persistence;

import GUI.ChooseIngredientsController;
import GUI.ChooseRecipeController;
import Logic.Ingredient;
import Logic.Recipe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DBController {

    //Method for establishing connection to the database
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

    //Method for creating a list of ingredients
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

    //Method for creating a list of recipes
    public ObservableList<Recipe> getRecipesList() {
        ChooseIngredientsController chooseIngredientsController = new ChooseIngredientsController();
        ObservableList<Recipe> recipeList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = chooseIngredientsController.matchIngredientsToRecipes();
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Recipe recipe;
            while (rs.next()) {
                if (rs.getInt("count") == GUI.ChooseIngredientsController.selectedIngredients.size()) {
                    recipe = new Recipe(rs.getInt("Id"), rs.getString("Name"));
                    recipeList.add(recipe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    //Method for returning the name of a recipe
    public String getRecipeName() {
        ChooseRecipeController chooseRecipeController = new ChooseRecipeController();
        String recipeName = "";
        Connection connection = getConnection();
        String query = "SELECT name FROM recipes WHERE ID=" + chooseRecipeController.chooseRecipe();
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

    //Method for returning the ingredients for a recipe
    public ArrayList<String> getIngredientsForRecipe() {
        ChooseRecipeController chooseRecipeController = new ChooseRecipeController();
        ArrayList<String> ingredientsList = new ArrayList<>();
        Connection connection = getConnection();
        String query = "SELECT name FROM ingredients JOIN ingredientamount ON ingredientamount.IngredientID = ingredients.id WHERE RecipeID=" + chooseRecipeController.chooseRecipe();
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                ingredientsList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientsList;
    }

    //Method for returning the step by step guide to a recipe
    public String getStepByStepForRecipe() {
        ChooseRecipeController chooseRecipeController = new ChooseRecipeController();
        String stepByStep = "";
        Connection connection = getConnection();
        String query = "SELECT howto FROM recipes WHERE recipes.id="+ chooseRecipeController.chooseRecipe();
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                stepByStep = rs.getString("howto");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stepByStep;
    }

    //Method for returning the URL for the image of a recipe
    public String getUrlForRecipe() {
        ChooseRecipeController chooseRecipeController = new ChooseRecipeController();
        String recipeImageUrl = "";
        Connection connection = getConnection();
        String query = "SELECT images FROM recipes WHERE ID=" + chooseRecipeController.chooseRecipe();
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()){
                recipeImageUrl = rs.getString("images");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipeImageUrl;
    }
}
