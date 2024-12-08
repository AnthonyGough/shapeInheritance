package shapes;

public abstract class Shape2D {

    protected  Point centre;
    private double area;
    private double perimeter;

    public Shape2D(Point centre) {
        this.centre = centre;
    }

    public void translate(double xPos, double yPos) {
        centre.translatePoint(xPos, yPos);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean containsPoint(Point checkPoint);

    public abstract Point[] getVertices();
}
