public class Logger {
    private static Logger instance;
    // Private constructor
    private Logger() {
        System.out.println("Logger instance created");
    }
    // Method to get single instance
    public static Logger getInstance() {

        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    // Log method
    public void log(String message) {
        System.out.println("Log Message: " + message);
    }
    public static void main(String[] args) {
        // First Logger instance
        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");
        // Second Logger instance
        Logger logger2 = Logger.getInstance();
        logger2.log("User Logged In");
        // Checking both references
        if (logger1 == logger2) {
            System.out.println("Singleton Verified: Both objects are SAME instance");
        } 
        else {
            System.out.println("Singleton Failed: Different instances created");
        }
    }
}
