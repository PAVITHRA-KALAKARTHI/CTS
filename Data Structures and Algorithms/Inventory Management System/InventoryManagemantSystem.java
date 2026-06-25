import java.util.HashMap;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        // Add Products
        inventory.addProduct(
                new Product(
                        101,
                        "Laptop",
                        10,
                        50000
                )
        );
        inventory.addProduct(
                new Product(
                        102,
                        "Mobile",
                        20,
                        25000
                )
        );
        // Display Inventory
        System.out.println("\nInitial Inventory:");
        inventory.display();

        // Update Product
        inventory.updateProduct(
                101,
                15
        );

        System.out.println("\nAfter Update:");
        inventory.display();

        // Delete Product
        inventory.deleteProduct(102);

        System.out.println("\nAfter Delete:");
        inventory.display();

        System.out.println("\nTime Complexity:");

        System.out.println("Add → O(1)");

        System.out.println("Update → O(1)");

        System.out.println("Delete → O(1)");
    }
}

// Product Class
class Product {
    int productId;
    String productName;
    int quantity;
    double price;
    public Product(
            int productId,
            String productName,
            int quantity,
            double price
    ) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String toString() {
        return
                "ID="
                + productId
                + ", Name="
                + productName
                + ", Quantity="
                + quantity
                + ", Price="
                + price;

    }
}
// Inventory Class
class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();
    // Add Product
    public void addProduct(
            Product product
    ) {
        products.put(
                product.productId,
                product
        );
    }

    // Update Product
    public void updateProduct(
            int id,
            int quantity
    ) {
        if(products.containsKey(id)) {
            products.get(id).quantity = quantity;
        }
    }
    // Delete Product
    public void deleteProduct(int id) {
        products.remove(id);
    }
    // Display
    public void display() {
        for(Product p : products.values()) {
            System.out.println(p);
        }
    }
}
