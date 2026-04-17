import java.util.*;
import java.util.function.*;



class Product {
    String name;
    double price;
    boolean inStock;

    Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String toString() {
        return name + " - $" + price + " - " + (inStock ? "In Stock" : "Out of Stock");
    }
}

public class Filtering {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Phone", 300, true));
        products.add(new Product("Book", 20, true));
        products.add(new Product("Headphones", 45, false));
        products.add(new Product("Mouse", 25, true));
        products.add(new Product("Keyboard", 60, true));

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        products.removeIf(p -> !isAffordable.test(p));

        for (Product p : products) {
            System.out.println(p);
        }
    }
}