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

        String mS = Long.toBinaryString(ships);
        while (mS.length() < 64) {
            mS = 0 + mS;
        }
        String mSho = Long.toBinaryString(shots);
        while (mSho.length() < 64) {
            mSho = 0 + mSho;
        }

        mapShips = mS.toCharArray();
        mapShots = mSho.toCharArray();

        if (mapShots[punch] == 49) mapShots[punch] = 48;
        else mapShots[punch] = 49;

        mSho = String.valueOf(mapShots);

        shots = Long.parseUnsignedLong(mSho, 2);

        if (mapShips[punch] == 49) return true;
        else return false;

    }

    public String state() {

        String map = toMap(shots);

        String out = "";

        String a = map.substring(0, 8) + "\n";
        String b = map.substring(8, 16) + "\n";
        String c = map.substring(16, 24) + "\n";
        String d = map.substring(24, 32) + "\n";
        String e = map.substring(32, 40) + "\n";
        String f = map.substring(40, 48) + "\n";
        String g = map.substring(48, 56) + "\n";
        String h = map.substring(56, 64) + "\n";

        out = (a.toString() + b.toString() + c.toString() + d.toString()  + e.toString() + f.toString() + g.toString() + h.toString());

        if (out == null) throw new UnsupportedOperationException();

        return out;

    }

    public String toMap(Long to){
        char[] mapArr;
        char[] mapAS;

        String mapSO = Long.toBinaryString(to);
        while (mapSO.length() < 64) {
            mapSO = 0 + mapSO;
        }
        mapArr = mapSO.toCharArray();

        String mapSH = Long.toBinaryString(ships);
        while (mapSH.length() < 64) {
            mapSH = 0 + mapSH;
        }
        mapAS = mapSH.toCharArray();

        for (int i = 0; i < mapArr.length; i++) {
            if (mapArr[i] == 48 && mapAS[i] == 49) mapArr[i] = 9746;
            if (mapArr[i] == 49 && mapAS[i] == 49) mapArr[i] = 9744;
            if (mapArr[i] == 49 && mapAS[i] == 48) mapArr[i] = 215;
            if (mapArr[i] == 48 && mapAS[i] == 48) mapArr[i] = 46;
        }

        mapSO = String.valueOf(mapArr);

        return mapSO;
    }
}
