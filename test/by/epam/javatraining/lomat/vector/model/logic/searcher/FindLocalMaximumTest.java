package by.epam.javatraining.lomat.vector.model.logic.searcher;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindLocalMaximumTest {

    private VectorBasicController vectorBasicController;
    private VectorModelDataService vectorModelDataService;
    private double expected;


    public FindLocalMaximumTest(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService,
                                double[] elements, double expected) {
        this.vectorBasicController = vectorBasicController;
        this.vectorModelDataService = vectorModelDataService;
        this.expected = expected;
        this.vectorBasicController.setVectorElements(elements);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        double[] array1 = {};
        double[] array2 = {1, 2, 7, 4, 5};
        double[] array3 = {-50, -1, 3, 4, 6, 5, 7};
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);
        return Arrays.asList(new Object[][]{
                {vectorBasicController, vectorModelDataService, array1, -1},
                {vectorBasicController, vectorModelDataService, array2, 7},
                {vectorBasicController, vectorModelDataService, array3, 6},
        });
    }

    @Test
    public void findLocalMaximum() {
        assertEquals(expected,
                VectorSearcher.findLocalMaximum(vectorBasicController, vectorModelDataService), 0.01);
    }
}