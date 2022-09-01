package com.epam.rd.autotasks;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Battleship8x8 {
    private long shots = 0L;
    private final long ships;

    public Battleship8x8(final long ships) {
        this.ships = ships;
        shots = ships;
    }

    public boolean shoot(String shot) {

        if (shot == null) throw new UnsupportedOperationException();

        String letter = shot.substring(0,1);
        String munder = shot.substring(1);
        int y = Integer.valueOf(munder)-1;
        int x;

        if (letter.equals("A")) x = 0;
        else if (letter.equals("B")) x = 1;
        else if (letter.equals("C")) x = 2;
        else if (letter.equals("D")) x = 3;
        else if (letter.equals("E")) x = 4;
        else if (letter.equals("F")) x = 5;
        else if (letter.equals("G")) x = 6;
        else  x = 7;

        int punch = y * 8 + x;

        char[] mapShips;
        char[] mapShots;

        String stringOfSips = Long.toBinaryString(ships);
        while (stringOfSips.length() < 64) {
            stringOfSips = 0 + stringOfSips;
        }
        String stringOfShots = Long.toBinaryString(shots);
        while (stringOfShots.length() < 64) {
            stringOfShots = 0 + stringOfShots;
        }

        mapShips = stringOfSips.toCharArray();
        mapShots = stringOfShots.toCharArray();

        if (mapShots[punch] == 49) mapShots[punch] = 48;
        else mapShots[punch] = 49;

        stringOfShots = String.valueOf(mapShots);

        shots = Long.parseUnsignedLong(stringOfShots, 2);

        if (mapShips[punch] == 49) return true;
        else return false;

    }

    public String state() {

        String stringOfMap = toMap(shots);

        String out = "";

        String a = stringOfMap.substring(0, 8) + "\n";
        String b = stringOfMap.substring(8, 16) + "\n";
        String c = stringOfMap.substring(16, 24) + "\n";
        String d = stringOfMap.substring(24, 32) + "\n";
        String e = stringOfMap.substring(32, 40) + "\n";
        String f = stringOfMap.substring(40, 48) + "\n";
        String g = stringOfMap.substring(48, 56) + "\n";
        String h = stringOfMap.substring(56, 64) + "\n";

        out = (a.toString() + b.toString() + c.toString() + d.toString()  + e.toString() + f.toString() + g.toString() + h.toString());

        if (out == null) throw new UnsupportedOperationException();

        return out;

    }

    public String toMap(Long longOfMap){
        char[] arrayOfShots;
        char[] arrayOfShips;

        String mapOfShots = Long.toBinaryString(longOfMap);
        while (mapOfShots.length() < 64) {
            mapOfShots = 0 + mapOfShots;
        }
        arrayOfShots = mapOfShots.toCharArray();

        String mapOfShips = Long.toBinaryString(ships);
        while (mapOfShips.length() < 64) {
            mapOfShips = 0 + mapOfShips;
        }
        arrayOfShips = mapOfShips.toCharArray();

        for (int i = 0; i < arrayOfShots.length; i++) {
            if (arrayOfShots[i] == 48 && arrayOfShips[i] == 49) arrayOfShots[i] = 9746;
            if (arrayOfShots[i] == 49 && arrayOfShips[i] == 49) arrayOfShots[i] = 9744;
            if (arrayOfShots[i] == 49 && arrayOfShips[i] == 48) arrayOfShots[i] = 215;
            if (arrayOfShots[i] == 48 && arrayOfShips[i] == 48) arrayOfShots[i] = 46;
        }

        mapOfShots = String.valueOf(arrayOfShots);

        return mapOfShots;
    }
}
