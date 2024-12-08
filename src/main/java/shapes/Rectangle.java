package shapes;

public class Rectangle extends Shape2D {

    private double width;
    private double length;

    public Rectangle(Point centre, double width, double length) {
        super(centre);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double value) {
        this.length = value;
    }
    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public boolean containsPoint(Point checkPoint) {
        return checkPoint.getXCord() >= centre.getXCord() - this.width / 2
                && checkPoint.getXCord() <= centre.getXCord() + this.width / 2
                && checkPoint.getYCord() >= centre.getYCord() - this.length / 2
                && checkPoint.getYCord() <= centre.getYCord() + this.length / 2;
    }

    @Override
    public Point[] getVertices() {
        return new Point[] {
                new Point(centre.getXCord() - this.width / 2, centre.getYCord() + this.length / 2),
                new Point(centre.getXCord() + this.width / 2, centre.getYCord() + this.length / 2),
                new Point(centre.getXCord() - this.width / 2, centre.getYCord() - this.length / 2),
                new Point(centre.getXCord() + this.width / 2, centre.getYCord() - this.length / 2)
        };
    }
}
