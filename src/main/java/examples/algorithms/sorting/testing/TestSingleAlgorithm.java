package examples.algorithms.sorting.testing;

import examples.algorithms.sorting.algorithms.*;
import examples.csvIO.CsvIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestSingleAlgorithm {
    public static void main(String[] args) {
        int randArraySize;
        int[] randIntArr;
        Scanner scanner = new Scanner(System.in);
        List<List<String>> csvLines = new ArrayList<>();
        List<String> csvLine = new ArrayList<>();
        String csvResultsFilePath = "./src/main/java/examples/algorithms/sorting/testing/";

        // choose sort algorithm
        System.out.print("""
                
                Which algorithm would you like to test?
                1. Bubble sort
                2. Insertion sort
                3. Merge sort
                4. Quick sort
                5. Selection sort
                6. Shell sort
                number=""");
        int algorithmNumber = scanner.nextInt();

        // info + enter max size of array to be tested
        System.out.print("""
                
                Sorting algorithm will be checked 10 times for each of 10 lengths of an array (100 runs).
                Lengths will be equally distributed: n_i = n_max/10 * i.
                Enter max length of an array (n) to be tested.
                n_max=""");
        int maxArrLengthToTest = scanner.nextInt();

        // assign description of chosen algorithm to String variable
        String algorithmType = switch (algorithmNumber) {
            case 1 -> "Bubble sort";
            case 2 -> "Insertion sort";
            case 3 -> "Merge sort";
            case 4 -> "Quick sort";
            case 5 -> "Selection sort";
            case 6 -> "Shell sort";
            default -> "";
        };

        // print out algorithm description
        System.out.println();
        System.out.println(algorithmType + ":");
        // store description as a first line to be saved in csv
        csvLine = List.of(algorithmType);
        csvLines.add(csvLine);
        csvLine = List.of("array length", "steps to sort");
        csvLines.add(csvLine);

        for (int i = 0; i < 10; i++) {
            // create random int array of length n_i
            randArraySize = maxArrLengthToTest/10 * (i+1);
            randIntArr = randomIntArray(randArraySize);
            // do 10 tests of sorting
            List<Long> results = new ArrayList<>();
            for (int j = 0; j < 1; j++) {
                switch (algorithmNumber) {
                    case 1 -> results.add(BubbleSort.howManySteps(randIntArr));
                    case 2 -> results.add(InsertionSort.howManySteps(randIntArr));
                    case 3 -> results.add(MergeSort.howManySteps(randIntArr));
                    case 4 -> results.add(QuickSort.howManySteps(randIntArr));
                    case 5 -> results.add(SelectionSort.howManySteps(randIntArr));
                    case 6 -> results.add(ShellSort.howManySteps(randIntArr));
                }
            }
            long avResult = reduceToAvg(results);
            System.out.printf("n=% 5d, steps=% 9d%n", randArraySize, avResult);
            csvLine = List.of(String.valueOf(randArraySize), String.valueOf(avResult));
            csvLines.add(csvLine);
        }

        scanner.nextLine();
        System.out.println();
        System.out.println("Would You like to save result to csv file? (y/n):");
        if (scanner.nextLine().equals("y")) {
                CsvIO.saveCSV(csvLines, csvResultsFilePath + algorithmType + " test results.csv");
            System.out.println("Saved");
        }
    }

    public static int[] randomIntArray(int length) {
        return new Random().ints(length, 0, length).toArray();
    }

    public static long reduceToAvg(List<Long> list) {
        return list.stream().reduce(0L, Long::sum) / list.size();
    }
}
