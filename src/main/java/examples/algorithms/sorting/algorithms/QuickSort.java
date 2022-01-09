package examples.algorithms.sorting.algorithms;

public class QuickSort {

    private static long counter;

    public static long howManySteps(int[] intArray) {
        counter = 0;
        int[] arrayToSort = intArray.clone();
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
        return counter;
    }

    public static void sort(int[] intArray) {
        quickSort(intArray, 0, intArray.length - 1);
    }

    private static void quickSort(int[] arrayToSort, int start, int end) {

        if (end == start)                  // for one-element array no need for sort
            return;

        int pivot = arrayToSort[end];       // take last element as pivot-element
        counter += 1;
        int i = start;                      // 'i' starts from 'start' and follows 'j' to the first element
                                            //      that is greater than pivot value
                                            // if there will be any element found to the right of 'i' element
                                            // that is greater than pivot value - it will be moved to the left of 'i'

        int tmp;                            // tmp - temporary space for exchanging two numbers in an array

        for (int j = start; j < end; j++) {             // end-element is a pivot
            if (arrayToSort[j] <= pivot) {              // comparing each element to the left of pivot with pivot value
                if (i != j) {                           // if all elements are smaller than pivot value
                    tmp = arrayToSort[i];               //      'i' ends up being equal to 'end'
                    arrayToSort[i] = arrayToSort[j];    // if all elements are greater than pivot value
                    arrayToSort[j] = tmp;               //      'i' stays equal to 'start' for whole loop
                    counter += 3;
                 }                                      // in all other cases 'start' < 'i' < 'end'
                i++;                                    //
            }
            counter += 1;
        }

        // 'i' is an index of the first value in an array that is greater than pivot value
        // exchange of arr[i] with pivot element puts the pivot between
        // all elements smaller than pivot value (to the left of pivot) and
        // all elements greater than pivot (to the right of pivot)
        // if 'i' == 'end' there is no need for exchange (in this case there is no values greater than pivot)
        if (i != end) {
            tmp = arrayToSort[i];
            arrayToSort[i] = pivot;
            arrayToSort[end] = tmp;
            counter += 3;
        }

        if (i > start)      // if 'i' == start all values are greater than pivot (no elements to the left of pivot)
            quickSort(arrayToSort, start, i - 1); // lef side

        if (i < end)        // if 'i' == end all values are smaller than pivot (no elements to the right of pivot)
            quickSort(arrayToSort, i + 1, end);   // right side
    }
}
