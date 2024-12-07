package shapes;

import java.awt.*;
import java.util.Scanner;


/**
 * Driver class for the program. Do not modify.
 */


public class Main {

    private final static String SHAPE_NUMBER = "Enter the number of shapes to create -> ";
    private final static String NUMBER_OF_POINTS = "Enter the number of points to create -> ";
    private final static String CENTRE_OF_SHAPE = "Enter the centre of shape %d -> ";
    private final static String POINT_ENTRY_NARRATION =  "Enter the coordinates of the point in the form x,y -> ";
    private final static String SHAPE_TYPE_NARRATION = "Select the type of shape to create from the following options:\n%s";
    private final static String SHAPE_MENU = "1. Equilateral Triangle\n2. Circle\n3. Rectangle\n4. Square\n\nSelection (1,2,3,4) -> ";
    private final static String TRIANGLE_SIDE = "Enter the side length of the Equilateral Triangle -> ";
    private final static String CIRCLE_RADIUS = "Enter the radius of the circle -> ";
    private final static String SQUARE_SIDE = "Enter the length of the Square side -> ";
    private final static String RECTANGLE_LENGTH = "Enter the length of the Rectangle -> ";
    private final static String RECTANGLE_WIDTH = "Enter the width of the Rectangle -> ";
    private final static String POINT_NUMBER = "Enter the number of points (Maximum of 5 points to check) -> ";
    private final static int NUMBER_OF_POINTS_TO_CHECK = 5;
    private final static String SPECIFIC_POINT_ENTRY_NARRATION =  "Enter the coordinates of point %d in the form x,y -> ";
    private final static String TRANSLATE_SHAPES = "Enter the amount to translate the shapes, in the form dx,dy -> ";
    private final static int TRIANGLE = 1;
    private final static int CIRCLE = 2;
    private final static int RECTANGLE = 3;
    private final static int SQUARE = 4;



    public static void main(String[] args)     {

        System.out.println( "===========================" );

        int numberOfShapes=askIntegerInput(SHAPE_NUMBER,0, Integer.MAX_VALUE);
        Shape2D[] shapes = readShapes(numberOfShapes);

        int numberOfPoints = askIntegerInput(POINT_NUMBER,1,NUMBER_OF_POINTS_TO_CHECK);
        Point[] points = readPoints(numberOfPoints);

        // Print the shapes and whether they contain the points
        printShapesDetails(shapes, points);

        // Translate the shapes
        translateShapes(shapes, points);

        // Print the shapes and whether they still contain the points
        printShapesDetails(shapes, points);

        System.out.println( "===========================" );
    }

    /**
     * Method to invoke translation for each of the shape objects
     * @param shapes Array of all shapes
     * @param points Array of points to check
     */
    public static void translateShapes(Shape2D[] shapes, Point[] points) {
        System.out.print(TRANSLATE_SHAPES);
        Point translate = readPoint(TRANSLATE_SHAPES);
        for (Shape2D shape : shapes) {
            shape.translate(translate.getXCord(), translate.getYCord());
        }
        printShapesDetails(shapes, points);
    }



    /**
     * Method to get dimensions/required parameters of th
     * @param numberOfShapes Number of shapes to be created
     * @return Array of shapes
     */
    static Shape2D[] readShapes(int numberOfShapes)
    {

        Shape2D[] shapes = new Shape2D[numberOfShapes];

        for (int i = 0; i < numberOfShapes; i++)
        {
            String narration = String.format(CENTRE_OF_SHAPE, i+1);

            Point centre = readPoint(narration);

            String concat_narration = String.format(SHAPE_TYPE_NARRATION,SHAPE_MENU);
            int choice = askIntegerInput(concat_narration,0,5);

            switch (choice)
            {
                case TRIANGLE:
                    shapes[i] = readEquilateralTriangle(centre);
                    break;
                case CIRCLE:
                    shapes[i] = readCircle(centre);
                    break;
                case RECTANGLE:
                    shapes[i] = readRectangle(centre);
                    break;
                case SQUARE:
                    shapes[i] = readSquare(centre);
                    break;
                default:
                    System.out.println( "Invalid choice" );
                    break;
            }
        }
        return shapes;
    }


    /**
     * Method for getting input as an double - validated input plus given range of acceptable values
     * @param narration Prompt for the user instructing what input required
     * @param lowerLimit Lowest acceptable value
     * @param upperLimit Highest acceptable value
     * @return The double entered by user in console
     */
    public static double askDoubleInput(String narration, double lowerLimit, double upperLimit) {
        boolean valid = false;
        double num =0;
        while (!valid) {
            System.out.println(narration);

            try {
                num = UserInput.nextDouble();
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input - please enter an integer\n");
            }
        }
        return num;
    }

    /**
     * Method for getting input as an integer - validated input plus given range of acceptable values
     * @param narration Prompt for the user instructing what input required
     * @param lowerLimit Lowest acceptable value
     * @param upperLimit Highest acceptable value
     * @return The integer entered by user in console
     */
    public static int askIntegerInput(String narration, int lowerLimit, int upperLimit) {
        boolean valid = false;
        int num =0;
        while (!valid) {
            System.out.print( narration );
            try {
                num = UserInput.nextInt();
                if ((num<=lowerLimit) || (num>=upperLimit)) {
                    System.out.printf("Invalid input - enter a number greater than %d and less than %d\n", lowerLimit, upperLimit);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input - please enter an integer\n");
            }
        }
        return num;
    }

     /**
     * Prints the details of the shapes and whether they contain the points
     * @param shapes The shapes to print
     * @param points The points to check if contained in the shape object
     */
    static void printShapesDetails(Shape2D[] shapes, Point[] points)
    {
        int count = 1;
        for (Shape2D shape : shapes)
        {

            System.out.printf( "Shape %d is %s",count, shape.getClass() );

            // Print whether the shape contains each point
            for (Point point : points)
            {
                if (shape.containsPoint( point ))
                {
                    System.out.printf( "%s contains the point %.2f , %.2f ", shape.getClass(), point.getXCord(), point.getYCord());
                }
            }
            // Print the shape's details
            if (!(shape instanceof Circle)) {
                Point[] vert = shape.getVertices();
                for (int i=0; i < vert.length; i++) {
                    System.out.printf("Vertices %d is %.2f , %.2f", i+1, vert[i].getXCord(), vert[i].getYCord());
                }
            } else {
                System.out.println("Shape is Circle and has no vertices");
            }
            System.out.printf( "Area: %.2f", shape.getArea() );
            System.out.printf( "Perimeter: %.2f", shape.getPerimeter() );
        }
    }


    /**
     * Reads a number of points from the user as input in the console in the form of x,y
     * (x coordinate, y coordinate)
     * @param numberOfPoints Number of times the method will call helper function to take
     *                       inputs from user from console in the form of x,y on Cartesian Plane
     * @return Array of Point objects representing the x,y coordinates entered by user
     */
    static Point[] readPoints                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   (int numberOfPoints)
    {
        Point[] points = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++)
        {
           String narration = String.format(SPECIFIC_POINT_ENTRY_NARRATION, i);
            points[i] = readPoint(narration);
        }
        return points;
    }


    /**
     * Reads a point as input from user in form of x,y (x coordinate, y coordinate)
     * @param narration is the prompt to the user as to type of input type/format required
     * @return Point object representing point on Cartesian plane
     */
    static Point readPoint(String narration)
    {
        double x=0,y=0;
        boolean valid = false;
        while (!valid) {
            System.out.println( narration );
            String input = UserInput.nextLine();
            String regex=",";
            String[] coordinates = input.split( regex,2 );
            if (coordinates.length!=2) {
                System.out.println("Invalid input - please enter point in form x,y e.g. 2.4, 6.5\n");
            } else {
                try {
                    x = Double.parseDouble( coordinates[0] );
                    y = Double.parseDouble( coordinates[1] );
                    if ((x <=0) || (y<=0)) {
                        System.out.println("Invalid input - points entered must be in positive cartesian plane (not less than zero\n");
                    } else {
                        valid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format - please enter a number (int or decimal");
                }
            }

        }

        return new Point(x, y);
    }

    /**
     * Method gathers required data to create Equilateral Triangle object
     * @param centre which is the centre of the triangle
     * @return Equilateral Triangle object
     */
    static EquilateralTriangle readEquilateralTriangle(Point centre)
    {
        double side = askDoubleInput(TRIANGLE_SIDE, 1, Double.MAX_VALUE);

        return new EquilateralTriangle( centre, side );
    }

    /**
     * Method gathers required data for a Circle object
     * @param centre of the circle
     * @return Circle object
     */
    static Circle readCircle(Point centre)
    {
        double radius = askDoubleInput(CIRCLE_RADIUS, 1, Double.MAX_VALUE);

        return new Circle( centre, radius );
    }

    /**
     * Method gathers required data to create a Rectangle object
     * @param centre of the Rectable
     * @return Rectangle object
     */
    static Rectangle readRectangle(Point centre)
    {
        double width = askDoubleInput(RECTANGLE_WIDTH, 1, Double.MAX_VALUE);
        double length = askDoubleInput(RECTANGLE_LENGTH, 1, Double.MAX_VALUE);

        return new Rectangle( centre, width, length );
    }

    /**
     * Method gathers required data to create a Square object
     * @param centre of the Square
     * @return Square object
     */
    static Square readSquare(Point centre)
    {
        double length = askDoubleInput(SQUARE_SIDE, 1, Double.MAX_VALUE);

        return new Square( centre, length );
    }
}
