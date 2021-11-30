package examples.algorithms.sorting.algorithms;

public class SelectionSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        selectionSort(intArray.clone());
        return counter;
    }

    public static void sort(int[] intArray) {
        selectionSort(intArray);
    }

    private static void selectionSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        int tempValue;
        int minIndex;

        for (int j = 0; j < n - 1; j++) {
            minIndex = j;
            for (int i = j+1; i < n - 1 - j; i++) {
                if (arrayToSort[i] < arrayToSort[minIndex]) {
                    minIndex = i;
                }
                counter++;
            }
            if (minIndex != j) {
                tempValue = arrayToSort[j];
                arrayToSort[j] = arrayToSort[minIndex];
                arrayToSort[minIndex] = tempValue;
                counter += 3;
            }
        }
    }
}
