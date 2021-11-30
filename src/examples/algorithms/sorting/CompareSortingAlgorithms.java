package examples.algorithms.sorting;

import examples.algorithms.sorting.algorithms.*;

import java.util.*;

public class CompareSortingAlgorithms {

    public static void main(String[] args) {

        int randArraySize = 1000;
        int numberOfTries = 1000;
        int[] randIntArr;

        List<Long> resultsListQuickSort = new ArrayList<>();
        List<Long> resultsListMergeSort = new ArrayList<>();
        List<Long> resultsListInsertionSort = new ArrayList<>();
        List<Long> resultsListShellSort = new ArrayList<>();
        List<Long> resultsListBubbleSort = new ArrayList<>();
        List<Long> resultsListSelectionSort = new ArrayList<>();

        for (int i = 0; i < numberOfTries; i++) {
            randIntArr = randomIntArray(randArraySize);

            resultsListQuickSort.add(QuickSort.howManySteps(randIntArr));
            resultsListMergeSort.add(MergeSort.howManySteps(randIntArr));
            resultsListInsertionSort.add(InsertionSort.howManySteps(randIntArr));
            resultsListShellSort.add(ShellSort.howManySteps(randIntArr));
            resultsListBubbleSort.add(BubbleSort.howManySteps(randIntArr));
            resultsListSelectionSort.add(SelectionSort.howManySteps(randIntArr));
        }

        Map<Long, String> results = new HashMap<>();
        results.put(reduceToAvg(resultsListQuickSort), "Quick sort:     ");
        results.put(reduceToAvg(resultsListMergeSort), "Merge sort:     ");
        results.put(reduceToAvg(resultsListInsertionSort), "Insertion sort: ");
        results.put(reduceToAvg(resultsListShellSort), "Shell sort:     ");
        results.put(reduceToAvg(resultsListBubbleSort), "Bubble sort:    ");
        results.put(reduceToAvg(resultsListSelectionSort), "Selection sort: ");

        if (results.size() < 6) {
            System.out.println("Sorry, seems two algorithms made the same number of steps. Try again.");
            return;
        }

        System.out.println(numberOfTries + "-tries-average number of steps to sort "
                + randArraySize + "-element array:");
        int resultsSize = results.size();
        for (int i = 0; i < resultsSize; i++) {
            long min = results.keySet().stream().min(Comparator.comparing(x -> x))
                    .orElseThrow(NoSuchElementException::new);
            System.out.printf("%d %s% 10d%n", i+1, results.get(min), min);
            results.remove(min);
        }
    }

    public static int[] randomIntArray(int length) {
        return new Random().ints(length, 0, length).toArray();
    }

    public static long reduceToAvg(List<Long> list) {
        return list.stream().reduce(0L, Long::sum) / list.size();
    }
}
