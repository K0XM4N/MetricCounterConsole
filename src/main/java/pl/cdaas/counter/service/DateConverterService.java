package pl.cdaas.counter.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Krzysztof on 2017-10-29.
 */
public class DateConverterService {

    public DateConverterService(){

    }

    public static Date convertDateFromString(String dateInString){

        Date convertedDate = null;

        if (dateInString.contains("-")) {

            String[] splitedDate = dateInString.split("-");
            int day = Integer.parseInt(splitedDate[0]);
            int month = Integer.parseInt(splitedDate[1]) -1;
            int year = Integer.parseInt(splitedDate[2]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, day, 00,00, 00);
            convertedDate = calendar.getTime();

        }

        return convertedDate;
    }

    public static String convertDateToString(Date date){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String convertedDateAsString = formatter.format(date);

        return convertedDateAsString;

    }

}
