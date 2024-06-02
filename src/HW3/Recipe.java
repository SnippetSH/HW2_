package HW3;

import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    private String dishName;
    CookingTool cookingTool;
    ArrayList<Ingredient> ingredient;

    public String getDishName() {
        return dishName;
    }



    public Recipe(String dishName, CookingTool cookingTool, ArrayList<Ingredient> ingredient) {
        this.dishName = dishName;
        this.cookingTool = cookingTool;
        this.ingredient = ingredient;
    }

    public String stringify() {
        StringBuilder s = new StringBuilder();
        s.append(cookingTool.getName());

        int cnt = ingredient.size();
        for(Ingredient it : ingredient) {
            s.append(it.getter());
            if(cnt != 1) {
                s.append(',');
            }
            cnt--;
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
        int cookingToolValue;

        try {
            cookingToolValue = Integer.parseInt(toolInt);
            if(!dish.matches("^[a-zA-Z]*$")) {
                throw new InvalidRecipeFileException("An Error Occurred: Invalid Dish name.");
            }
            if(Objects.equals(tool, "Oven")) {
                if(cookingToolValue != 100 && cookingToolValue != 150 && cookingToolValue != 200 && cookingToolValue != 250) {
                    throw new InvalidRecipeFileException("An Error Occurred: Invalid Oven Temperature.");
                }
            } else if(Objects.equals(tool, "FryingPan") || Objects.equals(tool, "Pot")) {
                if(cookingToolValue > 3 || cookingToolValue < 1) {
                    throw new InvalidRecipeFileException("An Error Occurred: Invalid " + tool + " Intensity");
                }
            } else {
                throw new InvalidRecipeFileException("An Error Occurred: Invalid Cooking Tool.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidRecipeFileException("An Error Occurred: Integer cannot be parseable");
        }

        CookingTool Tool = switch (tool) {
            case "FryingPan" -> new FryingPan(cookingToolValue);
            case "Pot" -> new Pot(cookingToolValue);
            case "Oven" -> new Oven(cookingToolValue);
            default -> throw new InvalidRecipeFileException("An Error Occurred: Invalid Cooking Tool Name.");
        };

        ArrayList<Ingredient> ingredients1 = new ArrayList<>();
        for(String it : ingredients) {
            if(!it.matches("^[a-zA-Z]*$")) {
                throw new InvalidRecipeFileException("An Error Occurred: Invalid Ingredient name.");
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
