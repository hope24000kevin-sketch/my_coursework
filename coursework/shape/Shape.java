public abstract class Shape {
    protected String color = "white";
    protected boolean filled;
    
    public Shape() { }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor) throws InvalidShapeException;
    
    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}