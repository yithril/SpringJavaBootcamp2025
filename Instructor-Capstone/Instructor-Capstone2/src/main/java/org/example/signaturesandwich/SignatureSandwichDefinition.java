package org.example.signaturesandwich;

import java.util.List;

public class SignatureSandwichDefinition {
    private String name;
    private String size;
    private List<String> ingredients;

    public SignatureSandwichDefinition(String name, String size, List<String> ingredients) {
        this.name = name;
        this.size = size;
        this.ingredients = ingredients;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public List<String> getIngredients() { return ingredients; }
}
