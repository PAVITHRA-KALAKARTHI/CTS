import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        // Register observers
        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);
        // Change stock price
        stockMarket.setStockPrice(2500);
        // Remove one observer
        stockMarket.deregisterObserver(web);
        stockMarket.setStockPrice(3000);
        System.out.println("\nObserver Pattern Implemented Successfully");
    }
}
// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}
// Observer Interface
interface Observer {
    void update(double price);
}
// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        System.out.println("\nStock Price Updated: " + stockPrice);
        notifyObservers();
    }
}

// Mobile Application Observer
class MobileApp implements Observer {
    public void update(double price) {
        System.out.println(
            "Mobile App Notification: Stock price is "
            + price
        );
    }
}
// Web Application Observer
class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App Notification: Stock price is " + price);
    }
}
