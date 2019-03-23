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
public class isSortedDescendingTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private boolean expected;


    public isSortedDescendingTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                                  double[] elements, boolean expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {2, 3, 4, 5, 7};
        double[] array3 = {9, 7, 6, 5, 5, 4, 3};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, true},
                {vectorBasicController, vectorModelDataService, array2, false},
                {vectorBasicController, vectorModelDataService, array3, true},
        });
    }


    @Test
    public void isSortedDescendingTest() {
        assertEquals(expected, VectorSorter.isSortedDesceding(vectorModelDataService, vectorBasicController));
    }
}