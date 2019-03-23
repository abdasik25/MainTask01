/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * Controller part (RUN THIS TO SEE EXAMPLE OF WORKING)
 */


package by.epam.javatraining.lomat.vector.controller;


import by.epam.javatraining.lomat.vector.model.logic.basic.VectorBasicController;
import by.epam.javatraining.lomat.vector.model.logic.calculator.VectorCalcuclator;
import by.epam.javatraining.lomat.vector.model.logic.searcher.VectorSearcher;
import by.epam.javatraining.lomat.vector.model.logic.sorter.VectorSorter;
import by.epam.javatraining.lomat.vector.model.data.VectorModelDataService;
import by.epam.javatraining.lomat.vector.view.VectorView;

import java.util.Random;

public class ConsoleController {
    public static void main(String[] args) {
        VectorModelDataService vectorModelDataService = new VectorModelDataService();
        VectorBasicController vectorBasicController = new VectorBasicController(vectorModelDataService);

        double rangeMin = -100;
        double rangeMax = 100;
        Random random = new Random();
        double[] mas = new double[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        }
        vectorBasicController.setVectorElements(mas);
        System.out.println(VectorView.output(vectorModelDataService.toString()));
        System.out.println("AVERAGE MEAN: " + VectorView.output(VectorCalcuclator.averageMean(vectorBasicController,
                vectorModelDataService)));
        System.out.println("MAXIMUM VALUE: " + VectorView.output(VectorSearcher.findMaximum(vectorBasicController,
                vectorModelDataService)));
        System.out.println("MINIMUM VALUE: " + VectorView.output(VectorSearcher.findLocalMinimum(vectorBasicController,
                vectorModelDataService)));
        System.out.println(VectorView.output(vectorModelDataService.toString()));
        vectorBasicController.reverseVector();
        VectorSorter.quickSort(vectorModelDataService, 0, vectorModelDataService.size());
        System.out.println(VectorView.output(vectorModelDataService.toString()));
        VectorSorter.bubbleSortDescending(vectorModelDataService, vectorBasicController);
        System.out.println(VectorView.output(vectorModelDataService.toString()));
        System.out.println("IS SORTED ACCEDING? " + (VectorSorter.isSortedAcceding(vectorModelDataService,
                vectorBasicController) ?
                "YES" : "NO"));
        System.out.println("IS SORTED DESCENDING? " + (VectorSorter.isSortedDesceding(vectorModelDataService,
                vectorBasicController)  ?
                "YES" : "NO"));
    }
}
