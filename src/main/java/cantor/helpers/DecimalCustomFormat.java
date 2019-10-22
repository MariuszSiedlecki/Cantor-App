package cantor.helpers;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalCustomFormat {
    public static String decimalToString(BigDecimal decimal){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(decimal);
    }
    public static String decimalGetRate(BigDecimal decimal){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        return df.format(decimal);
    }
}
