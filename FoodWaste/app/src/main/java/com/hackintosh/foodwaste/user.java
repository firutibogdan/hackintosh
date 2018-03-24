package com.hackintosh.foodwaste;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class user implements java.io.Serializable {
    private List<product> groceries = new LinkedList<>(); // product list

    public void addProduct(product newProduct, double quantity) {
        newProduct.setQuantity(quantity);
        newProduct.setDay(LocalDate.now().getDayOfYear());
        getGroceries().add(newProduct);
    }

    public void updateQuantity(String name, double remainPercent) { //
        for(product it : getGroceries()) {
            if (it.getName().equals(name)) {
                it.setQuantity(it.getQuantity() * remainPercent);
            }
        }
    }

    public List<product> getGroceries() {
        return groceries;
    }

    public void resetList() {
        groceries.clear();
    }

    public void addRecipeToGroceries(recipe r) {
        Boolean found;

        for(product toAdd : r.getIngredients()) {
            found = false;
            for(product inBasket: groceries) {
                if (toAdd.getName().equals(inBasket.getName())) { // acelasi produs
                    if (toAdd.getDay() == (inBasket.getDay())) { // aceeasi zi
                        found = true;
                        inBasket.setQuantity(inBasket.getQuantity() + toAdd.getQuantity());
                    }
                }
            }

            if (!found) {
                addProduct(toAdd, 2);
            }
        }
    }
}