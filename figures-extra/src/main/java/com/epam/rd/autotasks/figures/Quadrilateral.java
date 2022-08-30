package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

class Quadrilateral extends Figure{
    double ax, bx, cx, ay, by, cy, dx, dy;
    private double ab, bd, da;
    private double bc, cd, ac;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD){
        if (pointA == null || pointB == null || pointC == null || pointD == null) {
            throw new IllegalArgumentException();
        } else {
            this.ax = pointA.getX();
            this.bx = pointB.getX();
            this.cx = pointC.getX();
            this.ay = pointA.getY();
            this.by = pointB.getY();
            this.cy = pointC.getY();
            this.dx = pointD.getX();
            this.dy = pointD.getY();
        }
        isDegenerate();
        nonConvex();
    }

    public Point centroid(){

        double ab, bc, ca, cd, da;
        double centrX1, centrY1, centrX2, centrY2, s1, s2, newX, newY;
        Point point;

        ab = sqrt(((bx-ax)*(bx-ax))+((by-ay)*(by-ay)));
        bc = sqrt(((cx-bx)*(cx-bx))+((cy-by)*(cy-by)));

        ca = sqrt(((cx-ax)*(cx-ax))+((cy-ay)*(cy-ay)));

        cd = sqrt(((cx-dx)*(cx-dx))+((cy-dy)*(cy-dy)));
        da = sqrt(((ax-dx)*(ax-dx))+((ay-dy)*(ay-dy)));

        centrX1 = (ax+bx+cx)/3;
        centrY1 = (ay+by+cy)/3;

        centrX2 = (ax+cx+dx)/3;
        centrY2 = (ay+cy+dy)/3;

        s1 = sqrt((bc+ca-ab)*(bc-ca+ab)*(ca+ab-bc)*(bc+ca+ab))/4;
        s2 = sqrt((da+ca-cd)*(da-ca+cd)*(ca+cd-da)*(da+ca+cd))/4;

        newX = (s2 * centrX2 + s1 * centrX1) / (s1 + s2);
        newY = (s2 * centrY2 + s1 * centrY1) / (s1 + s2);

        point = new Point(newX, newY);

        return point;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double[][] arrayThis;
        double[][] arrayThat;
        boolean out = false;
        double xh, yh;
        double yht, xht;
        int theSame = 0;
        double delta = 0.0001;

        arrayThis = new double[][] {{ax,ay},{bx,by},{cx,cy},{dx,dy}};
        while (!out) {
            out = true;
            for (int i = 0; i < arrayThis.length-1; i++) {
                if (arrayThis[i][0] > arrayThis[i+1][0]){
                    xh = arrayThis[i][0];
                    yh = arrayThis[i][1];
                    arrayThis[i][0] = arrayThis[i+1][0];
                    arrayThis[i][1] = arrayThis[i+1][1];
                    arrayThis[i+1][0] = xh;
                    arrayThis[i+1][1] = yh;
                    out = false;
                }
            }
        }

        if (figure instanceof Quadrilateral) {
            Quadrilateral toCompare = (Quadrilateral) figure;
            arrayThat = new double[][]{{toCompare.ax,toCompare.ay},{toCompare.bx,toCompare.by},{toCompare.cx,toCompare.cy},{toCompare.dx,toCompare.dy}};

            out = false;
            while (!out) {
                out = true;
                for (int i = 0; i < arrayThat.length-1; i++) {
                    if (arrayThat[i][0] > arrayThat[i+1][0]){
                        xht = arrayThat[i+1][0];
                        yht = arrayThat[i+1][1];
                        arrayThat[i+1][0] = arrayThat[i][0];
                        arrayThat[i+1][1] = arrayThat[i][1];
                        arrayThat[i][0] = xht;
                        arrayThat[i][1] = yht;
                        out = false;
                    }
                }
            }

            theSame = 0;
            for (int i = 0; i < arrayThat.length; i++) {
                if (Math.abs(arrayThat[i][0] - arrayThis[i][0]) < delta && Math.abs(arrayThat[i][1] - arrayThis[i][1]) < delta){
                    theSame++;
                }
            }
        }

        if (theSame == 4) return true;
        else return false;
    }

    private void isDegenerate(){

        double perimetr1, perimetr2, perimetr3, perimetr4;

        bd = sqrt(((dx-bx)*(dx-bx))+((dy-by)*(dy-by)));
        ac = sqrt(((cx-ax)*(cx-ax))+((cy-ay)*(cy-ay)));

        cd = sqrt(((cx-dx)*(cx-dx))+((cy-dy)*(cy-dy)));
        da = sqrt(((dx-ax)*(dx-ax))+((dy-ay)*(dy-ay)));
        ab = sqrt(((bx-ax)*(bx-ax))+((by-ay)*(by-ay)));
        bc = sqrt(((cx-bx)*(cx-bx))+((cy-by)*(cy-by)));

        perimetr1 = ((float)ab+(float)bd+(float)da);
        perimetr2 = ((float)bc+(float)cd+(float)bd);
        perimetr3 = ((float)ab+(float)bc+(float)ac);
        perimetr4 = ((float)ac+(float)cd+(float)da);

        if ((float)ab == perimetr1 / 2 || (float)bd == perimetr1 / 2 || (float)da == perimetr1 / 2) {
            throw new IllegalArgumentException();
        }  else if ((float)bc == perimetr2 / 2 || (float)cd == perimetr2 / 2 || (float)bd == perimetr2 / 2) {
            throw new IllegalArgumentException();
        } else if ((float)ab == perimetr3 / 2 || (float)bc == perimetr3 / 2 || (float)ac == perimetr3 / 2) {
            throw new IllegalArgumentException();
        } else if ((float)ac == perimetr4 / 2 || (float)cd == perimetr4 / 2 || (float)da == perimetr4 / 2) {
            throw new IllegalArgumentException();
        }
    }

    private void nonConvex(){

        double AX, AY, BX, BY, CX, CY, DX, DY, AXR, AYR,  DXR, DYR, CXR, CYR, BXR, BYR;
        boolean notConvex1 = false, notConvex2 = false;

        AX = ax - dx;
        AY = ay - dy;
        BX = bx - ax;
        BY = by - ay;
        CX = cx - bx;
        CY = cy - by;
        DX = dx - cx;
        DY = dy - cy;

        AXR = ax - bx;
        AYR = ay - by;
        DXR = dx - ax;
        DYR = dy - ay;
        CXR = cx - dx;
        CYR = cy - dy;
        BXR = bx - cx;
        BYR = by - cy;

        if (AX * BY - AY * BX > 0 && BX * CY - BY * CX > 0 && CX * DY - CY * DX > 0 && DX * AY - DY * AX > 0) notConvex1 = true;
        if (AXR * DYR - AYR * DXR > 0 && DXR * CYR - DYR * CXR > 0 && CXR * BYR - CYR * BXR > 0 && BXR * AYR - BYR * AXR > 0) notConvex2 = true;

        if (notConvex1 == true || notConvex2 == true) ;
        else throw new IllegalArgumentException();

    }

}
