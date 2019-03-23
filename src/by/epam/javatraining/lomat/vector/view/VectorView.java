/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * View part
 */

package by.epam.javatraining.lomat.vector.view;

public class VectorView implements View {
    public static String output(Object object) {
        decimalFormat.applyPattern(pattern);
        return String.format(object.toString(), decimalFormat);
    }
}
