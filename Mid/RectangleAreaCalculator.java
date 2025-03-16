package Mid;
import java.util.Scanner;

public class RectangleAreaCalculator {
   
    static class Area {
        private int length;
        private int breadth;
        
        public Area() {
            this.length = 0;
            this.breadth = 0;
        }
        
        public void setDim(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }
    
        public int getArea() {
            return this.length * this.breadth;
        }
      
        public int getLength() {
            return this.length;
        }
        
        public int getBreadth() {
            return this.breadth;
        }
    }
    
    // New run method accepting an external Scanner
    public static void run(Scanner scanner) {
        Area rectangle = new Area();
        System.out.println("Rectangle Area Calculator");
        System.out.println("========================");
        
        boolean validInput = false;
        
        // Continue prompting until valid dimensions are provided.
        while (!validInput) {
            try {
                int length = getValidDimension(scanner, "length", 1, 100);
                int breadth = getValidDimension(scanner, "breadth", 1, 100);
                
                // Ensure breadth is strictly less than length.
                if (breadth >= length) {
                    System.out.println("Error: Breadth must be less than length. Please re-enter both values.");
                    continue;
                }
                
                rectangle.setDim(length, breadth);
                validInput = true;
                
            } catch (Exception e) {
                // In case any unexpected exception occurs.
                System.out.println("Unexpected error: " + e.getMessage());
                scanner.nextLine(); // clear scanner buffer
            }
        }
        
        int area = rectangle.getArea();
        System.out.println("\nRectangle Dimensions:");
        System.out.println("Length: " + rectangle.getLength());
        System.out.println("Breadth: " + rectangle.getBreadth());
        System.out.println("Area: " + area + " square units");
    }
    
    /**
     * Prompt the user to enter a valid dimension.
     * This method loops until the user provides an integer value within the specified range.
     *
     * @param scanner   Scanner instance for reading user input.
     * @param dimension The name of the dimension (e.g., "length" or "breadth").
     * @param min       The minimum allowed value.
     * @param max       The maximum allowed value.
     * @return a valid integer within the specified range.
     */
    private static int getValidDimension(Scanner scanner, String dimension, int min, int max) {
        while (true) {
            System.out.print("Enter the " + dimension + " of the rectangle (" + min + "-" + max + "): ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Error: " + dimension + " must be between " + min + " and " + max + ". Please try again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid integer for " + dimension + ".");
                scanner.next(); // Consume the invalid input
            }
        }
    }
    
    // Optional main method for standalone testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        // Do not close scanner here so System.in remains available for shared use
    }
}
