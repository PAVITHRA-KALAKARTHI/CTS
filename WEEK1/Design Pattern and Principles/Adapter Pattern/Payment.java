public class Payment {
    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter(new PayPalGateway());
        paypal.processPayment(5000);

        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(3000);

        System.out.println("Adapter Pattern Implemented Successfully");
    }
}
// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}
// PayPal Gateway (Adaptee)
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through PayPal");
    }
}
// Stripe Gateway (Adaptee)
class StripeGateway {
    public void sendPayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through Stripe");
    }
}
// PayPal Adapter
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}
// Stripe Adapter
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }
    public void processPayment(double amount) {
        stripeGateway.sendPayment(amount);
    }
}
