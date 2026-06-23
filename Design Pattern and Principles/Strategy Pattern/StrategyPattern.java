public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        
        // Credit Card Payment Strategy
        PaymentStrategy creditCard =  new CreditCardPayment();
        paymentContext.setPaymentStrategy(creditCard);
        paymentContext.executePayment(5000);

        // PayPal Payment Strategy
        PaymentStrategy paypal = new PayPalPayment();
        paymentContext.setPaymentStrategy(paypal);
        paymentContext.executePayment(3000);

        System.out.println( "\nStrategy Pattern Implemented Successfully");
    }
}
// Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}
// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println( "Paid Rs." + amount +" using Credit Card");
    }
}
// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal" );
    }
}

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy( PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
