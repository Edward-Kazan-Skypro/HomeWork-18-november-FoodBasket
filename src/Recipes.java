import java.util.HashSet;

public class Recipes {

    //private static HashMap<String, HashSet<Product>> recipesBook = new HashMap<>();
    private static HashSet<Product> productsSetForRecipe = new HashSet<>();
    private double priceAllProducts;
    private String nameRecipes;

    private static HashSet<Recipes> recipesSet = new HashSet<>();

    public Recipes(String nameRecipes, HashSet<Product> productsSetForRecipe) {
        this.nameRecipes = nameRecipes;
        getProductsSetForRecipe().addAll(productsSetForRecipe);
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

    public static void addProductsToRecipes(Product product) {
        productsSetForRecipe.add(product);
    }

    public static double getPriceAllProductsInRecipe(Recipes recipe) {
        double price = 0;
        for (Product r : productsSetForRecipe) {
            price += r.getPrice();
        }
        return price;
    }

    public static HashSet<Product> getProductsSetForRecipe() {
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
        Recipes recipes = (Recipes) o;
        return Double.compare(recipes.priceAllProducts, priceAllProducts) == 0 && getNameRecipes().equals(recipes.getNameRecipes());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime + prime * getNameRecipes().length() + prime * getProductsSetForRecipe().size();
        //return Objects.hash(priceAllProducts, getNameRecipes());
    }
}
