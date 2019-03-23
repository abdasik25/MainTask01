package by.epam.javatraining.lomat.vector.model.logic.basic;

import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class VectorCapacityTest {

    private VectorBasicController vectorBasicController;
    private int expected;


    public VectorCapacityTest(VectorBasicController vectorBasicController, double[] elements, int expected) {
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
                {new VectorBasicController(new VectorModelDataService()), array1, 4},
                {new VectorBasicController(new VectorModelDataService()), array2, 5},
                {new VectorBasicController(new VectorModelDataService()), array3, 7},
        });
    }

    @Test
    public void getVectorCapacity() {
        assertEquals(expected, vectorBasicController.getVectorCapacity());
    }
}