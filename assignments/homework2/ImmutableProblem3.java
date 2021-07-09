package homework2;

import java.util.Scanner;

/**
    * this class(immutable) has two private properties namely "base", and "height"
    * a constructor to initialize properties of the class
    * getters
    * computeArea function to calculate the area of Triangle
 */
final class Triangle{

    private final double base;
    private final double height;
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea(){
        return (double) 1/2 * base * height;
    }
}

/**
    * this class(immutable) has two private properties namely "length", and "width"
    * a constructor to initialize properties of the class
    * getters
    * computeArea function to calculate the area of Rectangle
*/
final class Rectangle{
    private final double length;
    private final double width;
    public Rectangle(double width, double length){
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double computeArea(){
        return length * width;
    }
}

/**
    * this class(immutable) has one private properties namely "radius"
    * a constructor to initialize properties of the class
    * getters
    * computeArea function to calculate the area of Rectangle
 */
final class Circle{

    private final double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea(){
        return Math.PI * Math.pow(radius, 2);
    }
}

/**
    * main class to test
*/
public class ImmutableProblem3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // user input from the console
        System.out.println("Enter C for Circle\nEnter R for Rectangle\nEnter T for Triangle");
        String choice = scanner.nextLine();
        switch (choice){
            case "C" :
                System.out.println("Enter radius of the circle : ");
                Circle c = new Circle(scanner.nextDouble());
                System.out.println("Area of Circle is " + c.computeArea());
                break;
            case "R" :
                System.out.println("Enter length of the Rectangle : ");
                double length = scanner.nextDouble();
                System.out.println("Enter width of the Rectangle : ");
                double width = scanner.nextDouble();
                Rectangle r = new Rectangle(length, width);
                System.out.println("Area of Rectangle is " + r.computeArea());
                break;
            case "T" :
                System.out.println("Enter base of the Triangle : ");
                double base = scanner.nextDouble();
                System.out.println("Enter height of the Triangle : ");
                double height = scanner.nextDouble();
                Triangle t = new Triangle(base, height);
                System.out.println("Area of Triangle is " + t.computeArea());
                break;
            default :
                System.out.println("Please enter valid input");
        }
        scanner.close();
    }
}