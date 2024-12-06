package shapes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Point point = new Point(3,3);
        Point point2 = new Point(6,7);
        double dis = point.distanceBetween(point2);
        System.out.println(point.toString());
        System.out.println(point2.toString());
        System.out.println("Double: " + String.format("%.2f", dis));
        }
    }
