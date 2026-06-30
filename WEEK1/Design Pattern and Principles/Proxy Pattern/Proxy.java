public class Proxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        // Image loads first time
        System.out.println("First call:");
        image1.display();
        // Image loaded from cache
        System.out.println("\nSecond call:");
        image1.display();
        
        Image image2 = new ProxyImage("photo2.jpg");
        System.out.println("\nAnother Image:");
        image2.display();

        System.out.println("\nProxy Pattern Implemented Successfully");
    }
}
// Subject Interface
interface Image {
    void display();
}
// Real Subject Class
class RealImage implements Image {
    private String fileName;
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }
    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server");
    }
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
// Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;
    
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    public void display() {
        // Lazy initialization
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        // Cached object reused
        realImage.display();
    }
}
