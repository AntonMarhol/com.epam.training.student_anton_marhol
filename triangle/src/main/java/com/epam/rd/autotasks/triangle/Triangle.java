package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;

class Triangle {
    double aX, bX, cX, aY, bY, cY;
    double ab, bc, ca;

    public Triangle(Point a, Point b, Point c) {

        aX = a.getX();
        bX = b.getX();
        cX = c.getX();
        aY = a.getY();
        bY = b.getY();
        cY = c.getY();

        area();

    }

    public double area() throws IllegalArgumentException{

        double areaTriangle;

        ab = sqrt(((bX - aX)*(bX - aX))+((bY - aY)*(bY - aY)));
        bc = sqrt(((cX - bX)*(cX - bX))+((cY - bY)*(cY - bY)));
        ca = sqrt(((cX - aX)*(cX - aX))+((cY - aY)*(cY - aY)));

        if ((float)ab == ((float)bc+(float)ca+(float)ab)/2) throw new IllegalArgumentException();
        else if ((float)bc == ((float)ab+(float)ca+(float)bc)/2) throw new IllegalArgumentException();
        else if ((float)ca == ((float)ab+(float)bc+(float)ca)/2) throw new IllegalArgumentException();

        return (sqrt((ab+bc-ca)*(ab-bc+ca)*(bc+ca-ab)*(ab+bc+ca)))/4;
    }

    public Point centroid(){

        return new Point((aX + bX + cX)/3, (aY + bY + cY)/3);

    }

}
