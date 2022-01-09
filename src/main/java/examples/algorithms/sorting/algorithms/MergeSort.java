package examples.algorithms.sorting.algorithms;

public class MergeSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        int[] arrayToSort = intArray.clone();
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        return counter;
    }

    public static void sort(int[] intArray) {
        mergeSort(intArray, 0, intArray.length - 1);
    }

    private static void mergeSort(int[] arrayToSort, int start, int end) {
        if (start < end) {
            int middle = (int) ((start + end) / 2);
            mergeSort(arrayToSort, start, middle);
            mergeSort(arrayToSort, middle+1, end);
            merge(arrayToSort, start, middle, end);
        }
    }

    private static void merge(int[] arrayToSort, int start, int middle, int end) {
        if (start == end)
            return;

        var tmpArr = new int[end - start + 1];

        int x = start;
        int y = middle + 1;

        for (int i = 0; i < tmpArr.length; i++) {
            if (x > middle) {
                tmpArr[i] = arrayToSort[y];
                y++;
                counter += 1;
            } else if (y > end) {
                tmpArr[i] = arrayToSort[x];
                x++;
                counter +=1;
            } else {
                if (arrayToSort[x] <= arrayToSort[y]) {
                    tmpArr[i] = arrayToSort[x];
                    x++;
                    counter += 2;
                } else {
                    tmpArr[i] = arrayToSort[y];
                    y++;
                    counter += 2;
                }
            }
        }

        int i=0;
        for (int j = start;j <= end; j++, i++) {
            arrayToSort[j] = tmpArr[i];
            counter += 1;
        }
    }
}
