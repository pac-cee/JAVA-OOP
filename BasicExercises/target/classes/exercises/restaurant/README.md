# Restaurant System Exercises

This package contains exercises focused on restaurant management and order processing in Java.

## Key Concepts Covered
- Menu management
- Price calculations
- Static initialization
- Map data structure usage

## Solutions Overview

### RestaurantSystem.java
- Uses `HashMap` to store menu items and prices
- Static initialization block for menu setup
- Menu items include:
  - Burger ($8.99)
  - Pizza ($12.99)
  - Salad ($6.99)
  - Pasta ($10.99)
  - Drink ($2.99)

- `getPrice(String item)`: Retrieves item price
  - Case-insensitive item lookup
  - Returns 0.0 for non-existent items
  - Uses Map.getOrDefault for safe access

## Best Practices Demonstrated
- Efficient data structure usage
- Static initialization
- Case-insensitive handling
- Default value handling
- Clean code organization
