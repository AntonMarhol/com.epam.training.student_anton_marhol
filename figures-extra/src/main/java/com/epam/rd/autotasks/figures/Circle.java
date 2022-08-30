package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private double x, y;
    private double radius;

    public Circle(Point center, double radius){
        if (center == null) throw new IllegalArgumentException();
        else {
            this.x = center.getX();
            this.y = center.getY();
        }
        if (radius <=0) throw new IllegalArgumentException();
        else this.radius = radius;
    }

    public Point centroid(){
        Point point;
        return point = new Point(x,y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double delta = 0.0001;
        if (figure instanceof Circle) {
            Circle toCompare = (Circle) figure;

            if (Math.abs(toCompare.x-this.x)<delta && Math.abs(toCompare.y-this.y)<delta && Math.abs(toCompare.radius-this.radius)<delta) return true;
            else return false;
        } else return false;
    }

}
