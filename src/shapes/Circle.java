package shapes;

/**
 * Class to represent a circle shape - as this is a circle it does not
 * contain any vertices
 */

public class Circle extends Shape2D {

    private double radius;

    /**
     * Constructor for Circle shape object
     * @param centre The centre of the circle represented as a Point object
     * @param radius The radius of the circle created
     */
    public Circle(Point centre, double radius) {
        super(centre);
        this.radius = radius;
    }

    /**
     * Getter for radius
     * @return radius of circle+
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * Method to calculate the Area of a circle
     * @return Returns the area of the circle object
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius,2);
    }

    /**
     * Method to calculate the Perimeter of a circle
     * @return Returns the area of the circle object
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    /**
     * Method to check if it contains a specific point as determined by
     * calculating the distance from the centre of circle to the point and check
     * if it is less than the radius
     * @param checkPoint Point to determine if is in the circle object
     * @return True if point within circle else false
     */
    @Override
    public boolean containsPoint(Point checkPoint) {
        return this.centre.distanceBetween(checkPoint) <= this.radius;
    }

    /**
     * Method to return the vertices of the shape object - as this is
     * a circle it does not contain any vertices
     * @return Empty array of Point
     */
    @Override
    public Point[] getVertices() {
        return new Point[0];
    }
}
