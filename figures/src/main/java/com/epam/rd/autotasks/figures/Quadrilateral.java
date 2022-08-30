package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Quadrilateral extends Figure{
    private double ax, ay, bx, by, cx,cy, dx, dy;

    public Quadrilateral(Point point1 ,Point point2 ,Point point3, Point point4){
        this.ax = point1.getX();
        this.ay = point1.getY();
        this.bx = point2.getX();
        this.by = point2.getY();
        this.cx = point3.getX();
        this.cy = point3.getY();
        this.dx = point4.getX();
        this.dy = point4.getY();
    }

    public double area(){
        double bd, ab, bc, cd, da, s1, s2;

        bd = sqrt(((dx-bx)*(dx-bx))+((dy-by)*(dy-by)));

        ab = sqrt(((ax-bx)*(ax-bx))+((ay-by)*(ay-by)));
        bc = sqrt(((bx-cx)*(bx-cx))+((by-cy)*(by-cy)));
        cd = sqrt(((cx-dx)*(cx-dx))+((cy-dy)*(cy-dy)));
        da = sqrt(((dx-ax)*(dx-ax))+((dy-ay)*(dy-ay)));

        s1 = sqrt((ab+bd-da)*(ab-bd+da)*(bd+da-ab)*(ab+bd+da))/4;
        s2 = sqrt((bc+bd-cd)*(bc-bd+cd)*(bd+cd-bc)*(bc+bd+cd))/4;

        return s1 + s2;
    }

    @Override
    public String toString(){
        return  "Quadrilateral[(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")(" + dx + "," +  dy + ")]";
    }

    public String pointsToString(){
        return  "(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")(" + dx + "," +  dy + ")";
    }

    public Point leftmostPoint(){
        Point point;
        double min;
        double who;
        boolean out = false;
        double[][] left =
                {{1, ax},
                {2, bx},
                {3, cx},
                {4, dx}};

        while (!out) {
            out = true;
            for (int i = 0; i < left.length-1; i++) {
                if (left[i][1] > left[i+1][1]) {
                    min = left[i+1][1];
                    who = left[i+1][0];
                    left[i+1][1] = left[i][1];
                    left[i+1][0] = left[i][0];
                    left[i][1] = min;
                    left[i][0] = who;
                    out = false;
                }
            }
        }

        if (left[0][0] == 1) return point = new Point(ax, ay);
        if (left[0][0] == 2) return point = new Point(bx, by);
        if (left[0][0] == 3) return point = new Point(cx, cy);
        else return point = new Point(dx, dy);

    }

}
