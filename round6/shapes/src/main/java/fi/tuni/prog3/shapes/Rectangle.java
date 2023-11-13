package fi.tuni.prog3.shapes;

public class Rectangle implements IShapeMetrics {

    private double height, width;

    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString(){
        return ("Rectangle with height " + String.format("%.2f", height) + " and width " +  String.format("%.2f", width));
    }

    @Override
    public String name(){
        return "rectangle";
    }

    @Override
    public double area(){
        return height*width;

    }

    @Override
    public double circumference(){
        return 2*(height+width);
    }
}
