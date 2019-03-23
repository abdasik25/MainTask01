package by.epam.javatraining.lomat.vector.model.logic.basic;

import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetVectorElementTest {

    private VectorBasicController vectorBasicController;
    private double expected;


    public GetVectorElementTest(VectorBasicController vectorBasicController, double[] elements, double expected) {
        this.vectorBasicController = vectorBasicController;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {2, 2, 3, 4};
        double[] array2 = {7, 2, 3, 4, 5};
        double[] array3 = {9, 2, 3, 4, 5, 6, 7};
        return Arrays.asList(new Object[][]{
                {new VectorBasicController(new VectorModelDataService()), array1, 2},
                {new VectorBasicController(new VectorModelDataService()), array2, 2},
                {new VectorBasicController(new VectorModelDataService()), array3, 2},
        });
    }

    @Test
    public void getVectorElement() {
        assertEquals(expected, vectorBasicController.getVectorElement(1), 0.1d);
    }
}