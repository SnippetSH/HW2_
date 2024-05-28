package HW3;

import javax.crypto.spec.OAEPParameterSpec;
import java.io.*;
import java.util.InputMismatchException;
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
            System.out.printf("%s : %s(%d),", it.dishName, it.cookingTool, it.cookingTool.getValue());
            for(Ingredient dish : it.ingredient) {
                System.out.printf(" %s,", dish.getter());
            }
            System.out.println();
        }
    }

    private void loadRecipe(Scanner sc) throws IOException, InvalidRecipeFileException{
        System.out.println("Enter file path to load recipes:");
        String filePath = sc.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                Recipe recipe = Recipe.parse(line);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            throw new IOException("[IOException]\n");
        } catch (InvalidRecipeFileException e) {
            throw new InvalidRecipeFileException(e.getMessage());
        }
    }

    private void saveRecipe(Scanner sc) throws IOException{
        System.out.println("Enter file path to save recipes:");
        String filePath = sc.nextLine();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for(Recipe it : recipes) {
                bw.write(it.stringify());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException("[IOException]\n");
        }
    }

    private void addRecipe(Scanner sc) {
        System.out.println("Enter the name of the dish (only alphabetic characters are allowed):\n");
        String dishName = sc.nextLine();
        try {
            if(!dishName.matches("^[a-zA-Z]*$")) {
                throw new InputMismatchException("An Error Occurred: The dish name has non-alphabet characters.\n");
            }
        } catch (InputMismatchException e) {
            return;
        }

        System.out.println("Select the type of cooking tool (1. FryingPan, 2. Pot, 3. Oven):\n");
        int n = sc.nextInt();
        CookingTool c = null;
        try {
            if(n < 1 || n > 3) {
                throw new InputMismatchException("An Error Occurred: Invalid input.\n");
            }

            switch (n) {
                case 1:
                    System.out.println("Enter intensity level (1 to 3) for the Frying Pan:\n");
                    c = new FryingPan();
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                case 2:
                    System.out.println("Enter intensity level (1 to 3) for the Pot:\n");
                    c = new Pot();
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                case 3:
                    System.out.println("Enter temperature for the Oven (100, 150, 200 or 250 degrees):");
                    c = new Oven();
                    c.setup(sc);
                    if(c.getValue() == 0) {
                        c = null;
                    }
                    break;
                default:
                    break;
            }
        } catch (InputMismatchException e) {
            return;
        }

        if(c == null) {
            return;
        }

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        try {
            System.out.println("Enter ingredient names separated byu commas (only alphabetic characters):");
            String s = sc.nextLine();
            String[] p = s.split(",");
            for (String it : p) {
                if (!it.matches("^[a-zA-Z]*$")) {
                    throw new InputMismatchException("An Error Occurred: An ingredient name has non-alphabet characters.\n");
                }
                Ingredient i = new Ingredient(it);
                ingredients.add(i);
            }
        } catch (InputMismatchException e) {
            return;
        }

        Recipe recipe = new Recipe(dishName, c, ingredients);
        recipes.add(recipe);
    }

    private void cook(Scanner sc) {
        System.out.println("Select the type of cooking tool (1. Frying Pan, 2. Pot, 3. Oven):\n");
        int n = sc.nextInt();
        if(n < 1 || n > 3) {
            System.out.println("Please input valid index\n");
            return;
        }

        int value = 0;
        switch (n) {
            case 1:
                System.out.println("Enter intensity for the Frying Pan\n");
                value = sc.nextInt();
                if(value < 1 || value > 3) {
                    System.out.println("Please input valid index\n");
                    return;
                }
            case 2:
                System.out.println("Enter intensity for the Pot\n");
                value = sc.nextInt();
                if(value < 1 || value > 3) {
                    System.out.println("Please input valid index\n");
                    return;
                }
            case 3:
                System.out.println("Enter temperature for the Oven (100, 150, 200 or 250 degrees):");
                value = sc.nextInt();
                if(value != 100 && value != 150 && value != 200 && value != 250) {
                    System.out.println("Please input valid input\n");
                    return;
                }
            default:
                break;
        }

        System.out.println("Enter ingredient names separated by commas (only alphabetic characters):");
        String names = sc.nextLine();
        String[] p = names.split(",");
        for (String it : p) {
            if (!it.matches("^[a-zA-Z]*$")) {
                System.out.println("Please input valid input\n");
                return;
            }
        }

        for(Recipe it : recipes) {
            if(it.isValidRecipe(n, value, p)) {
                System.out.printf("The dish [%s] has been cooked!", it.dishName);
                break;
            }
        }
    }

    public void simulate() throws InvalidRecipeFileException, IOException {
        Scanner sc = new Scanner(System.in);

        boolean Exit = true;
        while(Exit) {
            System.out.print("Select an action: ");

            for(int i = 0; i < prompt.length; i++) {
                System.out.printf("%d. %s,", i, prompt[i]);
            }

            int ch = sc.nextInt();
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

                case 6:
                    Exit = false;
                    break;
                default:
                    System.out.println("Please Input Valid Index");
                    break;
            }
        }
    }
}
