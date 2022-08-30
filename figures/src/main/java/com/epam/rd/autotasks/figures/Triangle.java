package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Triangle extends Figure{
    private double ax, ay, bx, by, cx, cy;

    public Triangle(Point point1 ,Point point2 ,Point point3){
        this.ax = point1.getX();
        this.ay = point1.getY();
        this.bx = point2.getX();
        this.by = point2.getY();
        this.cx = point3.getX();
        this.cy = point3.getY();
    }

    public double area(){
        double ab, bc, ca;

        ab = sqrt(((bx-ax)*(bx-ax))+((by-ay)*(by-ay)));
        bc = sqrt(((bx-cx)*(bx-cx))+((cy-by)*(cy-by)));
        ca = sqrt(((cx-ax)*(cx-ax))+((cy-ay)*(cy-ay)));

        return sqrt((ab+bc-ca)*(ab-bc+ca)*(bc+ca-ab)*(ab+bc+ca))/4;
    }

    @Override
    public String toString(){
        return "Triangle[(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")]";
    }

    public String pointsToString(){
        return "(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")";
    }

    public Point leftmostPoint(){
        Point point;

            if (ax <= bx) {
                if (bx <= cx) { point = new Point(ax,ay); }
                else if (ax <= cx) { point = new Point(ax,ay);}
                else { point = new Point(cx,cy);}
            } else if (bx <= cx) { point = new Point(bx,by); }
            else { point = new Point(cx,cy); }

        return point;
    }
}
