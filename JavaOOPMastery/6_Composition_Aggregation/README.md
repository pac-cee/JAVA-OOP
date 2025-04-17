# Composition & Aggregation in Java

## What are Composition and Aggregation?
- **Composition**: Strong "has-a" relationship. E.g., `Car` has an `Engine`.
- **Aggregation**: Weak "has-a" relationship. E.g., `Team` has `Players`.

## Example
```java
public class Engine {}
public class Car {
    private Engine engine;
    public Car() { engine = new Engine(); } // Composition
}

public class Player {}
public class Team {
    private List<Player> players;
    public Team(List<Player> players) { this.players = players; } // Aggregation
}
```

## Exercise
- Create a `Library` class that contains a list of `Book` objects (aggregation).

Continue to 7_SOLID_Principles after finishing the exercises.
