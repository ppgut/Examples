package examples.algorithms.sorting;

import java.util.*;

public class Main {

    public static int[] randomIntArray(int length) {
        return new Random().ints(length, 0, length).toArray();
    }

    public static void main(String[] args) {

        int randArraySize = 1000;
        int numberOfTries = 10000;

        int[] randIntArr;
        List<Long> resultsListQuickSort = new ArrayList<>();
        List<Long> resultsListMergeSort = new ArrayList<>();
        List<Long> resultsListInsertionSort = new ArrayList<>();
        List<Long> resultsListShellSort = new ArrayList<>();

        for (int i = 0; i < numberOfTries; i++) {
            randIntArr = randomIntArray(randArraySize);

            resultsListQuickSort.add(QuickSort.howManySteps(randIntArr));
            resultsListMergeSort.add(MergeSort.howManySteps(randIntArr));
            resultsListInsertionSort.add(InsertionSort.howManySteps(randIntArr));
            resultsListShellSort.add(ShellSort.howManySteps(randIntArr));
        }

        System.out.println(numberOfTries + "-tries-average number of steps to sort " + randArraySize + "-element array:");
        System.out.printf("quick sort:     %d%n",
                            resultsListQuickSort.stream().reduce(0L, Long::sum) / numberOfTries);
        System.out.printf("merge sort:     %d%n",
                            resultsListMergeSort.stream().reduce(0L, Long::sum) / numberOfTries);
        System.out.printf("insertion sort: %d%n",
                            resultsListInsertionSort.stream().reduce(0L, Long::sum) / numberOfTries);
        System.out.printf("Shell sort:     %d%n",
                            resultsListShellSort.stream().reduce(0L, Long::sum) / numberOfTries);



    }
}
