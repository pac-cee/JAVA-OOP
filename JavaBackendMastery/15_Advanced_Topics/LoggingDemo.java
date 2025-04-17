// Demonstrates logging in Java using SLF4J
// Requires SLF4J and Logback dependencies
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);
    public static void main(String[] args) {
        logger.info("App started");
        logger.warn("This is a warning");
        logger.error("This is an error message");
    }
}
