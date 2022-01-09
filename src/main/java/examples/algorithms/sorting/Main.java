package examples.algorithms.sorting;

import examples.algorithms.sorting.algorithms.InsertionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int randArraySize;
        int[] randIntArr;

        for (int i = 0; i < 10; i++) {
            randArraySize = 100 + i * 100;
            randIntArr = randomIntArray(randArraySize);
            List<Long> results = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                results.add(InsertionSort.howManySteps(randIntArr));
            }
            System.out.printf("n=% 5d, steps=% 9d%n", randArraySize, reduceToAvg(results));
        }
    }

    public static int[] randomIntArray(int length) {
        return new Random().ints(length, 0, length).toArray();
    }

    public static long reduceToAvg(List<Long> list) {
        return list.stream().reduce(0L, Long::sum) / list.size();
    }
}
