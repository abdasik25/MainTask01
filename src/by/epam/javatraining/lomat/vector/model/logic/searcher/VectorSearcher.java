/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (SEARCHING ALGORITHMS)
 */

package by.epam.javatraining.lomat.vector.model.logic.searcher;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;

public class VectorSearcher {

    //finds minimum of an array by iterating
    //through all elements and comparing them with minimum
    //(first element at the beginning)
    public static double findMinimum(VectorBasicController vectorBasicController,
                                     VectorModelDataService vectorModelDataService) {

        if (vectorBasicController.isEmpty()) {
            return -1;
        }
        double minimum = vectorBasicController.getVectorElement(0);
        for (int i = 0; i < vectorModelDataService.size(); i++) {
            if (vectorBasicController.getVectorElement(i) < minimum) {
                minimum = vectorBasicController.getVectorElement(i);
            }
        }
        return minimum;
    }

    //finds maximum of an array by iterating
    //through all elements and comparing them with maximum
    //(first element at the beginning)
    public static double findMaximum(VectorBasicController vectorBasicController,
                                     VectorModelDataService vectorModelDataService) {
        if (vectorBasicController.isEmpty()) {
            return -1;
        }
        double maximum = vectorBasicController.getVectorElement(0);
        for (int i = 0; i < vectorModelDataService.size(); i++) {
            if (vectorBasicController.getVectorElement(i) > maximum) {
                maximum = vectorBasicController.getVectorElement(i);
            }
        }
        return maximum;
    }

    //finds local minimum: element which is less than left and right one
    public static double findLocalMinimum(VectorBasicController vectorBasicController,
                                          VectorModelDataService vectorModelDataService) {
        for (int i = 1; i < vectorModelDataService.size() - 1; i++) {
            if (vectorBasicController.getVectorElement(i) < vectorBasicController.getVectorElement(i - 1)
                    && vectorBasicController.getVectorElement(i) < vectorBasicController.getVectorElement(i + 1)) {
                return vectorBasicController.getVectorElement(i);
            }
        }
        return -1;
    }

    //finds local maximum: element which is greater than left and right one
    public static double findLocalMaximum(VectorBasicController vectorBasicController,
                                          VectorModelDataService vectorModelDataService) {
        for (int i = 1; i < vectorModelDataService.size() - 1; i++) {
            if (vectorBasicController.getVectorElement(i) > vectorBasicController.getVectorElement(i - 1)
                    && vectorBasicController.getVectorElement(i) > vectorBasicController.getVectorElement(i + 1)) {
                return vectorBasicController.getVectorElement(i);
            }
        }
        return -1;
    }

    //linear search
    //returns index of element if it is presented in array
    //else returns -1
    public static int linearSearch(VectorBasicController vectorBasicController,
                                   VectorModelDataService vectorModelDataService, double element) {
        for (int i = 0; i < vectorModelDataService.size(); i++) {
            if (vectorBasicController.getVectorElement(i) == element) {
                return i;
            }
        }
        return -1;
    }

    //binary search
    //returns index of x if it is present in arr[l..r]
    //else returns -1
    public static int binarySearch(VectorBasicController vectorBasicController, int l, int r, int x) {
        double[] arr = vectorBasicController.getVectorElements();
        if (r >= l) {
            int mid = l + (r - l) / 2;
            //if the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            //if element is smaller than mid, then
            //it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(vectorBasicController, l, mid - 1, x);

            //else the element can only be present
            //in right subarray
            return binarySearch(vectorBasicController, mid + 1, r, x);
        }
        //we reach here when element is not present
        //in array
        return -1;
    }
}
