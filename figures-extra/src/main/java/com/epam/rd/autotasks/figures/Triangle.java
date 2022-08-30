package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Triangle extends Figure{
    private double ax, bx, cx, ay, by, cy;

    public Triangle(Point pointA, Point pointB, Point pointC){
        if (pointA == null || pointB == null || pointC == null) {
            throw new IllegalArgumentException();
        } else{
            this.ax = pointA.getX();
            this.bx = pointB.getX();
            this.cx = pointC.getX();
            this.ay = pointA.getY();
            this.by = pointB.getY();
            this.cy = pointC.getY();
        }
        isDegenerate();
    }

    public Point centroid(){
        double x;
        double y;

        x = (ax+bx+cx)/3;
        y = (ay+by+cy)/3;

        Point point = new Point(x, y);
        return point;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }

    private void isDegenerate(){
        double ab, bc, ca;

        ab = sqrt(((bx-ax)*(bx-ax))+((by-ay)*(by-ay)));
        bc = sqrt(((cx-bx)*(cx-bx))+((cy-by)*(cy-by)));
        ca = sqrt(((cx-ax)*(cx-ax))+((cy-ay)*(cy-ay)));

        if ((float)ab == ((float)bc+(float)ca+(float)ab)/2) {
            throw new IllegalArgumentException();
        } else if ((float)bc == ((float)ab+(float)ca+(float)bc)/2) {
            throw new IllegalArgumentException();
        }
        else
        if ((float)ca == ((float)ab+(float)bc+(float)ca)/2) {
            throw new IllegalArgumentException();
        }
    }
}
