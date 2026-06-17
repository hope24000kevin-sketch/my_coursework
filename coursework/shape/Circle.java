public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) throws InvalidShapeException {
        super();
        setRadius(radius);
    }
    
    public Circle(String color, boolean filled, double radius) throws InvalidShapeException {
        super(color, filled);
        setRadius(radius);
    }
    
    public void setRadius(double radius) throws InvalidShapeException {
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive: " + radius);
        }
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        radius = radius * factor;
    }
    
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }
}
    

