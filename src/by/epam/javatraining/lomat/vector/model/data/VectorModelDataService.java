/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (DATA-SERVICE CLASS)
 */


package by.epam.javatraining.lomat.vector.model.data;

import java.util.Locale;
import java.util.Vector;

public class VectorModelDataService {

    private VectorModelData vectorModelData;

    public VectorModelDataService() {
        vectorModelData = new VectorModelData();
    }

    //set element by index
    //FIXME
    //TODO
    public void setElement(int index, double element) {
        vectorModelData.getElements()[index] = element;
    }
//        return oldValue;
//        double[] elements = vectorModelData.getElements();
//        if (elementCount == 0) {
//            elementCount++;
//        }
//        double[] tmp = new double[elementCount];
//        for (int i = 0; i < elementCount; i++) {
//            if (i == index) {
//                tmp[i] = element;
//                continue;
//            }
//            tmp[i] = elements[i];
//        }
//
//        public synchronized E set(int index, E element) {
//            if (index >= elementCount)
//                throw new ArrayIndexOutOfBoundsException(index);
//
//            E oldValue = elementData(index);
//            elementData[index] = element;
//            return oldValue;
//        }
//        elements = tmp;
//        vectorModelData.setElements(elements);
//        vectorModelData.setElementCount(elementCount);

    public void addElementsToEnd(double[] elements) {
        int elementCount = vectorModelData.size();
        double[] vectorElements = vectorModelData.getElements();
        elementCount += elements.length;
        double[] tmpElements = new double[elementCount];
        for (int i = 0; i <= elementCount; i++) {
            if (elementCount - elements.length == i) {
                for (int j = elementCount - elements.length, k = 0; j < elementCount; j++, k++) {
                    tmpElements[j] = elements[k];
                }
                break;
            }
            tmpElements[i] = vectorElements[i];
        }
        vectorElements = tmpElements;
        vectorModelData.setElements(vectorElements);
        vectorModelData.setElementCount(elementCount);
    }

    public void addElementToEnd(double element) {
        int elementCount = vectorModelData.size();
        double[] elements = vectorModelData.getElements();
        elementCount++;
        double[] tmpElements = new double[elementCount];
        for (int i = 0; i < elementCount; i++) {
            //last element
            if (i == elementCount - 1) {
                tmpElements[i] = element;
                break;
            }
            tmpElements[i] = elements[i];
        }
        vectorModelData.setElementCount(elementCount);
        elements = tmpElements;
        vectorModelData.setElements(elements);
        vectorModelData.setElementCount(elementCount);
    }

    public double[] getElements() {
        return vectorModelData.getElements();
    }

    public void setElements(double[] elements) {
        vectorModelData.setElements(elements);
    }

    public void setElementCount(int elementCount) {
        vectorModelData.setElementCount(elementCount);
    }

    public int size() {
        return vectorModelData.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                builder.append(String.format(Locale.ENGLISH, "%1$.2f", getElements()[i])).append("]");
            } else {
                builder.append(String.format(Locale.ENGLISH, "%1$.2f", getElements()[i])).append(" ");
            }
        }
        return "ARRAY: " + builder.toString();
    }
}
