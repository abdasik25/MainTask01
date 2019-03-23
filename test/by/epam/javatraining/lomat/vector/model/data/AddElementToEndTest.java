package by.epam.javatraining.lomat.vector.model.data;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AddElementToEndTest {

    private VectorBasicController vectorBasicController;
    private double[] expected;


    public AddElementToEndTest(VectorBasicController vectorBasicController, double[] elements, double[] expected) {
        this.vectorBasicController = vectorBasicController;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {7, 2, 3, 4, 5};
        double[] array3 = {9, 2, 3, 4, 5, 6, 7};
        return Arrays.asList(new Object[][]{
                {new VectorBasicController(new VectorModelDataService()), array1, new double[]{3}},
                {new VectorBasicController(new VectorModelDataService()), array2, new double[]{7, 2, 3, 4, 5, 3}},
                {new VectorBasicController(new VectorModelDataService()), array3, new double[]{9, 2, 3, 4, 5, 6, 7, 3}},
        });
    }

    @Test
    public void addElementToEndTest() {
        vectorBasicController.addElement(3);
        assertArrayEquals(expected, vectorBasicController.getVectorElements(), 0.03d);
    }
}