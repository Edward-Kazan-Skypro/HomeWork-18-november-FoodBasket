import java.util.HashSet;
public class Product {

    private String name;
    private double price;
    private double amount;

    private boolean markForBuy;

    private static HashSet<Product> productsSet = new HashSet<>();

    public Product(String name, double price, double amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        if ((this.name.length()==0 || this.name.isBlank() || this.name.isEmpty() || this.name == null)
        || (this.price < 0)
        || (this.amount < 0)) {
            throw new RuntimeException("Заполните карточку товара полностью");
        }
    }

    public static void markProductForBuy (Product product){
        if (!productsSet.contains(product)) {
            System.out.print("Продукт " + product.getName() + " нет в списке покупок. ");
            System.out.println("Добавьте этот продукт в список!");
            return;
        }
        for (Product p: productsSet){
            if (p.isMarkForBuy()){
                System.out.println("Продукта " + product.getName() + " уже был отмечен для покупки.");
            } else {
                p.setMarkForBuy(true);
                System.out.println("Продукт " + product.getName() + " отмечен для покупки.");
                return;
            }
        }
    }

    public static void deleteAllBuyedProducts(){
        for (Product p: productsSet){
            if (p.isMarkForBuy()) {
                productsSet.remove(p);
            }
        }
    }

    public static void viewAllProductInSet(){
        if (productsSet.isEmpty()) {
            System.out.println("Список покупок пуст.");
        } else {
            System.out.println("Список покупок:");
            for (Product p: productsSet){
                System.out.println(p);
            }
        }
    }

    public static void deleteProductFromSet(Product product){
        if (productsSet.contains(product)) productsSet.remove(product);
    }
    public static void addProductToSet(Product product){
        if (productsSet.add(product)){
            System.out.println("Продукт " + product.getName() + " добавлен в список покупок.");
        } else {
            throw new RuntimeException("Продукт уже был добавлен в список покупок.");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isMarkForBuy() {
        return markForBuy;
    }

    public void setMarkForBuy(boolean markForBuy) {
        this.markForBuy = markForBuy;
    }

    @Override
    public String toString() {
        return "Продукт: " + name +
                ", цена за килограмм = " + price + " руб." +
                ", количество = " + amount + " кг." +
                ", продукт куплен? " + markForBuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 && Double.compare(product.getAmount(), getAmount()) == 0 && getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return (int) (prime + prime * getName().length() + prime * getPrice() + prime * getAmount());
        // Objects.hash(getName(), getPrice(), getAmount());
    }
}
