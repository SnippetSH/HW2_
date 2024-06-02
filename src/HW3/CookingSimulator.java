package HW3;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class CookingSimulator {
    ArrayList<Recipe> recipes;
    String[] prompt = {"View Recipes",
            "Load Recipes",
            "Save Recipes",
            "Add Recipes",
            "Cook",
            "Exit"
    };

    public CookingSimulator() {
        recipes = new ArrayList<>();
    }

    private void viewRecipe() {
        for(Recipe it : recipes) {
            System.out.printf("%s : %s(%d),", it.getDishName(), it.cookingTool, it.cookingTool.getValue());
            for(Ingredient dish : it.ingredient) {
                System.out.printf(" %s,", dish.getter());
            }
            System.out.println();
        }
    }

    private boolean isValidAdd(Recipe recipe) {
        for(Recipe it : recipes) {
            if(Objects.equals(it.getDishName(), recipe.getDishName())) {
                if(it.cookingTool.getClass() == recipe.cookingTool.getClass()) {
                    if(it.cookingTool.getValue() == it.cookingTool.getValue()) {
                        int cnt = recipe.ingredient.size();
                        for(Ingredient i : it.ingredient) {
                            for(Ingredient j : recipe.ingredient) {
                                if(Objects.equals(i.getter(), j.getter())) {
                                    cnt--;
                                }
                            }
                        }
                        if(cnt == 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void loadRecipe(Scanner sc) throws IOException, InvalidRecipeFileException{
        System.out.println("Enter file path to load recipes:");
        String filePath = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            recipes.clear();
            String line;
            while((line = br.readLine()) != null) {
                Recipe recipe = Recipe.parse(line);
                recipes.add(recipe);
            }
            System.out.println("Recipes loaded successfully.");
        } catch (IOException e) {
            throw new IOException("[IOException]");
        } catch (InvalidRecipeFileException e) {
            throw new InvalidRecipeFileException(e.getMessage());
        }
    }

    private void saveRecipe(Scanner sc){
        System.out.println("Enter file path to save recipes:");
        String filePath = sc.nextLine();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for(Recipe it : recipes) {
                bw.write(it.stringify());
                bw.newLine();
            }
            System.out.println("Recipes saved successfully.");
        } catch (IOException e) {
            System.out.println("[IOException]");
        }
    }

    private void addRecipe(Scanner sc) {
        System.out.println("Enter the name of the dish (only alphabetic characters are allowed):");
        String dishName = sc.nextLine();
        try {
            if(!dishName.matches("^[a-zA-Z]*$")) {
                throw new InputMismatchException("An Error Occurred: The dish name has non-alphabet characters.");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Select the type of cooking tool (1. FryingPan, 2. Pot, 3. Oven):");
        int n = sc.nextInt();
        CookingTool c = null;
        try {
            if(n < 1 || n > 3) {
                throw new InputMismatchException("An Error Occurred: Invalid input.");
            }

            switch (n) {
                case 1:
                    System.out.println("Enter intensity level (1 to 3) for the Frying Pan:");
                    c = new FryingPan(0);
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                case 2:
                    System.out.println("Enter intensity level (1 to 3) for the Pot:");
                    c = new Pot(0);
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                case 3:
                    System.out.println("Enter temperature for the Oven (100, 150, 200 or 250 degrees):");
                    c = new Oven(0);
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return;
        }

        if(c == null) {
            return;
        }

        sc.nextLine();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        try {
            System.out.println("Enter ingredient names separated by commas (only alphabetic characters):");
            String s = sc.nextLine();
            String[] p = s.split(",");
            for (String it : p) {
                if (!it.matches("^[a-zA-Z]*$")) {
                    throw new InputMismatchException("An Error Occurred: An ingredient name has non-alphabet characters.");
                }
                Ingredient i = new Ingredient(it);
                ingredients.add(i);
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return;
        }

        Recipe recipe = new Recipe(dishName, c, ingredients);
        if(isValidAdd(recipe)) {
            recipes.add(recipe);
            System.out.println("Recipe added successfully.");
        } else {
            System.out.printf("%s already exists in Recipe list.\n", dishName);
        }

    }

    private void cook(Scanner sc) {
        System.out.println("Select the type of cooking tool (1. Frying Pan, 2. Pot, 3. Oven):");
        int n = sc.nextInt();
        if(n < 1 || n > 3) {
            System.out.println("Please input valid index");
            return;
        }

        int value = 0;
        switch (n) {
            case 1:
                System.out.println("Enter intensity for the Frying Pan");
                value = sc.nextInt();
                if(value < 1 || value > 3) {
                    System.out.println("Please input valid input");
                    return;
                }
                break;
            case 2:
                System.out.println("Enter intensity for the Pot");
                value = sc.nextInt();
                if(value < 1 || value > 3) {
                    System.out.println("Please input valid input");
                    return;
                }
                break;
            case 3:
                System.out.println("Enter temperature for the Oven (100, 150, 200 or 250 degrees):");
                value = sc.nextInt();
                if(value != 100 && value != 150 && value != 200 && value != 250) {
                    System.out.println("Please input valid input");
                    return;
                }
                break;
            default:
                break;
        }

        sc.nextLine();
        System.out.println("Enter ingredient names separated by commas (only alphabetic characters):");
        String names = sc.nextLine();
        String[] p = names.split(",");
        for (String it : p) {
            if (!it.matches("^[a-zA-Z]*$")) {
                System.out.println("Please input valid input");
                return;
            }
        }

        boolean isValid = false;
        for(Recipe it : recipes) {
            if(it.isValidRecipe(n, value, p)) {
                System.out.printf("The dish [%s] has been cooked!\n", it.getDishName());
                isValid = true;
                break;
            }
        }
        if(!isValid) {
            System.out.println("Cooking failed. (You can only make dishes that exist in the recipes.)");
        }
    }

    public void simulate() {
        Scanner sc = new Scanner(System.in);

        boolean Exit = true;
        while(Exit) {
            try {
                System.out.print("Select an action: ");

                System.out.printf("%d. %s", 1, prompt[0]);
                for (int i = 1; i < prompt.length; i++) {
                    System.out.printf(", %d. %s", i + 1, prompt[i]);
                }
                System.out.println();

                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch) {
                    case 1:
                        viewRecipe();
                        break;
                    case 2:
                        loadRecipe(sc);
                        break;
                    case 3:
                        saveRecipe(sc);
                        break;
                    case 4:
                        addRecipe(sc);
                        break;
                    case 5:
                        cook(sc);
                        break;
                    case 6:
                        Exit = false;
                        break;
                    default:
                        System.out.println("Please Input Valid Index");
                        break;
                }
            } catch (InvalidRecipeFileException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
