package HW3;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    String dishName;
    CookingTool cookingTool;
    ArrayList<Ingredient> ingredient;

    public Recipe(String dishName, CookingTool cookingTool, ArrayList<Ingredient> ingredient) {
        this.dishName = dishName;
        this.cookingTool = cookingTool;
        this.ingredient = ingredient;
    }

    public String stringify() {
        StringBuilder s = new StringBuilder();
        s.append(cookingTool.getName());
        for(Ingredient it : ingredient) {
            s.append(it.getter()).append(",");
        }
        s.append("|").append(dishName);

        return s.toString();
    }

    public static Recipe parse(String recipe) throws InvalidRecipeFileException {
        String[] par = recipe.split("\\|");
        if(par.length != 4) {
            throw new InvalidRecipeFileException("An Error Occurred:");
        }

        String tool = par[0];
        String toolInt = par[1];
        String[] ingredients = par[2].split(",");
        String dish = par[3];

        CookingTool Tool = switch (tool) {
            case "FryingPan" -> new FryingPan();
            case "Pot" -> new Pot();
            case "Oven" -> new Oven();
            default -> throw new InvalidRecipeFileException("An Error Occurred: Invalid Cooking Tool Name.\n");
        };

        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        for(String it : ingredients) {
            if(!it.matches("^[a-zA-Z]*$")) {
                throw new InvalidRecipeFileException("An Error Occurred: Invalid Ingredient name.\n");
            }
            ingredients1.add(new Ingredient(it));
        }

        return new Recipe(dish, Tool, ingredients1);
    }

    public boolean isValidRecipe(int cookingToolNum, int value, String[] names) {
        boolean f, s, t;
        f = s = t =false;

        switch (cookingToolNum) {
            case 1:
                if(cookingTool instanceof FryingPan) {
                    f = true;
                }
                break;
            case 2:
                if(cookingTool instanceof Pot) {
                    f = true;
                }
                break;
            case 3:
                if(cookingTool instanceof Oven) {
                    f = true;
                }
                break;
            default:
                break;
        }

        if(value == cookingTool.getValue()) {
            s = true;
        }

        int cnt = 0;
        for(String name : names) {
            boolean ck = false;
            for(Ingredient it : ingredient) {
                if(Objects.equals(name, it.getter())) {
                    ck = true;
                    break;
                }
            }
            if(ck) cnt++;
        }
        if(cnt == names.length) t = true;

        return f && s && t;
    }
}
