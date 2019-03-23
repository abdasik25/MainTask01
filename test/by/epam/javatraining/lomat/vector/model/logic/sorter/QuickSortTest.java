package by.epam.javatraining.lomat.vector.model.logic.sorter;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuickSortTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private double[] expected;


    public QuickSortTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                         double[] elements, double[] expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {7, 2, 3, 4, 5};
        double[] array3 = {9, 2, 3, 4, 5, 6, 7};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, new double[]{}},
                {vectorBasicController, vectorModelDataService, array2, new double[]{2, 3, 4, 5, 7}},
                {vectorBasicController, vectorModelDataService, array3, new double[]{2, 3, 4, 5, 6, 7, 9}},
        });
    }


    @Test
    public void quickSortDescendingTest() {
        VectorSorter.quickSort(vectorModelDataService, 0, vectorBasicController.getVectorCapacity());
        assertArrayEquals(expected, vectorBasicController.getVectorElements(), 0.001d);
    }
}