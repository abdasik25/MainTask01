/**
 * Created by Alexander Lomat on 5.02.19.
 * Version 1.0
 * EPAM Main Task 01: Using Java Arrays.Sorting and Searching Algorithms.
 * View part. Basic behaviour interface
 */


package by.epam.javatraining.lomat.vector.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public interface View {
    Locale locale = new Locale("en", "UK");
    String pattern = "##.##";
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    static String output(Object object){
        return "";
    }
}
