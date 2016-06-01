package com.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/30.
 */
public class LocaleTest {
    public static void main(String[] args) {
//        Locale locale = Locale.getDefault();
//        locale.setDefault(Locale.US);
//        System.out.println(Locale.US);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        System.out.println(df.format(new Date()));
    }
}
