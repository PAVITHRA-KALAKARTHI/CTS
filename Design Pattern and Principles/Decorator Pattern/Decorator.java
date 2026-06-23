// Decorator Pattern Example
public class Decorator {
    public static void main(String[] args) {
        // Basic Email Notification
        Notifier notifier = new EmailNotifier();
        System.out.println("Email Notification:");
        notifier.send();
        // Adding SMS functionality dynamically
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        System.out.println("\nEmail + SMS Notification:");
        smsNotifier.send();
        // Adding Slack functionality dynamically
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        System.out.println("\nEmail + SMS + Slack Notification:");
        slackNotifier.send();
        System.out.println("\nDecorator Pattern Implemented Successfully");
    }
}
// Component Interface
interface Notifier {
    void send();
}
// Concrete Component
class EmailNotifier implements Notifier {
    public void send() {
        System.out.println("Sending Email Notification");
    }
}
// Abstract Decorator Class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    public void send() {
        notifier.send();
    }
}
// SMS Decorator
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        super.send();
        System.out.println("Sending SMS Notification");
    }
}
// Slack Decorator
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    public void send() {
        super.send();
        System.out.println("Sending Slack Notification");
    }
}
