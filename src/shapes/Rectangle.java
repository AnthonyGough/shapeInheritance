package shapes;

public class Rectangle extends Shape2D {

    private double width;
    private double height;

    public Rectangle(Point centre, double width, double height) {
        super(centre);
        this.width = width;
        this.height = heightl
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double value) {
        this.height = value;
    }
    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public boolean containsPoint(Point checkPoint) {
        return checkPoint.getXCord() >= centre.getXCord() - this.width / 2
                && checkPoint.getXCord() <= centre.getXCord() + this.width / 2
                && checkPoint.getYCord() >= centre.getYCord() - this.height / 2
                && checkPoint.getYCord() <= centre.getYCord() + this.height / 2;
    }

    @Override
    public Point[] getVertices() {
        return new Point[] {
                new Point(centre.getXCord() - this.width / 2, centre.getYCord() + this.height / 2),
                new Point(centre.getXCord() + this.width / 2, centre.getYCord() + this.height / 2),
                new Point(centre.getXCord() - this.width / 2, centre.getYCord() - this.height / 2),
                new Point(centre.getXCord() + this.width / 2, centre.getYCord() - this.height / 2)
        };
    }
}
