import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Recipes {

    private HashMap<Product, Double> costProductsInRecipe = new HashMap<>();
    private HashSet<Product> productsSetForRecipe = new HashSet<>();
    private String nameRecipes;

    private static HashSet<Recipes> recipesSet = new HashSet<>();

    public Recipes(String nameRecipes, HashSet<Product> productsSetForRecipe) {
        this.nameRecipes = nameRecipes;
        getProductsSetForRecipe().addAll(productsSetForRecipe);
    }

    public Recipes(String nameRecipes){
        this.nameRecipes = nameRecipes;
    }


    public static void addRecipes(Recipes recipe) {
        if (recipesSet.isEmpty()) {
            getRecipesSet().add(recipe);
            System.out.println("Рецепт " + recipe.getNameRecipes() + " добавлен в список рецептов.");
            return;
        }
        for (Recipes r : getRecipesSet()) {
            System.out.println("в списке " + getRecipesSet().size() + " рецепт(-а)");
            System.out.println("Добавляем рецепт " + recipe.getNameRecipes());
            if (!recipe.getNameRecipes().equals(r.getNameRecipes())) {
                getRecipesSet().add(recipe);
                System.out.println("Рецепт " + recipe.getNameRecipes() + " добавлен в список рецептов.");
                return;
            } else {
                throw new RuntimeException("Рецепт с таким названием уже есть в списке рецептов.");
            }
        }
    }

    public void addProductsToRecipes(Product product) {
        productsSetForRecipe.add(product);
        double cost = product.getPrice() * product.getAmount();
        if (cost < 1) cost = 1;
        costProductsInRecipe.put(product, cost);
    }

    public void viewDetailCostProducts (){
        System.out.println("Рецепт " + getNameRecipes() + " , стоимость входящих в него продуктов:");
        for (Map.Entry<Product, Double> p : costProductsInRecipe.entrySet()) {
            System.out.println("Продукт - " + p.getKey().getName() + ", стоимость = " + p.getValue() + " руб.");
        }
    }

    public double getCostAllProductsInRecipe() {
        double price = 0;
        for (Product r : productsSetForRecipe) {
            price += r.getPrice() * r.getAmount();
        }
        return price;
    }

    public HashSet<Product> getProductsSetForRecipe() {
        return productsSetForRecipe;
    }

    public String getNameRecipes() {
        return nameRecipes;
    }

    public static HashSet<Recipes> getRecipesSet() {
        return recipesSet;
    }

    public static void viewAllRecipes() {
        for (Recipes r : recipesSet) {
            System.out.println(r);
        }
    }

    @Override
    public String toString() {
        return "Рецепт - " + nameRecipes +
                ", состав продуктов:\n" + getProductsSetForRecipe();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipes)) return false;
        Recipes r = (Recipes) o;
        HashSet<Product> set = new HashSet<>();
       // set = (Recipes) o.
        return getNameRecipes().equals(r.getNameRecipes()) && productsSetForRecipe.equals(getProductsSetForRecipe());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime + prime * getNameRecipes().length() + prime * getProductsSetForRecipe().size();
    }
}
