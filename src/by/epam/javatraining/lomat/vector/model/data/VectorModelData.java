/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (DATA CLASS)
 */


package by.epam.javatraining.lomat.vector.model.data;


public class VectorModelData {
    //The array buffer
    private double[] elements;
    //The array number of elements
    private int elementCount;

    public VectorModelData() {
        elementCount = 0;
        elements = new double[elementCount];
    }

    public VectorModelData(double[] elements, int elementCount) {
        this.elements = elements;
        this.elementCount = elementCount;
    }

    public double[] getElements() {
        return elements;
    }

    public void setElements(double[] elements) {
        this.elements = elements;
    }

    //size of an array
    public int size() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }

}
