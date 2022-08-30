package com.epam.rd.autotasks.intersection;

public class Line {

    public int x;
    public int y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point intersection(Line other) {

        int x;
        int y;

        if(other == null) {
            throw new UnsupportedOperationException();
        } else {

            if (this.x - other.x == 0) return null;

            else
            x = (other.y - this.y) / (this.x - other.x);
            y = other.x * x + other.y;

            Point point = new Point(x, y);

            return point;

        }




    }

}
