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

        char letter = shot.charAt(0);
        int y = Integer.valueOf(shot.substring(1))-1;
        int x;
        int punch;

        switch (letter){
            case 'A': x = 0; break;
            case 'B': x = 1; break;
            case 'C': x = 2; break;
            case 'D': x = 3; break;
            case 'E': x = 4; break;
            case 'F': x = 5; break;
            case 'G': x = 6; break;
            default: x = 7;
        }

        punch = y * 8 + x;

        char[] mapShips = toArray(ships);
        char[] mapShots = toArray(shots);

        if (mapShots[punch] == 49) mapShots[punch] = 48;
        else mapShots[punch] = 49;

        shots = Long.parseUnsignedLong(String.valueOf(mapShots), 2);

        if (mapShips[punch] == 49) return true;
        else return false;
    }

    public String state() {

        String stringOfMap = toMap(shots);

        String out = (stringOfMap.substring(0, 8) + "\n"
                + stringOfMap.substring(8, 16) + "\n"
                + stringOfMap.substring(16, 24) + "\n"
                + stringOfMap.substring(24, 32) + "\n"
                + stringOfMap.substring(32, 40) + "\n"
                + stringOfMap.substring(40, 48) + "\n"
                + stringOfMap.substring(48, 56) + "\n"
                + stringOfMap.substring(56, 64) + "\n");

        if (out == null) throw new UnsupportedOperationException();

        return out;
    }

    private String toMap(Long longOfMap){
        
        char[] arrayOfShots = toArray(longOfMap);
        char[] arrayOfShips = toArray(ships);

        for (int i = 0; i < arrayOfShots.length; i++) {
            if (arrayOfShots[i] == 48 && arrayOfShips[i] == 49) arrayOfShots[i] = 9746;
            if (arrayOfShots[i] == 49 && arrayOfShips[i] == 49) arrayOfShots[i] = 9744;
            if (arrayOfShots[i] == 49 && arrayOfShips[i] == 48) arrayOfShots[i] = 215;
            if (arrayOfShots[i] == 48 && arrayOfShips[i] == 48) arrayOfShots[i] = 46;
        }
        return String.valueOf(arrayOfShots);
    }

    private char[] toArray(Long longOfField){

        String mapOfShots = Long.toBinaryString(longOfField);
        while (mapOfShots.length() < 64) {
            mapOfShots = 0 + mapOfShots;
        }
        return  mapOfShots.toCharArray();
    }

}
