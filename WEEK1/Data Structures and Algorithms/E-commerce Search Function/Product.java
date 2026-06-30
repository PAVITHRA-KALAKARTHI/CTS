import java.util.Arrays;
import java.util.Comparator;

public class Product {

    int productId;
    String productName;
    String category;


    // Constructor
    public Product(int productId, String productName, String category) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }


    // Display product
    public void display() {

        System.out.println(
            "Product ID: " + productId +
            ", Name: " + productName +
            ", Category: " + category
        );
    }



    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for(Product product : products) {

            if(product.productId == id) {
                return product;
            }
        }

        return null;
    }



    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;


        while(left <= right) {

            int mid = (left + right) / 2;


            if(products[mid].productId == id) {

                return products[mid];
            }

            else if(products[mid].productId < id) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        return null;
    }



    // Main method
    public static void main(String[] args) {


        Product[] products = {

            new Product(103,"Laptop","Electronics"),
            new Product(101,"Shoes","Fashion"),
            new Product(105,"Mobile","Electronics"),
            new Product(102,"Watch","Accessories"),
            new Product(104,"Book","Education")

        };


        System.out.println("Linear Search Result:");

        Product result1 = linearSearch(products,105);


        if(result1 != null)
            result1.display();

        else
            System.out.println("Product not found");



        // Sorting before Binary Search

        Arrays.sort(
            products,
            Comparator.comparingInt(p -> p.productId)
        );


        System.out.println("\nBinary Search Result:");

        Product result2 = binarySearch(products,105);


        if(result2 != null)
            result2.display();

        else
            System.out.println("Product not found");



        System.out.println("\nAnalysis:");

        System.out.println(
            "Linear Search: Best O(1), Average O(n), Worst O(n)"
        );

        System.out.println(
            "Binary Search: Best O(1), Average O(log n), Worst O(log n)"
        );

        System.out.println(
            "Binary Search is more suitable for large e-commerce platforms."
        );

    }

}
