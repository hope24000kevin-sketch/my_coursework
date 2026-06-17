public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle(double side1, double side2, double side3) throws InvalidShapeException {
        super();
        setSides(side1, side2, side3);
    }
    
    public Triangle(String color, boolean filled, double side1, double side2, double side3) throws InvalidShapeException {
        super(color, filled);
        setSides(side1, side2, side3);
    }
    
    public void setSides(double side1, double side2, double side3) throws InvalidShapeException {
        // Check all sides are positive
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new InvalidShapeException("All sides must be positive: " + side1 + ", " + side2 + ", " + side3);
        }
        
        // Check triangle inequality theorem
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new InvalidShapeException("Invalid triangle: sides " + side1 + ", " + side2 + ", " + side3 + 
                                           " violate triangle inequality theorem");
        }
        
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }
    
    public double getArea() {
        // Heron's formula: Area = sqrt(s(s-a)(s-b)(s-c))
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        side1 = side1 * factor;
        side2 = side2 * factor;
        side3 = side3 * factor;
    }
    
    public String toString() {
        return "Triangle[sides=" + side1 + ", " + side2 + ", " + side3 + 
               ", color=" + color + ", filled=" + filled + "]";
    }
}
