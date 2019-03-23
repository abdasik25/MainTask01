package by.epam.javatraining.lomat.vector.model.logic.calculator;


import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GeometricMeanTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private double expected;


    public GeometricMeanTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                             double[] elements, double expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {7, 2, 3, 4, 5};
        double[] array3 = {9, 2, 3, 4, 5, 6, 7};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, 0},
                {vectorBasicController, vectorModelDataService, array2, 3.84464},
                {vectorBasicController, vectorModelDataService, array3, 4.6263},
        });
    }

    @Test
    public void geometricMeanTest() {
        assertEquals(expected, VectorCalcuclator.geometricMean(vectorBasicController,
                vectorModelDataService), 0.001d);
    }
}