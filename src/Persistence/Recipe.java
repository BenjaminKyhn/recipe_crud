package Persistence;

import java.util.ArrayList;

public class Recipe {
    int id;
    String name;
    ArrayList<Ingredient> ingredients;
    ArrayList<Double> portionSize;
    int portionCount = 1;

    public Recipe(){}

    public Recipe(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Recipe(int id, String name, ArrayList<Ingredient> ingredients){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Double> getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(ArrayList<Double> portionSize) {
        this.portionSize = portionSize;
    }

    public int getPortionCount() {
        return portionCount;
    }

    public void setPortionCount(int portionCount) {
        this.portionCount = portionCount;
    }
}
