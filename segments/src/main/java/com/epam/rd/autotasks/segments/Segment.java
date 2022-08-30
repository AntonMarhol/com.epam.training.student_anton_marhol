package com.epam.rd.autotasks.segments;

import static java.lang.Math.sqrt;

class Segment {
    private double x1;
    private double x2;
    private double y1;
    private double y2;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) throw new IllegalArgumentException();
        else {
            this.x1 = start.getX();
            this.y1 = start.getY();
            this.x2 = end.getX();
            this.y2 = end.getY();
        }
    }

    double length() {
        return sqrt(((this.x2-this.x1)*(this.x2-this.x1))+((this.y2-this.y1)*(this.y2-this.y1)));
    }

    Point middle() {
        return new Point(((this.x1+this.x2)/2), ((this.y1+this.y2)/2));
    }

    Point intersection(Segment another) {
        double x;
        double y;
        double denominator;

        denominator = (this.x1-this.x2)*(another.y1-another.y2)-(this.y1-this.y2)*(another.x1-another.x2);

        if (this.x1 > another.x1 && this.x2>another.x2 || another.x1 > this.x1 && another.x2 > this.x2 || this.x1 == another.x1 && this.y2 == another.y2 && another.y1 == another.x2){
            return null;
        } else if (denominator == 0) return null;

        x = (((this.x1 * this.y2 - this.y1 * this.x2) * (another.x1 - another.x2)) - ((this.x1 - this.x2) * (another.x1 * another.y2 - another.y1 * another.x2))) / denominator;
        y = (((this.x1 * this.y2 - this.y1 * this.x2) * (another.y1 - another.y2)) - ((this.y1 - this.y2) * (another.x1 * another.y2 - another.y1 * another.x2))) / denominator;

        return new Point(x, y);
    }

}
