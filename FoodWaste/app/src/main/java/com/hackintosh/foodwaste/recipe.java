package com.hackintosh.foodwaste;


import java.util.LinkedList;
import java.util.List;


public class recipe implements java.io.Serializable {
    private List<product> ingredients = new LinkedList<product>();

    recipe(LinkedList<product> ing) {
        this.setIngredients(ing);
    }

    recipe() {}

    void addIngredient(product p) {
        getIngredients().add(p);
    }

    public List<product> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<product> ingredients) {
        this.ingredients = ingredients;
    }
}
