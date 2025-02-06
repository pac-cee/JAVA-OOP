package exercises.restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantSystem {
    private static final Map<String, Double> menuItems = new HashMap<>();
    
    static {
        menuItems.put("burger", 8.99);
        menuItems.put("pizza", 12.99);
        menuItems.put("salad", 6.99);
        menuItems.put("pasta", 10.99);
        menuItems.put("drink", 2.99);
    }
    
    public static double getPrice(String item) {
        return menuItems.getOrDefault(item.toLowerCase(), 0.0);
    }
}
