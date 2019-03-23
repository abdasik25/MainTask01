/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Model part (CALCULATING ALGORITHMS)
 */

package by.epam.javatraining.lomat.vector.model.logic.calculator;

import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;

public class VectorCalcuclator {

    //counts average mean of an array. average mean = sum of all elements / their amount
    public static double averageMean(VectorBasicController vectorBasicController,
                                     VectorModelDataService vectorModelDataService) {
        double averageMean = 0;
        if (vectorBasicController.isEmpty()) {
            return averageMean;
        }
        for (int i = 0; i < vectorModelDataService.size(); i++) {
            averageMean += vectorBasicController.getVectorElement(i);
        }
        averageMean /= vectorModelDataService.size();
        return averageMean;
    }

    //counts geometric mean of an array. uses logarithms method to avoid over- and underflows
    public static double geometricMean(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService) {
        int n = vectorModelDataService.size();
        if (n == 0) {
            return 0;
        }
        double GM_log = 0.0d;
        for (int i = 0; i < n; ++i) {
            if (vectorBasicController.getVectorElement(i) == 0L) {
                return 0.0d;
            }
            GM_log += Math.log(vectorBasicController.getVectorElement(i));
        }
        return Math.exp(GM_log / n);
    }

    public void reverseVector(VectorBasicController vectorBasicController, VectorModelDataService vectorModelDataService) {
        int endIndex = vectorModelDataService.size() - 1;
        for (int i = 0; i < vectorModelDataService.size() / 2; i++) {
            double tmp = vectorBasicController.getVectorElement(i);
            vectorBasicController.setVectorElement(i, vectorBasicController.getVectorElement(endIndex));
            vectorBasicController.setVectorElement(endIndex--, tmp);
        }
    }
}
