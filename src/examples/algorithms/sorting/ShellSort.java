package examples.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        shellSort(intArray.clone());
        return counter;
    }

    public static void sort(int[] intArray) {
        shellSort(intArray);
    }


    // Knuth Sequence - gives array of optimal intervals (h) for Shell sort algorithm
    private static int[] knuthSequence(int arrLength) {
        List<Integer> knuth = new ArrayList<>();
        int h = 1;

        while (h < arrLength) {
            knuth.add(h);
            h = 3*h + 1;
            counter += 2;
        }

        Collections.reverse(knuth);
        counter += knuth.size();
        counter += knuth.size();
        return knuth.stream().mapToInt(x -> x).toArray();   // map Integer[] to int[]
    }

    private static void shellSort(int[] arrayToSort) {

        counter += 1;
        int[] knuthSequence = knuthSequence(arrayToSort.length);

        int current;
        int j;

        for (int h : knuthSequence) {
            for (int k = h; k < 2*h; k++) {
                // based on Insertion Sort algorithm
                for (int i = k; i < arrayToSort.length; i += h) {
                    current = arrayToSort[i];
                    j = i - h;
                    counter += 1;
                    while (j >= 0 && arrayToSort[j] > current) {
                        arrayToSort[j + 1] = arrayToSort[j];
                        j-=h;
                        counter += 2;
                    }
                    arrayToSort[j + h] = current;
                    counter += 1;
                }
            }
        }
    }
}
