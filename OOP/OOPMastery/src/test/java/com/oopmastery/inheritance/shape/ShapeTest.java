package com.oopmastery.inheritance.shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class demonstrating how to test inheritance hierarchies.
 * Shows:
 * 1. Testing abstract classes through concrete implementations
 * 2. Testing inherited behavior
 * 3. Testing overridden methods
 * 4. Testing type-specific behavior
 */
public class ShapeTest {

    @Test
    void testCircleCreation() {
        Circle circle = new Circle(5.0, "Red", true);
        
        assertEquals(5.0, circle.getRadius());
        assertEquals("Red", circle.getColor());
        assertTrue(circle.isFilled());
        assertEquals("Circle", circle.getType());
    }

    @Test
    void testCircleCalculations() {
        Circle circle = new Circle(2.0, "Blue", false);
        
        assertEquals(Math.PI * 4.0, circle.getArea(), 0.001);
        assertEquals(Math.PI * 4.0, circle.getPerimeter(), 0.001);
        assertEquals(4.0, circle.getDiameter());
    }

    @Test
    void testRectangleCreation() {
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Green", true);
        
        assertEquals(4.0, rectangle.getWidth());
        assertEquals(6.0, rectangle.getHeight());
        assertEquals("Green", rectangle.getColor());
        assertTrue(rectangle.isFilled());
        assertEquals("Rectangle", rectangle.getType());
    }

    @Test
    void testRectangleCalculations() {
        Rectangle rectangle = new Rectangle(3.0, 4.0, "Yellow", false);
        
        assertEquals(12.0, rectangle.getArea());
        assertEquals(14.0, rectangle.getPerimeter());
        assertFalse(rectangle.isSquare());
    }

    @Test
    void testSquareRectangle() {
        Rectangle square = new Rectangle(5.0, 5.0, "Purple", true);
        assertTrue(square.isSquare());
    }

    @Test
    void testInvalidDimensions() {
        // Test circle with negative radius
        assertThrows(IllegalArgumentException.class, () -> {
            new Circle(-1.0, "Red", true);
        });

        // Test rectangle with zero width
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(0.0, 5.0, "Blue", false);
        });

        // Test rectangle with negative height
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(5.0, -1.0, "Green", true);
        });
    }

    @Test
    void testPolymorphicBehavior() {
        // Create shapes using parent type
        Shape circle = new Circle(3.0, "Red", true);
        Shape rectangle = new Rectangle(4.0, 3.0, "Blue", false);

        // Test that each shape calculates its area correctly
        assertEquals(Math.PI * 9.0, circle.getArea(), 0.001);
        assertEquals(12.0, rectangle.getArea());

        // Test that each shape calculates its perimeter correctly
        assertEquals(Math.PI * 6.0, circle.getPerimeter(), 0.001);
        assertEquals(14.0, rectangle.getPerimeter());

        // Test that toString includes type information
        assertTrue(circle.toString().contains("Circle"));
        assertTrue(rectangle.toString().contains("Rectangle"));
    }

    @Test
    void testShapeModification() {
        Circle circle = new Circle(5.0, "Red", true);
        
        // Test color modification
        circle.setColor("Blue");
        assertEquals("Blue", circle.getColor());

        // Test fill modification
        circle.setFilled(false);
        assertFalse(circle.isFilled());

        // Test radius modification
        circle.setRadius(7.0);
        assertEquals(7.0, circle.getRadius());
    }
} 