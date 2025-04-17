package exercises.geometry;

public class ShapeClassifier {
    public static String determineTriangleType(double side1, double side2, double side3) {
        if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static String classifyShape(int sides) {
        switch (sides) {
            case 3: return "Triangle";
            case 4: return "Quadrilateral";
            case 5: return "Pentagon";
            case 6: return "Hexagon";
            case 7: return "Heptagon";
            case 8: return "Octagon";
            default: return sides < 3 ? "Not a polygon" : "Polygon with " + sides + " sides";
        }
    }

    public static String getChessPieceMovement(String piece) {
        return switch (piece.toLowerCase()) {
            case "pawn" -> "Moves forward one square at a time, captures diagonally";
            case "rook" -> "Moves horizontally or vertically any number of squares";
            case "knight" -> "Moves in an L-shape: 2 squares in one direction and 1 square perpendicular";
            case "bishop" -> "Moves diagonally any number of squares";
            case "queen" -> "Moves in any direction (horizontal, vertical, or diagonal) any number of squares";
            case "king" -> "Moves one square in any direction";
            default -> "Unknown chess piece";
        };
    }
}
