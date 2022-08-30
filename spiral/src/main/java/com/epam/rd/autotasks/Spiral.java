package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int[][] mySpiral = new int[rows][columns];
        int round = rows * columns;
        int a = 0;
        int b = columns-1;
        int c = rows -1;
        int d = 0;
        int nummCircle = 1;

        while (round > 0){

            if (d  <= b && a <= c) { //заполняем верхний ряд
                for (int i = d; i <= b; i++) {
                    mySpiral[a][i] = nummCircle;
                    nummCircle++;
                    round--;
                    if (round == 0) break;
                }
                a++;
            }

            if (a <= c && d <= b) { //заполняем правый столбец
                for (int i = a; i <= c; i++) {
                    mySpiral[i][b] = nummCircle;
                    nummCircle++;
                    round--;
                    if (round ==0 ) break;
                }
                b--;
            }

            if (b  >= d && c  >= a) { //заполняем нижний ряд
                for (int i = b; i >= d; i--) {
                    mySpiral[c][i] = nummCircle;
                    nummCircle++;
                    round--;
                    if (round == 0) break;
                }
                c--;
            }

            if (c  >= a && b  >= d) { //заполняем левый столбец
                for (int i = c; i >= a; i--) {
                    mySpiral[i][d] = nummCircle;
                    nummCircle++;
                    round--;
                    if (round == 0) break;
                }
                d++;
            }
        }

        return mySpiral;
    }
}
