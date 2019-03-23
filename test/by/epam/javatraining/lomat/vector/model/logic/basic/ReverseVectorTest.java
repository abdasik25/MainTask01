package by.epam.javatraining.lomat.vector.model.logic.basic;

import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReverseVectorTest {
    private VectorBasicController controller;
    double[] elements;
    double[] expected;


    public ReverseVectorTest(VectorBasicController controller, double[] elements, double[] expected) {
        this.controller = controller;
        this.expected = expected;
        controller.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object> getParametrs() {
        double array1[] = {1, 2, 3, 4, 5};
        double array2[] = {5, 6, 7, 8, 9};
        double array3[] = {9, 10, 11, 12};

        return Arrays.asList(new Object[][]{
                {new VectorBasicController(new VectorModelDataService()), array1, new double[]{5, 4, 3, 2, 1}},
                {new VectorBasicController(new VectorModelDataService()), array2, new double[]{9, 8, 7, 6, 5}},
                {new VectorBasicController(new VectorModelDataService()), array3, new double[]{12, 11, 10, 9}},
        });
    }

    @Test
    public void reverseVectorTest() {
        controller.reverseVector();
        assertArrayEquals(expected, controller.getVectorElements(), 0.0d);
    }

}
