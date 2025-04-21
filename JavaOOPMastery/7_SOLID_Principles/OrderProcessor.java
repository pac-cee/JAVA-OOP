// Initial (non-SOLID) OrderProcessor for refactoring
import java.util.*;

public class OrderProcessor {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void processOrders() {
        for (Order o : orders) {
            System.out.println("Processing: " + o);
            // Imagine more logic here (e.g., payment, notification)
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.addOrder(new Order("Book", 2));
        processor.addOrder(new Order("Pen", 10));
        processor.processOrders();
    }
}
