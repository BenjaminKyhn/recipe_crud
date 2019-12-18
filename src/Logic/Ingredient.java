package Logic;

import javafx.scene.control.CheckBox;

public class Ingredient {
    private int id;
    private String name = "";
    private String unit = "g";
    private double amount = 100.0;
    private double calories = 0.0;
    private double protein = 0.0;
    private double fat = 0.0;
    private double carbohydrates = 0.0;
    private CheckBox select;

    public Ingredient(int id, String name, double calories, double protein, double fat, double carbohydrates) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.select = new CheckBox();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getAmount() {
        return amount;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public CheckBox getSelect() {
        return select;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}