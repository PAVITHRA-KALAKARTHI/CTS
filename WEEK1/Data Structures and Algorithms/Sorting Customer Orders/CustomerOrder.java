public class CustomerOrder {
    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, "John", 5000),
                new Order(102, "David", 2000),
                new Order(103, "Alice", 8000),
                new Order(104, "Bob", 3000)
        };
        System.out.println("Before Sorting:");
        displayOrders(orders);

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        displayOrders(orders);
        
        Order[] orders2 = {
                new Order(101, "John", 5000),
                new Order(102, "David", 2000),
                new Order(103, "Alice", 8000),
                new Order(104, "Bob", 3000)
        };
        // Quick Sort
        quickSort(orders2,0,orders2.length - 1);
        System.out.println("\nAfter Quick Sort:");
        displayOrders(orders2);
        
        System.out.println("\nTime Complexity Analysis:");

        System.out.println("Bubble Sort: Best O(n), Average O(n^2), Worst 0(n^2)");

        System.out.println("Quick Sort: Best O(n log n), Average O(n log n), Worst O(n^2)");

        System.out.println("Quick Sort is preferred because it is faster for large datasets.");
    }

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        for(int i=0;i<orders.length-1;i++) {
            for(int j=0;j<orders.length-i-1;j++) {
                if(orders[j].totalPrice > orders[j+1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }
    // Quick Sort
    public static void quickSort(
            Order[] orders,
            int low,
            int high
    ) {
        if(low < high) {
            int pi = partition(
                            orders,
                            low,
                            high
                    );
            quickSort(
                    orders,
                    low,
                    pi-1
            );
            quickSort(
                    orders,
                    pi+1,
                    high
            );
        }
    }

    public static int partition(
            Order[] orders,
            int low,
            int high
    ) {
        double pivot = orders[high].totalPrice;
        int i =low-1;
        for(int j=low;j<high;j++) {
            if(orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;
        
        return i+1;
    }

    // Display Orders
    public static void displayOrders(Order[] orders) {
        for(Order order: orders) {
            System.out.println(order);
        }
    }
}
// Order Class
class Order {
    int orderId;
    String customerName;
    double totalPrice;
    public Order(
            int orderId,
            String customerName,
            double totalPrice
    ) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return
                "Order ID="
                + orderId
                + ", Customer="
                + customerName
                + ", Price="
                + totalPrice;
    }
}
