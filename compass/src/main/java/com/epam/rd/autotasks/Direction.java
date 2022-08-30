package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    private int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees(){
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        if (degrees >= 360) degrees = degrees%360;
        else if (degrees < 0) degrees = 360-Math.abs(degrees);
        if (degrees < - 360)throw new UnsupportedOperationException();

        for (Direction dr : Direction.values()) {
            if (degrees == dr.getDegrees()){
                return dr;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {

        if (degrees >= 360) degrees = degrees%360;
        else if (degrees < 0) degrees = 360-Math.abs(degrees);
        if (degrees < - 360) throw new UnsupportedOperationException();

        for (Direction dr : Direction.values()) {
            if ((degrees - dr.getDegrees()) <= 22){
                return dr;
            }
        }
        return null;
    }

    public Direction opposite() {

        if (degrees >= 360) degrees = degrees%360;
        else if (degrees < 0) degrees = 360-Math.abs(degrees);
        if (degrees < - 360)throw new UnsupportedOperationException();

        for (Direction dr : Direction.values()) {
            if ((degrees + 180) ==  dr.getDegrees()){
                return dr;
            } else if ((degrees - 180) ==  dr.getDegrees()){
                return dr;
            }
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if (direction == null) throw new UnsupportedOperationException();

        if (direction.degrees == 315) return Math.abs((degrees+360)-direction.degrees);
        else return Math.abs(degrees - direction.degrees);
    }

}
