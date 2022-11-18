public class Main {


    public static void main(String[] args) {

        //Создадим продукты
        Product product_1 = new Product("Бананы", 3.67, 2);
        Product product_2 = new Product("Хлеб", 0.2, 0.5);
        Product product_3 = new Product("Молоко", 0.8, 1);
        Product product_4 = new Product("Апельсины", 2.13, 1.2);

        //Добавим product_1 в список продуктов
        Product.addProductToSet(product_1);
        //Отметим product_1 для покупки (при создании продукта эта отметка false)
        Product.markProductForBuy(product_1);
        //Удалим product_1 из списка
        Product.deleteProductFromSet(product_1);
        //Посмотрим наш список покупок
        Product.viewAllProductInSet();
        //Добавим в список другой продукт - product_4
        Product.addProductToSet(product_4);
        //Посмотрим наш список покупок
        Product.viewAllProductInSet();
        System.out.println("------------------------------------------------------------------");
        //Раздел - Рецепты
        //Добавим ранее созданные продукты для рецепта в список
        Recipes.addProductsToRecipes(product_1);
        Recipes.addProductsToRecipes(product_4);
        //Создаем рецепт Салата из бананов и апельсинов
        //В качестве аргументов - название салата и список продуктов
        // (список продуктов не совпадает со списком из класса Product).
        Recipes recipe_1 = new Recipes("Салат из бананов и апельсинов", Recipes.getProductsSetForRecipe());
        //Добавим этот рецепт в список рецептов
        Recipes.addRecipes(recipe_1);
        //Посчитаем стоимость продуктов в этом рецепте
        System.out.println("Продукты в этом рецепте стоят " + Recipes.getPriceAllProductsInRecipe(recipe_1) + " руб.");
        System.out.println("------------------------------------------------------------------");
        //Создадим еще один рецепт - с другим названием, но с теми же продуктами
        Recipes recipe_2 = new Recipes("Салат из апельсинов и бананов", Recipes.getProductsSetForRecipe());
        //Добавим его в список рецептов
        Recipes.addRecipes(recipe_2);
        System.out.println("------------------------------------------------------------------");
        //Посмотрим наш список рецептов
        Recipes.viewAllRecipes();
        System.out.println("------------------------------------------------------------------");
        //Создадим еще один рецепт - с другим названием, как у recipe_1
        Recipes recipe_3 = new Recipes("Салат из бананов и апельсинов", Recipes.getProductsSetForRecipe());
        Recipes.addRecipes(recipe_3);









    }
}