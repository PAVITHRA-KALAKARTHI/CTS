public class Main {
    public static void main(String[] args) {
        double initialValue = 10000;
        double growthRate = 0.10;
        int years = 5;
        double futureValue =
                calculateFutureValue(
                        initialValue,
                        growthRate,
                        years
                );
        System.out.println(
                "Initial Value: Rs."
                + initialValue
        );
        System.out.println(
                "Growth Rate: "
                + (growthRate * 100)
                + "%"
        );
        System.out.println(
                "Years: "
                + years
        );
        System.out.println(
                "Predicted Future Value: Rs."
                + futureValue
        );
        System.out.println("\nTime Complexity Analysis:");
        System.out.println( "Recursive Algorithm: O(n)");
        System.out.println("Optimization: Use memoization or iterative approach to reduce repeated calculations.");
    }
    // Recursive method for forecasting
    public static double calculateFutureValue(
            double value,
            double rate,
            int years
    ) {
        // Base condition
        if(years == 0) {
            return value;
        }
        // Recursive calculation
        return calculateFutureValue( value * (1 + rate), rate, years - 1);
    }
}
