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
public class isSortedAccedingTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private boolean expected;


    public isSortedAccedingTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                                double[] elements, boolean expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {2, 4, 4, 4, 7};
        double[] array3 = {9, 2, 3, 4, 4, 4, 7};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, true},
                {vectorBasicController, vectorModelDataService, array2, true},
                {vectorBasicController, vectorModelDataService, array3, false},
        });
    }


    @Test
    public void isSortedAccedingTest() {
        assertEquals(expected, VectorSorter.isSortedAcceding(vectorModelDataService, vectorBasicController));
    }
}