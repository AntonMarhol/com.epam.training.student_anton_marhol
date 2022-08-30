package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private double x, y, radius;

    public Circle(Point point, double radius){
        this.x = point.getX();
        this.y = point.getY();
        this.radius = radius;
    }

    public double area(){
        return (Math.PI * radius * radius);
    }

    @Override
    public String toString(){
        return "Circle[(" + this.x + "," + this.y + ")"+ radius + "]";
    }

    public String pointsToString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public Point leftmostPoint(){
        Point point = new Point(x - radius, y );
        return point;
    }

}
