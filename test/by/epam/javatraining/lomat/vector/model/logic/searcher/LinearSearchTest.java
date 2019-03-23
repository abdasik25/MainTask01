package by.epam.javatraining.lomat.vector.model.logic.searcher;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LinearSearchTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private int expected;


    public LinearSearchTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                            double[] elements, int expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {2, 3, 4, 5, 7};
        double[] array3 = {9, 2, 3, 4, 5, 5, 7};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, -1},
                {vectorBasicController, vectorModelDataService, array2, 3},
                {vectorBasicController, vectorModelDataService, array3, 4},
        });
    }


    @Test
    public void linearSearchTest() {
        assertEquals(expected, VectorSearcher.linearSearch(vectorBasicController, vectorModelDataService,5));
    }
}
