package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {

        int[] array = new int[]{10,10,10,20,10,35};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {

        int[] arrayResult = new int[array.length];
        int p = 0;

        for (int i = 0; i < array.length; i++) { //ПЕРЕБИРАЕТ array

            if (i == 0) { //если текущий элемент ПЕРВЫЙ В ARRAY
                if (array[i] == array[i + 1]) {
                    arrayResult[p] = array[i];
                    p++;
                    continue;
                }
                if (array[i] < array[i + 1]) {
                    arrayResult[p] = array[i];
                    p++;
                    continue;
                }
                if (array[i] > array[i + 1])
                    continue;
            }


            if (i == array.length - 1) {//если элемент ПОСЛЕДНИЙ В ARRAY

                if (array[i] < array[i - 1]) {
                    arrayResult[p] = array[i];
                    p++;
                    break;
                }
                if (array[i] > array[i - 1]) {
                    break;
                }
                if (array[i] == array[i - 1]) {
                    arrayResult[i] = array[i];
                    p++;
                    break;
                }

            }

            if (i < array.length - 1) {
                if (array[i - 1] < array[i]) {                  //ЕСЛИ СЛЕВА МЕНЬШЕ
                    if (array[i] == array[i + 1]) {// если справа равно
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    } else if (array[i] < array[i + 1]) {  //если справа меньше
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    } else if (array[i] > array[i + 1]) //если справа больше
                        continue;

                } else if (array[i - 1] > array[i]) {           //ЕСЛИ СЛЕВА БОЛЬШЕ

                    if (array[i] == array[i + 1]) {// если справа равно
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }
                    if (array[i] < array[i + 1]) {  //если справа меньше
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }
                    if (array[i] > array[i + 1]) {//если справа больше
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }

                } else if (array[i] == array[i - 1]) {             //ЕСЛИ СЛЕВА РАВНО
                    if (array[i] == array[i + 1]) { // если справа равно
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }
                    if (array[i] < array[i + 1]) {  //если справа меньше
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }
                    if (array[i] > array[i + 1]) {  //если справа больше
                        arrayResult[p] = array[i];
                        p++;
                        continue;
                    }
                }
            }
        }

        if (p == 0) {
            arrayResult = array;
        }
        if (p > 0) {
            arrayResult = Arrays.copyOf(arrayResult, p);
        }

        if (arrayResult == null)  {
            throw new UnsupportedOperationException(); }

        return arrayResult;
    }
}
