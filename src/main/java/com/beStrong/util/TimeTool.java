package com.beStrong.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author roy.zhuo
 */

@Component
public class TimeTool {
    public boolean isToday(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar current = Calendar.getInstance();
        Calendar today = Calendar.getInstance();
        System.out.println("current:" + current.getTime() + " today:" + today.getTime());
        System.out.println("current:" + current.get(Calendar.YEAR) + " today:" + today.get(Calendar.YEAR));
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }

    public Date dateFormatter(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = sdf.format(date);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
