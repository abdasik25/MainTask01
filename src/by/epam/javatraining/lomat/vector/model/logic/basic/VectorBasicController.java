/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (BASIC OPERATIONS)
 */


package by.epam.javatraining.lomat.vector.model.logic.basic;

import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;


public class VectorBasicController {

    private VectorModelDataService vectorModelDataService;

    public VectorBasicController(VectorModelDataService model) {
        this.vectorModelDataService = model;
    }

    //initializes an array with positive numbers
    public void setVectorElements(double[] elements) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                elements[i] *= -1;
            }
        }
        vectorModelDataService.setElements(elements);
        vectorModelDataService.setElementCount(elements.length);
    }

    public double[] getVectorElements() {
        return (vectorModelDataService.getElements());
    }

    //returns array element at specific index (if index exists)
    public double getVectorElement(int index) {
        if (index > vectorModelDataService.size() && index < 0) {
            return -1;
        }
        return ((vectorModelDataService.getElements())[index]);
    }

    //sets array element at specific index (if index exists) by value
    public void setVectorElement(int index, double element) {
        if (isEmpty()) {
            vectorModelDataService.addElementToEnd(element);
        } else if (index > vectorModelDataService.size() && index < 0) {
            return;
        } else {
            vectorModelDataService.setElement(index, element);
        }
    }

    public int getVectorCapacity() {
        return (vectorModelDataService.size());
    }

    //checks if array is empty
    public boolean isEmpty() {
        return vectorModelDataService.size() == 0;
    }

    //adds element to end of array
    public void addElement(double element) {
        vectorModelDataService.addElementToEnd(element);
    }

    //adds elements to end of array
    public void addElements(double[] elements) {
        vectorModelDataService.addElementsToEnd(elements);
    }

    //reverses vector
    public void reverseVector() {
        int endIndex = vectorModelDataService.size() - 1;
        for (int i = 0; i < vectorModelDataService.size() / 2; i++) {
            double tmp = getVectorElement(i);
            setVectorElement(i, getVectorElement(endIndex));
            setVectorElement(endIndex--, tmp);
        }
    }
}
