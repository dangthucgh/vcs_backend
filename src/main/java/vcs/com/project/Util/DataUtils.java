package vcs.com.project.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author anhvd_itsol
 */

public class DataUtils {
    private static final Logger logger = LoggerFactory.getLogger(DataUtils.class);

    public static boolean isNullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }

    public static boolean isNullOrEmpty(String value) {
        return (value == null || value.isEmpty());
    }

    public static boolean isNullOrZero(BigDecimal value) { return (value == null || value.compareTo(BigDecimal.ZERO) == 0); }

    public static boolean isNumber(String strId) {
        return strId.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isLong(String strId) {
        return strId.matches("\\d*");
    }

    public static boolean isNullOrZero(Short value) {
        return (value == null || value.equals(Short.parseShort("0")));
    }

    public static boolean isNullOrZero(Integer value) {
        return (value == null || value.equals(Integer.parseInt("0")));
    }
}
