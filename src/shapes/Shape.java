package shapes;

public enum Shape {
    TRIANGLE(1), CIRCLE(2), RECTANGLE(3), SQUARE(4);

    private int value;

    private Shape(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
