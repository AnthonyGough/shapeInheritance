package shapes;

import java.util.Scanner;

/**
 * Driver class for the program. Do not modify.
 */


public class Main {
    Scanner scanner = new Scanner(System.in);
    UserInput input = new UserInput();
    UserInput.getInstance().nex

    public static void main(String[] args)     {

        System.out.println( "===========================" );

        int numberOfShapes=0;
        do {
            System.out.println( "Enter the number of shapes: " );
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input - please enter a positive number!");
                scanner.next();
            }
            numberOfShapes = scanner.nextInt();
        } while (numberOfShapes <= 0);
        Shape2D[] shapes = ReadShapes(numberOfShapes);

        // Prompt the user to enter the number of points and read them
        Console.WriteLine( "Enter the number of points: " );
        int numberOfPoints = int.Parse( Console.ReadLine() );
        Point2D[] points = ReadPoints(numberOfPoints);

        // Print the shapes and whether they contain the points
        PrintShapesDetails(shapes, points);

        // Translate the shapes
        Console.WriteLine( "Enter the amount to translate the shapes, in the form dx,dy:" );
        string[] translation = Console.ReadLine().Split( ',' );
        double dx = double.Parse( translation[0] );
        double dy = double.Parse( translation[1] );
        foreach (Shape2D shape in shapes)
        {
            shape.Translate( dx, dy );
        }

        // Print the shapes and whether they still contain the points
        PrintShapesDetails(shapes, points);

        Console.WriteLine( "===========================" );
    }

    /// <summary>
    /// Reads the shapes from the console
    /// </summary>
    /// <param name="numberOfShapes">The number of shapes to read</param>
    /// <returns>A list of shapes</returns>
    static Shape2D[] ReadShapes(int numberOfShapes)
    {
        Shape2D[] shapes = new Shape2D[numberOfShapes];

        for (int i = 0; i < numberOfShapes; i++)
        {
            System.out.printf( "Enter the centre of shape %d:", i + 1 );
            Point centre = ReadPoint();
            Console.WriteLine( @"Enter the type of shape {0}:
            {1}. Equilateral Triangle
            {2}. Circle
            {3}. Rectangle
            {4}. Square", i + 1, TRIANGLE, CIRCLE, RECTANGLE, SQUARE );
            Console.WriteLine( "Enter your choice: " );

            // Read the user's choice, and create the corresponding shape
            int choice = int.Parse( Console.ReadLine() );
            switch (choice)
            {
                case TRIANGLE:
                    shapes[i] = ReadEquilateralTriangle(centre);
                    break;
                case CIRCLE:
                    shapes[i] = ReadCircle(centre);
                    break;
                case RECTANGLE:
                    shapes[i] = ReadRectangle(centre);
                    break;
                case SQUARE:
                    shapes[i] = ReadSquare(centre);
                    break;
                default:
                    Console.WriteLine( "Invalid choice" );
                    break;
            }
        }
        return shapes;
    }

    /// <summary>
    /// Prints the details of the shapes and whether they contain the points
    /// </summary>
    /// <param name="shapes">The shapes to print</param>
    /// <param name="points">The points to check for containment</param>
    static void PrintShapesDetails(Shape2D[] shapes, Point2D[] points)
    {
        foreach (Shape2D shape in shapes)
        {
            // Print the shape's name
            Console.WriteLine( "Shape: {0}", shape.GetType().Name );

            // Print whether the shape contains each point
            foreach (Point2D point in points)
            {
                if (shape.ContainsPoint( point ))
                {
                    Console.WriteLine( "\tContains point {0}", point );
                }
            }
            // Print the shape's details
            Console.WriteLine( "Vertices: {0:0.00}", string.Join<Point2D>( ", ", shape.GetVertices() ) );
            Console.WriteLine( "Area: {0:0.00}", shape.Area );
            Console.WriteLine( "Perimeter: {0:0.00}", shape.Perimeter );
        }
    }

    /// <summary>
    /// Read multiple points from the console
    /// </summary>
    /// <param name="numberOfPoints">The number of points to read</param>
    /// <returns>A list of points</returns>
    static Point[] ReadPoints(int numberOfPoints)
    {
        Point[] points = new Point[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++)
        {
            System.out.printf( "Enter point %d:", i + 1 );
            points[i] = ReadPoint();
        }
        return points;
    }

    /// <summary>
    /// Reads a point from the console
    /// </summary>
    /// <returns>The point</returns>
    static Point ReadPoint()
    {
        System.out.println( "Enter the coordinates of the point in the form x,y:" );
        String coOrdinates = scanner.nextLine();
        String[] coordinates = Console.ReadLine().Split( ',' );
        double x = double.Parse( coordinates[0] );
        double y = double.Parse( coordinates[1] );
        return new Point2D(x, y);
    }

    /// <summary>
    /// Reads an equilateral triangle from the console
    /// </summary>
    /// <param name="centre">The centre of the triangle</param>
    /// <returns>The equilateral triangle</returns>
    static EquilateralTriangle ReadEquilateralTriangle(Point2D centre)
    {
        Console.WriteLine( "Enter the side length: " );
        double sideLength = double.Parse( Console.ReadLine() );
        return new EquilateralTriangle( centre, sideLength );
    }

    /// <summary>
    /// Reads a circle from the console
    /// </summary>
    /// <param name="centre">The centre of the circle</param>
    /// <returns>The circle</returns>
    static Circle ReadCircle(Point2D centre)
    {
        Console.WriteLine( "Enter the radius: " );
        double radius = double.Parse( Console.ReadLine() );
        return new Circle( centre, radius );
    }

    /// <summary>
    /// Reads a rectangle from the console
    /// </summary>
    /// <param name="centre">The centre of the rectangle</param>
    /// <returns>The rectangle</returns>
    static Rectangle ReadRectangle(Point2D centre)
    {
        Console.WriteLine( "Enter the width and height, separated by a comma:" );
        string[] dimensions = Console.ReadLine().Split( ',' );
        double width = double.Parse( dimensions[0] );
        double height = double.Parse( dimensions[1] );
        return new Rectangle( centre, width, height );
    }

    /// <summary>
    /// Reads a square from the console
    /// </summary>
    /// <param name="centre">The centre of the square</param>
    /// <returns>The square</returns>
    static Square ReadSquare(Point2D centre)
    {
        Console.WriteLine( "Enter the side length: " );
        double sideLength = double.Parse( Console.ReadLine() );
        return new Square( centre, sideLength );
    }
}
