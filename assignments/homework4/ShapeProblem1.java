package homework4;

/**
    * this class is a general class for all types of shapes having color as a property
*/
class Shape{
    protected String color;
    Shape(String color){
        this.color = color;
    }
    public double calculateArea(){ return 0.0; }
    public double calculatePerimeter(){ return 0.0; }
}

/**
    * this class is for shape : rectangle having width and height as properties
    * extends class Shape
    * has calculateArea and calculatePerimeter to calculate area and perimeter of rectangle
*/
class Rectangle extends Shape{
    protected double width;
    protected double height;
    Rectangle(String color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }
    public double calculateArea(){ return width * height; }
    public double calculatePerimeter(){
        return 2 * width + 2 * height; // == 2 * (width+height)
    }
}

/**
    * this class is for shape : circle having radius as property
    * extends class Shape
    * has calculateArea and calculatePerimeter to calculate area and perimeter of circle
 */
class Circle extends Shape{
    protected double radius;
    Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    public double calculateArea(){ return Math.PI * radius * radius; }
    public double calculatePerimeter(){ return 2 * Math.PI * radius; }
}

/**
    * this class is for shape : square having side as property
    * extends class Shape
 */
class Square extends Rectangle{
    Square(String color, double side){
        super(color, side, side);
    }
}

/**
    * main class to test and calculate the area and perimeter of different shapes
 */
public class ShapeProblem1 {
    public static void main(String[] args){
        Shape[] shapeObjects = new Shape[5];
        shapeObjects[0] = new Rectangle("Red", 5.5, 6.0);
        shapeObjects[1] = new Circle("Blue", 10.0);
        shapeObjects[2] = new Square("Green", 4.5);
        shapeObjects[3] = new Rectangle("Yellow", 10.0, 3.0);
        shapeObjects[4] = new Circle("Purple", 20.0);
        printTotal(shapeObjects);
    }
    public static void printTotal(Shape[] shapeObjects){
        for (Shape s : shapeObjects){
            System.out.println(s.calculateArea());
            System.out.println(s.calculatePerimeter());
        }
    }
}
