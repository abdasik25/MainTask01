/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (SORTING ALGORITHMS)
 */

package by.epam.javatraining.lomat.vector.model.logic.sorter;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;

public class VectorSorter {


    //merges two subarrays of arr[].
    //first subarray is arr[lowBound..middlePoint]
    //second subarray is arr[middlePoint+1..upperBound]
    private static void merge(double arr[], int lowBound, int middlePoint, int upperBound) {
        // Find sizes of two subarrays to be merged
        int n1 = middlePoint - lowBound + 1;
        int n2 = upperBound - middlePoint;
        //create temp arrays
        double L[] = new double[n1];
        double R[] = new double[n2];
        //copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[lowBound + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[middlePoint + 1 + j];
        }
        //merge the temp arrays */
        //initial indexes of first and second subarrays
        int i = 0, j = 0;
        //initial index of merged subarray array
        int k = lowBound;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        //copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //main function that sorts arr[l..r] using
    //merge()
    public static void mergeSortDescending(VectorModelDataService vectorModelDataService, int lowBound, int highBound) {
        double[] arr = vectorModelDataService.getElements();
        if (lowBound < highBound) {
            //find the middle point
            int m = (lowBound + highBound) / 2;
            //sort first and second halves
            mergeSortDescending(vectorModelDataService, lowBound, m);
            mergeSortDescending(vectorModelDataService, m + 1, highBound);
            //merge the sorted halves
            merge(arr, lowBound, m, highBound);
        }
    }

    /* This function takes last element as pivot,
      places the pivot element at its correct
      position in sorted array, and places all
      smaller (smaller than pivot) to left of
      pivot and all greater elements to right
      of pivot */
    private static int partitionQuickSort(VectorModelDataService vectorModelDataService, int low, int high) {
        double[] arr = vectorModelDataService.getElements();
        double pivot = arr[high];
        int i = (low - 1); //index of smaller element
        for (int j = low; j < high; j++) {
            //if current element is smaller than or
            //equal to pivot
            if (arr[j] <= pivot) {
                i++;
                //swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap arr[i+1] and arr[high] (or pivot)
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    /*the main function that implements quickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void quickSort(VectorModelDataService vectorModelDataService, int low, int high) {
        double[] mas = vectorModelDataService.getElements();
        if (low < high) {
            /*pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partitionQuickSort(vectorModelDataService, low, high - 1);
            //recursively sort elements before
            //partition and after partition
            quickSort(vectorModelDataService, low, pi - 1);
            quickSort(vectorModelDataService, pi + 1, high);
        }
    }

    //checks if array is sorted acceding
    public static boolean isSortedAcceding(VectorModelDataService vectorModelDataService,
                                           VectorBasicController vectorBasicController) {
        boolean isSortedAcceding = true;
        for (int i = 0; i < vectorModelDataService.size() - 1; i++) {
            if (vectorBasicController.getVectorElement(i) > vectorBasicController.getVectorElement(i + 1)) {
                return !isSortedAcceding;
            }
        }
        return isSortedAcceding;
    }

    //checks if array is sorted desceding
    public static boolean isSortedDesceding(VectorModelDataService vectorModelDataService,
                                            VectorBasicController vectorBasicController) {
        boolean isSortedDesceding = true;
        for (int i = 0; i < vectorModelDataService.size() - 1; i++) {
            if (vectorBasicController.getVectorElement(i) < vectorBasicController.getVectorElement(i + 1)) {
                return !isSortedDesceding;
            }
        }
        return isSortedDesceding;
    }

    //bubble sort (descending)
    //sorts an array descending using bubble sort algorithm
    public static void bubbleSortDescending(VectorModelDataService vectorModelDataService,
                                            VectorBasicController vectorBasicController) {
        for (int i = 0; i < vectorModelDataService.size() - 1; i++) {
            for (int j = 0; j < vectorModelDataService.size() - i - 1; j++) {
                if (vectorBasicController.getVectorElement(j) < vectorBasicController.getVectorElement(j + 1)) {
                    double tmp = vectorBasicController.getVectorElement(j);
                    vectorBasicController.setVectorElement(j, vectorBasicController.getVectorElement(j + 1));
                    vectorBasicController.setVectorElement(j + 1, tmp);
                }
            }
        }
    }

    public static void insertionSortDescending(VectorModelDataService vectorModelDataService,
                                               VectorBasicController vectorBasicController) {
        for (int i = 1; i < vectorModelDataService.size(); ++i) {
            double key = vectorBasicController.getVectorElement(i);
            int j = i - 1;
            /* move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && vectorBasicController.getVectorElement(j) < key) {
                vectorBasicController.setVectorElement(j + 1, vectorBasicController.getVectorElement(j));
                j = j - 1;
            }
            vectorBasicController.setVectorElement(j + 1, key);
        }
    }

    //sorts an array ascending using insertion sort algorithm
    public static void insertionSort(VectorModelDataService vectorModelDataService,
                                     VectorBasicController vectorBasicController) {
        int n = vectorModelDataService.size();
        //one by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            //find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (vectorBasicController.getVectorElement(j) < vectorBasicController.getVectorElement(min_idx)) {
                    min_idx = j;
                }
            }
            //swap the found minimum element with the first
            //element
            double temp = vectorBasicController.getVectorElement(min_idx);
            vectorModelDataService.setElement(min_idx, vectorBasicController.getVectorElement(i));
            vectorModelDataService.setElement(i, temp);
        }
    }

}
