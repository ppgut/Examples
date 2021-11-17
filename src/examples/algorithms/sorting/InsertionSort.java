package examples.algorithms.sorting;

public class InsertionSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        insertionSort(intArray.clone());
        return counter;
    }

    public static void sort(int[] intArray) {
        insertionSort(intArray);
    }

    private static void insertionSort(int[] arrayToSort) {

        int current;
        int j;

        for (int i = 1; i < arrayToSort.length; i++) {
            current = arrayToSort[i];
            counter += 1;
            j = i - 1;
            while (j >= 0 && arrayToSort[j] > current) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
                counter += 3;
            }
            arrayToSort[j + 1] = current;
            counter += 1;
        }
    }
}
