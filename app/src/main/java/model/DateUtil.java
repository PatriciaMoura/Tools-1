package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Patricia on 23/11/2018.
 */


public class DateUtil {

    private static final String FORMAT_DEFAULT = "dd-MM-yyyy";
    private static final String FORMAT_HORA = "HH:mm";

    public static String horaToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_HORA);
        return dateFormat.format(date);
    }

    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DEFAULT);
        return dateFormat.format(date);
    }

    public static Date stringToDate(String strDate) {
        DateFormat dateFormat = new SimpleDateFormat(FORMAT_DEFAULT);

        try {
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
