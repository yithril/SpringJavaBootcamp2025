package org.example.signaturesandwich;

import org.example.Ingredient;
import org.example.Sandwich;
import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SignatureSandwichLoader {
    private final Map<String, Ingredient> ingredientLookup;

    public SignatureSandwichLoader(List<Ingredient> allIngredients) {
        this.ingredientLookup = allIngredients.stream()
                .collect(Collectors.toMap(i -> i.getName().toLowerCase(), i -> i));
    }

    public List<SignatureSandwichDefinition> loadAll() {
        List<SignatureSandwichDefinition> results = new ArrayList<>();
        File file = new File("src/main/resources/signatures/signature_sandwiches.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\|");
                if (parts.length != 3) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }

                String name = parts[0].trim();
                String size = parts[1].trim();
                List<String> ingredients = Arrays.stream(parts[2].split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());

                results.add(new SignatureSandwichDefinition(name, size, ingredients));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading signature sandwiches file", e);
        }

        return results;
    }

    public Sandwich buildSandwich(SignatureSandwichDefinition def) {
        Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder()
                .setSandwichSize(parseSize(def.getSize()))
                .setDisplayName(def.getName());

        for (String ingredientName : def.getIngredients()) {
            Ingredient ingredient = ingredientLookup.get(ingredientName.toLowerCase());
            if (ingredient == null) {
                throw new IllegalArgumentException("Unknown ingredient: " + ingredientName);
            }

            if (ingredient.getIngredientType() == IngredientType.BREAD) {
                builder.setBread(ingredient);
            } else {
                builder.addIngredient(ingredient);
            }
        }

        return builder.build();
    }

    private SandwichSize parseSize(String rawSize) {
        return switch (rawSize.toUpperCase()) {
            case "FOUR_INCH", "SMALL" -> SandwichSize.SMALL;
            case "EIGHT_INCH", "MEDIUM" -> SandwichSize.MEDIUM;
            case "TWELVE_INCH", "LARGE" -> SandwichSize.LARGE;
            default -> throw new IllegalArgumentException("Unknown sandwich size: " + rawSize);
        };
    }
}
