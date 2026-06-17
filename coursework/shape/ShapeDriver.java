public class ShapeDriver {
    
    public static void main(String[] args) {
        System.out.println("=== SHAPE DEMONSTRATION ===\n");
        
        // Create an array of shapes (polymorphism)
        Shape[] shapes = new Shape[3];
        
        try {
            // Create valid shapes
            System.out.println("Creating shapes...");
            shapes[0] = new Circle("red", true, 5.0);
            shapes[1] = new Rectangle("blue", false, 4.0, 6.0);
            shapes[2] = new Triangle("green", true, 3.0, 4.0, 5.0);
            
            System.out.println("All shapes created successfully!\n");
            
            // Demonstrate toString()
            System.out.println("=== SHAPE DETAILS ===");
            for (int i = 0; i < shapes.length; i++) {
                System.out.println("Shape " + (i+1) + ": " + shapes[i]);
            }
            
            // Demonstrate printAreas()
            System.out.println("\n=== AREAS (Dynamic Binding) ===");
            printAreas(shapes);
            
            // Demonstrate largest()
            System.out.println("\n=== LARGEST SHAPE ===");
            Shape largestShape = largest(shapes);
            System.out.println("Shape with largest area: " + largestShape);
            System.out.println("Area: " + largestShape.getArea());
            
            // Demonstrate resize
            System.out.println("\n=== RESIZE DEMONSTRATION ===");
            System.out.println("Resizing Circle by factor 2...");
            shapes[0].resize(2.0);
            System.out.println("New Circle: " + shapes[0]);
            System.out.println("New Area: " + shapes[0].getArea());
            
        
            // DEMONSTRATE EXCEPTION HANDLING
            
            System.out.println("\n=== EXCEPTION HANDLING DEMONSTRATION ===");
            System.out.println("Attempting to create invalid triangle (1, 2, 5)...");
            
            try {
                // This will throw an exception (violates triangle inequality)
                Triangle invalidTriangle = new Triangle("yellow", false, 1.0, 2.0, 5.0);
                System.out.println("Triangle created: " + invalidTriangle);
            } catch (InvalidShapeException e) {
                System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
            }
            
            // Demonstrate invalid resize factor
            System.out.println("\nAttempting to resize with negative factor (-1)...");
            try {
                shapes[0].resize(-1.0);
                System.out.println("Resize successful!");
            } catch (InvalidShapeException e) {
                System.out.println("CAUGHT EXCEPTION: " + e.getMessage());
            }
            
        } catch (InvalidShapeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
    
    /**
     * Prints the area of each shape using polymorphism
     * Dynamic binding ensures the correct getArea() method is called
     */
    public static void printAreas(Shape[] shapes) {
        for (int i = 0; i < shapes.length; i++) {
            String className = shapes[i].getClass().getSimpleName();
            System.out.println(className + " area: " + shapes[i].getArea());
        }
    }
    
    /**
     * Finds the shape with the largest area
     */
    public static Shape largest(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            return null;
        }
        
        Shape largest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        return largest;
    }
}
