public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) throws InvalidShapeException {
        super();
        setWidth(width);
        setHeight(height);
    }
    
    public Rectangle(String color, boolean filled, double width, double height) throws InvalidShapeException {
        super(color, filled);
        setWidth(width);
        setHeight(height);
    }
    
    public void setWidth(double width) throws InvalidShapeException {
        if (width <= 0) {
            throw new InvalidShapeException("Width must be positive: " + width);
        }
        this.width = width;
    }
    
    public void setHeight(double height) throws InvalidShapeException {
        if (height <= 0) {
            throw new InvalidShapeException("Height must be positive: " + height);
        }
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        width = width * factor;
        height = height * factor;
    }
    
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + ", color=" + color + ", filled=" + filled + "]";
    }
}
