package examples.algorithms.sorting.algorithms;

public class BubbleSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        bubbleSort(intArray.clone());
        return counter;
    }

    public static void sort(int[] intArray) {
        bubbleSort(intArray);
    }

    private static void bubbleSort(int[] arrayToSort) {
        int n = arrayToSort.length;
        int tempValue;
        boolean swapped;

        for (int j = 0; j < n - 1; j++) {
            swapped = false;
            for (int i = 0; i < n - 1 - j; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    tempValue = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = tempValue;
                    counter += 3;
                    swapped = true;
                }
                counter++;
            }
            if (!swapped)
                break;
        }
    }
}
