package shapes;

/**
 * Class to represent an Equilateral Triangle shape - contains 3 sides of equal length and
 * contains 3 vertices
 */

public class EquilateralTriangle extends Shape2D {

    private double sideLength;
    private static final int NUMBER_OF_SIDES = 3;

    /**
     * Constructor for Equilateral Triangle  shape object
     * @param centre The centre of the Equilateral Triangle represented as a Point object
     * @param sideLength The length of each side (all same as quilateral)
     */
    public EquilateralTriangle(Point centre, double sideLength) {
        super(centre);
        this.sideLength = sideLength;
    }

    /**
     * Calculates the area of an Equilateral Triangle  shape object
     * @return area of Equilateral Triangle  shape object
     */
    @Override
    public double getArea() {
        return Math.sqrt(3)/4 * Math.pow(sideLength,2);
    }

    /**
     * Calculates the Perimeter of an Equilateral Triangle  shape object
     * @return Perimeter of Equilateral Triangle  shape object
     */
    @Override
    public double getPerimeter() {
        return NUMBER_OF_SIDES*sideLength;
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
        double[] pointDifference = calculatePointDiff(checkPoint);
        return (pointDifference[1] <= (Math.sqrt(3) * (pointDifference[1]+this.sideLength/3))) &&
                (pointDifference[1]<= -(Math.sqrt(3) + (pointDifference[0]-this.sideLength/3))) &&
                (pointDifference[1] >= -(Math.sqrt(3)/6 * sideLength));
    }

    private double[] calculatePointDiff(Point point) {
        double[] pointDiff = new double[2];
        pointDiff[0] = this.centre.getXCord()-point.getXCord();
        pointDiff[1] = this.centre.getYCord()-point.getYCord();
        return pointDiff;
    }

    @Override
    public Point[] getVertices() {
        Point[] vertices = new Point[3];
        vertices[0] = new Point(this.centre.getXCord(), this.centre.getYCord());
        vertices[1] = new Point(this.centre.getXCord()- this.sideLength/2,
                this.centre.getYCord()-Math.sqrt(3)/6*this.sideLength);
        vertices[2] = new Point(this.centre.getXCord()+ this.sideLength/2,
                this.centre.getYCord()-Math.sqrt(3)/6*this.sideLength);
        return  vertices;
    }
}
