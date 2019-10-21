package com.minakov.railwayticketbooking.config;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatConfig {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
    public static SimpleDateFormat userBirthdayFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
}
